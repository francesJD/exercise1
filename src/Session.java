import java.util.*;

public class Session {
    int[] avgQuizScore;
    // Create a HashMap to store all quiz scores
    Map<String, int[]> allQuizScores = new HashMap<>();
    // Create a HashSet to store the names of part-time students
    Set<String> ptStudentName = new HashSet<>();
    // Create a HashMap to store the exam scores of full-time students
    Map<String, int[]> ftStudentExamScores = new HashMap<>();

    Session(int avgQS) {
        avgQuizScore = new int[avgQS];
    }

    // Add related info of full-time students to proper HashMaps
    public void addFTStudent(String name, int[] quizScore, int[] examScore) {
        FTStudent ftStudent = new FTStudent(name, quizScore, examScore);
        allQuizScores.put(name, quizScore);
        ftStudentExamScores.put(name, examScore);
    }

    // Add related info of part-time students to proper HashMap / HashSet
    public void addPTStudent(String name, int[] quizScore) {
        PTStudent ptStudent = new PTStudent(name, quizScore);
        allQuizScores.put(name, quizScore);
        ptStudentName.add(name);
    }

    // Calculate average quiz scores per student for the whole class
    public double getAvgQuizScore(String name) {
        int[] currQuizScore = allQuizScores.get(name);
        int totalScore = 0;

        for (int i = 0; i < currQuizScore.length; i++) {
            totalScore += currQuizScore[i];
        }
        
        return totalScore / currQuizScore.length;
    }

    // Print the list of quiz scores in ascending order for one session
    public void printQuizScore() {
        int j = 0;
        for (String student : allQuizScores.keySet()) {
            avgQuizScore[j++] = (int) getAvgQuizScore(student);
        }

        Arrays.sort(avgQuizScore);

        System.out.println("Print the list of quiz scores in ascending order for one session: ");

        for (int i = 0; i < avgQuizScore.length; i++) {
            System.out.print(avgQuizScore[i] + " ");
        }

        System.out.println();
    }

    // Print names of part-time students
    public void printPTStudentName() {
        System.out.println("Print names of part-time students: ");

        for (String partTime : ptStudentName) {
            System.out.print(partTime + " ");
        }

        System.out.println();
    }

    // Print exam scores of full-time students
    public void printFTStudentExamScore() {
        // Print exam scores of full-time students
        System.out.println("Print two exam scores of full-time students: ");

        for (String fullTime : ftStudentExamScores.keySet()) {
            System.out.print("The two exam scores of " + fullTime + " are: ");
            for (int exam : ftStudentExamScores.get(fullTime)) {
                System.out.print(exam + " ");
            }
            System.out.println();
        }
    }
}
