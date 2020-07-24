package GreenAndRed;

import static GreenAndRed.Colors.*;

public class Cell {
    Colors color;

    public Cell(String color) {
        setColor(color);
    }

    Cell() {
    }

    public Colors getColor() {
        return color;
    }

    //Changing the color of the cell if the rules for Green Neighbours apply
    public static void AssignColorToNewCell(int greenNeighboursCount, Cell currentCell, Cell newCell) {
        if (currentCell.color == GREEN) {
            if (greenNeighboursCount == 0 || greenNeighboursCount == 1 ||
                    greenNeighboursCount == 4 || greenNeighboursCount == 5
                    || greenNeighboursCount == 7 || greenNeighboursCount == 8) {
                newCell.color = RED;
            } else {
                newCell.color = GREEN;
            }
        } else {
            if (greenNeighboursCount == 3 || greenNeighboursCount == 6) {
                newCell.color = GREEN;
            } else {
                newCell.color = RED;
            }
        }
    }

    private void setColor(String target) {
        if (target.equals("1")) {
            this.color = GREEN;
        } else {
            this.color = RED;
        }
    }
}
