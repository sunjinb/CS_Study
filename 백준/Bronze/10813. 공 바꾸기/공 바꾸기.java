import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int tmp = arr[num1];
			arr[num1] = arr[num2];
			arr[num2] = tmp;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
