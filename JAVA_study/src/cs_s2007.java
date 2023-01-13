import java.util.Scanner;

public class cs_s2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            String str = sc.next();
            for(int i = 1; i <= str.length(); i++){
                String alpha = str.substring(0, i);
                String beta = str.substring(i, i+i);
                if(alpha.equals(beta)){
                    System.out.printf("#%d %d\n", test_case, beta.length());
                    break;
                }
            }
        }

    }
}
