package Day5;

import java.util.*;

public class StudentExamAnalyzer {
    private HashMap<String, Integer> studentScores = new HashMap<>();

    public void addStudentScore(String name, int score) {
        studentScores.put(name, score);
    }

    public void displaySortedScores() {
        TreeMap<String, Integer> sortedScores = new TreeMap<>(studentScores);
        System.out.println("Student Scores (Sorted by Name):");
        for (Map.Entry<String, Integer> entry : sortedScores.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void displayMinMaxScores() {
        if (studentScores.isEmpty()) {
            System.out.println("No scores available.");
            return;
        }
        
        int maxScore = Collections.max(studentScores.values());
        int minScore = Collections.min(studentScores.values());
        
        System.out.println("Highest Score: " + maxScore);
        System.out.println("Lowest Score: " + minScore);
    }

    public void processScores() {
        List<Integer> scores = new ArrayList<>(studentScores.values());
        double average = scores.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average Score: " + average);
    }

    public static void main(String[] args) {
        StudentExamAnalyzer analyzer = new StudentExamAnalyzer();
        analyzer.addStudentScore("Alice", 85);
        analyzer.addStudentScore("Bob", 92);
        analyzer.addStudentScore("Charlie", 78);
        analyzer.addStudentScore("David", 90);

        analyzer.displaySortedScores();
        analyzer.displayMinMaxScores();
        analyzer.processScores();
    }
}