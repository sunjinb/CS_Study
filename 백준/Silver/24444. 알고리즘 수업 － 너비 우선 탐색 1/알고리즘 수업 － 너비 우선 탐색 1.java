import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int[] order;
	static boolean[] visited;
	static StringBuilder sb;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		order = new int[N + 1];
		bfs(R);
		
		for(int i = 1; i <= N; i++) {
			sb.append(order[i] + "\n");
		}
		System.out.println(sb);
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		visited[start] = true;
		q.add(start);
		
		int count = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			order[cur] = count;
			count++;
						
			for(int next : list[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
	}
}