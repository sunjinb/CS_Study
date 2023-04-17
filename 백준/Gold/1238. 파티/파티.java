import java.io.*;
import java.util.*;

public class Main {
	static int N, M, X;
	static int max = 0;
	static final int INF = 987654321;
	static int[] distance;
	static int[] Xdistance;
	static boolean[] visited;
	static ArrayList<Node>[] firstList;
	static ArrayList<Node>[] list;
	static class Node implements Comparable<Node>{
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[N + 1];
	    for(int i = 1; i <= N; i++) {
	    	list[i] = new ArrayList<>();
	    }
	    
	    firstList = new ArrayList[N + 1];
	    for(int i = 1; i <= N; i++) {
	    	firstList[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int cost = Integer.parseInt(st.nextToken());
	    	list[from].add(new Node(to, cost));
	    	firstList[to].add(new Node(from, cost));
	    }
	    
	    Xdistance = new int[N + 1];
	    Arrays.fill(Xdistance, INF);
	    visited = new boolean[N + 1];
	    
	    PriorityQueue<Node> q = new PriorityQueue<>();
	    Xdistance[X] = 0;
	    q.add(new Node(X, 0));
	    
	    while(!q.isEmpty()) {
	    	Node now = q.poll();
	    	
	    	if(visited[now.to]) continue;
	    	visited[now.to] = true;
	    	
	    	for(Node next : list[now.to]) {
	    		if(Xdistance[now.to] + next.cost < Xdistance[next.to]) {
	    			Xdistance[next.to] = Xdistance[now.to] + next.cost;
	    			q.add(new Node(next.to, Xdistance[next.to]));
	    		}
	    	}
	    }
	    
	    distance = new int[N + 1];
	    Arrays.fill(distance, INF);
	    visited = new boolean[N + 1];
	    
	    q = new PriorityQueue<>();
	    distance[X] = 0;
	    q.add(new Node(X, 0));
	    
	    while(!q.isEmpty()) {
	    	Node now = q.poll();
	    	
	    	if(visited[now.to]) continue;
	    	visited[now.to] = true;
	    	
	    	for(Node next : firstList[now.to]) {
	    		if(distance[now.to] + next.cost < distance[next.to]) {
	    			distance[next.to] = distance[now.to] + next.cost;
	    			q.add(new Node(next.to, distance[next.to]));
	    		}
	    	}
	    }
        
	    for(int start = 1; start <= N; start++) {
		    if(start != X) {
		    	max = Math.max(max, distance[start] + Xdistance[start]);
		    }
	    }
	    
	    System.out.println(max);
	}
}