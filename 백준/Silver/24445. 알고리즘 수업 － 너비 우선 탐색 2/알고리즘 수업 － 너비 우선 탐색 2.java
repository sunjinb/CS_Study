import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
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
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
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
			Collections.sort(list[i], new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});			
		}

		
		
		memo = new int[N + 1];
		visited = new boolean[N + 1];
		
		Queue<Integer> q = new LinkedList<>();
		visited[R] = true;
		q.add(R);
		
		int count = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			count++;
			memo[now] = count;
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(memo[i] + "\n");
		}
		System.out.println(sb);
	}
}