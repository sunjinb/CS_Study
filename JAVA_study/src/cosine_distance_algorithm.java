import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class cosine_distance_algorithm {
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
            System.out.printf("%.0f 퍼센트 유사도 : ", cosineSimilarity(dream, list.get(i)) * 100);
            System.out.println(list.get(i));
        }
    }

    public static double cosineSimilarity(String s1, String s2) {
        Map<String, Integer> vector1 = buildTermFrequencyVector(s1);
        Map<String, Integer> vector2 = buildTermFrequencyVector(s2);

        // 벡터의 내적 계산
        double dotProduct = calculateDotProduct(vector1, vector2);

        // 벡터의 크기 계산
        double magnitude1 = calculateMagnitude(vector1);
        double magnitude2 = calculateMagnitude(vector2);

        // 코사인 유사도 계산
        return dotProduct / (magnitude1 * magnitude2);
    }

    private static Map<String, Integer> buildTermFrequencyVector(String text) {
        Map<String, Integer> vector = new HashMap<>();
        String[] terms = text.split(" ");

        for (String term : terms) {
            vector.put(term, vector.getOrDefault(term, 0) + 1);
        }

        return vector;
    }

    private static double calculateDotProduct(Map<String, Integer> vector1, Map<String, Integer> vector2) {
        double dotProduct = 0.0;

        for (String term : vector1.keySet()) {
            if (vector2.containsKey(term)) {
                dotProduct += vector1.get(term) * vector2.get(term);
            }
        }

        return dotProduct;
    }

    private static double calculateMagnitude(Map<String, Integer> vector) {
        double magnitude = 0.0;

        for (int value : vector.values()) {
            magnitude += Math.pow(value, 2);
        }

        return Math.sqrt(magnitude);
    }
}
