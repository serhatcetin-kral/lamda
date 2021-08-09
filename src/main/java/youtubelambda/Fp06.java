package youtubelambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Fp06 {

    public static void main(String[] args) {
        Course courseTurkishDay = new Course("Summer", "Turkish Day", 97, 128);
        Course courseTurkishNight = new Course("Winter", "Turkish Night", 98, 154);
        Course courseEnglishDay = new Course("Spring", "English Day", 95, 132);
        Course courseEnglishNight = new Course("Winter", "English Night", 93, 144);

        List<Course> coursesList = new ArrayList();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        System.out.println(checkAvgScrToBeGreaterThanGivenNumber(coursesList, 91));
        System.out.println(checkAnyCourseNameContainsTurkish(coursesList, "Turkish"));
        System.out.println(courseHasHighestAvg(coursesList));
        System.out.println(sortAvgAscSkipFirstTwo(coursesList));

    }

    //1)Create a method to check if all average scores are greater than 91
    public static boolean checkAvgScrToBeGreaterThanGivenNumber(List<Course> coursesList, int avgScr){
        return coursesList.stream().allMatch(t->t.getAverageScore()>avgScr);
    }

    //2)Create a method to check if at least one of the course names contains "Turkish" word
    public static boolean checkAnyCourseNameContainsTurkish(List<Course> coursesList, String courseName){
        return coursesList.stream().anyMatch(t->t.getCourseName().contains(courseName));
    }

    //3)Create a method to print the course whose average score is the highest
    public static Optional<Course> courseHasHighestAvg(List<Course> coursesList){
        return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore).reversed()).findFirst();
    }

    //4)Sort the list elements according to the average score in ascending order and skip first 2 elements
    public static List<Course> sortAvgAscSkipFirstTwo(List<Course> coursesList){
        return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(1).collect(Collectors.toList());
    }














}
