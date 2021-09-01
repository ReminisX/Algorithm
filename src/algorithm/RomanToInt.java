package algorithm;

public class RomanToInt {
    public int getNum(char c){

        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int romanToInt(String s) {
        int res = 0;
        int index = 0;
        char[] c = s.toCharArray();
        while(index < s.length()){
            if(index == s.length()-1){
                res += getNum(c[index]);
                break;
            }
            if(c[index] == 'I' && c[index+1] == 'V'){
                res += 4;
                index = index + 2;
            }else if(c[index] == 'I' && c[index+1] == 'X'){
                res += 9;
                index = index + 2;
            }else if(c[index] == 'X' && c[index+1] == 'L'){
                res += 40;
                index = index + 2;
            }else if(c[index] == 'X' && c[index+1] == 'C'){
                res += 90;
                index = index + 2;
            }else if(c[index] == 'C' && c[index+1] == 'D'){
                res += 400;
                index = index + 2;
            }else if(c[index] == 'C' && c[index+1] == 'M'){
                res += 900;
                index = index + 2;
            }else{
                res += getNum(c[index]);
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        RomanToInt R = new RomanToInt();
        int res = R.romanToInt(s);
        System.out.println(res);
    }
}
