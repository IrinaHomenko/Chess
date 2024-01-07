public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn &&
                Math.max(line, toLine) - Math.min(line, toLine) == Math.max(column, toColumn) - Math.min(column, toColumn) &&
                checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            }

            if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
                    (toColumn == Math.min(column, toColumn) && toLine == Math.max(line, toLine))) {
                int fromLine = Math.max(line, toLine);
                int fromColumn = Math.min(column, toColumn);
                int toC = Math.max(column, toColumn);
                int[][] positions = new int[toC - fromColumn][1];
                for (int i = 1; i < toC - fromColumn; i++) {
                    if (chessBoard.board[fromLine - i][fromColumn + i] == null) {
                        positions[i - 1] = new int[]{fromLine - i, fromColumn + i};
                    } else if (!chessBoard.board[fromLine - i][fromColumn + i].color.equals(this.color) && fromLine - i == toLine) {
                        positions[i - 1] = new int[]{fromLine - i, fromColumn + i};
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                int fromLine = Math.min(line, toLine);
                int fromColumn = Math.min(column, toColumn);
                int toC = Math.max(column, toColumn);
                int[][] positions = new int[toC - fromColumn][1];
                for (int i = 1; i < toC - fromColumn; i++) {
                    if (chessBoard.board[fromLine + i][fromColumn + i] == null) {
                        positions[i - 1] = new int[]{fromLine + i, fromColumn + i};
                    } else if (!chessBoard.board[fromLine + i][fromColumn + i].color.equals(this.color) && fromLine + i == toLine) {
                        positions[i - 1] = new int[]{fromLine + i, fromColumn + i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
        } else if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (column == toColumn) {
                for (int i = Math.min(line, toLine); i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == Math.max(line, toLine))
                            return false;
                        else if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return false;
                        else if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return true;
                        else if (i != toLine && i != line)
                            return false;
                    }
                }

                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this)
                        return false;
                    else return !chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this;
                } else return true;

            } else if (line == toLine) {

                for (int i = Math.min(toColumn, column); i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == Math.max(column, toColumn))
                            return false;
                        else if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return false;
                        else if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return true;
                        else if (i != toLine && i != column)
                            return false;
                    }
                }

                if (chessBoard.board[toLine][toColumn] != null) {
                    if (chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this)
                        return false;
                    else return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this;
                } else return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
