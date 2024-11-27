public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на выход за пределы доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка на то, что ферзь не находится в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка движения по горизонтали, вертикали или диагонали
        int diffX = Math.abs(toLine - line);
        int diffY = Math.abs(toColumn - column);

        if (!((line == toLine || column == toColumn) || (diffX == diffY))) {
            return false;
        }

        return chessBoard.isPathClear(line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}