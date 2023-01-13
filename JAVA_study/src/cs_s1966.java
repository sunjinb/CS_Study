import java.util.Scanner;
import java.io.FileInputStream;

class cs_s1966
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = arr.length - 1; i > 0; i--) {
                // 따라서, 한 번의 반복마다 가장 뒤의 인덱스는 비교하지 않도록 반복문을 설계할 수 있다.
                for(int j = 0; j < i; j++) {
                    // 만일, 앞의 수가 뒤의 수보다 더 크다면 swap 연산을 진행해준다.
                    if(arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            System.out.print("#" + test_case);
            for(int i = 0; i < arr.length; i++){
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}