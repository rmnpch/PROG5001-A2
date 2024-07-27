//TODO 
//Add input validation for null grades
//Create another file to store Student as a public class

import java.util.*;
import java.io.*;

class Student { // Blueprint for creating similar student objects
    private String name;
    private int studentId;
    private float a1;
    private float a2;
    private float a3;
    private float total;

    // Student class constructor
    Student(String name, int studentId, float a1, float a2, float a3) {
        this.name = name;
        this.studentId = studentId;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.total = a1 + a2 + a3;
    }

    public String getName() {
        return name;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(Float newTotal) {
        this.total = newTotal;
    }

}

public class StudentsMarksA2 {
    private List<Student> students; // Array list to store Student objects
    String path = "";
    float threshold = 100;

    public StudentsMarksA2(String path, float threshold) {// StudentMarksA2_v2 constructor
        this.path = path;
        this.threshold = threshold;
        this.students = new ArrayList<>();
    }

    public void getInput() {

    }

    public void readFile() {// Method that handles reading CSV file and construct Student objs
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(path));

            br.readLine(); // Skip first line
            br.readLine(); // Skip second line

            // // create parallell arrays
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Student student = new Student(values[1] + " " + values[0], Integer.parseInt(values[2]),
                        Float.parseFloat(values[3]), Float.parseFloat(values[4]), Float.parseFloat(values[5]));
                students.add(student);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sort() {// Bubble sorting the students array of Student objects
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int k = 0; k < students.size() - 1 - i; k++) {
                if (students.get(k).getTotal() > students.get(k + 1).getTotal()) {
                    temp = students.get(k);
                    students.set(k, students.get(k + 1));
                    students.set(k + 1, temp);
                }
            }
        }
    }

    public void printStudents() {// Print students with best grades, worst graes and under threshold
        for (int k = 0; k < students.size() - 1; k++) {
            if (k == 0)
                System.out.printf("Students with grades lower than %.1f: \n", threshold);
            if (students.get(k).getTotal() < threshold) {
                System.out.printf("\t %s\n", students.get(k).getName());
            }
        }
        // Print best students
        for (int i = 0; i < 5; i++) {
            if (i == 0)
                System.out.println("Students with highest marks: ");
            System.out.printf("\t %d: %s\n", (i + 1), students.get(students.size() - i - 1).getName());
        }
        // Print worst students
        for (int i = 0; i < 5; i++) {
            if (i == 0)
                System.out.println("Students with lowest marks: ");
            System.out.printf("\t %d: %s\n", (students.size() - i), students.get(i).getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter the student threshold: ");
        float threshold = scanner.nextFloat();
        System.out.print("Enter the path name: ");
        // String path = scanner.nextLine();
        scanner.close();
        
        String path = "D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundalmentals of Programming/PROG5001-A2/grades.csv";

        StudentsMarksA2 std = new StudentsMarksA2(path, threshold);
        // std is an object from the StudentsMarksA2 class, which can be used to run the program
        std.getInput();
        std.readFile();
        std.sort();
        std.printStudents();
    }

}
