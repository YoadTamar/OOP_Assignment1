package observer;
import java.util.Stack;


/**
 / * StringBuilder class with support for the undo operation by a stack that stores the change history
 / * @maya rom 207485251
 / * @yoad tamar
 / * @1.0
 / */


/**
 / * the field of the object- stack
 / */
public class UndoableStringBuilder {
    Stack<String> stk;

    /**
     * constructor ,create object of the class, that get a String type
     * @param str the first value in the stack
     * @return A new object whose stack field contains the string
     */
    public UndoableStringBuilder(String str) {
        Stack<String> stk = new Stack();
        stk.push(str);
        this.stk = stk;
    }

    /**
     *  It constructs a blank Stack
     */
    public UndoableStringBuilder() {
        Stack<String> stk = new Stack();
        stk.push("");//the first value in the stack is empty
        this.stk = stk;
    }

    /**
     * this function appends the specified string to this character sequence.
     *
     * @param str appends the mentioned string with the existing string
     * @return a new string consisting of the last string + the inserted string
     */

    public UndoableStringBuilder append(String str) {
        StringBuilder _str = new StringBuilder(stk.peek());
        try {
            _str.append(str);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("");
            throw e;
        }
        stk.push(_str.toString());
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.
     *
     * @param start - The first index that the substring begin .
     * @param end   - end-1 is the last index of the sequence if no such character exists.
     * @return new string without the substring from start to end. If start is equal to end, no changes are made.
     */
    public UndoableStringBuilder delete(int start, int end) {
        StringBuilder str = new StringBuilder(stk.peek());
        str.delete(start, end);
        stk.push(str.toString());
        return this;
    }

    /**
     * Inserts the given string into this character sequence.
     *
     * @param offset - Specifies the position where the string is inserted
     * @param str    - The string that the operation inserts at the offset position
     * @return New string containing the captured string
     */
    public UndoableStringBuilder insert(int offset, String str) {
        StringBuilder _str = new StringBuilder(stk.peek());
        _str.insert(offset, str);
        stk.push(_str.toString());
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. First the characters in the substring are removed
     * and then the specified String is inserted at start.
     *
     * @param start -The substring begins at the specified start
     * @param end   -extends to the character at index end - 1 or to the end of the sequence if
     *              no such character exists.
     * @param str   - the specified String is inserted at start
     * @return new string with characters in the specified range
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        StringBuilder _str = new StringBuilder(stk.peek());
        try {
            _str.replace(start, end, str);
        } catch (StringIndexOutOfBoundsException e1) {
            System.err.println("start and end must be positive numbers and start<=end");
            throw e1;
        } finally {
            stk.push(_str.toString());
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     *
     * @return A new String that reverse the last String's character order
     */
    public StringBuilder reverse() {
        StringBuilder _str = new StringBuilder(stk.peek());
        _str = _str.reverse();
        stk.push(_str.toString());
        return new StringBuilder(this.stk.peek());
    }

    /**
     * A function that returns the last saved string, before the last change
     *
     * @return The String before the last change
     */
    public UndoableStringBuilder undo() {
        if (stk.isEmpty() == true)
            System.out.println("there is no more history");
        return this;
    }

    /**
     * Overrides the default print operation, whose purpose is to print the most recent value of the string
     *
     * @return The most recent value of the string
     */
    @Override
    public String toString (){
        return stk.peek();
    }


    public static void main(String[] args) {
        UndoableStringBuilder _str = new UndoableStringBuilder("abcd");
        System.out.println("start: " + _str);
        _str.reverse();
        System.out.println("reverse:  " + _str);
        _str.append("efgh");
        System.out.println("append efgh:  " + _str);
        _str.undo();
        System.out.println("undo:  " + _str);
        _str.append(null);
        System.out.println(_str);
        _str.undo();
        System.out.println(_str);
        _str.replace(2, 7, "hey");
        System.out.println(_str);
        _str.replace(6, 4, "hey");
        System.out.println(_str);
        _str.undo();
        System.out.println(_str);
        _str.reverse();
        System.out.println(_str);
        _str.append("maya\nrom");
        System.out.println(_str);
        _str.reverse();
        System.out.println(_str);


    }
}


