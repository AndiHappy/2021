
import java.util.Stack;

import util.ListNode;
import util.Parenthesees;
public class Test {

    public static  boolean areNumbersAscending(String s) {
        String[] splitArray = s.split(" ");
        if(splitArray.length > 0){
            int pre = 0;
            for (int i = 0; i < splitArray.length; i++) {
                String tmp = splitArray[i];
                if(Character.isDigit(tmp.charAt(0))){
                    Integer charInt = Integer.parseInt(tmp);
                    if(charInt > pre){
                        pre = charInt;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;

    }



    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));

        s = "hello world 5 x 5";
        System.out.println(areNumbersAscending(s));

        s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60";
        System.out.println(areNumbersAscending(s));
        s = "4 5 11 26";
        System.out.println(areNumbersAscending(s));

    }
}
