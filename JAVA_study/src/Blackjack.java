import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        int n, m = 0;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        result = search(array, n, m);
        System.out.println("result = " + result);
    }
        static int search(int[] array, int n, int m){
            int result = 0;
            int tmp = 0;
            for(int i = 0; i < n - 2; i++){
                for(int j = 0; j < n - 1; j++){
                    for(int k = 0; k < n; k++){
                        if(i == j || j == k || k == i){
                            continue;
                        }
                        tmp = array[i] + array[j] + array[k];
                        if(tmp <= m && result <= tmp){
                            result = tmp;
                        }
                    }
                }
            }
            return result;
        }
}
