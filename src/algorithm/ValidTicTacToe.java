package algorithm;

public class ValidTicTacToe {

    public boolean validTicTacToe(String[] board) {
        if(!countDiff(board)){
            return false;
        }
        if(isWinner(board,'X')&&isWinner(board,'O')){
            return false;
        }
        if(isWinner(board,'X')&&charCount(board,'X')-charCount(board,'O')!=1){
            return false;
        }
        if(isWinner(board,'O')&&charCount(board,'X')!=charCount(board,'O')){
            return false;
        }
        return true;
    }
    public int charCount(String[] board,char c){
        int count=0;
        for(int i=0;i<3;i++){
            for(char ch:board[i].toCharArray()){
                if(c==ch){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isWinner(String[] board,char c){
        //判断是不是c（X或者O）赢了,X赢得时候，X比O多1，反之相同
        if(board[0].charAt(0)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(2)&&board[2].charAt(2)==c){
            return true;
        }
        if(board[0].charAt(2)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(0)&&board[2].charAt(0)==c){
            return true;
        }
        for(int i=0;i<3;i++){
            if(board[i].charAt(0)==board[i].charAt(1)&&board[i].charAt(1)==board[i].charAt(2)&&board[i].charAt(2)==c){
                return true;
            }
            if(board[0].charAt(i)==board[1].charAt(i)&&board[1].charAt(i)==board[2].charAt(i)&&board[2].charAt(i)==c){
                return true;
            }
        }
        return false;
    }
    public boolean countDiff(String[] board){
        //判断X是不是比O多1或者相同
        int xNum=0;
        int oNum=0;
        for(int i=0;i<3;i++){
            for(char c:board[i].toCharArray()){
                if(c=='X'){xNum++;}
                if(c=='O'){oNum++;}
            }
        }
        return xNum-oNum==0||xNum-oNum==1;
    }

}
