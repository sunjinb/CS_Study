import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int resultH = 0;
        int resultV = 0;

        for(int i = 0; i < N; i++){
            int checkH = 0;
            int checkV = 0;
            for(int j = 0; j < N; j++){
                if(map[i][j] == '.') checkH++;
                if(map[i][j] == 'X' || (j == N - 1)){
                    if(checkH >= 2) resultH++;
                    checkH = 0;
                }

                if(map[j][i] == '.') checkV++;
                if(map[j][i] == 'X' || (j == N - 1)) {
                    if(checkV >= 2) resultV++;
                    checkV = 0;
                }
            }
        }

        System.out.println(resultH + " " + resultV);
    }
}
