import java.util.Arrays;
import java.util.Scanner;

public class cs_1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int length = sc.nextInt();
        int[] pipe = new int[num];

        for (int i = 0; i < num; i++){
            pipe[i] = sc.nextInt();
        }

        Arrays.sort(pipe);

        int tape_count = 1;
        int start = pipe[0];
        for(int i = 0; i < num; i++){
            if(pipe[i] < (start + length)){
                continue;
            }
            else{
                tape_count++;
                start = pipe[i];
            }
        }
        System.out.println(tape_count);
    }
}
