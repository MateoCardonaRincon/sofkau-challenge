package QuizGame;

//import java.util.ArrayList;
import java.util.Scanner;

public class QuizMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("################# Bienvenid@ a Preguntas y Respuesta #################\n");
        System.out.print("Nickname para la sesión: ");
        String nick = scanner.next();
        MainMenu menu = new MainMenu(nick);
//        Question question = new Question("2+2");
//        ArrayList<Option> opt = question.getOptions();
//        System.out.println(opt.get(0));
    }

}
