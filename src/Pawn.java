public class Pawn extends ChessPiece{
    public  Pawn(String color) {
        super (color);
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (column == toColumn){
                int direction;
                int startPosition;

                if (color.equals("White")) {
                    direction = 1;
                    startPosition = 1;
                }
                else {
                    direction = -1;
                    startPosition = 6;
                }

                if (line + direction == toLine)
                    return chessBoard.board[toLine][toColumn] == null;

                if (line == startPosition && line + 2 * direction == toLine)
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + direction][column] == null;;
            }
            else {
                if (Math.abs(column - toColumn) == 1 && Math.abs(line - toLine) == 1 && chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
