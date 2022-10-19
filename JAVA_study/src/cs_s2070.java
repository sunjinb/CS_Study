import java.util.Scanner;

public class cs_s2070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        char[] result = new char[T];

        for(int i = 0; i < T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a > b) result[i] = '>';
            if(a < b) result[i] = '<';
            if(a == b) result[i] = '=';
        }

        for(int i = 0; i < result.length; i++){
            System.out.println("#" + (i + 1) + " " + result[i]);
        }
    }
}
