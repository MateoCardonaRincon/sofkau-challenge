package QuizGame;

/**
 *
 * @author MATEO
 */
public class Record extends Player {

    public String player;
    public Game game;
    public int score;

    public Record(String playerNickname, Game game) {
        super(playerNickname);
        this.player = playerNickname;
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
