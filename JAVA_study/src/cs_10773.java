import java.util.Stack;
import java.util.Scanner;

public class cs_10773 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        int K = in.nextInt();

        for(int i = 0; i < K; i++) {
            int number = in.nextInt();

            if(number == 0) {	// 0이라면 스택에 저장된 top 원소 삭제
                stack.pop();
            }
            else {
                stack.push(number);
            }
        }
        int sum = 0;

        for(int o : stack) {
            sum += o;
        }

        System.out.println(sum);
    }

}