import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int dicCount;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList();
		dfs(0, list);
		System.out.println(-1);
	}
	private static void dfs(int sum, ArrayList<Integer> valList) {
		// 합계가 N인 녀석을 찾았다면
		if(sum == N) {
			dicCount++; // 사전순서 + 1
		}
		
		// K번째에 오는 녀석을 찾았으면 종료
		if(dicCount == K) {
			StringBuilder sb = new StringBuilder();
			sb.append(valList.get(0));
			for(int i = 1; i < valList.size(); i++) {
				sb.append("+" + valList.get(i));
			}
			// 문자열 출력
			System.out.println(sb);
			System.exit(0);
		}
		
		// 길이가 N이상인 경우 종료 
		
		for(int i = 1; i <= 3; i++) {
			if(sum + i <= N) {
				valList.add(i);
				dfs(sum + i, valList);
				valList.remove(valList.size() - 1);
			}
		}
	}
}
