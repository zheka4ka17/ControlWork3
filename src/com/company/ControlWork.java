package com.company;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*Студенты нескольких групп сдают экзамен по одному предмету, который оценивается по шкале от 1 до 10.
Вывести список студентов и их оценок для выбранной группы с сортировкой по фамилиям; по оценкам.
После списка группы вывести статистику (количество студентов, получивших 10 баллов, 9 баллов и т.д.;
среднюю успеваемость по выбранной группе). */
public class ControlWork {
   private static ArrayList<Student> students= new ArrayList<Student>();
    public static void main(String[] args) {
        Student student1 = new Student("Андерей", "Иванов ", 6, "1А");
        Student student2 = new Student("Игорь ", "Петров  ", 8, "1Б");
        Student student3 = new Student("Генадий", "Сидоров", 10, "1В");
        Student student4 = new Student("Илья", "Мельников ", 3, "1А");
        Student student5 = new Student("Андерей", "Николаев ", 9, "1Б");
        Student student6 = new Student("Николай", "Дуров", 5, "1В");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        sortGroupSurname("1Б");
        System.out.println();

      sortGroupMarks("1В");
        System.out.println("средняя оценка группы: ");
        System.out.println(getAverage("1А"));

    }



    public static double getAverage(String group){
        int marks=0;
        int count=0;

        for(Student student: students){
            if(student.getGroup().equals(group)){
            marks+=student.getMark();
            count++;}}
        return marks/count;



    }

    public static  void sortGroupMarks(String group){

        for(int i=10; i>0; i--){
            int count =0;
            int count1 =0;


            System.out.println("Получили оценку : "+ i+ " "+ count+ " человек" );
        for (Student student : students) {
            if (student.getMark() == i && group.equals(student.getGroup())) {
                System.out.println((student.getName() + " " + student.getSurname() + " " + student.getMark()));
                count++;
                count1+=student.getMark();


            }


        }




    }



}


        public static void sortGroupSurname(String nameOfGroup){

        ArrayList<String> surnames = new ArrayList<>();
        for (Student student :students) {
            if (student.getGroup().equals(nameOfGroup)) {
                surnames.add(student.getSurname());
            }
        }

            Collections.sort(surnames);


        for(String string: surnames){
                for(Student student : students)
                    if (string.equals(student.getSurname()))
                        System.out.println(student.getName()+ " "+ student.getSurname()+" " + student.getMark() );

            }












    }


}
class Student{
    private String name;
    private String surname;
    private int mark;
    private String group;


    public Student(String name, String surname,int mark, String group) {
        this.name = name;
        this.surname = surname;
        this.mark=mark;
        this.group= group;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
