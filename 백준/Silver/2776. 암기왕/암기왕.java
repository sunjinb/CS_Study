import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int tmp = Integer.parseInt(st.nextToken());
                map.put(tmp, 1);
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                int tmp = Integer.parseInt(st.nextToken());
                if(map.containsKey(tmp)){
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
