package youtubelambda;

public class Utils {

    public static void printWithSpace(Object o){
        System.out.print(o + " ");
    }

    public static boolean checkToBeEven(int x){
        return x%2==0;
    }

    public static boolean checkToBeOdd(int x){
        return x%2!=0;
    }

    public static Integer getSquare(int x){
        return x*x;
    }

    public static Integer getCube(int x){
        return x*x*x;
    }

    public static double getHalf(int x){
        return x/2.0;
    }

    public static boolean checkToBeGreaterThanFive(String s){
        return s.length()>5;
    }

    public static Integer sumOfDigits(int x){

        int sum = 0;
        while(x != 0){
            sum = sum + x % 10;
            x = x / 10;
        }

        return sum;
    }
}
