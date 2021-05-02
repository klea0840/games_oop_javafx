package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {
    @Test
    public void whenTestPosition() {
        BishopBlack newBishop = new BishopBlack(A4);
        assertThat(newBishop.position(), is(A4));
    }

    @Test
    public void whenTestCopy() {
        BishopBlack newBishop = new BishopBlack(A4);
        assertThat(newBishop.copy(A1).position(), is(A1));
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack newBishop = new BishopBlack(C1);
        Figure newBishopMoved = newBishop.copy(E3);
        assertTrue(newBishop.isDiagonal(newBishop.position(), newBishopMoved.position()));
    }

    @Test
    public void whenIsNotDiagonal() {
        BishopBlack newBishop = new BishopBlack(C1);
        Figure newBishopMoved = newBishop.copy(B3);
        assertFalse(newBishop.isDiagonal(newBishop.position(), newBishopMoved.position()));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNoWay () {
        BishopBlack newBishop = new BishopBlack(C1);
        newBishop.way(D1);
    }

    @Test
    public void whenWayFromC1ToG5 () {
        BishopBlack newBishop = new BishopBlack(C1);
        Cell[] newWay = newBishop.way(G5);
        Cell[] expected = {D2, E3, F4, G5};
        assertArrayEquals(expected, newWay);
    }
}