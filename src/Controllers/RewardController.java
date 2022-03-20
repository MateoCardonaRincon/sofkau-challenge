package Controllers;

import Model.DatabaseConnection;
import Model.Entities.RewardEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MATEO
 */
public class RewardController {

    public static RewardEntity getReward(int idReward) throws SQLException {
        RewardEntity reward;
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM reward WHERE idReward = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idReward));
            ResultSet result = ps.executeQuery();
            reward = new RewardEntity(result.getInt(1), result.getInt(2));
            connection.close();
        }
        return reward;
    }

    public static void setReward(int value) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO reward (value) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, value);
            ps.executeQuery();
            connection.close();
        }
    }
}
