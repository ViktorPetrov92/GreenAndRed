package Tests;

import GreenAndRed.Cell;
import GreenAndRed.Colors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellTests {
    Cell greenCell;
    Cell redCell;
    Cell target;

    @Before
    public void before() {
        greenCell = new Cell("1");
        redCell = new Cell("0");
        target = new Cell(" ");
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreZero_CurrentGreen() {
        //Arrange
        int greenNeighbours = 0;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreOne_CurrentGreen() {
        //Arrange
        int greenNeighbours = 1;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Green_WhenGreenNeighboursAreTwo_CurrentGreen() {
        //Arrange
        int greenNeighbours = 2;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.GREEN, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Green_WhenGreenNeighboursAreThree_CurrentGreen() {
        //Arrange
        int greenNeighbours = 3;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.GREEN, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreFour_CurrentGreen() {
        //Arrange
        int greenNeighbours = 4;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreFive_CurrentGreen() {
        //Arrange
        int greenNeighbours = 5;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Green_WhenGreenNeighboursAreSix_CurrentGreen() {
        //Arrange
        int greenNeighbours = 6;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.GREEN, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreSeven_CurrentGreen() {
        //Arrange
        int greenNeighbours = 7;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreEight_CurrentGreen() {
        //Arrange
        int greenNeighbours = 8;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, greenCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreOne_CurrentRed() {
        //Arrange
        int greenNeighbours = 1;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreTwo_CurrentRed() {
        //Arrange
        int greenNeighbours = 2;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Green_WhenGreenNeighboursAreTwo_CurrentRed() {
        //Arrange
        int greenNeighbours = 2;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Green_WhenGreenNeighboursAreThree_CurrentRed() {
        //Arrange
        int greenNeighbours = 3;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.GREEN, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreFour_CurrentRed() {
        //Arrange
        int greenNeighbours = 4;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreFive_CurrentRed() {
        //Arrange
        int greenNeighbours = 5;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Green_WhenGreenNeighboursAreSix_CurrentRed() {
        //Arrange
        int greenNeighbours = 6;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.GREEN, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreSeven_CurrentRed() {
        //Arrange
        int greenNeighbours = 7;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }

    @Test
    public void AssignColorToNewCell_ShouldAssign_Red_WhenGreenNeighboursAreEight_CurrentRed() {
        //Arrange
        int greenNeighbours = 8;
        //Act
        Cell.AssignColorToNewCell(greenNeighbours, redCell, target);
        //Assert
        Assert.assertEquals(Colors.RED, target.getColor());
    }
}
