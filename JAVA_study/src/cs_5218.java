import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_5218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            sb.append("Distances: ");
            for(int i = 0; i < str1.length(); i++){
                int tmp1 = str1.charAt(i);
                int tmp2 = str2.charAt(i);

                if(tmp1 <= tmp2) sb.append(tmp2 - tmp1 + " ");
                else {
                    int result = (tmp2 + 26) - tmp1;
                    sb.append(result + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
