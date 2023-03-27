import java.util.Scanner;

public class cs_professor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            // 시작지점
            for(int startRow = 0; startRow < N; startRow++) {
                for(int startCol = 0; startCol < N; startCol++) {

                    // 종료지점
                    for(int endRow = 0; endRow < N; endRow++) {
                        for(int endCol = 0; endCol < N; endCol++) {

                            // 계산지점
                            int count = 1;
                            int start_x = startRow;
                            for(int nowRow = startRow; nowRow < endRow - 1; nowRow++){
                                for(int nowCol = startCol; nowCol < endCol - 1; nowCol++){
                                    if(Math.abs(map[start_x][nowCol] - map[start_x][nowCol + 1]) <= K){
                                        count++;
                                    }
                                    else{
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
