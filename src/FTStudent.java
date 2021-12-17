public class FTStudent extends Student {
    int[] examScore;

    FTStudent(String name, int[] QuizScore, int[] examScore) {
        this.quizScore = QuizScore;
        this.name = name;
        this.examScore = examScore;
    }

    public int[] getExamScore() {
        return examScore;
    }
}
