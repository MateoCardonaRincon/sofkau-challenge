package Model.Entities;

/**
 *
 * @author MATEO
 */
public class CategoryEntity {

    protected int idCategory;
    private int idGame;
    private int idReward;
    private int level;

    public CategoryEntity(int idCategory, int idGame, int idReward, int level) {
        this.idCategory = idCategory;
        this.idGame = idGame;
        this.idReward = idReward;
        this.level = level;
    }

    public CategoryEntity() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIdReward() {
        return idReward;
    }

    public void setIdReward(int idReward) {
        this.idReward = idReward;
    }

}
