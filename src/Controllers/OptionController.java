package Controllers;

import Model.DatabaseConnection;
import Model.Entities.OptionEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class OptionController {

    public static ArrayList<OptionEntity> getOption(int idQuestion) throws SQLException {
        ArrayList<OptionEntity> options = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM option WHERE Question_idQuestion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idQuestion));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                options.add(new OptionEntity(result.getInt(1),
                        result.getString(2),
                        result.getBoolean(3),
                        result.getInt(4)));
            }
            connection.close();
        }
        return options;
    }

    public static void setOption(String body, boolean isCorrect, int idQuestion) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO option (option_body, is_correct, Question_idQuestion) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, body);
            ps.setBoolean(2, isCorrect);
            ps.setInt(3, idQuestion);
            ps.executeQuery();
            connection.close();
        }
    }
}
