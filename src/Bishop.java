public class Bishop extends ChessPiece{

    public Bishop(String color) {
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
                    if (chessBoard.board[fromLine- i][fromColumn + i] == null) {
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
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
