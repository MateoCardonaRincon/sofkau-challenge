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

    private String map(boolean isCorrect) {
        if (isCorrect){
            return "Correcta";
        } else {
            return "Incorrecta";
        }
    }

    @Override
    public String toString() {
        return optionBody + " (" + map(isCorrect) + ")";
    }

}
