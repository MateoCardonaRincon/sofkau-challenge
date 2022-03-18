package QuizGame;

public class QuizMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Running Main");
//        Player player = new Player("Mate", "mate123");
//        Option option = new Option("NoSQL", true);
//        System.out.println(option.isCorrect);
        Question question = new Question("2 + 2=");
        System.out.println("question.questionBody: \n" + question.questionBody);
        System.out.println("question.options: \n" + question.options);

    }

}
