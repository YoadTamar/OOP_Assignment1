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
            members.add(obj);
        }
    }

    @Override
    public void unregister(Member obj) throws IllegalStateException, IndexOutOfBoundsException, NullPointerException  {
        if (obj==null){
            throw new NullPointerException("you can not create null member.");
        }
        else if (members.size()>0){
            if (members.contains(obj)) {
                members.remove(obj);
            }
            else {
                throw new IllegalStateException("no such member.");
            }
        }
        else {
            throw new IndexOutOfBoundsException("members is empty.");
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
    }
}
