package sk.kosickaakademia.lenart.school;


import sk.kosickaakademia.lenart.school.hobby.Book;
import sk.kosickaakademia.lenart.school.hobby.Movie;
import sk.kosickaakademia.lenart.school.hobby.Sport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Student[] students;
        students = Main.vytvorStudentov();

        Main.printN1Student(students);
        System.out.println();

        Main.printStudentsWhereAverageLE2(students);
        System.out.println();

        Main.printStudentsWhereYearIsMoreThan2000(students);
        System.out.println();

        Main.printAge(students);
        System.out.println();

        sortByAverage(students);
        System.out.println("---------------------------------");
        System.out.println("Sort and print:");
        printAllStudents(students);


        Book b1 = new Book("Pan prstenov","J.R.R. Tolkien");
        students[0].addHobby(b1);
        Sport s1=new Sport("Basketball");
        students[0].addHobby(s1);
        Book b2 = new Book("Zaklinac", "A. Sabkowski");
        students[0].addHobby(b2);
        students[0].printHobbies();
        Movie m1 = new Movie("Borat 2",2020);
        students[0].addHobby(m1);

        students[0].printHobbies();
    }

    private static void printAllStudents(Student[] students) {
        int i;
        int len=students.length;
        System.out.println("List of students - 1N :");
        for(i=0;i<len;i++){

            System.out.println(students[i].toString());
        }
        System.out.println();
    }

    private static Student[] vytvorStudentov() {
        Student[] s = new Student[10];

        GPA gradesS1 = new GPA(3, 2, 1);
        Student s1 = new Student("Marek", "Baca", gradesS1,
                ClassName.N1, createDob("2000-04-09"));

        s[0] = s1;

        Student s2 = new Student("Richard", "Bacbag", new GPA(4, 2, 3),
                ClassName.N2, createDob("1999-06-01"));
        s[1] = s2;

        Student s3 = new Student("Samuel", "Samson", new GPA(1, 1, 4),
                ClassName.N3, createDob("1998-08-15"));

        s[2] = s3;

        Student s4 = new Student("Kristian", "Matej", new GPA(1, 1, 1),
                ClassName.N2, createDob("2000-01-08"));


        s[3] = s4;

        Student s5 = new Student("Matej", "Dlhy", new GPA(3, 5, 2),
                ClassName.N1, createDob("1998-09-28"));

        s[4] = s5;

        Student s6 = new Student("Matej", "Augustin", new GPA(2, 2, 2),
                ClassName.N2, createDob("1999-05-20"));
        s[5] = s6;

        Student s7 = new Student("Martin", "Novak", new GPA(1, 2, 3),
                ClassName.N3, createDob("1999-05-20"));
        s[6] = s7;

        Student s8 = new Student("Jozef", "Holly", new GPA(3, 2, 3),
                ClassName.N2, createDob("1999-05-20"));
        s[7] = s8;

        Student s9 = new Student("Michal", "Kic", new GPA(4, 1, 1),
                ClassName.N2, createDob("1996-05-22"));
        s[8] = s9;

        Student s10 = new Student("Ondrej", "Oravec", new GPA(1, 1, 3),
                ClassName.N1, createDob("1997-04-21"));
        s[9] = s10;

        return s;
    }
    private static void sortByAverage(Student[] students) {
        int len=students.length;
        for(int i = 0;i<=len-1;i++){
            for(int j=0; j< len-1-i;j++){
                if(students[j].getGrades().getAverage()>students[j+1].getGrades().getAverage()){
                    // ak podmienka plati, je potrebne vymenit A[j] <-> A[j+1]
                    Student temp = students[j];
                    students[j]=students[j+1];
                    students[j+1] = temp;

                }
            }
        }
    }

    private static void printStudentsWhereYearIsMoreThan2000(Student[] studenti) {
        System.out.println("Year of born is bigger than 2000");

        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i].getDob() != null){
                int year = studenti[i].getDob().getYear()+1900;
                if (year >= 2000) {
                    System.out.println(studenti[i].printStudent());
                }
            }
        }
    }

    private static void printStudentsWhereYearIsMoreThan2000SecondOption(Student[] studenti) {
        System.out.println("Year of born is bigger than 2000");

        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i].getDob() != null){
                LocalDate date = studenti[i].getDob();
                DateFormat dateFormat = new SimpleDateFormat("yyyy");
                String strDate = dateFormat.format(date);
                int year = Integer.parseInt(strDate);
                if (year >= 2000) {
                    System.out.println(studenti[i].printStudent());
                }
            }
        }
    }

    private static <Grades> void printStudentsWhereAverageLE2(Student[] studenti) {
        double average;
        System.out.println("Average is better than 2");
        for (int i = 0; i < studenti.length; i++) {
            GPA znamky = studenti[i].getGrades();
            average = (znamky.getEng() + znamky.getMath() + znamky.getPro()) / 3;
            if (average < 2) {
                System.out.println("Student: " + studenti[i].getFirstName() + " " + studenti[i].getLastName());
            }
        }
    }

    private static void printN1Student(Student[] studenti) {
        int dlzka = studenti.length;
        System.out.println("---List 1N---");
        for (int i = 0; i < dlzka; i++) {
            if (studenti[i].getClassName() == ClassName.N1) {
                System.out.println(studenti[i].getFirstName() + " " + studenti[i].getLastName());
            }
        }
    }

    private static Date createDob(String dateS){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String convertDateToString(LocalDate datum){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(datum);
        return  strDate;
    }


    private static void printAge(Student[] studenti){
        System.out.println("How old are you??");
        Date aktualnyDatum = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(aktualnyDatum);
        int todaysDay = c.get(Calendar.DAY_OF_MONTH);
        int todaysMonth = c.get(Calendar.MONTH)+1;
        int todaysYear = c.get(Calendar.YEAR);
        System.out.println("Actual date is: ");
        System.out.println(todaysYear +" "+ todaysMonth +" " +todaysDay);

        int rok;
        int mesiac;
        int den;
        for(int i = 0; i < studenti.length; i++){
            if(studenti[i].getDob() != null) {
                String datum = convertDateToString(studenti[i].getDob());
                int datumovecislo = cisloDokopy(datum);
                //System.out.println(datumovecislo);
                rok = datumovecislo / 10000;
                mesiac = (datumovecislo - rok * 10000) / 100;
                den = datumovecislo % 100;
                if (mesiac == todaysMonth && todaysDay < den) {
                    System.out.println(studenti[i].getFirstName() + " " + studenti[i].getLastName()
                            + " ma " + ((todaysYear - rok) - 1) + " rokov");
                } else {
                    System.out.println(studenti[i].getFirstName() + " " + studenti[i].getLastName()
                            + " ma " + (todaysYear - rok) + " rokov");
                }

            }
        }

    }

    private static int cisloDokopy(String datum){
        int dlzka = datum.length();
        int cislo = 0;
        for(int i = 0; i < datum.length(); i++){
            if(i == 4 || i == 7){
                continue;
            }
            cislo = cislo*10+Character.getNumericValue(datum.charAt(i));
        }
        return cislo;
    }

    private static void zoradStudentov(Student[] studenti){
        double[] priemerStudentov = new double[studenti.length];
        double priemer;

        for(int i = 0; i < studenti.length; i++){
            priemer = (studenti[i].getGrades().getEng() + studenti[i].getGrades().getMath()+
                    studenti[i].getGrades().getPro())/3.0;
            priemerStudentov[i] = priemer;
        }

        double k,l;
        for(int i = 0; i < studenti.length; i++){
            for(int j = studenti.length-1; j > 0; j--){
                if(priemerStudentov[j] > priemerStudentov[j-1]){
                    k = priemerStudentov[j];
                    l = priemerStudentov[j-1];
                    priemerStudentov[j] = l;
                    priemerStudentov[j-1] = k;
                }
            }
        }

        double[] pole = new double[studenti.length];
        int j = studenti.length-1;
        for(int i = 0; i < studenti.length; i++){
            pole[i] = priemerStudentov[j];
            j--;
        }
        j=0;
        double[] poleSkratene = new double[studenti.length];
        for(int i = 0; i < studenti.length-1; i++){
            if(pole[i] == pole[i+1]){
                continue;
            }else{
                poleSkratene[j] = pole[i];
                j++;
            }
        }


        for(int i = 0; i < studenti.length; i++){
            priemer = (studenti[i].getGrades().getEng() + studenti[i].getGrades().getMath()+
                    studenti[i].getGrades().getPro())/3.0;
            for(j = 0; j < poleSkratene.length; j++){
                if(priemer == poleSkratene[j]){
                    System.out.println(studenti[j].getFirstName() + " " + studenti[i].getLastName()
                            + " je na mieste " + (j+1));
                    break;
                }
            }
        }
    }



}

