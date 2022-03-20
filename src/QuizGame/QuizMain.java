package QuizGame;

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
    }

}
