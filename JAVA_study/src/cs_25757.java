import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cs_25757 {
    static int N;
    static char type;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        type = st.nextToken().charAt(0);

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            hashMap.put(str, hashMap.getOrDefault(str, 1) + 1);
        }

        int result = 0;
        if(type == 'Y') result = hashMap.size();
        if(type == 'F') result = hashMap.size() / 2;
        if(type == 'O') result = hashMap.size() / 3;

        System.out.println(result);
    }
}
