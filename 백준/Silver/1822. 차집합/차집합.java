import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int nA, nB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nA; i++){
            mapA.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nB; i++){
            mapB.put(Integer.parseInt(st.nextToken()), 1);
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        for(int t : mapA.keySet()){
            if (!mapB.containsKey(t)) {
                resultList.add(t);
            }
        }

        if(resultList.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(resultList.size());
            Collections.sort(resultList);
            for(int i = 0; i < resultList.size(); i++){
                System.out.print(resultList.get(i) + " ");
            }
        }
    }
}
