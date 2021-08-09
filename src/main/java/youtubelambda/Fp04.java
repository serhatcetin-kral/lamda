package youtubelambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Fp04 {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>();
        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");

        printUpperCase1(l);
        System.out.println();
        printUpperCase2(l);
        System.out.println();
        printUpperCase3(l);
        System.out.println();
        printSortedLength(l);
        System.out.println();
        printDistinctSortedLastChar(l);
        System.out.println();
        printSortedLengthThenInitial(l);
        System.out.println();
        //removeIfLengthGreaterThanFive1(l);
        System.out.println();
        //removeIfLengthGreaterThanFive2(l);
        System.out.println();
        //removeIfStartsAEndsN(l);
        nameLengthSorted(l);
        System.out.println();
        lengthSquareDistinctReversed(l);
        System.out.println();
        checkLengthToBeLessThanEight(l);
        System.out.println();
        checkInitials(l);
        System.out.println();
        checkLastChar(l);
        System.out.println();
        getFirstElementAfterSortingWithSecondLastChar(l);
        System.out.println();
        getLastElementAfterSortingWithLength(l);
    }

    //1) Create a method to print all list elements in uppercase
    //1.Way: Use Lambda Expression
    public static void printUpperCase1(List<String> l){
        l.stream().map(t->t.toUpperCase()).forEach(Utils::printWithSpace);
    }
    //2.Way: Use Method Reference
    public static void printUpperCase2(List<String> l){
        l.stream().map(String::toUpperCase).forEach(Utils::printWithSpace);
    }
    //3.Way: Use replaceAll()
    public static void printUpperCase3(List<String> l){
        l.replaceAll(String::toUpperCase);
        System.out.println(l);
    }

    //2) Create a method to print the elements after ordering according to their lengths
    //Note: Java puts the elements in ascending order as default.
    public static void printSortedLength(List<String> l){
        l.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::printWithSpace);
    }

    //3) Create a method to sort the distinct elements by using their last characters
    public static void printDistinctSortedLastChar(List<String> l){
        l.stream().distinct().sorted(Comparator.comparing(t->t.substring(t.length()-1))).forEach(Utils::printWithSpace);
    }

    //4) Create a method to sort the elements according to their lengths then according to their first character
    public static void printSortedLengthThenInitial(List<String> l){
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1))).forEach(Utils::printWithSpace);
    }

    //5) Remove the elements if the length of the element is greater than 5
    //1.Way: Lambda Expression
    public static void removeIfLengthGreaterThanFive1(List<String> l){
        l.removeIf(t->t.length()>5);
        System.out.println(l);
    }
    //2.Way: Method Reference
    public static void removeIfLengthGreaterThanFive2(List<String> l){
        l.removeIf(Utils::checkToBeGreaterThanFive);
        System.out.println(l);
    }

    //6) Remove the elements if the element is starting with 'A', 'a' or ending with 'N', 'n'
    public static void removeIfStartsAEndsN(List<String> l){
        l.removeIf(t->t.toUpperCase().startsWith("A") || t.toUpperCase().endsWith("N"));
        System.out.println(l);
    }

    //7) Create a method to print the elements with lengths in the following format. Sort the elements according to the lengths.
    //  Ali: 3        Mark: 4     Amanda: 6     etc.
    public static void nameLengthSorted(List<String> l){
        l.stream().sorted(Comparator.comparing(String::length)).map(t->t + ": " + t.length()).forEach(Utils::printWithSpace);
    }

    //8) Create a method which takes the square of the length of every element, prints them distinctly in reverse order
    //   if the square is greater than 20.
    public static void lengthSquareDistinctReversed(List<String> l){
        l.
            stream().
            map(t->t.length()).
            map(Utils::getSquare).
            distinct().
            filter(t->t>20).
            sorted(Comparator.reverseOrder()).
            forEach(Utils::printWithSpace);
    }

    //9) Create a method to check if the lengths of all elements are less than 12
    public static void checkLengthToBeLessThanEight(List<String> l){
        boolean result = l.stream().allMatch(t->t.length()<12);
        System.out.println("Are the lengths of all elements less than 12 ? " + result);
    }

    //10) Create a method to check if the initial of any element is not 'X'
    public static void checkInitials(List<String> l){
        boolean result = l.stream().noneMatch(t->t.startsWith("X"));
        System.out.println("No element is starting with 'X': " + result);
    }

    //11) Create a method to check if at least one of the elements ending with "R"
    public static void checkLastChar(List<String> l){
        boolean result = l.stream().anyMatch(t->t.endsWith("R"));
        System.out.println("Any one of the elements is ending 'R': " + result);
    }

    //12) Create a method to get the first element after sorting the elements by using their second last character
    public static void getFirstElementAfterSortingWithSecondLastChar(List<String> l){
        Optional<String> firstEl = l.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-2))).findFirst();
        System.out.println(firstEl);
    }

    //13) Create a method to get the last element after sorting the elements by using their length
    public static void getLastElementAfterSortingWithLength(List<String> l){
         Optional<String> lastEl = l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst();
         System.out.println(lastEl);
    }

}