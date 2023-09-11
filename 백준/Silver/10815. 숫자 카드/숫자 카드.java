import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int need = Integer.parseInt(st.nextToken());
			int low = 0;
			int high = N - 1;
			boolean flag = false;
			while(low <= high) {
				int mid = (low + high) / 2;
				
				if(arr[mid] < need){
	                low = mid + 1;
	            }
	            else if(need < arr[mid]){
	                high = mid - 1;
	            }
	            else if(need == arr[mid]){
	                flag = true;
	                break;
	            }
			}
			if(flag) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		System.out.println(sb);
		
	}
}
