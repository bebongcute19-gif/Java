public class Demo {
    public static void main(String[] args) {
        String name = "Nguyễn Văn A";
        // lấy độ dài chuỗi
        // String trong java vừa có tính nguyên thủy vừa có tính tham chiếu
        // cách 1 là khởi tạo trực tiếp
        String str = "hello World";// khởi tạo theo hướng nguyên thủy(String pool)
        String str2 = "hello World";// khởi tạo theo hướng nguyên thủy(String pool)
        //in ra địa chỉ của buến
        System.out.println(""+System.identityHashCode(str2));
        System.out.println(""+System.identityHashCode(str));
        // cách 2 khởi tạo thông qua từ khóa new(cấp phát đông)
        String  str3 = new String("hello World") ;
        String  str4 = new String("hello World") ;
        System.out.println(""+System.identityHashCode(str3));
        System.out.println(""+System.identityHashCode(str4));
        //Các phương thức thường duùng của string
        // lenght(), length(), charAt(), substring(), indexOf(), toLowerCase(), toUpperCase(), trim(), replace(), split()
        //equals(), equalsIgnoreCase(), compareTo(), contains()

        String s = "Java";
        s.length(); // 4


// charAt(int index)
// → Lấy ký tự tại vị trí index (bắt đầu từ 0)
        s.charAt(0); // 'J'


// substring(int begin, int end)
// → Cắt chuỗi từ vị trí begin đến end - 1
        s.substring(0, 2); // "Ja"


// indexOf(String str)
// → Trả về vị trí xuất hiện đầu tiên của chuỗi con
// → Trả về -1 nếu không tìm thấy
        s.indexOf("va"); // 2


// toLowerCase()
// → Chuyển toàn bộ chuỗi sang chữ thường
        "Java".toLowerCase(); // "java"


// toUpperCase()
// → Chuyển toàn bộ chuỗi sang chữ hoa
        "Java".toUpperCase(); // "JAVA"


// trim()
// → Xóa khoảng trắng ở đầu và cuối chuỗi
        "  Java  ".trim(); // "Java"


// replace(old, new)
// → Thay thế tất cả old bằng new trong chuỗi
        "Java".replace("a", "o"); // "Jovo"


// split(String regex)
// → Tách chuỗi thành mảng dựa vào ký tự phân cách
        "Java PHP C++".split(" "); // ["Java", "PHP", "C++"]


// equals(Object obj)
// → So sánh 2 chuỗi có giống nhau hay không (phân biệt hoa thường)
        "Java".equals("java"); // false


// equalsIgnoreCase(String str)
// → So sánh 2 chuỗi, KHÔNG phân biệt hoa thường
        "Java".equalsIgnoreCase("java"); // true


// compareTo(String str)
// → So sánh 2 chuỗi theo thứ tự từ điển
// = 0 : giống nhau
// > 0 : chuỗi hiện tại lớn hơn
// < 0 : chuỗi hiện tại nhỏ hơn
        "a".compareTo("b"); // < 0


// contains(CharSequence s)
// → Kiểm tra chuỗi có chứa chuỗi con hay không
        "Java Programming".contains("Java"); // true

    }
}
//public class StringDemo {
//    public static void main(String[] args) {
//        String s = "  Hello Java World  ";
//        String s2 = "hello java world";
//
//        // length()
//        System.out.println(s.length()); // 20
//
//        // charAt()
//        System.out.println(s.charAt(2)); // H
//
//        // substring()
//        System.out.println(s.substring(2, 7)); // Hello
//
//        // indexOf()
//        System.out.println(s.indexOf("Java")); // 8
//
//        // toLowerCase()
//        System.out.println(s.toLowerCase());
//
//        // toUpperCase()
//        System.out.println(s.toUpperCase());
//
//        // trim()
//        System.out.println(s.trim()); // "Hello Java World"
//
//        // replace()
//        System.out.println(s.replace("Java", "Python"));
//
//        // split()
//        String[] arr = s.trim().split(" ");
//        for (String word : arr) {
//            System.out.println(word);
//        }
//
//        // equals()
//        System.out.println(s.trim().equals(s2)); // false
//
//        // equalsIgnoreCase()
//        System.out.println(s.trim().equalsIgnoreCase(s2)); // true
//
//        // compareTo()
//        System.out.println(s.trim().compareTo(s2)); // >0, <0 hoặc =0
//
//        // contains()
//        System.out.println(s.contains("Java")); // true
//    }
//}
