/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class cs_s1974
{
    public static void main(String args[]) throws Exception
    {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 배열 선언
            int[][] arr = new int[9][9];
            boolean check = true;

            // 값 삽입
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 행 확인
            for(int i = 0; i < 9; i++) {
                int[] visited = new int[9];
                for(int j = 0; j < 9; j++) {
                    visited[arr[i][j] - 1]++;
                }
                for(int k = 0; k < 9; k++) {
                    if(visited[k] != 1) {
                        check = false;
                        break;
                    }
                }
            }

            // 열 확인
            for(int j = 0; j < 9; j++) {
                int[] visited = new int[9];
                for(int i = 0; i < 9; i++) {
                    visited[arr[i][j] - 1]++;
                }
                for(int k = 0; k < 9; k++) {
                    if(visited[k] != 1) {
                        check = false;
                        break;
                    }
                }
            }

            // 격자 확인
            // 시작점 9개만 주면 됨
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    if(i % 3 == 0 && j % 3 == 0) {
                        boolean myCheck = isValid(arr, i, j);
                        if(!myCheck) {
                            check = false;
                        }
                    }
                }
            }

            // 최종 결과 생성
            if(check) System.out.println("#" + test_case + " " + 1);
            else System.out.println("#" + test_case + " " + 0);
        }

    }

    public static boolean isValid(int[][] array, int row, int col) {
        int[] visited = new int[9];
        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                visited[array[i][j] - 1]++;
            }
        }
        for(int i = 0; i < 9; i++) {
            if(visited[i] != 1) return false;
        }
        return true;

    }
}