import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C == 0) break;

            int max = Math.max(Math.max(A, B), C);

            if(max == A){
                int sum = B + C;

                if(A >= sum){
                    System.out.println("Invalid");
                    continue;
                }
            }

            if(max == B){
                int sum = A + C;

                if(B >= sum){
                    System.out.println("Invalid");
                    continue;
                }
            }

            if(max == C){
                int sum = B + A;

                if(C >= sum){
                    System.out.println("Invalid");
                    continue;
                }
            }

            if(A != B && A != C && B != C){
                System.out.println("Scalene");
                continue;
            }

            if(A == B && A == C && B == C){
                System.out.println("Equilateral");
                continue;
            }

            if(A == B || A == C || B == C){
                System.out.println("Isosceles");
                continue;
            }
        }
    }
}
