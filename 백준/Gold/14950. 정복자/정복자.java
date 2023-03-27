import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M, t;
	static int[] parents;
	static ArrayList<Edge> edgeList;
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Main.Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        edgeList = new ArrayList<>();
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	edgeList.add(new Edge(from, to, cost));
        }
        
        Collections.sort(edgeList);
        
        makeSet();
        
        int sum = 0;
//        int count = 0;
        for(int i = 0; i < edgeList.size(); i++) {
        	Edge edge = edgeList.get(i);
        	if(unionSet(edge.from, edge.to)) {
        		sum += edge.cost;
//        		sum += 8 * count;
//        		count++;
        	}
        }
        
        for(int i = 0; i < N - 1; i++) {
        	sum += t * i;
        }
        
        System.out.println(sum);
    }
	private static boolean unionSet(int a, int b) {
		int rootA = findRoot(a);
		int rootB = findRoot(b);
		
		if(rootA == rootB) return false;
		else {
			parents[rootA] = rootB;
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