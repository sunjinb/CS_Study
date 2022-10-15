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
class Solution
{
    public static int result;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int number=sc.nextInt();
            int cnt=sc.nextInt();

            // 1. 숫자 하나 씩 떼어내어서 char array로 만들
            char[] numbers = Integer.toString(number).toCharArray();
            result = 0;

            // 2. 최대 교환 횟수는 총 숫자를 넘지 않게 하고, dfs 탐색 시작
            if(numbers.length<cnt) cnt = numbers.length;
            dfs(cnt,0, numbers);

            // 3. 결과 출력
            System.out.printf("#%d %d%n",test_case, result);

        }
    }

    public static void dfs(int cnt, int start, char[] numbers) {

        // 4-1. 기저 조건
        if(cnt==0) {
            int current = charArrToInt(numbers);
            if(current>result) {
                result = current;
            }
            return;
        }

        // 4-2. 교환 실행
        for(int i=start; i<numbers.length-1; ++i) {
            for(int j=i+1; j<numbers.length; ++j) {
                int src = Integer.parseInt(String.valueOf(numbers[i]));
                int trg = Integer.parseInt(String.valueOf(numbers[j]));

                numbers[i] = (char)(trg+'0');
                numbers[j] = (char)(src+'0');
                dfs(cnt-1, i, numbers);
                numbers[i] = (char)(src+'0');
                numbers[j] = (char)(trg+'0');

            }
        }

    }

    public static int charArrToInt(char[] numbers) {
        return Integer.parseInt(new String(numbers));
    }
}