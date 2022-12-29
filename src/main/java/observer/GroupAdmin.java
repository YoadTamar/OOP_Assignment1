package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender{

    UndoableStringBuilder usb;
    List<Member> members;

    public GroupAdmin(){
        this.members=new ArrayList<>();
        this.usb= new UndoableStringBuilder();
    }

    @Override
    public void register(Member obj) throws NullPointerException
    {
        if (obj==null){
            throw new NullPointerException("you can not create null member");
        }
        else {
            if (members.contains(obj)){
                System.out.println( obj + " is already register");
            }
            else {
                members.add(obj);
                System.out.println(obj + " has register!");
            }
        }
    }

    @Override
    public void unregister(Member obj) throws NullPointerException  {
        if (obj==null){
            throw new NullPointerException("you can not remove null member.");
        }
        if (members.contains(obj)) {
            members.remove(obj);
            System.out.println(obj + " unregister!");
        }
        else{
            System.out.println(obj + " is not register");
        }
    }

    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset,obj);
        notifyObservers();
    }

    @Override
    public void append(String obj) {
        usb.append(obj);
        notifyObservers();
    }

    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notifyObservers();
    }

    @Override
    public void undo() {
        usb.undo();
        notifyObservers();
    }

    public void notifyObservers(){
        for (Member member: members){
            member.update(this.usb);
        }
        System.out.println("all the members are notified");
    }

    @Override
    public String toString() {
        String str = "Members:\n";

        for (Member m: this.members)
            str += m.toString() + "\n";

        return str;
    }
}
