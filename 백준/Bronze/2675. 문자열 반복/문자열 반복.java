import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] n_array = new int[n];
        String[] s_array = new String[n];

        for (int i = 0; i < n; i++){
            n_array[i] = sc.nextInt();
            s_array[i] = sc.next();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < s_array[i].length(); j++){
                for(int k = 0; k < n_array[i]; k++){
                    System.out.print(s_array[i].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
