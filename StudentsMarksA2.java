import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentsMarksA2 {
    public StudentsMarksA2() {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the path name: ");
        // String path = scanner.nextLine();
        // System.out.print("Enter the student threshold: ");
        // String threshold = scanner.nextLine();
        // System.out.println(path);
        // System.out.println(threshold);
        // scanner.close();

        String path = "D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundalmentals of Programming/PROG5001-A2/grades.csv";

        int numberOfLines = 0;
        String line = "";
        Integer i = 0;
        try {
            BufferedReader lineCounter = new BufferedReader(new FileReader(path));
            
            while (lineCounter.readLine() != null) {
                numberOfLines++;
            }
            lineCounter.close();

            BufferedReader br = new BufferedReader(new FileReader(path));
            int numberOfStudents = numberOfLines - 2;
            
            String[] name = new String[numberOfStudents];
            int[] studentID = new int[numberOfStudents];
            float[] a1 = new float[numberOfStudents];
            float[] a2 = new float[numberOfStudents];
            float[] a3 = new float[numberOfStudents];
            float[] avg = new float[numberOfStudents];
            
            int j = 0;

            
            while ((line = br.readLine()) != null) {
                i++;

                if (i > 2) {
                    String[] values = line.split(",");
                    name[j]=values[1] + " " + values [0];
                    studentID[j] = Integer.parseInt(values[2]);
                    a1[j] = Float.parseFloat(values[3]);
                    a2[j] = Float.parseFloat(values[4]);
                    a3[j] = Float.parseFloat(values[5]);
                    avg[j] = (a1[j]+a2[j]+a3[j])/3;
                    j++;
                }
                
            }
            br.close();
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
