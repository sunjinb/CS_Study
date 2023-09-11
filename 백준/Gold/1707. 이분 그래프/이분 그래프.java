import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static int judge;
	static boolean flag;
	static int[] visited;
	static ArrayList<Info>[] list;
	static class Info{
		int point, side;
		public Info(int point, int side) {
			this.point = point;
			this.side = side;
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    int K = Integer.parseInt(br.readLine());
	    for(int testCase = 1; testCase <= K; testCase++) {
	    	st = new StringTokenizer(br.readLine());
	    	V = Integer.parseInt(st.nextToken());
	    	E = Integer.parseInt(st.nextToken());
	    	
	    	list = new ArrayList[V + 1];
	    	for(int i = 1; i <= V; i++) {
	    		list[i] = new ArrayList<>();
	    	}
	    	
	    	for(int i = 0; i < E; i++) {
	    		st = new StringTokenizer(br.readLine());
	    		int from = Integer.parseInt(st.nextToken());
	    		int to = Integer.parseInt(st.nextToken());
	    		list[from].add(new Info(to, 0));
	    		list[to].add(new Info(from, 0));
	    	}
	    	
	    	flag = true;
	    	visited = new int[V + 1];
	    	
	    	for(int i = 1; i <= V; i++) {
	    		if(visited[i] == 0) {
	    			bfs(i);
	    			if(!flag) break;
	    		}
	    	}
	    	
	    	if(flag) System.out.println("YES");
	    	else System.out.println("NO");
	    }
	}
	private static void bfs(int now) {
		Queue<Info> q = new LinkedList<>();
		judge = -1;
		q.add(new Info(now, judge));
		visited[now] = judge;
		
		// judge를 바꿔주는 과정 필요
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(Info next : list[cur.point]) {
				if(visited[cur.point] == visited[next.point]) {
					flag = false;
					return;
				}
				if(visited[next.point] == 0) {
					visited[next.point] = cur.side * -1;
					q.add(new Info(next.point, visited[next.point]));
				}
			}
		}
	}
}