import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            long N = Long.parseLong(br.readLine());

            if(N <= 2){
                sb.append(2 + "\n");
            }
            else{
                while(true)
                {
                    int result = 0;
                    for (long j = 2; j <= Math.sqrt((double) N); j++) {

                        if (N % j == 0) {
                            result++;
                            break;
                        }
                    }

                    if(result == 0)
                    {
                        sb.append(N + "\n");
                        break;
                    }
                    N++;
                }
            }
        }
        System.out.println(sb);
    }
}
