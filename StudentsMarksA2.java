import java.util.*;
import java.io.*;

public class StudentsMarksA2 {
    private List<Student> students; // Array list to store Student objects
    String path = "";
    // float threshold = 100;

    public StudentsMarksA2(String path) {// StudentMarksA2_v2 constructor
        this.path = path;
        // this.threshold = threshold;
        this.students = new ArrayList<>();
    }

    public void menu() {
        readFile();

        System.err.println(
                "Please select an option (1-2) to execution the algorithm.\n\t1. Print students below a given threshold.\n\t2. Print 5 best and worst students by total grade.");
        Scanner menu = new Scanner(System.in);
        int choice = menu.nextInt();

        switch (choice) {
            case 1:
                belowThreshold();
                break;
            case 2:
                topAndBottom();
                break;
            default:
                System.err.println("Please select 1 or 2 to run the methods.");
                menu();
                break;
        }
        menu.close();

    }

    public void readFile() {// Method that handles reading CSV file and construct Student objs
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(path));

            br.readLine(); // Skip first line
            br.readLine(); // Skip second line

            // create students array list and student objects
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    Student student = new Student(values[1] + " " + values[0], Integer.parseInt(values[2]),
                            Float.parseFloat(values[3]), Float.parseFloat(values[4]), Float.parseFloat(values[5]));
                    students.add(student);

                } catch (Exception e) {
                    System.err.println(
                            "Make sure " + values[1] + " " + values[0] + " has all grades listed on the .csv file.");
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found.\nPlease make sure the path to the .csv file is correct.");
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

    public void belowThreshold() {// Print students with best grades, worst graes and under threshold

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student threshold (0.0 - 100.0): ");
        float threshold = scanner.nextFloat();
        if (threshold<0 || threshold >100) {  //repeat method for invalid input
            System.err.println("Please enter a threshold between 0 and 100");
            belowThreshold();
        }
        
        scanner.close();

        System.out.printf("Students with grades lower than %.1f: \n", threshold);
        for (int k = 0; k < students.size() - 1; k++) {
            if (students.get(k).getTotal() < threshold) {
                System.out.printf("\t %s\n", students.get(k).getName());
            }
        }
    }

    public void topAndBottom() {// Print students with best grades, worst graes and under threshold
        sort();
        // Print best students
        System.out.println("Students with highest marks: ");
        for (int i = 0; i < 5; i++) {
            System.out.printf("\t %d: %s\n", (i + 1), students.get(students.size() - i - 1).getName());
        }
        // Print worst students
        System.out.println("Students with lowest marks: ");
        for (int i = 0; i < 5; i++) {
            System.out.printf("\t %d: %s\n", (students.size() - i), students.get(i).getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path name: ");
        String path = scanner.nextLine();
        
        // String path2 = "D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundamentals of Programming/PROG5001-A2/grades.csv";

        StudentsMarksA2 std = new StudentsMarksA2(path);
        // std is an object from the StudentsMarksA2 class, which can be used to run the
        // program
        std.menu();
        scanner.close();
    }
}