package sample;

import java.util.Arrays;

public class Group {

    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName, Student[] students) {
        super();
        this.groupName = groupName;
        this.students = students;
    }

    public Group() {
        super();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent (Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                student.setGroupName(groupName);
                students[i] = student;
                System.out.println("You've added a student  " + student.getName() + " " + student.getLastName() + " to  a group - " + student.getGroupName());
                return;
            }
        }
        throw new GroupOverflowException("This group is full");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Student " + students[i].getLastName() + "is in " + groupName + " group");
                return students[i];
            } else {
            }
        }
        throw new StudentNotFoundException("There is no student with this lastname");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
