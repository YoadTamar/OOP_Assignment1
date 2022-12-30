package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        boolean thrown=false; // variable to check the null test

        //creating 5 members
        GroupAdmin groupAdmin=new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("member1");
        ConcreteMember member2=new ConcreteMember("member2");
        ConcreteMember member3=new ConcreteMember("member3");
        ConcreteMember member4=new ConcreteMember("member4");
        ConcreteMember member5=new ConcreteMember("member5");
        //creating 6th member to check the null test.
        ConcreteMember member6= null;

        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.register(member5);
        try{
            groupAdmin.register(member6);

        }
        catch (NullPointerException e){
            thrown=true;
        }

        assertEquals(groupAdmin.members.size(),5);
        assertEquals(thrown,true);

    }

    @Test
    void unregister() {
        boolean thrown=false;
        // Create and register a new members
        GroupAdmin groupAdmin=new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("member1");
        ConcreteMember member2=new ConcreteMember("member2");

        groupAdmin.register(member1);
        groupAdmin.register(member2);

        //unregister member2
        groupAdmin.unregister(member2);
        assertEquals(groupAdmin.members.contains(member2),false);

        //try to get exception
        try{
            groupAdmin.unregister(null);
        }
        catch (NullPointerException e){
            thrown=true;
        }
        assertEquals(thrown,true);

        //try to unregister member2 again
        groupAdmin.unregister(member2);

        //unregister member1
        groupAdmin.unregister(member1);
        assertEquals(groupAdmin.members.size(),0);
    }

    @Test
    void insert() {
        GroupAdmin groupAdmin = new GroupAdmin();

        // Create and register a new member
        ConcreteMember member = new ConcreteMember("yoad");
        groupAdmin.register(member);

        //check insert
        groupAdmin.insert(0, "hey!");
        assertEquals("Members:\n" + "yoad: hey!\n", groupAdmin.toString());

        groupAdmin.insert(4, " bye!");
        assertEquals("Members:\n" + "yoad: hey! bye!\n", groupAdmin.toString());

    }

    @Test
    void append() {
        GroupAdmin groupAdmin = new GroupAdmin();

        // Create and register a new member
        ConcreteMember yoad = new ConcreteMember("yoad");
        groupAdmin.register(yoad);

        // append - "hello".
        groupAdmin.append("hello");
        assertEquals("Members:\n" + "yoad: hello\n", groupAdmin.toString());

        // Create and register a new member
        ConcreteMember member2 = new ConcreteMember("ron");
        groupAdmin.register(member2);

        //append - hello2
        groupAdmin.append(" hello2!");
        assertEquals("Members:\n" + "yoad: hello hello2!\n" +"ron: hello hello2!\n", groupAdmin.toString());
    }

    @Test
    void delete() {
        GroupAdmin groupAdmin = new GroupAdmin();

        // Create member and register him.
        ConcreteMember member = new ConcreteMember("yoad");
        groupAdmin.register(member);

        // append - "hello".
        groupAdmin.append("hello");
        assertEquals("Members:\n" + "yoad: hello\n", groupAdmin.toString());

        // delete the first letter - hello -> ello
        groupAdmin.delete(0,1);
        assertEquals("Members:\n" + "yoad: ello\n", groupAdmin.toString());
    }

    @Test
    void undo() {
        GroupAdmin groupAdmin = new GroupAdmin();

        // Check initialized string in StatesCollection is "".
        assertEquals("Members:\n", groupAdmin.toString());

        // Create and register a new members
        ConcreteMember member1=new ConcreteMember("yoad");
        ConcreteMember member2=new ConcreteMember("ron");
        groupAdmin.register(member1);
        groupAdmin.register(member2);

        // Call undo()
        groupAdmin.undo();
        assertEquals("Members:\n" + "yoad: \n" + "ron: \n", groupAdmin.toString());

        // append - hello
        groupAdmin.append("hello");

        // append - "" - for the undo later
        groupAdmin.append("");
        assertEquals("Members:\n" + "yoad: hello\n" + "ron: hello\n", groupAdmin.toString());

        // undo - ""
        groupAdmin.undo();
        assertEquals("Members:\n" + "yoad: hello\n" + "ron: hello\n", groupAdmin.toString());
        // undo - hello
        groupAdmin.undo();
        assertEquals("Members:\n" + "yoad: \n" + "ron: \n", groupAdmin.toString());
    }

    @Test
    void notifyObservers() {
        GroupAdmin groupAdmin = new GroupAdmin();

        // Create member and register him.
        ConcreteMember member = new ConcreteMember("yoad");
        groupAdmin.register(member);

        // append - "hello" - (notify)
        groupAdmin.append("hello");
        assertEquals("Members:\n" + "yoad: hello\n", groupAdmin.toString());

        // Create member and register him. (he is not notify)
        ConcreteMember member2 = new ConcreteMember("ron");
        groupAdmin.register(member2);
        assertEquals("Members:\n" + "yoad: hello\n" + "ron: \n", groupAdmin.toString());

        // notify member2
        groupAdmin.notifyObservers();
        assertEquals("Members:\n" + "yoad: hello\n" + "ron: hello\n", groupAdmin.toString());
    }
}