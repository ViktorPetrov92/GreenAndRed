package GreenAndRed; /**
 * Green vs. Red is a game played on a 2D grid. Each cell on the grid is either green (represent by "1") or
 * red (represented by "0"). Initial state is given as input from console and it's called "Generation Zero".
 * <p>
 * There are 4 rules in this game:
 * 1. Red cell will become green if there are exactly 3 or 6 green neighbour cells.
 * 2. A red cell will remain red if it has either 0,1,2,4,5,7,8 green neighbours.
 * 3. A green cell will remain green when there are exactly 2,3 or 6 green neighbours.
 * 4. A green cell will become red if it's surrounded by 0,1,4,5,7,8 green neighbours.
 * <p>
 * When the program runs on the initial input it's given:
 * The size of the grid 'x' and 'y'(separated by ", ").
 * On the next 'y' lines: strings (long 'x') containing '0' and '1'.
 * Coordinate 'x1' , 'y1' and 'N', where 'N' is the number of generation that will run. 'x1' and 'y1' are coordinates
 * of the cell that's been watched.
 * <p>
 * On single output we calculate how many times this watched cell has turn green from"Generation Zero"to'N'
 */
import java.util.Scanner;


import static GreenAndRed.PlayGame.ValidateInput;

class Main {
    public static void main(String[] args) {
        ArgsParser argsParser = new ArgsParser().invoke();
        Scanner scanner = argsParser.getScanner();
        int width = argsParser.getWidth();
        int height = argsParser.getHeight();

        ValidateInput(scanner, width, height);
    }

    private static class ArgsParser {
        private Scanner scanner;
        private int width;
        private int height;

        public Scanner getScanner() {
            return scanner;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public ArgsParser invoke() {
            scanner = new Scanner(System.in);
            System.out.println("Enter x and y coordinates (separated by ', '):");
            String[] coordinates = scanner.nextLine().split(", ");
            width = Integer.parseInt(coordinates[0]);
            height = Integer.parseInt(coordinates[1]);
            return this;
        }
    }
}
