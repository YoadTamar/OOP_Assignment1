import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("yoad");
        ConcreteMember member2 = new ConcreteMember("ron");
        ConcreteMember member3 = new ConcreteMember("elizabeth");

        System.out.println("start testing");

        logger.info(()->JvmUtilities.objectFootprint(groupAdmin, member1, member2, member3));
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin, member1, member2, member3));
        System.out.println("-----------------------------------------------");
        System.out.println("Registering members: ");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);

        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin));
        System.out.println("-----------------------------------------------");

        groupAdmin.append("str str");
        System.out.println();
        System.out.println("-----------------------------------------------");

        System.out.println("after append"); //want to see the changes
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin));
        System.out.println();
        System.out.println("-----------------------------------------------");


        System.out.println("unregister members");
        groupAdmin.unregister(member2);
        System.out.println();
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin));
        System.out.println("-----------------------------------------------");
        groupAdmin.unregister(member3);
        System.out.println();
        logger.info(()->JvmUtilities.memoryStats(groupAdmin));
        System.out.println("-----------------------------------------------");

        System.out.println("insert");
        groupAdmin.insert(0,"tamar");
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin));
        System.out.println("-----------------------------------------------");

        System.out.println("end info: ");
        logger.info(() -> JvmUtilities.jvmInfo());
        System.out.println();
    }
}
