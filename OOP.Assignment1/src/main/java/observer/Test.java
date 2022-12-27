package observer;

public class Test {
    public static void main(String[] args) {

        GroupAdmin groupAdmin=new GroupAdmin();
        ConcreteMember concreteMember=new ConcreteMember();
        ConcreteMember concreteMember1=new ConcreteMember();
        ConcreteMember nullmember=null;

        if (concreteMember==null){
            System.out.println("null");
        }

        groupAdmin.register(concreteMember);
//        groupAdmin.append("hello");
//        System.out.println(concreteMember);
        System.out.println(concreteMember);

        groupAdmin.register(concreteMember1);
        System.out.println(concreteMember1);
//        groupAdmin.append(" world");
//        System.out.println(concreteMember1);

        System.out.println(concreteMember);
        System.out.println(groupAdmin.members.isEmpty());
        System.out.println("check");


    }
}
