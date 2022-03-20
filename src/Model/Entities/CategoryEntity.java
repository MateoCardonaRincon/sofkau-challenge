package Model.Entities;

/**
 *
 * @author MATEO
 */
public class CategoryEntity {

    private int idCategory;
    private int idGame;
    private int level;
    private int idReward;

    public CategoryEntity(int idCategory, int idGame, int level, int idReward) {
        this.idCategory = idCategory;
        this.idGame = idGame;
        this.level = level;
        this.idReward = idReward;
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
