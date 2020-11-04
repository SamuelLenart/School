package sk.kosickaakademia.lenart.school;

import sk.kosickaakademia.lenart.school.hobby.Book;
import sk.kosickaakademia.lenart.school.hobby.Hobby;
import sk.kosickaakademia.lenart.school.hobby.Movie;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private ClassName className;
    private int salary;
    private LocalDate dob;
    private GPA grades;   //GPA = trieda, typ; grades = premenna
    private Hobby[] hobbies;
    private int countHobbies;

    //metody
    public Student(String firstName, String lastName, GPA grades, ClassName className, Date dob){
        this.firstName=firstName;
        this.lastName=lastName;
        this.grades=grades;
        this.className=className;
        hobbies = new Hobby[5];
        countHobbies=0;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    public void setDob(LocalDate dob) {

        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public ClassName getClassName() {


        return className;
    }

    public int getSalary() {

        return salary;
    }

    public LocalDate getDob() {

        return dob;
    }

    public GPA getGrades() {

        return grades;
    }

    public boolean printStudent() {
        return false;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName+" "+getGrades().getAverage();
    }

    public void addHobby(Hobby newHobby) {
        int len = hobbies.length;
        if(countHobbies==5) {
            System.out.println("Chyba. nie je mozne pridat dalsie hobby");
            return;
        }
        hobbies[countHobbies++] = newHobby;
    }

    public void printHobbies(){
        System.out.println("Student's hobby:");
        int len = hobbies.length;
        for(int i=0;i<countHobbies;i++) {
            System.out.println(hobbies[i].getName());
            if (hobbies[i] instanceof Book)
                System.out.println(((Book) hobbies[i]).getAuthor());
            if(hobbies[i] instanceof Movie)
                System.out.println(((Movie)hobbies[i]).getYear());
        }
    }
}

