import java.util.Scanner;

public class cs_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String array[] = new String[sc.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.next();
        }

        sc.close();

        for (int i = 0; i < array.length; i++) {

            int cnt = 0;	// 연속횟수
            int sum = 0;	// 누적 합산

            for (int j = 0; j < array[i].length(); j++) {

                if (array[i].charAt(j) == 'O') {
                    cnt++;
                }
                else {
                    cnt = 0;
                }
                sum += cnt;
            }

            System.out.println(sum);
        }
    }
}