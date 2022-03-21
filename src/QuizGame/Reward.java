package QuizGame;

import Controllers.RewardController;
import java.sql.SQLException;

/**
 *
 * @author MATEO
 */
public class Reward {

    private int value;

    public Reward(int value) throws SQLException {
        this.value = value;
        RewardController.setReward(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
