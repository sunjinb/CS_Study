import java.util.Scanner;

public class cs_s2001{
    static int max, n, m;
    static int[][] area;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc =0; tc < T; tc++){
            n = sc.nextInt();
            m = sc.nextInt();
            area = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    area[i][j] = sc.nextInt();
                }
            }

            max = 0;
            for(int i = 0; i <= n-m; i++){
                for(int j = 0; j <= n-m; j++){
                    getMax(i,j);
                }
            }
            System.out.println("#" + (tc+1) + " " + max);
        }

    }

    static void getMax(int x, int y){
        int sum = 0;
        for(int i = x; i < x + m; i++){
            for(int j = y; j < y+m; j++){
                sum += area[i][j];
            }
        }
        if(max < sum)
            max = sum;
    }
}

//import java.util.Scanner;
//import java.lang.String;
//
//public class cs_s2001 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        int result_num = 0;
//        int[] result = new int[T];
//
//        for(int i = 0; i < T; i++){
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//            int[][] array = new int[N][N];
//            for(int j = 0; j < N; j++){
//                for(int k = 0; k < N; k++){
//                    array[j][k] = sc.nextInt();
//                }
//            }
//            int sample_result = getMax(array, N, M);
//            result[i] = sample_result;
//        }
//
//        for(int i = 0; i < T; i++){
//            System.out.println("#" + (result_num + 1) + " " + result[i]);
//        }
//    }
//
//    public static int getMax(int[][] array, int N, int M) {
//        int max = 0;
//        for (int i = 0; i <= N - M; i++) {
//            for (int j = 0; j <= N - M; j++) {
//                int sample_count = array[i][j] + array[i][j+1] + array[i+1][j] + array[i+1][j+1];
//                if(sample_count >= max){
//                    max = sample_count;
//                }
//            }
//        }
//        return max;
//    }
//}
