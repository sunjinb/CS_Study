import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int first = 0;
			int second = 0;
			first = W * P;
			
            if(W <= R){
            	second = Q;
            }
			else {
                second = Q;
				second += (W - R) * S;
			}
			
			int result = 0;
			if(first <= second) result = first;
			else result = second;
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}