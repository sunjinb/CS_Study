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

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)){
                map.remove(tmp);
            }
            else{
                map.put(tmp, 1);
            }
        }

        System.out.println(map.size());
    }
}
