package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    /**
     * Нужно написать (TDD) класс MoodAnalyser, который оценивает фразы по настроению
     */
    @Test
    void testMoodAnalysisHappy() {
        MoodAnalysis moodAnalyser = new MoodAnalysis();
        String str = "хорошее настроение";
        assertThat(moodAnalyser.analize(str)).isEqualTo("happy");
    }

    @Test
    void testMoodAnalysisSad() {
        MoodAnalysis moodAnalyser = new MoodAnalysis();
        String str = "плохое настроение";
        assertThat(moodAnalyser.analize(str)).isEqualTo("sad");
    }

    @Test
    void testMoodAnalysisMedium() {
        MoodAnalysis moodAnalyser = new MoodAnalysis();
        String str = "обычное настроение";
        assertThat(moodAnalyser.analize(str)).isEqualTo("So so");
    }

}