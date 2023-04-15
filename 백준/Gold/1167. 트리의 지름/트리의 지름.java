import java.io.*;
import java.util.*;

public class Main {
	static int V;
	static int result;
	static int startPoint;
	static boolean[] visited;
	static ArrayList<Info>[] list;
	static class Info{
		int to, cost;
		public Info(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    V = Integer.parseInt(br.readLine());
	    
	    list = new ArrayList[V + 1];
	    for(int i = 1; i <= V; i++) {
	    	list[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0; i < V; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	while(true) {
	    		int tmp = Integer.parseInt(st.nextToken());
	    		if(tmp == -1) break;
	    		int to = tmp;
	    		int cost = Integer.parseInt(st.nextToken());
	    		list[from].add(new Info(to, cost));
	    	}
	    }
	  
	    // 아무 정점 잡고 가장 많은 가중치의 지점 찾기
	    result = 0;
	    visited = new boolean[V + 1];
	    dfs(2, 0);
	    
	    // 종점 찾았으면 그 녀석의 종점이 최장거리
	    result = 0;
	    visited = new boolean[V + 1];
	    dfs2(startPoint, 0);
	    System.out.println(result);
	    
	}
	private static void dfs2(int point, int sum) {
		if(result < sum) result = sum;
		
		visited[point] = true;
				
		for(Info next : list[point]) {
			if(!visited[next.to]) {
				dfs2(next.to, sum + next.cost);
				visited[next.to] = true;
			}
		}
		
	}
	private static void dfs(int point, int sum) {	
		if(result < sum) {
			result = sum;
			startPoint = point;
		}
		
		visited[point] = true;
		
		
		for(Info next : list[point]) {
			if(!visited[next.to]) {
				dfs(next.to, sum + next.cost);
				visited[next.to] = true;
			}
		}
		
	}
}