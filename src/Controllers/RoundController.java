package Controllers;

import Model.DatabaseConnection;
import Model.Entities.RoundEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class RoundController {

    public static ArrayList<RoundEntity> getRound(int idQuestion) throws SQLException {
        ArrayList<RoundEntity> rounds = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM round WHERE Question_idQuestion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idQuestion));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                rounds.add(new RoundEntity(result.getInt(1), result.getInt(2)));
            }
            connection.close();
        }
        return rounds;
    }

    public static void setRound(int idQuestion) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO round (Question_idQuestion) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idQuestion);
            ps.executeQuery();
            connection.close();
        }
    }
}
