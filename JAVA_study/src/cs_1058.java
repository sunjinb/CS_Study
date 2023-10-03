import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_1058 {
    static int N;
    static final int INF = 987654321;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                char tmp = str.charAt(j);
                if(i == j) {
                    map[i][j] = 0;
                    continue;
                }
                if(tmp == 'Y') map[i][j] = 1;
                else map[i][j] = INF;
            }
        }

        // 경유지
        for(int k = 0; k < N; k++){
            // 출발지
            for(int i = 0; i < N; i++){
                if(k == i) continue; // 경유지와 출발지가 같다면 할 필요 없음
                // 도착지
                for(int j = 0; j < N; j++){
                    // 출발지와 도착지가 같거나, 경유지가 도착지가 같다면 할 필요 없음
                    if(i == j || k == j) continue;
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int count = 0;
        int result = 0;
        for(int i = 0; i < N; i++){
            count = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(map[i][j] <= 2){
                    count++;
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}
