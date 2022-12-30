package observer;

/**
 * This class implements the Member interface in the observer design pattern.
 * This class has 2 fields: "usb" to hold the updated UndoableStringBuilder, and a "memberName".
 *
 * @author Yoad and Ron
 */
public class ConcreteMember implements Member{

    String memberName ="";
    UndoableStringBuilder usb;

    /**
     * A constructor that create a new object of type ConcreteMember
     *
     * @param name - the name of tne new member
     */
    public ConcreteMember(String name)
    {
        memberName = name;
        usb=new UndoableStringBuilder();
    }

    /**
     *The method update the usb
     *The copy make by a shallow copy
     *
     * @param usb - the new UndoableStringBuilder that usb need to point to
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        System.out.println(memberName + " is notified");
        this.usb=usb;
    }

    /**
     *the method return a string that hold the member's name and the UndoableStringBuilder
     *
     * @return memberName
     */
    public String toString(){
        return memberName + ": " +  this.usb.toString();
    }
}
