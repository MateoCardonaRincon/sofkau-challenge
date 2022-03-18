package QuizGame;

/**
 *
 * @author MATEO
 */
public class Game {

    public String accessKey;

    public Game(String ak) {
        this.accessKey = ak;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
