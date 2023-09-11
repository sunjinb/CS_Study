import java.io.*;
import java.util.*;

public class Main {
	static int N, B, C;
	static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        long result = 0;
        
        for(int i = 0; i < N; i++) {
        	result++;
        	
        	arr[i] = arr[i] - B;
        	
        	if(arr[i] < 0) continue;
        	
        	if(arr[i] % C == 0) result += arr[i] / C;
        	else result = result + (arr[i] / C) + 1;
        }
        
        System.out.println(result);
	}
}