package Controllers;

import Model.DatabaseConnection;
import Model.Entities.RecordEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class RecordController {

    public static ArrayList<RecordEntity> getRecord(int idQuestion) throws SQLException {
        ArrayList<RecordEntity> records = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM record WHERE Player_idPlayer = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idQuestion));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                records.add(new RecordEntity(result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4)));
            }
            connection.close();
        }
        return records;
    }

    public static void setRecord(int score, int idPlayer, int idGame) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO record (score, Player_idPlayer, Game_idGame) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, score);
            ps.setInt(2, idPlayer);
            ps.setInt(3, idGame);
            ps.executeUpdate();
            connection.close();
        }
    }
}
