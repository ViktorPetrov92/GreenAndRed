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

import static GreenAndRed.PlayGame.Play;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x and y coordinates:");
        String[] coordinates = scanner.nextLine().split(", ");
        int width = Integer.parseInt(coordinates[0]);
        int height = Integer.parseInt(coordinates[1]);

        if (width <= 1 || width > height || height >= 1000) {
            System.out.println("Please type valid input between 2 and 999");
        } else {
            Cell[][] cellsGrid = FillUpGrid(scanner, width, height);

            Play(scanner, width, height, cellsGrid);
        }
    }

    // Method to fill the 2d array
    private static Cell[][] FillUpGrid(Scanner scanner, int width, int height) {
        Cell[][] cellsGrid = new Cell[height][width];
        System.out.println("Enter cells value as strings (long 'x') and on a single line. '0' for red, '1' for green : ");
        for (int row = 0; row < height; row++) {
            String[] cellsValue = scanner.nextLine().split("");

            for (int col = 0; col < width; col++) {
                cellsGrid[row][col] = new Cell(cellsValue[col]);
            }
        }
        return cellsGrid;
    }
}
