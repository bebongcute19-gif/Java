import java.lang.reflect.Array;

public class SapXepNoiBot {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for(int i = 0; i<array.length-1;i++){
            for(int j = i+1;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
