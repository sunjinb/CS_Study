import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static class Point{
        int row, col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static int[] dRow = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dCol = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];

        for(int i = 0; i < 8; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                map[i][j] = str.charAt(j);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(7, 0));

        boolean flag = false;
        
        // 시간 돌리는거
        while(true){
            if(q.isEmpty()) break;
            
            int qSize = q.size();
            
            while(qSize > 0){
                qSize--;

                Point now = q.poll();

                if(map[now.row][now.col] == '#'){
                    continue;
                }
                
                if(now.row == 2) {
                    flag = true;
                    break;
                }

                if(now.row == 0 && now.col == 7){
                    flag = true;
                    break;
                }

                for(int i = 0; i < 9; i++){
                    int nextRow = now.row + dRow[i];
                    int nextCol = now.col + dCol[i];

                    if(nextRow < 0 || nextCol < 0 || nextRow > 7 || nextCol > 7) continue;

                    if(map[nextRow][nextCol] == '.'){
                        q.add(new Point(nextRow, nextCol));
                    }
                }
            }
            
            if(flag) break;
            moveWall();
        }

        if(!flag) System.out.println(0);
        else System.out.println(1);
    }

    private static void moveWall() {
        for(int i = 7; i > 0; i--){
            for(int j = 0; j < 8; j++){
                map[i][j] = map[i - 1][j];
            }
        }

        // 맨 위 벽 처리
        for(int i = 0; i < 8; i++){
            map[0][i] = '.';
        }
    }
}
