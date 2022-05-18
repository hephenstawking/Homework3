package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {



    public void saveGroupToCSV(Group group) throws IOException {

        try (PrintWriter pw = new PrintWriter(new File(group.getGroupName() + ".csv"))) {

            for (int i = 0; i < group.getStudents().size(); i++) {
                if (group.getStudents().get(i) != null) {
                    pw.println(group.getStudents().get(i).getId() + ";" + group.getStudents().get(i).getLastName() + ";" + group.getStudents().get(i).getName() + ";"
                            + group.getStudents().get(i).getGender() + ";" + group.getStudents().get(i).getGroupName());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Group loadGroupFromCSV(File file) throws IOException {

        Group group = new Group();
        group.setGroupName(file.getName().substring(0, file.getName().indexOf('.')));
        String str = "";

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                str += sc.nextLine() + System.lineSeparator();
            }
        }

        System.out.println(str);
        System.out.println();

        String[] students = str.split(System.lineSeparator());

        for (int i = 0; i < students.length; i++) {
            String first = students[i];
            String[] separator = first.split("[;]");

            try {
                Student student = new Student(separator[0], separator[1], Gender.valueOf(separator[2]), Integer.valueOf(separator[3]),
                        file.getName().substring(0, file.getName().indexOf('.')));
                group.addStudent(student);
            } catch (GroupOverflowException e) {
                e.printStackTrace();
            }
        }

        return group;
    }


    public File findFileByGroupName(String groupName, File workFolder) {
        File[] listOfFiles = workFolder.listFiles();

        for ( File file: listOfFiles ) {
            if (file.isFile() && file.getName().equals(groupName + ".csv")) {
                System.out.println("File " + groupName + ".csv was found in folder" + workFolder);
                return file;
            }
        }

        System.out.println("File " + groupName + ".csv has't found in folder " + workFolder);
        return null;

    }
}
