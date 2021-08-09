package youtubelambda;


import java.util.ArrayList;
import java.util.List;

public class Fp01 {

   /*                           Functional Programming vs Structured Programming
        a)Functional Programming focuses on the use of "functions" where each function performs a specific task.
        Structured Programming focuses on objects, classes, data types etc.
        Functional Programming focuses on mostly "what to do" but Structured Programming focuses on mostly "How to do"

        b)Functional Programming supports "parallel execution", but Structured Programming doe snot support "parallel execution"

                                What is Stream?
        a) Stream is an API and it is used to process collections of objects
        b) A stream is not a data structure instead it takes input from the 1)Collections, 2)Arrays or 3)I/O channels.
   */

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

        printElStructured(l);
        System.out.println();
        printElFunctional(l);
        System.out.println();
        printEvenStructured(l);
        System.out.println();
        printEvenFunctional(l);
        System.out.println();
        printSquareOdds(l);
        System.out.println();
        printDistinctOddCube(l);
        System.out.println();
        System.out.println(sumOfSquaresOfEvens(l));
        System.out.println();
        System.out.println(prodOfCubesOfEvens(l));
    }

    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Structured)
    public static void printElStructured(List<Integer> l){
        for(Integer w : l){
            System.out.print(w + " ");
        }
    }
    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Functional)
    public static void printElFunctional(List<Integer> l){
                      l.stream().forEach(t -> System.out.print(t + " "));
    }

    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Structured)
    public static void printEvenStructured(List<Integer> l){
        for(Integer w : l){
            if(w%2==0){
                System.out.print(w + " ");
            }
        }
    }
    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Functional)
    public static void printEvenFunctional(List<Integer> l){
        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t + " "));
    }

    //3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.
    public static void printSquareOdds(List<Integer> l){
        l.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t + " "));
    }

    //4)Create a method to print the cube of distinct odd list elements on the console in the same line with a space between two consecutive elements.
    public static void printDistinctOddCube(List<Integer> l){
        l.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t + " "));
    }

    //5)Create a method to calculate the sum of the squares of distinct even elements
    public static Integer sumOfSquaresOfEvens(List<Integer> l){
        return l.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0, (x, y)->x+y);
    }

    //6)Create a method to calculate the product of the cubes of distinct even elements
    public static Integer prodOfCubesOfEvens(List<Integer> l){
        return l.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1, (x, y) -> x*y);
    }

}
