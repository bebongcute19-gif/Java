
public class OperatorPractice {
    public static void main(String[] args) {
        //viết 1 logic khởi tạo 3 cạnh của 1 tam giác hợp lệ
        // sử dụng công thức heron để tính diện tích  và chu vi của tam giác(math)
        //khởi tạo 3 hệ số a,b,c cho phương trình bậc 2 thỏa mãn pt có 2 nghiệm
        //áp dụng công thức giải pt bậc 2 tính nghiệm của phương trình
        // in các kết quả ra màn hình

        int a=10,b=12,c=13;
        int cvtg = a+b+c;
        double p= cvtg/2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Chu vi tam giac is "+cvtg);
        System.out.println("Area is "+area);
        double a1= 1;
        double b1= -3;
        double c1= 2;
        double delta= b1*b1-4*a1*c1;
        double x1= (-b1 + Math.sqrt(delta))/2*a1;
        double x2= (-b1 - Math.sqrt(delta))/2*a1;
        System.out.println("Nghiem 1  "+x1);
        System.out.println("Nghiem 2  "+x2);
    }
}
