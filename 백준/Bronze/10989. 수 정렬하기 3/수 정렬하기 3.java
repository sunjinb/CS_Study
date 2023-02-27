import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int size = 10001;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[value]++;
		}
		
		for(int i = 1; i < size; i++) {
			if(arr[i] > 0) {
				int cnt = arr[i];
				while(cnt > 0) {
					sb.append(i + "\n");
					cnt--;
				}
			}
		}
		System.out.println(sb);
	}

}