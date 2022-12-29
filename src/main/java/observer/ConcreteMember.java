package observer;

public class ConcreteMember implements Member{

    String memberName ="";
    UndoableStringBuilder usb;

    public ConcreteMember(String name)
    {
        memberName = name;
        usb=new UndoableStringBuilder();
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        System.out.println(memberName + " is notified");
        this.usb=usb;
    }

    public String toString(){
        return memberName + ": " +  this.usb.toString();
    }
}
