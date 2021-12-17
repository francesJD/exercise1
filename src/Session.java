import java.util.*;

public class Session {
    int[] avgQuizScore;
    Map<String, int[]> allQuizScore = new HashMap<>();
    Set<String> ptStudentName = new HashSet<>();
    Map<String, int[]> ftStudentExamScore = new HashMap<>();

    Session(int avgQS) {
        avgQuizScore = new int[avgQS];
    }

    public void addFTStudent(String name, int[] quizScore, int[] examScore) {
        FTStudent ftStudent = new FTStudent(name, quizScore, examScore);
        allQuizScore.put(name, quizScore);
        ftStudentExamScore.put(name, examScore);
    }

    public void addPTStudent(String name, int[] quizScore) {
        PTStudent ptStudent = new PTStudent(name, quizScore);
        allQuizScore.put(name, quizScore);
        ptStudentName.add(name);
    }

    public double getAvgQuizScore(String name) {
        // Calculate average quiz scores per student for the whole class
        int[] currQuizScore = allQuizScore.get(name);
        int totalScore = 0;

        for (int i = 0; i < currQuizScore.length; i++) {
            totalScore += currQuizScore[i];
        }
        
        return totalScore / currQuizScore.length;
    }

    public void printQuizScore() {
        // Print the list of quiz scores in ascending order for one session
        int j = 0;
        for (String student : allQuizScore.keySet()) {
            avgQuizScore[j++] = (int) getAvgQuizScore(student);
        }

        Arrays.sort(avgQuizScore);

        System.out.println("Print the list of quiz scores in ascending order for one session: ");

        for (int i = 0; i < avgQuizScore.length; i++) {
            System.out.print(avgQuizScore[i] + " ");
        }

        System.out.println();
    }

    public void printPTStudentName() {
        // Print names of part-time students
        System.out.println("Print names of part-time students: ");

        for (String partTime : ptStudentName) {
            System.out.print(partTime + " ");
        }

        System.out.println();
    }

    public void printFTStudentExamScore() {
        // Print exam scores of full-time students
        System.out.println("Print two exam scores of full-time students: ");

        for (String fullTime : ftStudentExamScore.keySet()) {
            System.out.print("The two exam scores of " + fullTime + " are: ");
            for (int exam : ftStudentExamScore.get(fullTime)) {
                System.out.print(exam + " ");
            }
            System.out.println();
        }
    }
}
