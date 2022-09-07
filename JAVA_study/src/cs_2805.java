import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각각 나무의 높이 선언
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < tree.length; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
    }
}
