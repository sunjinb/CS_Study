import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cs_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = 0;
        while(true){
            if(len >= s.length()) break;

            if(len + 1 < s.length() && s.charAt(len) == 'p' && s.charAt(len + 1) == 'i'){
                len += 2;
                continue;
            }
            else if(len + 1 < s.length() && s.charAt(len) == 'k' && s.charAt(len + 1) == 'a'){
                len += 2;
                continue;
            }
            else if(len + 2 < s.length() && s.charAt(len) == 'c' && s.charAt(len + 1) == 'h' && s.charAt(len + 2) == 'u'){
                len += 3;
                continue;
            }
            break;
        }
        if(len == s.length()) System.out.println("YES");
        else System.out.println("NO");
    }
}
