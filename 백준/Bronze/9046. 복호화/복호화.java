import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){
            String str = br.readLine();
            int[] visited = new int[26];

            for(int i = 0; i < str.length(); i++){
                char tmp = str.charAt(i);

                if(tmp >= 97 && tmp <= 122){
                    visited[tmp - 97]++;
                }
            }

            int max = 0;
            char result = '?';
            for(int i = 0; i < 26; i++){
                if(max < visited[i]){
                    max = visited[i];
                    result = (char)(i + 97);
                }
                else if(max == visited[i]){
                    result = '?';
                }
            }

            System.out.println(result);
        }
    }
}
