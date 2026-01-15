public class Demo {
    public static void main(String[] args) {
        int [] arrInt = new int [10];
        int [] arrInt1 = new int[]{1,2,3,4,5,6,7};//đầy đủ
        System.out.println("Phan tu tai indẽx=2"+arrInt[2]);
        arrInt[2] = 100;
        System.out.println("Phan tu tai indẽx=2"+arrInt[2]);
        //mảng 2 chiều
        int [][] arr2D = new int [10][5];//
        int [][] arr2D1 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        System.out.println("array"+arr2D[0][4]);
        for(int i=0;i<arrInt1.length;i++){
            System.out.println("array"+arrInt1[i]);
        }
        for(int i=0;i<arr2D.length;i++){
            for(int j=0;j<arr2D1.length;j++){
                System.out.println("array"+arr2D1[i][j]);
            }
        }
        // Tạo mảng lưu trữ danh sách điểm thi của 10 môn học nhập từ bàn phím
        //duyệt mang thực hiện tính : điểm trung bình , điểm cao nhất , điểm thấp nhất của sinh viên
    }
}
