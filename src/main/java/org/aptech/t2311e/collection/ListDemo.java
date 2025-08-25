package org.aptech.t2311e.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {
    /*
    Collection in java  : List,Set,Map,Queue
    List : co thu tu , cho phep trung lap
    Implement : ArrayList,LinkedList,Vector...
     */

    public static void main(String[] args) {

    }

    public static void ArrayListDemo(){
        List<String> languages = new ArrayList<>();
        for (int  i =1  ; i <= 100000 ; i ++){
            languages.add("languages" +i);
        }
        System.err.println(languages);

        // lambda

        for (int i = 0; i < languages.size(); i++){
            String lang  = languages.get(i);
            System.err.println(lang);
        }

         languages.stream().forEach(lang -> System.err.println(lang));
         languages.forEach(lang -> System.err.println(lang));
         languages.forEach(System.err::println);



        List<Student> students = new ArrayList<>();
        for (int  i =1  ; i <= 100000 ; i ++){
            students.add(new Student("student"+i,i));
        }

        // solution1
       List<String> studentNames = new ArrayList<>();
        for (int i = 0; i < students.size(); i++){
            Student student  = students.get(i);
            studentNames.add(student.getName());
        }
        System.err.println(studentNames);
        // solution2

        List<String> studentName2 = students.stream()
                .map(Student::getName)
                .toList();
        System.err.println(studentName2);



    }
}

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}