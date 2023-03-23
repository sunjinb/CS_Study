import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N;
	static int max;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	static class Node{
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, cost));
        	list[to].add(new Node(from, cost));
        }
        
        max = 0;

        visited = new boolean[N + 1];
        
        for(int i = 1; i <= N; i++) {
        	if(list[i].size() == 1) {
        		visited[i] = true;
        		dfs(i, 0);
        		visited[i] = false;
        	}
        }
        
        System.out.println(max);
    }
	private static void dfs(int point, int sum) {
		if(max < sum) max = sum;
		
		for(Node next : list[point]) {
			if(!visited[next.to]) {
				visited[next.to] = true;
				dfs(next.to, sum + next.cost);
				visited[next.to] = false; 
			}
		}
		
	}

}