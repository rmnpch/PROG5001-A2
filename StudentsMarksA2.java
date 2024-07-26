//TODO 
//Use % notation when printing results
//Store students details in a class/object
//Create explicit constructor for the parent class, instead of using Java's default constructor
//Implement getters and setters
//Add input validation for null grades
//Create individual methods for individual tasks and combine them as necessary
//Refactor code to separate methods, classes, constructors, etc

import java.util.*;
import java.io.*;

public class StudentsMarksA2 {
    // Scanner scanner = new Scanner(System.in);
    // System.out.print("Enter the path name: ");
    // String path = scanner.nextLine();
    // System.out.print("Enter the student threshold: ");
    // String threshold = scanner.nextLine();
    // System.out.println(path);
    // System.out.println(threshold);
    // scanner.close();

    String path = "D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundalmentals of Programming/PROG5001-A2/grades.csv";
    float threshold = 15;

    int numberOfLines = 0;
    String line = "";
    // Integer i = 0;

    public StudentsMarksA2() {
        // read the file
        try {
            BufferedReader lineCounter = new BufferedReader(new FileReader(path));

            while (lineCounter.readLine() != null) {
                numberOfLines++;
            }
            lineCounter.close();

            BufferedReader br = new BufferedReader(new FileReader(path));
            int numberOfStudents = numberOfLines - 2;
            br.readLine(); // Skip header line
            br.readLine(); // Skip second line

            String[] name = new String[numberOfStudents];
            int[] studentID = new int[numberOfStudents];
            float[] a1 = new float[numberOfStudents];
            float[] a2 = new float[numberOfStudents];
            float[] a3 = new float[numberOfStudents];
            float[] total = new float[numberOfStudents];

            int j = 0;

            // create parallell arrays
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                name[j] = values[1] + " " + values[0];
                studentID[j] = Integer.parseInt(values[2]);
                a1[j] = Float.parseFloat(values[3]);
                a2[j] = Float.parseFloat(values[4]);
                a3[j] = Float.parseFloat(values[5]);
                total[j] = (a1[j] + a2[j] + a3[j]);
                System.out.println(line + ", " + total[j]);
                j++;
            }
            br.close();

            for (int k = 0; k < name.length; k++) {
                if (k == 0)
                    // System.out.println("Students with grades lower than " + threshold + ": ");
                    if (total[k] < threshold) {
                        // System.out.println(name[k]);
                    }
            }

            // Bubble sorting
            float tempFloat = 0;
            String tempName = "";
            int tempStudentID = 0;
            for (int a = 0; a < total.length - 1; a++) {
                for (int k = 0; k < total.length - 1 - a; k++) {
                    if (total[k] > total[k + 1]) {
                        tempFloat = total[k];
                        total[k] = total[k + 1];
                        total[k + 1] = tempFloat;

                        tempFloat = a1[k];
                        a1[k] = a1[k + 1];
                        a1[k + 1] = tempFloat;

                        tempFloat = a2[k];
                        a2[k] = a2[k + 1];
                        a2[k + 1] = tempFloat;

                        tempFloat = a3[k];
                        a3[k] = a3[k + 1];
                        a3[k + 1] = tempFloat;

                        tempName = name[k];
                        name[k] = name[k + 1];
                        name[k + 1] = tempName;

                        tempStudentID = studentID[k];
                        studentID[k] = studentID[k + 1];
                        studentID[k + 1] = tempStudentID;

                    }
                }
            }
            for (int a = 0; a < 5; a++) {
                if (a == 0)
                    System.out.println("Students with highest marks: ");
                System.out.println("\t" + (a + 1) + ": " + name[name.length - a - 1]);
            }
            for (int a = 0; a < 5; a++) {
                if (a == 0)
                    System.out.println("Students with lowest marks: ");
                System.out.println("\t" + (name.length - a) + ": " + name[a]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new StudentsMarksA2();
    }

}
