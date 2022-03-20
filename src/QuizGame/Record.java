package QuizGame;

/**
 *
 * @author MATEO
 */
public class Record extends Player {

    private final String PLAYER;
    private int round;
    private int score;

    public Record(String playerNickname, Game game) {
        super(playerNickname);
        this.PLAYER = playerNickname;
        this.round = 1;
        this.score = 0;
        setRecord(game);
    }

    private void setRecord(Game game) {
        int nRounds = 2;

        while (round <= nRounds) {
            Round currentRound = new Round(round, game.getCategories().get(round - 1));

            if ("success".equals(currentRound.getSuccess())) {
                this.score = this.score + game.getCategories().get(round - 1).getReward().getValue();

                if (round == nRounds) {
                    System.out.printf("¡Felicitaciones, %s! Respondiste todas las preguntas correctamente\n", this.PLAYER);
                    System.out.println("Tu puntuación final: ¡" + this.score + "!");
                    break;
                }
                System.out.println("Puntuación actual: " + this.score);
                round++;

            } else if ("withdraw".equals(currentRound.getSuccess())) {
                System.out.printf("¡%s, te has retirado con una puntuación de %d!\n", this.PLAYER, this.score);
                break;
            } else {
                this.score = 0;
                System.out.println("Fallaste. ¡Has perdido todos tus puntos!");
                System.out.printf("%s, tu puntuación final es: %d\n", this.PLAYER, this.score);
                break;
            }
        }
    }

}
