package GreenAndRed;

import static GreenAndRed.Cell.AssignColorToNewCell;

// All methods are public for testing
public class Counter {
    public static Cell CreateNewGenerationCell(int row, int col, int width, int height, Cell[][] cells) {
        int greenNeighboursCount = 0;
        Cell currentCell = cells[row][col];
        Cell newCell = new Cell();

        // We pass the method a boolean for possibleMove by row (up or down), if the move is possible it takes the targeted row
        greenNeighboursCount = CountByRow(col, width, cells, greenNeighboursCount, row - 1 < 0, row - 1);
        greenNeighboursCount = CountByRow(col, width, cells, greenNeighboursCount, row + 1 >= height, row + 1);
        greenNeighboursCount = CountLeftNeighbour(row, col, cells, greenNeighboursCount);
        greenNeighboursCount = CountRightNeighbour(row, col, width, cells, greenNeighboursCount);

        // Checking how many green neighbours cells got and define the color for next generation
        AssignColorToNewCell(greenNeighboursCount, currentCell, newCell);

        return newCell;
    }

    public static int CountByRow(int col, int width, Cell[][] cells, int greenNeighboursCount, boolean possibleMove, int targetRow) {
        // First check if we can go up or down, then add left and right neighbours
        if (!(possibleMove)) {
            greenNeighboursCount = CountLeftNeighbour(targetRow, col, cells, greenNeighboursCount);
            greenNeighboursCount = CountRightNeighbour(targetRow, col, width, cells, greenNeighboursCount);

            //Last we add the one on top or bottom
            Cell neighbour = cells[targetRow][col];
            greenNeighboursCount = isNeighbourGreen(greenNeighboursCount, neighbour);
        }
        return greenNeighboursCount;
    }

    public static int CountRightNeighbour(int row, int col, int width, Cell[][] cells, int greenNeighboursCount) {
        //Check if we can go to the right cell
        if (!(col + 1 >= width)) {
            Cell neighbour = cells[row][col + 1];
            greenNeighboursCount = isNeighbourGreen(greenNeighboursCount, neighbour);
        }
        return greenNeighboursCount;
    }

    public static int CountLeftNeighbour(int row, int col, Cell[][] cells, int greenNeighboursCount) {
        //Check if we can go to the left cell
        if (!(col - 1 < 0)) {
            Cell neighbour = cells[row][col - 1];
            greenNeighboursCount = isNeighbourGreen(greenNeighboursCount, neighbour);
        }
        return greenNeighboursCount;
    }

    // A check if the neighbour is green. We don't need a RedCounter because we can make all checks with only Green Neighbours
    public static int isNeighbourGreen(int greenNeighboursCount, Cell neighbour) {
        if (neighbour.color==Colors.GREEN) {
            greenNeighboursCount++;
        }
        return greenNeighboursCount;
    }
}
