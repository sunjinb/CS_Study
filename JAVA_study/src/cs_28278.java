import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class cs_28278 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            if(tmp == 1){
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            }
            else if(tmp == 2){
                if(stack.size() != 0){
                    sb.append(stack.pop() + "\n");
                }
                else{
                    sb.append(-1 + "\n");
                }
            }
            else if(tmp == 3){
                sb.append(stack.size() + "\n");
            }
            else if(tmp == 4){
                if (stack.isEmpty()) {
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
            else if(tmp == 5){
                if(stack.size() != 0){
                    sb.append(stack.peek() + "\n");
                }
                else{
                    sb.append(-1 + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
