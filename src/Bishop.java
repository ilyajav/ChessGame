public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на выход за пределы доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка на то, что слон не находится в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка движения по диагонали
        int diffX = Math.abs(toLine - line);
        int diffY = Math.abs(toColumn - column);

        if (diffX != diffY) {
            return false; // Не диагональный ход
        }

        return chessBoard.isPathClear(line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}