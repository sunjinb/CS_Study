import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static class Info implements Comparable<Info> {
        String name;
        int korean, english, math;

        public Info(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Info o) {
            if (this.korean != o.korean) {
                return Integer.compare(o.korean, this.korean);
            } else if (this.english != o.english) {
                return Integer.compare(this.english, o.english);
            } else if (this.math != o.math) {
                return Integer.compare(o.math, this.math);
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Info> infoList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            infoList.add(new Info(name, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(infoList);

        for (Info info : infoList) {
            System.out.println(info.name);
        }
    }
}
