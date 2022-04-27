package sample;

public class Main {

    public static void main(String[] args) {
        Group group = new Group();
        group.setGroupName("Group of students");

        Student student1 = new Student("O", "Zelensky", Gender.MALE, 1, group.getGroupName());
        Student student2 = new Student("S", "Bandera", Gender.MALE, 2, group.getGroupName());
        Student student3 = new Student("V", "Zaluzhniy", Gender.MALE, 3, group.getGroupName());
        Student student4 = new Student("V", "Vereschuk", Gender.FEMALE, 4, group.getGroupName());
        Student student5 = new Student("O", "Malyar", Gender.FEMALE, 5, group.getGroupName());
        Student student6 = new Student("M", "Makhno", Gender.MALE, 6, group.getGroupName());
        Student student7 = new Student("E", "Svitolina", Gender.FEMALE, 7, group.getGroupName());
        Student student8 = new Student("T", "Luzan", Gender.MALE, 8, group.getGroupName());
        Student student9 = new Student("A", "Arestovych", Gender.MALE, 9, group.getGroupName());
        Student student10 = new Student("T", "Shevchenko", Gender.MALE, 10, group.getGroupName());
        Student student11 = new Student("V", "Kim", Gender.MALE, 11, group.getGroupName());

        try {
            group.addStudent(student1);
            group.addStudent(student2);
            group.addStudent(student3);
            group.addStudent(student4);
            group.addStudent(student5);
            group.addStudent(student6);
            group.addStudent(student7);
            group.addStudent(student8);
            group.addStudent(student9);
            group.addStudent(student10);
            group.addStudent(student11);
        } catch (GroupOverflowException e) {
            System.err.println(e.getMessage());
        }

        try {
            Student searchStudent = group.searchStudentByLastName("Zelensky");
            System.out.println(searchStudent);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            Student searchStudent = group.searchStudentByLastName("Pukin");
            System.out.println(searchStudent);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        group.removeStudentByID(4);
        group.removeStudentByID(25);

    }

}

