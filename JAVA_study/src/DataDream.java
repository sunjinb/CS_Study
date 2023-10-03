import java.util.List;

public class DataDream{
    String sentence;
    String dreamTelling;
    int positivePoint;
    int negativePoint;
    int tellingPositivePoint;
    int tellingNegativePoint;
    List<String> keywords;

    public DataDream(String sentence, String dreamTelling, int positivePoint, int negativePoint,
                     int tellingPositivePoint, int tellingNegativePoint){
        this.sentence = sentence;
        this.dreamTelling = dreamTelling;
        this.positivePoint = positivePoint;
        this.negativePoint = negativePoint;
        this.tellingPositivePoint = tellingPositivePoint;
        this.tellingNegativePoint = tellingNegativePoint;
    }
}
