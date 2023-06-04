import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count1;
    static int[] count2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if(str1.length() != str2.length()){
                sb.append(str1 + " & " + str2 + " are NOT anagrams." + "\n");
                continue;
            }

            count1 = new int[26];
            count2 = new int[26];

            for(int i = 0; i < str1.length(); i++){
                count1[str1.charAt(i) - 97]++;
                count2[str2.charAt(i) - 97]++;
            }

            boolean flag = true;
            for(int i = 0; i < count1.length; i++){
                if(count1[i] != count2[i]){
                    flag = false;
                    break;
                }
            }

            if(!flag){
                sb.append(str1 + " & " + str2 + " are NOT anagrams." + "\n");
            }
            else{
                sb.append(str1 + " & " + str2 + " are anagrams." + "\n");
            }

        }
        System.out.println(sb);
    }
}
