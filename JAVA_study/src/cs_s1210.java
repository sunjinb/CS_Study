
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_s1210 {
    static int[] dRow = {0, 0, -1};
    static int[] dCol = {-1, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(br.readLine()).append(" ");

            int[][] map = new int[100][100];
            int col = 0, row = 99;

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 99 && map[i][j] == 2) col = j;
                }
            }

            int nextCol, nextRow;
            while (row != 0) {
                for (int i = 0; i < 3; i++) {
                    nextCol = col + dCol[i];
                    nextRow = row + dRow[i];
                    if (nextCol < 0 || nextCol >= 100 || nextRow < 0 || nextRow >= 100 || map[nextRow][nextCol] == 0)
                        continue;
                    col = nextCol;
                    row = nextRow;
                    map[nextRow][nextCol] = 0;
                }
            }

            sb.append(col).append("\n");
        }

        System.out.print(sb);
    }

}