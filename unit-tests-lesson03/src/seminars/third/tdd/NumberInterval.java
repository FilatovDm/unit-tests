package seminars.third.tdd;

public class NumberInterval {
    public static boolean numberInInterval(int n) {
        if ((n > 25) && (n < 100)) {
            return true;
        }
        return false;
    }
}
