import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DreamTest {
    public static void main(String[] args) {

        RequestDream requestDream = new RequestDream("비둘기가 집에 들어가다.",
                70, 20);

        DataDream dataDream1 = new DataDream("비둘기가 방에 들어가지 않다", "복이 올거에요",
                20, 90, 20, 90);
        DataDream dataDream2 = new DataDream("호랑이가 방에 들어가다", "복이 올거에요",
                70, 20, 70, 20);
        DataDream dataDream3 = new DataDream("가방에 들어가다", "복이 올거에요",
                50, 50, 50, 50);
        DataDream dataDream4 = new DataDream("달팽이집을 구경하다.", "복이 올거에요",
                65, 5, 65, 5);
        DataDream dataDream5 = new DataDream("초가집 위에 비둘기가 날라 다닌다.", "복이 올거에요",
                80, 0, 80, 0);

        ArrayList<DataDream> list = new ArrayList<>();
        list.add(dataDream1);
        list.add(dataDream2);
        list.add(dataDream3);
        list.add(dataDream4);
        list.add(dataDream5);

        for(int i = 0; i < list.size(); i++){
            System.out.println("내 꿈 내용 : " +  requestDream.sentence);
            System.out.println("데이터 꿈 내용 : " + list.get(i).sentence);
            System.out.println("두 꿈의 유사도 : " + analysis(requestDream, list.get(i)));
            System.out.println("--------------------------------");
        }
    }

    public static double analysis(RequestDream requestDream, DataDream dataDream) {

        double result = 0;

        double sentenceSimilarity = jaccardSimilarity(requestDream.sentence, dataDream.sentence) * 10 * 5;
        System.out.println("문자열 유사도 : " + sentenceSimilarity);
        double posSimilarity = (double) (positiveSimilarity(requestDream.positivePoint, dataDream.positivePoint) * 2.5) / 10;
        System.out.println("긍정도 유사도 : " + posSimilarity);
        double negSimilarity = (double) (negativeSimilarity(requestDream.negativePoint, dataDream.negativePoint) * 2.5) / 10;
        System.out.println("부정도 유사도 : " + negSimilarity);

        result = sentenceSimilarity + posSimilarity + negSimilarity;
        return result;
    }

    private static int negativeSimilarity(int dreamNegativePoint, int dataNegativePoint) {

        int result = Math.abs(dreamNegativePoint - dataNegativePoint);
        return 100 - result;
    }

    private static int positiveSimilarity(int dreamPositivePoint, int dataPositivePoint) {

        int result = Math.abs(dreamPositivePoint - dataPositivePoint);
        return 100 - result;
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
