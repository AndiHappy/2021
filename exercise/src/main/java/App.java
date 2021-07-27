import util.PrintUtil;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        System.arraycopy(src,srcpos,dest,despost,length);
        System.out.println("keep Happy boy");
        List<String> values = Arrays.asList("3.");
        for (int i = 0; i < values.size(); i++) {
            String input = values.get(i);
            PrintUtil.p("input:{} : {}",input,isNumber(input));
        }
    }


    public int mySqrt(int x) {
        return x;
    }

    public static boolean isNumber(String s) {
        s=s.trim();
        boolean digitSeen = false;
        boolean digitAfterESeen=true;
        boolean ditSeen = false;
        boolean ESeen = false;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if('0' <= cur && cur <= '9'){
                digitSeen=true;
                digitAfterESeen=true;
            }else if('.' == cur){
                //  (Optional) An 'e' or 'E', followed by an integer.
                //  E 之后，只能是 integer，不能出现.
                if(ditSeen || ESeen){
                    return false;
                }
                ditSeen=true;
            }else if('e' == cur){
                // ee，1e formate，
                // e3 formate
                if(ESeen || !digitSeen){
                    return false;
                }
                ESeen=true;
                digitAfterESeen=false;
            }else if('+' == cur || '-' == cur){
                if(i!=0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return digitSeen && digitAfterESeen;
    }



    //(+,-)3|4|.1234567890|| e，E||(+|-)3|4
    public static boolean validate1(String v){
        boolean digit=false;
        boolean dot=false;
        boolean e=false;
        for (int i = 0; i < v.length(); i++) {
            Character cur = v.charAt(i);
            if(Character.isDigit(cur)){
                digit=true;
                continue;
            }else {
                if('e' == cur && digit && !e && i != v.length()-1){
                    digit=false;
                    e=true;
                    continue;
                }
                if('.' == cur && !dot){
                    digit=false;
                    dot=true;
                    continue;
                }

                return false;
            }
        }

        return true;
    }

}
