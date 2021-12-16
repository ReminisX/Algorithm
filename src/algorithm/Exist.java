package algorithm;

public class Exist {
	private boolean[][] visited;
    private int index = 0;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exit(board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exit(char[][] board, String word, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        boolean flag = false;
        if (col >= 0 && col < board[0].length
                && row >= 0 && row < board.length
                && !visited[row][col] && board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            index++;
            flag = exit(board, word, row + 1, col)
                    || exit(board, word, row - 1, col)
                    || exit(board, word, row, col + 1)
                    || exit(board, word, row, col - 1);
            if (!flag) {
                index--;
                visited[row][col] = false;
            }
        }
        return flag;
    }
	
	public static void main(String[] args) {
		Exist E = new Exist();
		char[][] board = {{'a', 'b', 'c', 'e'}, {'d', 'e', 'f', 'g'}, {'h', 'i', 'j', 'g'}};
		String word = "abcb";
		System.out.println(E.exist(board, word));
	}
}
