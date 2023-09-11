import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }

        Collections.sort(list);

        if(list.size() % 2 == 0){
            System.out.println(list.get(list.size() / 2 - 1));
        }
        else{
            System.out.println(list.get(list.size() / 2));
        }
    }
}
