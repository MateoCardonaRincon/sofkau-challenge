package Controllers;

import Model.DatabaseConnection;
import Model.Entities.QuestionEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class QuestionController {

    public static ArrayList<QuestionEntity> getQuestion(int idCategory) throws SQLException {
        ArrayList<QuestionEntity> questions = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM question WHERE Category_idCategory = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idCategory));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                questions.add(new QuestionEntity(result.getInt(1),
                        result.getString(2),
                        result.getInt(3)));
            }
            connection.close();
        }
        return questions;
    }

    public static int getId(String body) throws SQLException {
        int questionId;
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT max(idQuestion) FROM question WHERE question_body = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, body);
            ResultSet result = ps.executeQuery();
            result.next();
            questionId = result.getInt(1);
            connection.close();
            return questionId;
        }

    }

    public static void setQuestion(String body, int idCategory) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO question (question_body, Category_idCategory) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, body);
            ps.setInt(2, idCategory);
            ps.executeUpdate();
            connection.close();
        }
    }
}
