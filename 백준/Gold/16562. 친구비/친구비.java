import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] cost;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    cost = new int[N + 1];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= N; i++) {
	    	cost[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    list = new ArrayList[N + 1];
	    for(int i = 1; i <= N; i++) {
	    	list[i] = new ArrayList<>();
	    }
	    for(int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int tmp = Math.min(cost[from], cost[to]);
	    	
	    	list[from].add(new Node(to, tmp));
	    	list[to].add(new Node(from, tmp));
	    }
	    
	    PriorityQueue<Node> q = new PriorityQueue<>();
	    visited = new boolean[N + 1];
	    
	    for(int i = 1; i <= N; i++) {
	    	q.add(new Node(i, cost[i]));
	    }
	    
	    int sum = 0;
	    while(!q.isEmpty()) {
	    	Node now = q.poll();
	    	
	    	if(visited[now.to]) continue;
	    	
	    	visited[now.to] = true;
	    	sum += now.cost;
	    	
	    	for(Node next : list[now.to]) {
	    		if(!visited[next.to]) {
	    			visited[next.to] = true; 
	    			dfs(next.to);	
	    		}
	    	}
	    }
	    if(sum <= K) System.out.println(sum);
	    else System.out.println("Oh no");
	    
	    
	}
	private static void dfs(int cur) {
		for(Node next : list[cur]) {
			if(!visited[next.to]) {
				visited[next.to] = true;
				dfs(next.to);
			}
		}
		
	}
}