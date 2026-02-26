public class demo implements InterfaceMethod {
    @Override
    public void printf() {
    }
    @Override
    public void printcolor() {
        System.out.println("Mau xanh");
    }
    public static void main(String[] args) {
        demo d= new demo();
        d.printcolor();
        InterfaceMethod.printSize();
    }


}
