import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentsMarksA2
{
    public StudentsMarksA2()
    {
    //  Scanner scanner = new Scanner(System.in);
    //  System.out.print("Enter the path name: ");
    //  String path = scanner.nextLine();
    //  System.out.print(path);

    String path = "D:/OneDrive - Southern Cross University/SCU/Term 3/PROG5001 Fundalmentals of Programming/PROG5001-A2/grades.csv";

    String line = "";

    try{
        BufferedReader br = new BufferedReader(new FileReader(path));

        while ((line = br.readLine()) != null ){
            String [] values = line.split(",");
            System.out.println(values[0]);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e){
        e.printStackTrace();
    } 

    }
    
    public static void main(String[] args) {
        new StudentsMarksA2();
    }

}
