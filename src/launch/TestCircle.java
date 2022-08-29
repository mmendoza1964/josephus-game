package launch;

import game.Direction;
import game.JosephusCircle;

/**
 * Test files for debugging
 * @author Mark Mendoza
 * @version 1.3
 */
public class TestCircle {
    /**
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("Hello world\n");

        JosephusCircle josephusCircle = new JosephusCircle(5);
        josephusCircle.addPlayer("Leer");
        System.out.println("Game over? " + josephusCircle.isGameOver());
        josephusCircle.addPlayer("Fear");
        josephusCircle.addPlayer("Susan");
        System.out.println(josephusCircle.getCircle());
        System.out.println("Game over? " + josephusCircle.isGameOver());
        josephusCircle.getHead().setName("Dick");

        //Linter appeasement
        int maxHolder = josephusCircle.getMaxPlayers();
        System.out.println("Max Holder is: " + maxHolder);

        //move cursor to 3
        String name = josephusCircle.moveCursor(Direction.RIGHT, 2);
        System.out.println();
        System.out.println(name);

        josephusCircle.removeAtCursor(Direction.RIGHT);
        System.out.println(josephusCircle.getCursor());
        System.out.println("Game over? " + josephusCircle.isGameOver());

        String result = josephusCircle.getCircle();
        System.out.println(result);
        System.out.println("Game over? " + josephusCircle.isGameOver());

        josephusCircle.removeAtCursor(Direction.LEFT);
        System.out.println(josephusCircle.getCircle());
        System.out.println("Game over? " + josephusCircle.isGameOver());
    }
}
