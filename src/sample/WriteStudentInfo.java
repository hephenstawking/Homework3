package sample;

import java.util.Scanner;

public class WriteStudentInfo {
    public Student getData() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Type name");
        String name = sc.nextLine();

        System.out.println("Type lastname");
        String lastName = sc.nextLine();

        System.out.println("Type gender");
        Gender gender = Gender.valueOf(sc.nextLine());

        System.out.println("Type ID");
        int id = sc.nextInt();

        String groupName = sc.nextLine();
        System.out.println("Enter name of group");

        Student student = new Student (name, lastName, gender, id, groupName);

        return student;
    }
}
