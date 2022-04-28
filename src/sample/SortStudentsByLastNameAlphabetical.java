package sample;

import java.util.Comparator;

public class SortStudentsByLastNameAlphabetical implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        Student student1 = (Student) o1;
        Student student2 = (Student) o2;

        String name1 = student1.getLastName();
        String name2 = student2.getLastName();

        return name1.compareTo(name2);
    }
}
