import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.length() < M) continue;
            hashMap.put(tmp, hashMap.getOrDefault(tmp, 0) + 1);
        }
        
        ArrayList<String> words = new ArrayList<>(hashMap.keySet());
        
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.compare(hashMap.get(o1), hashMap.get(o2)) != 0) {
                    return Integer.compare(hashMap.get(o2), hashMap.get(o1));
                }
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}