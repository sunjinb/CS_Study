import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M, R;
	static int count;
	static int[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception {
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
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	list[u].add(v);
        	list[v].add(u);
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
        
        count = 1;
        visited = new int[N + 1];
        dfs(R);
        
        for(int i = 1; i <= N; i++) {
        	sb.append(visited[i] + "\n");
        }
        
        System.out.println(sb);
        
    }
	private static void dfs(int point) {
		visited[point] = count;
		
		for(int next : list[point]) {
			if(visited[next] == 0) {
				count++;
				dfs(next);
			}
		}
	}
}