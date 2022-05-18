package sample;

import java.util.*;

public class Group {

    private String groupName;
    private List<Student> students = new ArrayList<>(10);

    public Group(String groupName, List<Student> students) {
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

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean checkEqualityOfStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {
                if (students.get(i).equals(student)) {
                    return false;
                }
            }

        }
        return true;
    }

    public void addStudent (Student student) throws GroupOverflowException {

        if (!checkEqualityOfStudent(student)) {
            throw new GroupOverflowException ("The group has already this student!");
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == null) {
                student.setGroupName(groupName);
                students.add(student);
                System.out.println("You've added a student " + student.getName() + " " + student.getLastName() + " to  a group - " + student.getGroupName());
                return;
            }
        }
        throw new GroupOverflowException("This group is full");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null && students.get(i).getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Student " + students.get(i).getLastName() + "is in " + groupName + " group");
                return students.get(i);
            } else {
            }
        }
        throw new StudentNotFoundException("There is no student with this lastname");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {
                if (students.get(i).getId() == id) {
                    students.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Student> sortStudents() {
        Collections.sort(getStudents(), Comparator.nullsLast(new SortStudentsByLastNameAlphabetical()));
        return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }
}
