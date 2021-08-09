package youtubelambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Fp05 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);

        System.out.println(sumOfAll(l));
        System.out.println(sumIntFrom1To100());
        System.out.println(prodIntFrom2To11());
        System.out.println(factorialOfGivenInt(3));//6
        System.out.println(sumOfEvensBetweenTwoInt(2, 10)); //2 + 4 + 6 + 8 + 10 = 30
        sumOfDigitsOfGivenIntegers(2, 12);//3 4 5 6 7 8 9
    }
    //1)Create a method to find the sum of all elements in the list
    public static Integer sumOfAll(List<Integer> l){
        Integer result = l.stream().reduce(0,Math::addExact);
        return result;
    }

    //2)Create a method to find the sum of the integers from 1 to 100
    public static Integer sumIntFrom1To100(){
        Integer result = IntStream.rangeClosed(1, 100).reduce(0,Math::addExact);
        return result;
    }

    //3)Create a method to find the multiplication of the integers from 2(inc) to 11(inc)
    public static Integer prodIntFrom2To11(){
        return IntStream.range(2, 12).reduce(1,Math::multiplyExact);
    }


    //4)Create a method to calculate the factorial of a given number.
    public static Integer factorialOfGivenInt(Integer x){
        return IntStream.rangeClosed(1,x).reduce(1, Math::multiplyExact);
    }

    //5)Create a method to calculate the sum of even integers between given two integers
    public static Integer sumOfEvensBetweenTwoInt(Integer s, Integer e){
        return IntStream.rangeClosed(s, e).filter(Utils::checkToBeEven).reduce(0,Math::addExact);
    }

    //6)Create a method to calculate the sum of digits of every integers between given two integers
    public static void sumOfDigitsOfGivenIntegers(Integer s, Integer e){
            IntStream.rangeClosed(s, e).map(Utils::sumOfDigits).forEach(Utils::printWithSpace);
    }

}
