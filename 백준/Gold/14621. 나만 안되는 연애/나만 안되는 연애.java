import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parents;
	static char[] gender;
	static ArrayList<Edge> list;
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
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
	    
	    gender = new char[N + 1];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= N; i++) {
	    	gender[i] = st.nextToken().charAt(0);
	    } 
	    
	    list = new ArrayList<>();
	    
	    for(int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int cost = Integer.parseInt(st.nextToken());
	    	
	    	list.add(new Edge(from, to, cost));
	    }
	    
	    Collections.sort(list);
	    makeSet();
	    
	    int sum = 0;
	    int count = 1;
	    for(int i = 0; i < list.size(); i++) {
	    	Edge now = list.get(i);
	    	
	    	int from = now.from;
	    	int to = now.to;
	    	
	    	if(gender[from] == gender[to]) continue;
	    	
	    	if(union(from, to)) {
	    		sum += now.cost;
	    		count++;
	    	}
	    	if(count == N) break;
	    }
	    
	    if(count < N) System.out.println(-1);
	    else System.out.println(sum);
	}
	
	private static boolean union(int from, int to) {
		int rootFrom = findRoot(from);
		int rootTo = findRoot(to);
		
		if(rootFrom != rootTo) {
			parents[rootFrom] = rootTo;
			return true;
		}
		return false;
	}

	private static int findRoot(int val) {
		if(parents[val] == val) return val;
		else return parents[val] = findRoot(parents[val]);
	}
	
	private static void makeSet() {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}