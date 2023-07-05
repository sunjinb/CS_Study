import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String name = br.readLine();

            if(map.containsKey(name)){
                map.put(name, map.get(name) + 1);
            }
            else{
                map.put(name, 1);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        int resultValue = 0;
        for(String key : map.keySet()){
            if(resultValue < map.get(key)){
                resultValue = map.get(key);
                list = new ArrayList<>();
                list.add(key);
            }
            else if(resultValue == map.get(key)){
                list.add(key);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
