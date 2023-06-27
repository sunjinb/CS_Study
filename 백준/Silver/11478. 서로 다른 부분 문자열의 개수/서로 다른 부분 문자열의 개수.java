import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i <= S.length(); i++){
            for(int j = i; j <= S.length(); j++){
                String tmp = S.substring(i, j);
                set.add(tmp);
            }
        }

//        for(String t : set){
//            System.out.println(t);
//        }

        System.out.println(set.size() - 1);
    }
}
