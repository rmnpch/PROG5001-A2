//TODO 
//Implement getters and setters
//Add input validation for null grades
//Create individual methods for individual tasks and combine them as necessary
//Refactor code to separate methods, classes, constructors, etc
//Create another file to store Student as a public class

import java.util.*;
import java.io.*;

class Student { //Blueprint for creating similar student objects
    private String name;
    private int studentId;
    private float a1;
    private float a2;
    private float a3;
    private float total;

    //Student class constructor
    Student (String name, int studentId, float a1, float a2, float a3){
        this.name = name;
        this.studentId = studentId;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.total = a1+a2+a3;
    }

    public String getName() {
        return name;
    }

    public float getTotalMark() {
        return total;
    }

}
public class StudentsMarksA2 {
    // Scanner scanner = new Scanner(System.in);
    // System.out.print("Enter the path name: ");
    // String path = scanner.nextLine();
    // System.out.print("Enter the student threshold: ");
    // String threshold = scanner.nextLine();
    // System.out.println(path);
    // System.out.println(threshold);
    // scanner.close();

    private List<Student> students; //Array list to store Student objects
    String path = "D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundalmentals of Programming/PROG5001-A2/grades.csv";
    float threshold = 15;

    
    public StudentsMarksA2(String path, float threshold) {
        this.path = path;
        this.threshold = threshold;
        this.students = new ArrayList<>();
    }//StudentMarksA2_v2 constructor
    
    public void readFile() {
        try {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(path));

        br.readLine(); // Skip header line
        br.readLine(); // Skip second line

        // // create parallell arrays
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Student student = new Student(values[1] + " " + values[0], Integer.parseInt(values[2]), Float.parseFloat(values[3]), Float.parseFloat(values[4]), Float.parseFloat(values[5]));
            students.add(student);
        }
        br.close();

        // for (int k = 0; k < name.length; k++) {
        //     if (k == 0)
        //         // System.out.println("Students with grades lower than " + threshold + ": ");
        //         if (total[k] < threshold) {
        //             // System.out.println(name[k]);
        //         }
        // }

        // sort();
        // printBestWorst();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

// public void sort(){
//     float tempFloat = 0;
//     String tempName = "";
//     int tempStudentID = 0;
//     for (int a = 0; a < total.length - 1; a++) {
//         for (int k = 0; k < total.length - 1 - a; k++) {
//             if (total[k] > total[k + 1]) {
//                 tempFloat = total[k];
//                 total[k] = total[k + 1];
//                 total[k + 1] = tempFloat;

//                 tempFloat = a1[k];
//                 a1[k] = a1[k + 1];
//                 a1[k + 1] = tempFloat;

//                 tempFloat = a2[k];
//                 a2[k] = a2[k + 1];
//                 a2[k + 1] = tempFloat;

//                 tempFloat = a3[k];
//                 a3[k] = a3[k + 1];
//                 a3[k + 1] = tempFloat;

//                 tempName = name[k];
//                 name[k] = name[k + 1];
//                 name[k + 1] = tempName;

//                 tempStudentID = studentID[k];
//                 studentID[k] = studentID[k + 1];
//                 studentID[k + 1] = tempStudentID;
//             }
//         }
//     }
// }

// public void printBestWorst () {
//     // Print best students
//     for (int a = 0; a < 5; a++) {
//         if (a == 0)
//             System.out.println("Students with highest marks: ");
//         System.out.printf("\t %d: %s\n", (a + 1), name[name.length - a - 1]);
//     }
//     // Print worst students
//     for (int a = 0; a < 5; a++) {
//         if (a == 0)
//             System.out.println("Students with lowest marks: ");
//         System.out.printf("\t %d: %s\n", (name.length - a), name[a]);
//     }
// }
    public static void main(String[] args) {
        StudentsMarksA2 std = new StudentsMarksA2("D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundalmentals of Programming/PROG5001-A2/grades.csv", 15);
        //std is an object from the StudentsMarksA2 class, which can be used to run the program
        std.readFile();
    }

}
