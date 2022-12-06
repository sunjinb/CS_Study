import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array;

        int test_count = sc.nextInt();

        for(int i = 0; i < test_count; i++){
            int num = sc.nextInt();
            array = new int[num];

            double sum = 0;

            for(int j = 0; j < num; j++){
                int score = sc.nextInt();
                array[j] = score;
                sum += score;
            }
            double mean = sum / num;
            double over_sum = 0;

            for(int j = 0; j < num; j++){
                if(array[j]> mean){
                    over_sum++;
                }
            }
            System.out.printf("%.3f%%\n",(over_sum/num)*100);
        }
    }
}