package seminars.third.tdd;

public class MoodAnalysis {
    public String analize(String str) {
        if (str.contains("хорошее")) {
            return "happy";
        }
        if (str.contains("плох")){
            return "sad";
        }
        return "So so";
    }
}
