public class Horse extends ChessPiece{
    public  Horse(String color) {
        super (color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (toLine != line && toColumn != column && (chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                    chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this))
                    return false;
            }

            int [][] positions = new int [][]{
                    {line + 2, column + 1}, {line + 2, column - 1},
                    {line + 1, column + 2}, {line + 1, column - 2},
                    {line - 1, column + 2}, {line - 1, column - 2},
                    {line - 2, column + 1}, {line - 2, column -1}
            };
            for (int i = 0; i < positions.length; i++) {
                if (positions[i][0] == toLine && positions[i][1] == toColumn)
                    return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
