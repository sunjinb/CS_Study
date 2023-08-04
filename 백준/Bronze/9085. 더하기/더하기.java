import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int testCase= 1; testCase <= T; testCase++){
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum+ "\n");
        }
        System.out.println(sb);
    }
}
