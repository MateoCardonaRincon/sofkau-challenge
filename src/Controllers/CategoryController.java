package Controllers;

import Model.DatabaseConnection;
import Model.Entities.CategoryEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class CategoryController {

    public static ArrayList<CategoryEntity> getCategory(int idGame) throws SQLException {
        ArrayList<CategoryEntity> categories = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM category WHERE Game_idGame = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idGame));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                categories.add(new CategoryEntity(result.getInt(1),
                        result.getInt(1),
                        result.getInt(1),
                        result.getInt(1)));
            }
            connection.close();
        }
        return categories;
    }

    public static void setCategory(int idGame, int idReward, int level) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO category (Game_idGame, Reward_idReward, level) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idGame);
            ps.setInt(2, idReward);
            ps.setInt(3, level);
            ps.executeQuery();
            connection.close();
        }
    }
}
