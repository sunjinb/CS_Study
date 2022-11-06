import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        //최대값
        int max = A;
        //세 수가 같을때
        if(A == B && B == C) {
            System.out.println(10000 + (1000 * A));
            //세 수가 다를때
        }else if(A != B && B != C && A != C) {
            //최대값 구하기
            if(max < B) {
                max = B;
            }
            if(max < C) {
                max = C;
            }
            System.out.println(100 * max);
            //두 수만 같을때
        }else {
            //같은 수 구하기
            if(A != B) {
                System.out.println(1000 + (100 * C));
            }else if(A != C) {
                System.out.println(1000 + (100 * B));
            }

        }
    }

}