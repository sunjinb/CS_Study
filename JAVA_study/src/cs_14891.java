import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_14891 {
    static int[][] data = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 톱니바퀴 값 할당
        for(int i = 0; i < 4; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                data[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) -1;
            int dir = Integer.parseInt(st.nextToken());
            operation(idx, dir);
        }

        int result = 0;
        for(int i = 0; i < 4; i++){
            result += Math.pow(2, i) * data[i][0];
        }
        System.out.println(result);
    }

    static void operation(int idx, int dir) {
        // 회전 톱니바퀴 기준 왼쪽 톱니바퀴
        leftSide(idx-1, -dir);
        // 회전 톱니바퀴 기준 오른쪽 톱니바퀴
        rightSide(idx+1, -dir);
        // 톱니바퀴 회전
        rotation(idx,dir);
    }

    static void leftSide(int idx, int dir) {
        // 범위 밖이라면 return
        if (idx < 0) {
            return;
        }
        // 인접한 톱니바퀴의 극이 같다면 return
        if (data[idx][2] == data[idx + 1][6]) {
            return;
        }

        // 아니라면 왼쪽 톱니바퀴도 회전
        leftSide(idx-1, -dir);
        rotation(idx,dir);
    }

    static void rightSide(int idx, int dir) {
        // 범위 밖이라면 return
        if (idx > 3) {

            return;
        }
        // 인접한 톱니바퀴의 극이 같다면 return
        if (data[idx][6] == data[idx - 1][2]) {
            return;
        }
        
        // 아니라면 오른쪽 톱니바퀴도 회전
        rightSide(idx+1, -dir);
        rotation(idx,dir);
    }

    // 직접적인 톱니 회전 부분
    static void rotation(int idx, int dir) {
        // 정방향일 경우
        if (dir == 1) {
            int tmp = data[idx][7];
            for (int i = 7; i > 0; i--) {
                data[idx][i] = data[idx][i - 1];
            }
            data[idx][0] = tmp;
        }
        // 역방향일 경우
        else {
            int tmp = data[idx][0];
            for (int i = 0; i < 7; i++) {
                data[idx][i] = data[idx][i + 1];
            }
            data[idx][7] = tmp;
        }
    }
}
