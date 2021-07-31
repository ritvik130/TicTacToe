
import java.io.Console;

public class TicTacToe{

    /**
     * <b>main</b> of the application. Creates the instance of  TicTacToeGame
     * and starts the game. If two parameters lines  and columns
     * are passed, they are used. If the parameters lines, columns
     * and win are passed, they are used.
     * Otherwise, a default value is used. Defaults values (3) are also
     * used if the paramters are too small (less than 2).
     * @param args
     *            command lines parameters
     */
    public static void main(String[] args) {


        Console console = System.console();
        TicTacToeGame game;
        int lines, columns, win;
        lines = 3;
        columns = 3;
        win = 3;

        if (args.length >= 2) {
            lines = Integer.parseInt(args[0]);
            if(lines<2){
                System.out.println("Invalid argument, using default...");
                lines = 3;
            }
            columns = Integer.parseInt(args[1]);
            if(columns<2){
                System.out.println("Invalid argument, using default...");
                columns = 3;
            }
        }
        if (args.length >= 3){
            win = Integer.parseInt(args[2]);
            if(win<2){
                System.out.println("Invalid argument, using default...");
                win = 3;
            }
        }
        if (args.length > 3){
            System.out.println("Too many arguments. Only the first 3 are used.");
        }

        game = new TicTacToeGame(lines, columns,win);

        while(game.getGameState() == GameState.PLAYING) {
            System.out.println(game);
            System.out.print(game.nextCellValue() + " to play: ");
            String answer = console.readLine();
            int value;

            value = Integer.parseInt(answer)-1;

            if(value < 0 || value >= (game.getLines()*game.getColumns())){
                System.out.println("The value should be between 1 and " + (game.getLines()*game.getColumns()));
            } else if(game.valueAt(value) != CellValue.EMPTY) {
                System.out.println("This cell has already been played");
            } else {
                game.play(value);
            }
        }
        System.out.println(game);
        System.out.println("Result: " + game.getGameState());


    }

}
