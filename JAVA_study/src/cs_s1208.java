import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;

public class cs_s1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++){
            int dumpCount = sc.nextInt();
            int[] arr = new int[100];
            for(int i = 0; i < dumpCount; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < dumpCount; i++) {
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }
            System.out.println("#" + test_case + " " + (arr[99] - arr[0]) + " ");
        }
    }
}
