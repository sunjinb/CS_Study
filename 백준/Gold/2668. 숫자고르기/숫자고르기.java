import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[N + 1];
		result = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		sb.append(result.size() + "\n");
		Collections.sort(result);
		
		for(int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)+ "\n");
		}
		
		System.out.println(sb);
	}
	private static void dfs(int start, int target) {
		
		if(!visited[arr[start]]) {
			visited[arr[start]] =  true;
			dfs(arr[start], target);
			visited[arr[start]] = false;
		}
		
		if(arr[start] == target) result.add(arr[start]);
	}
}