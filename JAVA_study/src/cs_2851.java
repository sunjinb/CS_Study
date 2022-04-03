import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cs_2851 {

    static int max = 10;
    static int[] num = new int[max]; 

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < max; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        compare(num);
    }

    static void compare(int[] num) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < max; i++) {
            sum += num[i];
            if (Math.abs(100 - sum) > Math.abs(100 - result)) {
                break;
            }
            result = sum;
        }
        System.out.println("result : " + result);
    }
}