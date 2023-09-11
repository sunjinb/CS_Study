import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static Point start;
    static Point end;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
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

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));


            System.out.println("#" + testCase + " " + bfs());
        }
    }

    private static int bfs() {
        visited = new boolean[N][N];

        Queue<Point> q = new LinkedList<>();
        visited[start.row][start.col] = true;
        q.add(start);

        int time = 0;
        while(!q.isEmpty()){
            int curSize = q.size();

            // 현재 시점 기준 움직일 수 있는 애들 움직임
            while(curSize-- > 0){
                Point now = q.poll();

                for(int i = 0; i < 4; i++){
                    int nextRow = now.row + dRow[i];
                    int nextCol = now.col + dCol[i];

                    // 범위 벗어나면 못 감
                    if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;

                    // 벽이면 못 감
                    if(map[nextRow][nextCol] == 1) continue;

                    // 방문 했으면 갈 필요 없음
                    if(visited[nextRow][nextCol]) continue;

                    // 소용돌이라면 조건에 부합해야 갈 수 있음
                    if(map[nextRow][nextCol] == 2){
                        // 2초에 한번 소용돌이가 사라지는 시점이 아니라면
                        if(time % 3 != 2){
                            q.add(new Point(now.row, now.col));
                            continue;
                        }
                    }
                    if(nextRow == end.row && nextCol == end.col){
                        return time + 1;

                    }

                    // 갈 수 있는 지점임
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol));
                }
            }
            time++;
        }
        return -1;
    }
}
