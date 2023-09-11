import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                map = new HashMap<>();
            }
            else{
                if(map.containsKey(str)){
                    continue;
                }
                else{
                    map.put(str, 1);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
