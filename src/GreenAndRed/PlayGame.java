package GreenAndRed;

import java.util.Arrays;
import java.util.Scanner;

import static GreenAndRed.Counter.CreateNewGenerationCell;

class PlayGame {
    static void Play(Scanner scanner, int width, int height, Cell[][] cellsGrid) {
        System.out.println("Enter x1, y1, N (as total generation): ");
        String[] str = scanner.nextLine().split(", ");
        int targetColumn = Integer.parseInt(str[0]);
        int targetRow = Integer.parseInt(str[1]);
        int totalGenerations = Integer.parseInt(str[2]);

        int totalGreenTimes = 0;

        // Creating empty temporary 2d array
        Cell[][] temp = new Cell[width][height];

        Cell targetCell = cellsGrid[targetRow][targetColumn];
        // Add to count if initial target cell is green
        totalGreenTimes = getTotalGreenTimes(totalGreenTimes, targetCell);

        while (totalGenerations > 0) {
            // Loop through every cell and count neighbours
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    // Store in temporary matrix new generation, to not change the color directly in initial matrix
                    temp[row][col] = CreateNewGenerationCell(row, col, width, height, cellsGrid);
                }
            }
            // Copying new generation grid to initial grid
            cellsGrid = Arrays.stream(temp).map(Cell[]::clone).toArray(Cell[][]::new);

            //Reassign targetCell from the new cellsGrid
            targetCell = cellsGrid[targetRow][targetColumn];
            totalGreenTimes = getTotalGreenTimes(totalGreenTimes, targetCell);

            totalGenerations--;
        }

        System.out.println(totalGreenTimes);
    }

    private static int getTotalGreenTimes(int totalGreenTimes, Cell targetCell) {
        if (targetCell.color==Colors.GREEN) {
            totalGreenTimes++;
        }
        return totalGreenTimes;
    }
}
