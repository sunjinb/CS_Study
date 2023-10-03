import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cs_3190 {
    static int N, K, L;
    static int[][] map;
    static ArrayList<Info> infoList;
    static class Info{
        int X;
        String C;
        public Info(int X, String C){
            this.X = X;
            this.C = C;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            // 사과 지도에 표시
            map[row][col] = 1;
        }

        infoList = new ArrayList<>();
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            infoList.add(new Info(X, C));
        }

        while(true){

        }
    }
}
