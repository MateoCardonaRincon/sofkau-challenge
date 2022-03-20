package QuizGame;

/**
 *
 * @author MATEO
 */
public class Option {

    private final boolean correct;
    private final String optionBody;

    public Option(String optionBody, boolean correct) {
        this.optionBody = optionBody;
        this.correct = correct;
    }

    public String getOptionBody() {
        return optionBody;
    }

    public boolean isCorrect() {
        return correct;
    }

    @Override
    public String toString() {
        return optionBody;
    }

}
