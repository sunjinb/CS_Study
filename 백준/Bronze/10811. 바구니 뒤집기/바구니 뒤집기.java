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
        
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken()) - 1;
			int tmp2 = Integer.parseInt(st.nextToken()) - 1;
			
			while (tmp1 < tmp2) {
				int temp = arr[tmp1];
				arr[tmp1++] = arr[tmp2];
				arr[tmp2--] = temp;
			}

		}
	
		for (int j = 0; j < N; j++) {
            sb.append(arr[j] + " ");
		}
		System.out.print(sb);
	}
}