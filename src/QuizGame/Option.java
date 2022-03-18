package QuizGame;

/**
 *
 * @author MATEO
 */
public class Option {

    public String optionBody;
    public boolean isCorrect;

    public Option(String optionBody, boolean isCorrect) {
        this.optionBody = optionBody;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return optionBody + " (" + isCorrect +")";
    }

}
