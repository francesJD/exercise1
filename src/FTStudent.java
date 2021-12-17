public class FTStudent extends Student {
    int[] examScore;

    FTStudent(String name, int[] QuizScore, int[] examScore) {
        this.name = name;
        this.quizScore = QuizScore;
        this.examScore = examScore;
    }

    public int[] getExamScore() {
        return examScore;
    }
}
