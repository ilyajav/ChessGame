public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //Проверка на выход за пределы доски

        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка на то, что пешка не находится в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка движения пешки
        int direction = getColor().equals("White") ? 1 : -1; // 1 для белых, -1 для черных
        int deltaLine = toLine - line;
        int deltaColumn = toColumn - column;

        if (deltaColumn != 0) return false; // Пешка ходит только прямо

        if (deltaLine == direction ) return true; // Обычный ход на 1 клетку

        return deltaLine == 2 * direction && line == (getColor().equals("White") ? 1 : 6); // Первый ход на 2 клетки

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}