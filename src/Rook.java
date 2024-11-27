public class Rook extends ChessPiece {

    protected boolean isMoving = false;

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на выход за пределы доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка на то, что ладья не находится в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка движения по горизонтали или вертикали
        if (line != toLine && column != toColumn) {
            return false; // Не горизонтальный и не вертикальный ход
        }

        if (chessBoard.isPathClear(line, column, toLine, toColumn)) {
            isMoving = chessBoard.isPathClear(line, column, toLine, toColumn);
        }

        return chessBoard.isPathClear(line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}