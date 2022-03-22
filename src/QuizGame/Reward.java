package QuizGame;

import Controllers.RewardController;
import java.sql.SQLException;

/**
 *
 * @author MATEO
 */
public class Reward {

    private int value;
    private int idReward;

    public Reward(int value) throws SQLException {
        this.value = value;
        storeValidate(value);
        this.idReward = RewardController.getId(getValue());
    }

    private void storeValidate(int value) throws SQLException {
        if (RewardController.getRewardbyValue(value) == null) {
            RewardController.setReward(value);
        }
    }

    public final int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIdReward() {
        return idReward;
    }

    public void setIdReward(int idReward) {
        this.idReward = idReward;
    }
}
