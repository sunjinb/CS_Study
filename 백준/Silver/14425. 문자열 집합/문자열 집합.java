import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            map.put(tmp, 1);
        }

        int result = 0;
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(map.containsKey(str)){
                result++;
            }
        }
        System.out.println(result);
    }
}
