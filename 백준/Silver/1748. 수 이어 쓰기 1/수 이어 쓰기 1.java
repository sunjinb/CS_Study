import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int length = 0;
        int plustPositionValue = 1;
        int mul = 10;

        for(int i = 1; i <= N; i++){
            if(i % mul == 0){
                plustPositionValue++;
                mul *= 10;
            }
            length += plustPositionValue;
        }
        System.out.println(length);
    }
}
