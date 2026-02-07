import re.exception.MyCheckdException;
import re.exception.MyUncheckedException;

public class Demo {
    public static void test1() throws MyCheckdException{
       throw new MyCheckdException(404,"ko tìm thấy tài nguyên");
        //throw new MyUncheckedException();
    }
    public static void test2(){
        System.out.println("test2");
    }
}
/*1 tạo 1 hàm static thực hiện phép chia cho 2 số a/b
hãy dùng try catch để xử lý ngoại lệ khi chia cho 0
a và b là 2 số thực được nhập vào và phải bắt và xử lý lỗi nhập không phải số
*
* */