package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Sender interface in the observer design pattern.
 * This class has 2 fields:
 * "usb" to hold the main UndoableStringBuilder object - the most update one.
 * Member type list "members" to keep all members.
 *
 * @author Yoad and ron
 */
public class GroupAdmin implements Sender{

    UndoableStringBuilder usb;
    List<Member> members;

    /**
     * A constructor that create a new object of type GroupAdmin.
     */
    public GroupAdmin(){
        this.members=new ArrayList<>();
        this.usb= new UndoableStringBuilder();
    }

    /**
     *
     *The method add a new member to the member list.
     *It can not accept a null member, or it won't add a member that already add.
     *
     * @param obj - a new member.
     * @throws NullPointerException - if the user try to add a null member - throw an exception.
     */
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

    /**
     * The method remove a member from the member list.
     * It can not receive a null member to remove.
     * If the member is not exist in the list - the method don't change a thing.
     *
     * @param obj - the member we need to remove
     * @throws NullPointerException -  if the user try to remove a null member - throw an exception.
     */
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

    /**
     * The method use the insert method of the UndoableStringBuilder class.
     * Then, notify all the members in the list.
     *
     * @param offset - the start position to insert
     * @param obj -  the string to insert
     */
    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset,obj);
        notifyObservers();
    }

    /**
     * The method use the append method of the UndoableStringBuilder class.
     * Then, notify all the members in the list.
     *
     * @param obj - the string we want to append
     */
    @Override
    public void append(String obj) {
        usb.append(obj);
        notifyObservers();
    }

    /**
     * The method use the delete method of the UndoableStringBuilder class.
     * Then, notify all the members in the list.
     *
     * @param start - the start position of delete
     * @param end - the end position of delete
     */
    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notifyObservers();
    }

    /**
     * The method use the undo method of the UndoableStringBuilder class.
     * Then, notify all the members in the list.
     */
    @Override
    public void undo() {
        usb.undo();
        notifyObservers();
    }

    /**
     * The method notify and update all the members UndoableStringBuilder to a new UndoableStringBuilder pointer
     */
    public void notifyObservers(){
        for (Member member: members){
            member.update(this.usb);
        }
        System.out.println("all the members are notified");
    }

    /**
     *the method return a string that hold all the member's names and the UndoableStringBuilders
     * @return String
     */
    @Override
    public String toString() {
        String str = "Members:\n";

        for (Member m: this.members)
            str += m.toString() + "\n";

        return str;
    }
}
