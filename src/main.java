import java.util.Random;

public class main {
    public static void main(String[] args) {
        int numStudents = 20;
        Session session = new Session(numStudents);

        for (int i = 0; i < numStudents / 2; i++) {
            String name = "FTStudent" + i;
            int[] quizScore = getRandomScore(15, 100);
            int[] examScore = getRandomScore(2, 100);
            session.addFTStudent(name, quizScore, examScore);
        }

        for (int i = 1; i <= numStudents / 2; i++) {
            String name = "PTStudent" + i;
            int[] quizScore = getRandomScore(15, 15);
            session.addPTStudent(name, quizScore);
        }

        session.printQuizScore();
        System.out.println("==================================================================================");

        session.printPTStudentName();
        System.out.println("==================================================================================");

        session.printFTStudentExamScore();
    }

    public static int[] getRandomScore(int n, int max) {
        int[] score = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            score[i] = rand.nextInt(max);
        }
        return score;
    }
}
