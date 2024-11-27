public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на выход за пределы доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка на то, что конь не находится в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка хода "Г"
        int diffX = Math.abs(toLine - line);
        int diffY = Math.abs(toColumn - column);

        return (diffX == 1 && diffY == 2) || (diffX == 2 && diffY == 1);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}