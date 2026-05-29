import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GradeAnalyzerTest {

    @Test
    public void testCalculateAverage() {
        int[] grades = {85, 70, 100, 55, 70, 90};

        assertEquals(78.33, GradeAnalyzer.calculateAverage(grades), 0.01);
    }

    @Test
    public void testCalculateAverageWithSingleGrade() {
        int[] grades = {100};

        assertEquals(100.0, GradeAnalyzer.calculateAverage(grades), 0.01);
    }

    @Test
    public void testFindHighestGrade() {
        int[] grades = {85, 70, 100, 55, 70, 90};

        assertEquals(100, GradeAnalyzer.findHighestGrade(grades));
    }

    @Test
    public void testFindLowestGrade() {
        int[] grades = {85, 70, 100, 55, 70, 90};

        assertEquals(55, GradeAnalyzer.findLowestGrade(grades));
    }

    @Test
    public void testFindHighestAndLowestWithBoundaryValues() {
        int[] grades = {0, 100, 45, 60};

        assertEquals(100, GradeAnalyzer.findHighestGrade(grades));
        assertEquals(0, GradeAnalyzer.findLowestGrade(grades));
    }

    @Test
    public void testCountGradesAtOrAboveAverage() {
        int[] grades = {85, 70, 100, 55, 70, 90};

        assertEquals(3, GradeAnalyzer.countGradesAtOrAboveAverage(grades));
    }

    @Test
    public void testCountGradesAtOrAboveAverageIncludesEqualValues() {
        int[] grades = {50, 50, 50};

        assertEquals(3, GradeAnalyzer.countGradesAtOrAboveAverage(grades));
    }

    @Test
    public void testCalculateFrequency() {
        int[] grades = {85, 70, 100, 55, 70, 90};
        int[] expected = {0, 0, 0, 0, 0, 1, 0, 2, 1, 1, 1};

        assertArrayEquals(expected, GradeAnalyzer.calculateFrequency(grades));
    }

    @Test
    public void testCalculateFrequencyWithAllRanges() {
        int[] grades = {0, 9, 10, 19, 20, 35, 49, 50, 68, 70, 89, 90, 99, 100};
        int[] expected = {2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1};

        assertArrayEquals(expected, GradeAnalyzer.calculateFrequency(grades));
    }

    @Test
    public void testFormatFrequencyLineForRegularRanges() {
        assertEquals("00-09: 2", GradeAnalyzer.formatFrequencyLine(0, 2));
        assertEquals("70-79: 3", GradeAnalyzer.formatFrequencyLine(7, 3));
        assertEquals("90-99: 1", GradeAnalyzer.formatFrequencyLine(9, 1));
    }

    @Test
    public void testFormatFrequencyLineForGradeOneHundred() {
        assertEquals("100: 1", GradeAnalyzer.formatFrequencyLine(10, 1));
    }
}
