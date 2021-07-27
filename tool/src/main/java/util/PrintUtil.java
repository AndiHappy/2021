package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintUtil {

    private static final  String replace = "\\{\\}";

    public static void p(int[] o) {
        System.out.println(Arrays.toString(o));
    }


    public static void p(Object o) {
        System.out.println(o);
    }

    /**
     * [[0,0,0],[0,1,0],[0,1,0],[0,1,0],[0,0,0]] 变为int的二维数组，这样方面一些代码
     * */
    public static int[][] costructIntArray(String s) {
        String[] spit = s.split("],");
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < spit.length; i++) {
            String array = spit[i].replace("[","").replace("]","");
            String[] arrayElemet = array.split(",");
            ArrayList<Integer> arrayTmp = new ArrayList<>();
            for (String e : arrayElemet) arrayTmp.add(Integer.parseInt(e));
            result.add(arrayTmp);
        }
        int[][] a = new int[result.size()][result.get(0).size()];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                a[i][j]=result.get(i).get(j);
            }
        }
        return a;
    }

    public static <T> void p(T[] words, int left, int right, String spit) {
        for (int i = left; i <= right ; i++) {
            String value = words[i].toString() + (spit!=null?spit:"");
            System.out.print(value );
        }
        System.out.println();
    }


    private enum Level {
        SOIUT("consoult");
        private String s;

        Level(String s) {
            this.s = s;
        }
    }

    public static void p(String format, Object... arguments) {
        info(Level.SOIUT, format, arguments);
    }

    private static void info(Level info, String format, Object[] arguments) {
        switch (info){
            case SOIUT:
                for (int i = 0; i < arguments.length; i++) {
                    format = format.replaceFirst(replace,arguments[i].toString());
                }
                System.out.println(format);
            default:
                return;
        }
    }


    public static void pIntArray(int[][] a) {
        if (a != null) {
            for (int[] element : a) {
                System.out.println(Arrays.toString(element));
            }
        }
    }

    public static void pLine() {
        System.out.println("----------------------------------------------------------------------------------------");
    }


}
