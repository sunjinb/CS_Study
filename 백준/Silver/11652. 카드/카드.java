import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            long tmp = Long.parseLong(br.readLine());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int resultValue = 0;
        long result = 0;
        for (long key : map.keySet()) {
            if(resultValue == map.get(key)){
                if(key < result){
                    result = key;
                }
            }
            else if(resultValue < map.get(key)){
                resultValue = map.get(key);
                result = key;
            }
        }
        System.out.println(result);
    }
}
