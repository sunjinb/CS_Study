import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[102];
		for(int i = 0; i < 3; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[value]++;
		}
		
		int result = 0;
		int count = 0;
		L:for(int i = 0; i < 102; i++) {
			if(arr[i] > 0) {
				int value = arr[i];
				while(value > 0) {
					count++;
					if(count == 2) {
						result = i;
						break L;
					}
					value--;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
