import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for(int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean isAscending = true;
		for(int i = 0; i < 7; i++) {
			if(arr[i] < arr[i + 1]) continue;
			isAscending = false;
		}
		
		boolean isDescending = true;
		for(int i = 0; i < 7; i++) {
			if(arr[i] > arr[i + 1]) continue;
			isDescending = false;
		}
		
		if(isAscending) System.out.println("ascending");
		else if(isDescending) System.out.println("descending");
		else System.out.println("mixed");
		
	}
}
