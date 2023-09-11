import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if(!map.containsKey(kind)){
                    map.put(kind, 1);
                }
                else{
                    map.put(kind, map.get(kind) + 1);
                }
            }

            int result = 1;
            for(int count : map.values()){
                result *= count + 1;
            }

            sb.append(result - 1 + "\n");
        }

        System.out.println(sb);
    }
}
