package Model.Entities;

/**
 *
 * @author MATEO
 */
public class RewardEntity {

    private int idReward;
    private int value;

    public RewardEntity(int idReward, int value) {
        this.idReward = idReward;
        this.value = value;
    }

    public int getIdReward() {
        return idReward;
    }

    public void setIdReward(int idReward) {
        this.idReward = idReward;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
