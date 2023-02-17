import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		int fullLength = 8;
		for(int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			int len = Integer.parseInt(br.readLine());
			
			char[][] map = new char[fullLength][fullLength];
			for(int i = 0; i < fullLength; i++) {
				String str = br.readLine();
				for(int j = 0; j < fullLength; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			// 가로 검출
			for(int i = 0; i < fullLength; i++) {
				// 시작점 
				for(int j = 0; j < fullLength - len + 1; j++) {
					char[] arr = new char[len];
					// 길이만큼 문자열 할당
					for(int index = 0; index < len; index++) {
						arr[index] = map[i][j + index];
					}
					judge(arr);
				}
			}
			
			// 세로 검출
			for(int j = 0; j < fullLength; j++) {
				// 시작점
				for(int i = 0; i < fullLength - len + 1; i++) {
					char[] arr = new char[len];
					// 길이만큼 문자열 할당
					for(int index = 0; index < len; index++) {
						arr[index] = map[i + index][j];
					}
					judge(arr);
				}
			}
			System.out.printf("#%d %d\n", test_case , count);
		}
	}

	// 회문인지 검사
	private static void judge(char[] arr) {
		if(arr.length == 1) {
			count++; 
			return;
		}
		// 짝수일 경우
		if(arr.length % 2 == 0) {
			for(int i = 0; i < arr.length / 2; i++) {
				if(arr[i] != arr[arr.length - i - 1]) return;
			}
		}
		// 홀수일 경우
		else if(arr.length % 2 == 1) {
			for(int i = 0; i < arr.length / 2; i++) {
				if(arr[i] != arr[arr.length - i - 1]) return;
			}
		}
//		회문일 경우
		count++;
	}
}
