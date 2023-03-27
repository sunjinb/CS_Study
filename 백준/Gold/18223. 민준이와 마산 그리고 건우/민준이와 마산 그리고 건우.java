import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int V, E, P;
	static final int INF = Integer.MAX_VALUE;
	static final int INF2 = 10000 * 10000;
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

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    
        list = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, cost));
        	list[to].add(new Node(from, cost));
        }
        
        // 1 -> V 가는 방법
        dijkstra(1, V);
        int originWayCost = distance[V];
        
        // 1 -> P -> V 가는 방법
        dijkstra(1, P);
        int tmpFirst = distance[P];
        dijkstra(P, V);
        int tmpSecond = distance[V];
        
        int pickUpWayCost = tmpFirst + tmpSecond;
        
        if(originWayCost == pickUpWayCost) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
	private static void dijkstra(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(visited[now.to]) continue;
			visited[now.to] = true; 
			
			if(now.to == end) {
				break;
			}
			
			for(Node next : list[now.to]) {
				if(distance[now.to] + next.cost < distance[next.to]) {
					distance[next.to]= distance[now.to] + next.cost;
					q.add(new Node(next.to, distance[next.to]));
				}
			}
		}
		
	}
}