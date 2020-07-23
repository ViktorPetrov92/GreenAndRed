package Tests;

import GreenAndRed.Cell;
import GreenAndRed.Colors;
import GreenAndRed.Counter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CounterTests {
    private Cell cellTwo;
    private Cell[][] cellsGrid;
    private int col;
    private int row;
    private int width;
    private int greenNeighboursCount;


    @Before
    public void before() {
        Cell cellOne = new Cell("0");
        cellTwo = new Cell("1");
        cellsGrid = new Cell[][]{{cellOne, cellTwo, cellOne}, {cellTwo, cellTwo, cellTwo}, {cellOne, cellOne, cellOne}};
        col = 1;
        row = 1;
        width = 3;
        greenNeighboursCount = 0;
    }

    @Test
    public void CountByRow_ShouldAddToCount_WhenMoveIsPossible() {
        //Arrange
        int target = row - 1;
        boolean possibleMove = row - 1 < 0;
        //Act
        int result = Counter.CountByRow(col, width, cellsGrid, greenNeighboursCount, possibleMove, target);
        //Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void CountLeft_ShouldAddToCount_WhenMoveIsPossible() {
        //Arrange , Act
        int result = Counter.CountLeftNeighbour(1, col, cellsGrid, greenNeighboursCount);
        //Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void CountRight_ShouldAddToCount_WhenMoveIsPossible() {
        //Arrange , Act
        int result = Counter.CountRightNeighbour(1, col, width, cellsGrid, greenNeighboursCount);
        //Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void IsNeighbourGreen_ShouldAddToCount_WhenCell_IsGreen() {
        //Arrange , Act
        int result = Counter.isNeighbourGreen(greenNeighboursCount, cellTwo);
        //Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void CreateNewGenerationCell_ShouldReturn_NewCell() {
        //Arrange , Act
        Cell newCell = Counter.CreateNewGenerationCell(0,0,3,3,cellsGrid);
        //Assert
        Assert.assertEquals(Colors.GREEN, newCell.getColor());
    }

}
