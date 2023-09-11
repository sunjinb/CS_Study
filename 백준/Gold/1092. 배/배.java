import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer> limit;
    static ArrayList<Integer> box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        limit = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            limit.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(limit, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Collections.sort(box, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int result = 0;
        if(limit.get(0) < box.get(0)){
            result = -1;
        }

        if(result != -1){
            result = 0;
            while(!box.isEmpty()){
                int tmp = 0;
                for(int i = 0; i < limit.size(); i++){
                    if(tmp == box.size()) {
                        break;
                    }

                    if(limit.get(i) >= box.get(tmp)){
                        box.remove(tmp);
                    }
                    else{
                        tmp++;
                        i--;
                    }
                }
                result++;
            }
        }

        System.out.println(result);
    }
}
