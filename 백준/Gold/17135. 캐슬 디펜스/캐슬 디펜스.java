import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D;
    static int[] sel;
    static int[][] map;
    static int result;
    static ArrayList<Point> tmpEnemyList;
    static ArrayList<Point> enemyList;
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
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        enemyList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enemyList.add(new Point(i, j));
            }
        }

        result = Integer.MIN_VALUE;
        sel = new int[3];
        // 궁수의 위치 정하기
        comb(0, 0);
        System.out.println(result);
    }

    private static void comb(int idx, int count) {
        // 궁수 3명의 자리를 다 뽑음
        if(count == 3){
            // 원본 병사들의 위치를 기억하기 위해 복사해놓자
            makeTmpEnemy();
            // 게임 진행해보기
            int deathEnemyCount = playGame();
            result = Math.max(result, deathEnemyCount);
            return;
        }
        
        // 궁수의 위치는 행 N으로 고정, 가로 값만이 변화
        for(int i = idx; i < M; i++){
            sel[count] = i;
            comb(i + 1, count + 1);
        }
    }

    // tmpMap 으로만 작업
    private static int playGame() {
        int deathEnemy = 0;
        while(true){
            // 이번 시점에 죽을 녀석들
            ArrayList<Point> timeDeathList = new ArrayList<>();

            for(int i = 0; i < sel.length; i++){
                // 차례차례 궁수의 위치 // 궁수의 위치는 (N, sel[i])
                Point archer = new Point(N, sel[i]);

                // 턴마다 궁수는 적 하나를 공격할 수 있다
                // 궁수가 공격할 적 찾기
                int minDistance = Integer.MAX_VALUE;
                int minEnemyIdx = -1;
                int minEnemyCol = M;
                for(int enemy = 0; enemy < tmpEnemyList.size(); enemy++){
                    Point curEnemy = tmpEnemyList.get(enemy);
                    int distance = Math.abs(archer.row - curEnemy.row) + Math.abs(archer.col - curEnemy.col);
                    // 궁수가 공격하는 적은 거리가 D 이하인 적 중 가장 가까운 적
                    // 적과의 거리가 D이하라서 궁수가 죽일 수 있다면
                    if(distance <= D){
                        // 이번 적이 가장 작은 거리의 적이라면 얘로 확정
                        if(distance < minDistance){
                            minDistance = distance;
                            minEnemyIdx = enemy;
                            minEnemyCol = curEnemy.col;
                        }
                        // 거리가 같다면
                        else if(distance == minDistance){
                            // 가장 가까운 적이 여럿이라면 가장 왼쪽에 있는 적
                            if(curEnemy.col < minEnemyCol){
                                minEnemyIdx = enemy;
                                minEnemyCol = curEnemy.col;
                            }
                        }
                    }
                }
                // 죽일 수 있는 적이 없을 수도 있음 
                // 죽일 수 있다면 죽일 리스트에 추가
                if(minEnemyIdx != -1){
                    timeDeathList.add(tmpEnemyList.get(minEnemyIdx));
                }
            }

            // 죽일 리스트 녀석들 죽이자
            // 같은 적이 여러 궁수에게 공격 당할 수 있음
            for(int e = 0; e < timeDeathList.size(); e++){
                for(int te = 0; te < tmpEnemyList.size(); te++){
                    if(timeDeathList.get(e) == tmpEnemyList.get(te)){
                        // 리스트에서 무언가를 지우면 인덱스를 하나 전으로 해줘야 순차적으로 모든 원소 탐색 가능
                        tmpEnemyList.remove(te);
                        te--;
                        deathEnemy++;
                    }
                }
            }

            for(int m = 0; m < tmpEnemyList.size(); m++){
                Point enemy = tmpEnemyList.get(m);
                enemy.row++;
                if(enemy.row == N){
                    tmpEnemyList.remove(enemy);
                    m--;
                }
            }
            
            // 종료 조건은 무조건 지도에 적이 없을 경우
            if(tmpEnemyList.size() == 0){
                break;
            }
        }
        return deathEnemy;
    }
    private static void makeTmpEnemy() {
        tmpEnemyList = new ArrayList<>();
        for(int i = 0; i < enemyList.size(); i++){
            Point enemy = enemyList.get(i);
            tmpEnemyList.add(new Point(enemy.row, enemy.col));
        }
    }
}
