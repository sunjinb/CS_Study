import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;
        char[][] map = new char[8][8];
        for(int i = 0; i < 8; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                map[i][j] = str.charAt(j);
                if((i + j) % 2 == 0 && map[i][j] == 'F') count++;
            }
        }

        System.out.println(count);
    }
}
