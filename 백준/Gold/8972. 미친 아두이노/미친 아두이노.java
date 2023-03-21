import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static Queue<Point> person;
    static Queue<Point> robot;
    static int[] dRow = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dCol = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    static class Point{
        int row, col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        person = new LinkedList<>();
        robot = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I') {
                    person.add(new Point(i, j));
                }
                else if(map[i][j] == 'R') {
                    robot.add(new Point(i, j));
                }
            }
        }

        int count = 1;
        boolean flag = true;
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            int dir = str.charAt(i) - '0';
            
            // 사람 움직임
            if(!personMove(dir)){
                flag = false;
                break;
            }

            // 로봇들 움직임
            if(!robotsMove()){
                flag = false;
                break;
            }
            count++;
        }
        if(!flag) System.out.println("kraj " + count);
        else printMap();
    }

    private static void printMap() {
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean robotsMove() {
        int[][] robotCountMap = new int[R][C];

        Point personPoint = person.peek();
        int personRow = personPoint.row;
        int personCol = personPoint.col;

        while (!robot.isEmpty()) {
            Point now = robot.poll();

            map[now.row][now.col] = '.';

            int minDis = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i = 1; i <= 9; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;

                if(i == 5) continue;

                int distance = Math.abs(personRow - nextRow) + Math.abs(personCol - nextCol);

                if(distance < minDis) {
                    minDis = distance;
                    minIdx = i;
                }
            }

            int robotNextRow = now.row + dRow[minIdx];
            int robotNextCol = now.col + dCol[minIdx];

            // 다음 로봇 장소가 사람이면 종료
            if(map[robotNextRow][robotNextCol] == 'I') return false;

            // 다음 로봇의 장소 카운팅
            robotCountMap[robotNextRow][robotNextCol] += 1;
        }
        
        // 터지는 로봇 제외
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(robotCountMap[i][j] == 1){
                    robot.add(new Point(i, j));
                    map[i][j] = 'R';
                }
            }
        }
        return true;
    }

    private static boolean personMove(int dir) {
        Point now = person.poll();

        map[now.row][now.col] = '.';
        int nextRow = now.row + dRow[dir];
        int nextCol = now.col + dCol[dir];

        // 이동할 자리가 로봇이라면 안됨
        if(map[nextRow][nextCol] == 'R') return false;
        // 아니라면 움직임
        else{
            person.add(new Point(nextRow, nextCol));
            map[nextRow][nextCol] = 'I';
        }
        return true;
    }
}