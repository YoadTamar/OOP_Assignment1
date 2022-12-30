package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        GroupAdmin groupAdmin = new GroupAdmin();

        // Create and register a new members
        ConcreteMember member = new ConcreteMember("yoad");
        groupAdmin.register(member);
        ConcreteMember member2 = new ConcreteMember("ron");
        groupAdmin.register(member2);

        // append - hello (update)
        groupAdmin.append("hello");
        assertEquals("Members:\n" + "yoad: hello\n" +"ron: hello\n", groupAdmin.toString());

        // Unsubscribe member2
        groupAdmin.unregister(member2);

        //undo - hello (update)
        groupAdmin.undo();
        assertEquals("Members:\n" + "yoad: \n", groupAdmin.toString());
    }
}