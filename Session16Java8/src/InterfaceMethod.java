public interface InterfaceMethod {
    void printf();// trừu tượng hh
    //default phương thức mặc định
    default void printcolor(){

    }
    // static: phương thức tĩnh
    static void printSize(){
        System.out.println("XXL");
    }
}
