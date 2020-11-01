package ru.job4j.chess.firuges.black;

import static java.lang.Math.abs;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = abs(dest.getX() - position().getX()) + 1;
        Cell[] steps = new Cell[size];
//        int DeltaX = (dest.getX() - position().getX()) / (size - 1);
//        int DeltaY = (dest.getY() - position().getY()) / (size - 1);
        int DeltaX = dest.getX() < position().getX() ? -1 : 1;
        int DeltaY = dest.getY() < position().getY() ? -1 : 1;
        for (int index = 0; index < size; index++) {
            int x = position().getX() + DeltaX * index;
            int y = position().getY() + DeltaY * index;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(dest.getX() - source.getX()) == abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
    