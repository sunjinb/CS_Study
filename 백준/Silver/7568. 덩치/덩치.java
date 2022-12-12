import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] array = new int[N][2];


        for(int i = 0; i < N; i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            int rank = 1;
            for(int j = 0; j < N; j++){
                if(i == j){
                    continue;
                }
                if(array[i][0] < array[j][0] && array[i][1] < array[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
