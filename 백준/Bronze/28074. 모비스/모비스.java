import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), 1);
        }

        char[] tmp = new char[5];
        tmp[0] = 'M';
        tmp[1] = 'O';
        tmp[2] = 'B';
        tmp[3] = 'I';
        tmp[4] = 'S';

        int count = 0;
        for(int i = 0; i < 5; i++){
            if(map.containsKey(tmp[i])){
                count++;
            }
        }

        if(count == 5){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
