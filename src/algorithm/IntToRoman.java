package algorithm;

public class IntToRoman {
    public String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder res = new StringBuilder("");
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        IntToRoman I = new IntToRoman();
        int k = 1994;
        String res = I.intToRoman(k);
        System.out.println(res);
    }
}
