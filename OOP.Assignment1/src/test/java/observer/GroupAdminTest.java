package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {




    @Test
    void register() {
        boolean thrown=false; // variable to check the null test

        //creating 5 members
        GroupAdmin groupAdmin=new GroupAdmin();
        ConcreteMember member1=new ConcreteMember();
        ConcreteMember member2=new ConcreteMember();
        ConcreteMember member3=new ConcreteMember();
        ConcreteMember member4=new ConcreteMember();
        ConcreteMember member5=new ConcreteMember();
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

        assertEquals(groupAdmin.members.isEmpty(),false);
        assertEquals(groupAdmin.members.size(),5);
        assertEquals(thrown,true);


    }

    @Test
    void unregister() {
        boolean thrown=false;
        //creating 2 members
        GroupAdmin groupAdmin=new GroupAdmin();
        ConcreteMember member1=new ConcreteMember();
        ConcreteMember member2=new ConcreteMember();

        groupAdmin.register(member1);
        groupAdmin.register(member2);

        groupAdmin.unregister(member2);
        assertEquals(groupAdmin.members.contains(member2),false);

        try{
            groupAdmin.unregister(null);
        }
        catch (NullPointerException e){
            thrown=true;
        }
        assertEquals(thrown,true);

        try{
            groupAdmin.unregister(member2);
        }
        catch (IllegalStateException e){
            thrown=true;
        }
        assertEquals(thrown,true);

        groupAdmin.unregister(member1);
        assertEquals(groupAdmin.members.size(),0);

        try{
            groupAdmin.unregister(member1);
        }
        catch (IndexOutOfBoundsException e){
            thrown=true;
        }
        assertEquals(thrown,true);


    }

    @Test
    void insert() {

    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }

    @Test
    void notifyObservers() {
    }
}