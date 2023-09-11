import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.length() <= 9 && str.length() >= 6){
                sb.append("yes\n");
            }
            else{
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}
