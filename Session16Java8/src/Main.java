import java.util.function.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//trước java 8
//      8  // trong java 8 chúng ta tạo 1 class nặc danh
//               IFlyable chicken = new IFlyable() {
//                   @Override
//                   public boolean flyable() {
//                       return false;
//                   }
//               };
//               // Lambda expresion
//        IFlyable hoaMi=()->true;//-> biểu tượng cho return nên có thể lược bỏ {}
//        IMath cal = (x,y)-> x+y;
        IMath cal1 = (x,y)-> x+y;
        demo(cal1);
        demo(new IMath() {
            @Override
            public int calculate(int a, int b) {
                return 0;
            }
        });
        //danh sách funtionalInterface dựng sẵn
        //Consumer, Predicate, Funtion, Supplier
        // dùng lambda tạo ra 4 dối tượng từ 4 interface trên không quan trọng logic
        // 1. Consumer – nhận vào 1 giá trị, không trả về
        Consumer<String> consumer = s -> System.out.println(s);

        // 2. Predicate – nhận vào 1 giá trị, trả về boolean
        Predicate<Integer> predicate = n -> n > 0;

        // 3. Function – nhận vào 1 giá trị, trả về 1 giá trị khác
        Function<Integer, String> function = n -> "So: " + n;

        // 4. Supplier – không nhận tham số, trả về giá trị
        Supplier<Double> supplier = () -> Math.random();

        demo ((x,y)->x+y);
        demo ((x,y)->x+y);
        demo ((x,y)->x+y);

    }
    //cái j được duyệt theo mảng thì đều được hôx trợ bởi stream

    public static void demo(IMath cal){
        int a = 10; int b = 100;
        int rs = cal.calculate(a,b);
        System.out.println(rs);
    }
}