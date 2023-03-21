import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M, P;
	static int s, e;
	static int[] rememeberParents;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Main.Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        	int cost = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        rememeberParents = new int[N + 1];
        dijkstra(s);
        System.out.println(distance[e]);
        
        Stack<Integer> stack = new Stack<>();
        while(e != 0) {
        	stack.push(e);
        	e = rememeberParents[e];	
        }
        
        System.out.println(stack.size());
        while(!stack.isEmpty()) {
        	System.out.print(stack.pop()+ " ");
        }
        
    }
    
	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(visited[now.to]) continue;
			visited[now.to] = true; 
			
			
			for(Node next : list[now.to]) {
				if(distance[now.to] + next.cost < distance[next.to]) {
					distance[next.to]= distance[now.to] + next.cost;
					rememeberParents[next.to]= now.to; 
					q.add(new Node(next.to, distance[next.to]));
				}
			}
		}
		
	}
}