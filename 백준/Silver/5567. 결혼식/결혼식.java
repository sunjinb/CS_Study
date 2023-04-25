import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    list = new ArrayList[N + 1];
	    for(int i = 1; i <= N; i++) {
	    	list[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	
	    	list[from].add(to);
	    	list[to].add(from);
	    }
	    
	    Queue<Integer> q = new LinkedList<>();
	    visited = new boolean[N + 1];
	    
	    int count = 0;
	    for(int next : list[1]) {
	    	visited[next] = true;
	    	q.add(next);
//	    	System.out.println(next);
	    	count++;
	    }

	    while(!q.isEmpty()) {
	    	int now = q.poll();
	    	
	    	for(int next : list[now]) {
	    		if(!visited[next] && next != 1) {	    			
//	    			System.out.println(next);
	    			visited[next] = true;
	    			count++;
	    		}
	    	}
	    }
	    
	    System.out.println(count);
	}
}