import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String T = br.readLine();

        while(true){
            if(S.length() == T.length()){
                if(T.equals(S)){
                    sb.append(1);
                }
                else{
                    sb.append(0);
                }
                break;
            }

            char tmp = T.charAt(T.length() - 1);

            T = T.substring(0, T.length() - 1);

            if(tmp == 'B'){
                T = new StringBuilder(T).reverse().toString();
            }
        }
        System.out.println(sb);
    }
}
