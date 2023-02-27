
import java.util.Scanner;

class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] chess = {1, 1, 2, 2, 2, 8};
		int[] input = new int[6];
		for(int i = 0; i < 6; i++) {
			input[i] = sc.nextInt();
		}
		for(int i = 0; i < 6; i++) {
			System.out.print(chess[i] - input[i] + " ");
		}
				
		
		sc.close();
	}

}