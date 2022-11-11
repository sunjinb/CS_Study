import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[10];

        int value = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());

        String str = String.valueOf(value);

        for (int i = 0; i < str.length(); i++) {
            array[(str.charAt(i) - '0')]++;
        }

        for (int v : array) {
            System.out.println(v);
        }

    }
}