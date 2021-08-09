package youtubelambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(14);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(16);

        System.out.println(getMaxValue(l));//15
        System.out.println(getMaxValueWithSort(l));//15

        System.out.println(getMinValue(l));//2
        System.out.println(getMinValueWithSort(l));//2

        System.out.println(getMinGreaterThanSevenEven(l));//12

        System.out.println(getHalfOfDistinctElementsReversed(l));//[8, 7, 6, 4]

    }

    //1)Create a method to find the maximum value from the list elements
    //1.Way:
    public static Integer getMaxValue(List<Integer> l){
        return l.stream().reduce(Integer.MIN_VALUE, (x, y) -> x>y ? x : y);
    }
    //2.Way:
    //sorted() puts the elements in ascending order as default
    //Ascending Order and Alphabetical Order are called "Natural Order"
    public static Integer getMaxValueWithSort(List<Integer> l){
        return l.stream().sorted().reduce(Integer.MIN_VALUE, (x, y)->y);
    }

    //2)Create a method to find the minimum value from the list elements
    //1.Way:
    public static Integer getMinValue(List<Integer> l){
        return l.stream().reduce(Integer.MAX_VALUE, (x, y) -> x<y ? x : y);
    }
    //2.Way:
    //sorted(Comparator.reverseOrder()) puts the elements in descending order
    public static Integer getMinValueWithSort(List<Integer> l){
        return l.stream().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (x, y)->y);
    }

    //3)Create a method to find the minimum value which is greater than 7 and even from the list
    public static Integer getMinGreaterThanSevenEven(List<Integer> l){
        return l.stream().filter(t->(t>7 && t%2==0)).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (x, y)->y);
    }

    //4)Create a method to find the half of the elements which are distinct and greater than 5 in reverse order from the list.
    public static List getHalfOfDistinctElementsReversed(List<Integer> l){
        return l.stream().distinct().filter(t->t>5).map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

}





















