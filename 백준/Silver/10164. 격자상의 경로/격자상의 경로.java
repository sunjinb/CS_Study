import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] dRow = {0, 1};
    static int[] dCol = {1, 0};
    static class Point{
        int row, col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int circleRow = 1;
        int circleCol = 1;
        int toMidCount = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));

        if(K != 0){
            toMidCount = 0;
            circleRow = K / M + 1;
            circleCol = K % M;

            if(circleCol == 0){
                circleRow -= 1;
                circleCol = M;
            }

            while(!q.isEmpty()){
                Point now = q.poll();
                if(now.row == circleRow && now.col == circleCol){
                    toMidCount++;
                }

                for(int i = 0; i < 2; i++){
                    int nextRow = now.row + dRow[i];
                    int nextCol = now.col + dCol[i];
                    if(nextRow > circleRow || nextCol > circleCol) continue;

                    q.add(new Point(nextRow, nextCol));
                }
            }
        }

        int toGoalCount = 0;
        q = new LinkedList<>();
        q.add(new Point(circleRow, circleCol));

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.row == N&& now.col == M){
                toGoalCount++;
            }

            for(int i = 0; i < 2; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow > N || nextCol > M) continue;
                q.add(new Point(nextRow, nextCol));
            }
        }

        System.out.println(toMidCount * toGoalCount);
    }
}
