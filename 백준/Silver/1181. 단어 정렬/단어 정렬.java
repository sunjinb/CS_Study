import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] strList = new String[N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            strList[i] = str;
        }

        Arrays.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else{
                    return Integer.compare(o1.length(), o2.length());
                }
            }
        });

        System.out.println(strList[0]);
        for(int i = 1; i < strList.length; i++){
            if(strList[i].equals(strList[i - 1])){
                continue;
            }
            else{
                System.out.println(strList[i]);
            }
        }

    }
}
