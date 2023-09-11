import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C, X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        boolean halfValid = false;

        if(A + B > C * 2){
            halfValid = true;
        }

        int result = 0;

        // 반반치킨으로 사!
        if(halfValid){
            if(X == Y) {
                result += C * 2 * X;
            }
            else if(X < Y){
                result += C * 2* X;
                result += (Y - X) * Math.min(B, C * 2);
            }
            else if(X > Y){
                result += C * 2 * Y;
                result += (X - Y) * Math.min(A, C * 2);
            }
        }
        else{
            result += A * X + B * Y;
        }
        System.out.println(result);
    }
}
