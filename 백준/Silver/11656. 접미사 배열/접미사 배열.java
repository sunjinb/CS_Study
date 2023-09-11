import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            String tmp = S.substring(i, S.length());
            list.add(tmp);
        }

        Collections.sort(list);
        
        for(String s : list){
            System.out.println(s);
        }
    }
}
