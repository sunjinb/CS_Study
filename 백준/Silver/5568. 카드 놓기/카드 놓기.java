import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static String[] arr;
	static boolean[] visited;
	static HashSet<String> hashSet;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    K = Integer.parseInt(br.readLine());
	    
	    arr = new String[N];
	    for(int i = 0; i < N; i++) {
	    	arr[i] = br.readLine();
	    }
	    
	    hashSet = new HashSet<>();
	    visited = new boolean[N];
	    perm(0, 0, "");
	    
	    
	    System.out.println(hashSet.size());
	    
	}
	private static void perm(int idx, int count, String str) {
		// 일단 카드 뽑자
		if(count == K) {
//			System.out.println(str);
			hashSet.add(str);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(i + 1, count + 1, str + arr[i]);
				visited[i] = false;
			}
			
		}
	}
}