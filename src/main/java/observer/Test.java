package observer;

public class Test {
    public static void main(String[] args) {

        GroupAdmin groupAdmin=new GroupAdmin();
        ConcreteMember member1 =new ConcreteMember("mem1");
        ConcreteMember member2 =new ConcreteMember("mem2");

        groupAdmin.register(member1);
        groupAdmin.append("Hello member 1");
        System.out.println(member1);

        groupAdmin.register(member2);
        groupAdmin.append("Hello member 2");
        System.out.println(member2);

        groupAdmin.unregister(member2);
        System.out.println(member1);
        groupAdmin.delete(0,1);
        System.out.println(member1);
        groupAdmin.undo();
        System.out.println(member1);
        System.out.println(groupAdmin);



    }
}
