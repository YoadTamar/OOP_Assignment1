package observer;

public class ConcreteMember implements Member{

    UndoableStringBuilder usb;

    public ConcreteMember(){
        usb=new UndoableStringBuilder();
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb=usb;

    }
    public String toString(){
        return this.usb.toString();
    }
}
