import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class cs_17952 {
    static int N;
    static class Info{
        int point, time;
        public Info(int point, int time){
            this.point = point;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Info> stack = new Stack<>();

        int result = 0;
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 1){
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(T == 1){
                    result += A;
                }
                else{
                    stack.push(new Info(A, T - 1));
                }
            }
            else{
                if(stack.size() == 0){
                    continue;
                }
                else{
                    Info now = stack.pop();
                    if(now.time == 1){
                        result += now.point;
                    }
                    else{
                        stack.push(new Info(now.point, now.time - 1));
                    }
                }
            }
        }
        System.out.println(result);
    }
}
