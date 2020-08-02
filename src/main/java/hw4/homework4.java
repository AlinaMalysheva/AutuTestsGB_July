package hw4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class homework4 {
//не поняла, почему надо использовать интерфейсы, использовала классы
    public static class Student {
        public String name;
        public List<Course> courses = new ArrayList<>();

        public String getName() {
            return this.name;
        }

        public List<Course> getAllCourses() {
            return this.courses;
        }

        Student(String name, Course... courses) {
            this.name = name;
            for (int i = 0; i < courses.length; i++) {
                this.courses.add(courses[i]);
            }

        }
    }

    public static class Course {
        String name;

        Course(String name) {
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }

    public static void main(String[] args) {
        Course math = new Course("Math");
        Course biology = new Course("Biology");
        Course eng = new Course("English");
        Course sp = new Course("Spanish");
        Course psyho = new Course("Psyho");

        Student ann = new Student("Anna", math, biology, eng, sp);
        Student bob = new Student("Bob", math, biology, eng);
        Student john = new Student("John", math);
        Student kate = new Student("Kate", math, biology);
        Student roi = new Student("Roy", math,eng, biology);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(ann);
        allStudents.add(bob);
        allStudents.add(john);
        allStudents.add(kate);
        allStudents.add(roi);
       // Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
        System.out.print("Курсы, на которые подписан хотя бы один студент:" );
        visitedCourses(allStudents);

       //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
       // (любознательность определяется количеством курсов).
        System.out.print("\nНаиболее любознательные студенты: " +
        activeStud(allStudents));

        System.out.print("\nAnn has " + ann.getAllCourses().size());
        System.out.print(". Bob has " + bob.getAllCourses().size());
        System.out.print(". John has " + john.getAllCourses().size());
        System.out.print(". Roy has " + roi.getAllCourses().size());
        System.out.println(". Kate has " + kate.getAllCourses().size());

        //Написать функцию, принимабщую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
        System.out.println("Math-studs: " + allStForCourse(allStudents,math));
        System.out.println("Biology-studs: " + allStForCourse(allStudents,biology));
        System.out.println("Eng-studs: " + allStForCourse(allStudents,eng));
        System.out.println("Spanish-studs: " + allStForCourse(allStudents,sp));
        System.out.println("Psyho-studs: " + allStForCourse(allStudents,psyho));
    }

    //Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
    public static void visitedCourses(List<Student> students) {
               students.stream()
                .map(x -> x.getAllCourses())
                .flatMap(x -> x.stream()) // из листов курсов получаем список курсов
                .map(Course::getName)
                .distinct()
                .forEach(x-> System.out.print(x+" "));
                 //или в return вернуть
                // .collect(Collectors.toList());
    }

    //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
    //(любознательность определяется количеством курсов).
    public static List<String> activeStud(List<Student> studs){
        return (studs.stream()
                .sorted(Comparator.comparingInt(stud-> stud.getAllCourses().size())) // как перервернуть?
                .skip(studs.size()-3)//не нашла, как иначе перевернуть сортировку.
                // И остался вопрос, как учитывать студентов с одинаковым количеством курсов, если они на 3 и 4 местах
                .limit(3)
               .map(student -> student.getName())
               // .forEach(System.out::print);
                .collect(Collectors.toList()));
    }


   // Написать функцию, принимабщую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
    public static List<String> allStForCourse(List<Student> studs, Course course){
            return (studs.stream()
                    .filter(student -> student.getAllCourses().contains(course))
                    .map(student -> student.getName())
                    .collect(Collectors.toList())
        );


    }
}

