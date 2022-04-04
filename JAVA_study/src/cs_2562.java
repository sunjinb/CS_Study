import java.util.Scanner;

public class cs_2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = new int[9];
        int max = 0;
        int index = 0;
        for(int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
            if(array[i] >= max){
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}