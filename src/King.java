public class King extends ChessPiece {

    protected boolean isMoving = false;

    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на выход за пределы доски
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        // Проверка на то, что король не находится в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка на движение на одну клетку
        int diffX = Math.abs(toLine - line);
        int diffY = Math.abs(toColumn - column);

        boolean canKingMove = !isUnderAttack(chessBoard, toLine, toColumn);

        if (diffX <= 1 && diffY <= 1 && canKingMove) {
            isMoving = true;
        }

        return (diffX <= 1 && diffY <= 1 && canKingMove) ;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}