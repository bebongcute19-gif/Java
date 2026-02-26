@FunctionalInterface
public interface IFunctionalInterface {
    // là 1 interface có duy nhất 1 phương thức trừu tượng đều là chức năng
    boolean flyable();
    //void print();
    default void run() {
        System.out.println("I am flyable");
    }
}
