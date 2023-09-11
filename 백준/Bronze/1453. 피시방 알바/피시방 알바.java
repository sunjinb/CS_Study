import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    visited = new boolean[101];
	    int count = 0;
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= N; i++) {
	    	int pos = Integer.parseInt(st.nextToken());
	    	if(!visited[pos]) {
	    		visited[pos] = true;
	    		continue;
	    	}
	    	count++;
	    }
	    System.out.println(count);
	}
}