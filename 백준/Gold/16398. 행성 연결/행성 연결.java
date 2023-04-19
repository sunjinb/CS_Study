import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parents;
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
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

		    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList<>();
	    
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j = 0; j < N; j++) {
	    		int cost = Integer.parseInt(st.nextToken());
	    		if(i == j) continue;
	    		list.add(new Edge(i, j, cost));
	    	}
	    }
	    
	    Collections.sort(list);
	    // 크루스칼로 풀자
	    makeSet();
	    
	    long result = 0;
	    int count = 0;
	    for(int i = 0; i < list.size(); i++) {
	    	Edge now = list.get(i);
//	    	System.out.println(now.cost);
	    	
	    	if(union(now.from, now.to)) {
	    		result += now.cost;
	    		count++;
	    	}
	    	// 간선이 N-1개 연결되면 더 할 필요 없음
	    	if(count == N - 1) break;
	    }
	    System.out.println(result);
	}
	
	private static boolean union(int from, int to) {
		int rootFrom = findRoot(from);
		int rootTo = findRoot(to);
		
		if(rootFrom == rootTo) {
			return false;
		}
		else {
			parents[rootFrom] = rootTo;
			return true;
		}
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