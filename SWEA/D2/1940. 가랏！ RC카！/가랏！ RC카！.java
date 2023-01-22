
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
			int N = sc.nextInt();
			int speed = 0;
			int distance = 0;
			for(int i = 0; i < N; i++) {
				int mode = sc.nextInt();
				if(mode == 1) {
					speed += sc.nextInt();
				}
				else if(mode == 2) {
					speed -= sc.nextInt();
                    if(speed < 0){
                    	speed = 0;
                    }
				}
				distance += speed;
			}
			System.out.printf("#%d %d\n", test_case, distance);
		}
	}
}