package GreenAndRed;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.String.*;

class PlayGame {
    // Method to fill the 2d array
    private static Cell[][] FillUpGrid(Scanner scanner, int width, int height) {
        Cell[][] cellsGrid = new Cell[height][width];
        System.out.println("Enter cells value as strings (long 'x') and on a single line(not separated). '0' for red, '1' for green : ");
        for (int row = 0; row < height; row++) {
            String[] cellsValue = scanner.nextLine().split("");

            for (int col = 0; col < width; col++) {
                cellsGrid[row][col] = new Cell(cellsValue[col]);
            }
        }
        return cellsGrid;
    }

    static void ValidateInput(Scanner scanner, int width, int height) {
        if (width <= 1 || width > height || height >= 1000) {
            System.out.println("Please type valid input between 2 and 999");
        } else {
            Cell[][] cellsGrid = FillUpGrid(scanner, width, height);

            Play(scanner, width, height, cellsGrid);
        }
    }

    static void Play(Scanner scanner, int width, int height, Cell[][] cellsGrid) {
        System.out.println("Enter coordinates for target cell and total generations(on a single line, separated by ', '): ");
        String[] str = scanner.nextLine().split(", ");
        int targetColumn = Integer.parseInt(str[0]);
        int targetRow = Integer.parseInt(str[1]);
        int totalGenerations = Integer.parseInt(str[2]);
        int totalGreenTimes = 0;

        if (targetColumn < 0 || targetColumn > width || targetRow < 0 || targetRow > height) {
            System.out.println(format("Please enter valid coordinates(between 0 - %d for width and 0 - %d", width, height));
        } else {

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
                        temp[row][col] = Counter.CreateNewGenerationCell(row, col, width, height, cellsGrid);
                    }
                }
                // Copying new generation grid to initial grid
                cellsGrid = Arrays.stream(temp).map(Cell[]::clone).toArray(Cell[][]::new);

                //Reassign targetCell from the new cellsGrid
                targetCell = cellsGrid[targetRow][targetColumn];
                totalGreenTimes = getTotalGreenTimes(totalGreenTimes, targetCell);

                totalGenerations--;

            }
        }

        System.out.println(format("Total times target cell was green: %d", totalGreenTimes));
    }

    private static int getTotalGreenTimes(int totalGreenTimes, Cell targetCell) {
        if (targetCell.color == Colors.GREEN) {
            totalGreenTimes++;
        }
        return totalGreenTimes;
    }
}
