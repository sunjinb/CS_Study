import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class jaccard_distance_algorithm {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("초밥을 먹었어. 근데 엄청나게 맛있었어. 집에 오는 길에 넘어졌어.");
        list.add("초밥을 먹습니다");
        list.add("초밥을 버립니다. 치킨을 시켰습니다.");
        list.add("치킨은 맛있습니다");
        list.add("집에 파도가 칩니다");
        list.add("오다작가의 만화 원피스");
        list.add("이 길에 끝에 서서 하늘을 바라보다");
        list.add("초밥이 넘어집니다.");
        list.add("범선이는 밥을 먹는다.");
        list.add("그리고 선진이는 치킨을 먹는다.");
        list.add("선진이는 밥을 먹는다. 그리고 범선이는 초밥을 먹는다");
        list.add("초밥을 먹었어 범선이가. 선진이는 밥을 먹는데.");
        list.add("먹다 밥 선진 먹다 초밥 먹다 범선");
        list.add("먹다");
        list.add("범선");
        list.add("선진");
        list.add("초밥");
        list.add("먹었다");
        list.add("먹을거다");
        list.add("먹의싶다");
        list.add("범선 범선 범선");
        list.add("선");
        list.add("먹");
        list.add("다");

        String dream = "범선이는 초밥을 먹었다. 그리고 선진이는 밥을 먹을거다. 범선이는 배고프다.";

        System.out.println(dream);
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%.0f 퍼센트 유사도 : ", jaccardSimilarity(dream, list.get(i)) * 100);
            System.out.println(list.get(i));
        }
    }
    public static double jaccardSimilarity(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // 문자열을 집합으로 변환
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }

        for (char c : s2.toCharArray()) {
            set2.add(c);
        }

        // 교집합 크기 계산
        Set<Character> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // 합집합 크기 계산
        Set<Character> union = new HashSet<>(set1);
        union.addAll(set2);

        // Jaccard 유사도 계산
        return (double) intersection.size() / union.size();
    }
}
