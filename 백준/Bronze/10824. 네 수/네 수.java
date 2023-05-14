import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String a, b, c, d;
        a = st.nextToken();
        b = st.nextToken();
        c = st.nextToken();
        d = st.nextToken();

        a = a + b;
        c = c + d;

        long sum = Long.parseLong(a) + Long.parseLong(c);
        System.out.println(sum);
    }
}
