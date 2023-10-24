import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int S, X, Y;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Info implements Comparable<Info>{
        int row, col, type;
        public Info(int row, int col, int type){
            this.row = row;
            this.col = col;
            this.type = type;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.type, o.type);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        ArrayList<Info> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    list.add(new Info(i, j, map[i][j]));
                }
            }
        }

        Collections.sort(list);
        Queue<Info> q = new LinkedList<>(list);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int time = 0;
        while (time != S) {

            int qSize = q.size();

            while (qSize-- > 0) {
                Info now = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nextRow = now.row + dRow[d];
                    int nextCol = now.col + dCol[d];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= N
                            || nextCol >= N) continue;

                    if (map[nextRow][nextCol] != 0) continue;

                    map[nextRow][nextCol] = now.type;
                    q.add(new Info(nextRow, nextCol, now.type));
                }
            }
            time++;
        }

        System.out.println(map[X - 1 ][Y - 1]);
    }
}
