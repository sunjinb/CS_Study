import java.util.List;

public class RequestDream {
    String sentence;
    int positivePoint;
    int negativePoint;

    String file;
    List<String> keywords;

    public RequestDream(String sentence, int positivePoint, int negativePoint){
        this.sentence = sentence;
        this.positivePoint = positivePoint;
        this.negativePoint = negativePoint;
    }
}
