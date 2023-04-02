import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_19238 {
    static int N, M, fuel;
    static int[][] map;
    static boolean[][] visited;
    static Point startPoint;
    static ArrayList<Point> startList;
    static ArrayList<Point> destList;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point{
        int row, col, depth;
        public Point(int row, int col, int depth){
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    static class SAD{
        int startRow, startCol, endRow, endCol, depth;
        public SAD(int startRow, int startCol, int endRow, int endCol, int depth){
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startPoint = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        startList = new ArrayList<>();
        destList = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            startList.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
            destList.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
        }

        int result = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);

        while (!q.isEmpty()) {
            Point now = q.poll();

            // 현재 위치로부터 최단거리의 사람 고르기
            SAD next = findClosePerson(now);
            
            // 사람한테 이동한 거리만큼 기름 빼기
            fuel -= next.depth;
            
            // 목적지까지 이동
            int toDest = moveDestination(next);
            if(toDest == -1){
                result = -1;
                break;
            }
            else{
                fuel -= toDest;
            }

            if(fuel < 0) {
                result = -1;
                break;
            }
            else{
                fuel += (next.depth + toDest) * 2;
            }

            q.add(new Point(next.endRow, next.endCol, 0));
        }
    }

    private static int moveDestination(SAD next) {
        int result = -1;

        visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();

        visited[next.startRow][next.startCol] = true;
        q.add(new Point(next.startRow, next.startCol, 0));

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.row == next.endRow && cur.col == next.endCol){
                result = cur.depth;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nextRow = cur.row + dRow[i];
                int nextCol = cur.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;

                if(visited[nextRow][nextCol] || map[nextRow][nextCol] == 1) continue;

                visited[nextRow][nextCol] = true;
                q.add(new Point(nextRow, nextCol, cur.depth + 1));
            }
        }

        return result;
    }

    private static SAD findClosePerson(Point now) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[now.row][now.col] = true;
        q.add(now);

        ArrayList<SAD> closeList = new ArrayList<>();
        int closeDepth = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Point cur = q.poll();

            if(closeDepth < cur.depth){
                break;
            }

            // 사람 만났는지 확인
            for(int i = 0; i < startList.size(); i++){
                if(cur.row == startList.get(i).row && cur.col == startList.get(i).col){
                    closeDepth = cur.depth;
                    // 만약 현재 기름으로 갈 수 없는 위치라면 여기서 처리해야함
                    closeList.add(new SAD(cur.row, cur.col, cur.depth, destList.get(i).row, destList.get(i).col));
                }
            }

            for(int i = 0; i < 4; i++){
                int nextRow = cur.row + dRow[i];
                int nextCol = cur.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;

                if(visited[nextRow][nextCol] || map[nextRow][nextCol] == 1) continue;

                visited[nextRow][nextCol] = true;
                q.add(new Point(nextRow, nextCol, cur.depth + 1));
            }
        }

        SAD closePerson = null;
        if (closeList.size() == 1){
            closePerson = closeList.get(0);
        }
        else{
            int closeRow = Integer.MAX_VALUE, closeCol = Integer.MAX_VALUE;
            int closeIdx = -1;
            for(int i = 0; i < closeList.size(); i++){
                SAD tmp = closeList.get(i);
                if(tmp.startRow < closeRow){
                    closeRow = tmp.startRow;
                    closeCol = tmp.startCol;
                    closeIdx = i;
                }
                else if(tmp.startRow == closeRow){
                    if(tmp.startCol < closeCol){
                        closeRow = tmp.startRow;
                        closeCol = tmp.startCol;
                        closeIdx = i;
                    }
                }
            }
            closePerson = closeList.get(closeIdx);
        }
        return closePerson;
    }
}
