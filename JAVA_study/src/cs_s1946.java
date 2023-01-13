import java.util.Scanner;

class cs_s1946
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            String[] alpha = new String[N];
            int[] alphaCount = new int[N];

            // 총 출력 횟수
            int count = 0;
            for(int i = 0; i < N; i++) {
                alpha[i] = sc.next();
                alphaCount[i] = sc.nextInt();
                count += alphaCount[i];
            }

            int idx = 0;
            String[] arr = new String[count];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < alphaCount[i]; j++){
                    arr[idx] = alpha[i];
                    idx++;
                }
            }

            System.out.println("#" + test_case);
            for(int i = 0; i < idx; i++){
                if(i != 0 && i % 10 == 0){
                    System.out.println();
                }
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}