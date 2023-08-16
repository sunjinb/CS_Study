import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int hMin = Integer.MAX_VALUE;
        int dMin = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){
            int tmp = Integer.parseInt(br.readLine());
            if (tmp < hMin) {
                hMin = tmp;
            }
        }

        for(int i = 0; i < 2; i++){
            int tmp = Integer.parseInt(br.readLine());
            if (tmp < dMin) {
                dMin = tmp;
            }
        }

        System.out.println(dMin + hMin - 50);
    }
}
