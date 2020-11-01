package ru.job4j.chess.firuges.black;

import org.junit.Test;
import static org.junit.Assert.*;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.ImpossibleMoveException;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Cell expected = Cell.C3;
        Figure bishopBlack = new BishopBlack(expected);
        Cell actual  = bishopBlack.position();
        assertTrue(actual == expected);
    }

    @Test
    public void whenCopyC3toE5() {
        Cell oldPosition = Cell.C3;
        Figure bishopBlack = new BishopBlack(oldPosition);
        Cell newPosition = Cell.E5;
        bishopBlack = bishopBlack.copy(newPosition);
        assertTrue(bishopBlack.position() == newPosition);
    }

    @Test
    public void whenCopyE5toC3() {
        Cell oldPosition = Cell.E5;
        Figure bishopBlack = new BishopBlack(oldPosition);
        Cell newPosition = Cell.C3;
        bishopBlack = bishopBlack.copy(newPosition);
        assertTrue(bishopBlack.position() == newPosition);
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        Cell startPosition = Cell.C1;
        Cell destPosition = Cell.G5;
        Cell[] wayExpected = {Cell.C1, Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Figure bishopBlack = new BishopBlack(startPosition);
        Cell[] cells = bishopBlack.way(destPosition);
        assertArrayEquals(wayExpected, cells);
    }

    @Test(expected = IllegalStateException.class)
    public void whenWayIsNotDiagonal() throws ImpossibleMoveException {
        Cell startPosition = Cell.C1;
        Cell destPosition = Cell.G4;
        Figure bishopBlack = new BishopBlack(startPosition);
        Cell[] cells = bishopBlack.way(destPosition);
    }
}