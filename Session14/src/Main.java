import java.text.SimpleDateFormat;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
     Date dateStr = new Date();
     String dateString ="10/10/2000";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Date date =sdf.parse(dateStr) ;//Phương thức này có thể ném ra ngoại lệ checked
        System.out.println(4/0);//Unchecked exception


    }
}