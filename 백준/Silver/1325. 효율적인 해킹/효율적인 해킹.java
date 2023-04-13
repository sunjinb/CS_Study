import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] memo;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memo = new int[N + 1];
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}
		
		int maxResult = 0;
		for(int i = 1; i <= N; i++) {
//			memo 에 저장해놓고 Math.max가자
			int tmp = bfs(i);
			memo[i] = tmp;
			maxResult = Math.max(maxResult, tmp);
		}
		
		for(int i = 1; i <= N; i++) {
			if(maxResult == memo[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}
	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N + 1];
		
		visited[start] = true;
		q.add(start);
		
		int count = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			count++;
			
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return count;
		
	}
}