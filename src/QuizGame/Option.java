package QuizGame;

/**
 *
 * @author MATEO
 */
public class Option {

    private final boolean CORRECT;
    private final String OPTIONBODY;

    public Option(String optionBody, boolean correct) {
        this.OPTIONBODY = optionBody;
        this.CORRECT = correct;
    }

    public String getOptionBody() {
        return OPTIONBODY;
    }

    public boolean isCorrect() {
        return CORRECT;
    }

    @Override
    public String toString() {
        return OPTIONBODY;
    }

}
