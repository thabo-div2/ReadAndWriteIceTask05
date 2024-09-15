/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Thabo Setsubi st10445734@vcconnnect.edu.za ST10445734
 */
public class Employee {
    static final String FILEPATH = "emloyeeRecords.txt";
    
    static int id;
    static String name;
    static double salary;
    
    private static void readFromFile(String filePath, int position, int size) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(position);
        
        int employeeId = file.readInt();
        char[] nameChars = new char[20];
        for (int i = 0; i < 20; i++) {
            nameChars[i] = file.readChar(); // Read employee name (fixed length)
        }
        String employeeName = new String(nameChars).trim(); // Convert char array to String and trim whitespace
        double employeeSalary = file.readDouble();
       
        file.close();
        
        System.out.println("===================================================\n" 
                + "Employee ID: " + employeeId + "\n"
                + "Employee Name: " + employeeName + "\n"
                + "Employee Salary: " + employeeSalary + "\n"
                + "===================================================");
    }
    
    private static void writeToFile(String filePath, String name, int id, double salary, int position) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(position);
        file.writeInt(id);
        file.writeChars(name);
        file.writeDouble(salary);
        file.close();
    }
    
    public static void addNewEmployee() 
    {
        Scanner scan = new Scanner(System.in);
        
        try 
        {
            System.out.println("Enter employee ID");
            id = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter employee's name: ");
            name = scan.nextLine();
            System.out.println("Enter employee's salary: ");
            salary = scan.nextDouble();
            
            int position = (id - 1) * (4 + 20 * 2 + 4);

            writeToFile(FILEPATH, name, id, salary, position);
            
            System.out.println("Employee record saved successfully");
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void updateEmployee() 
    {
        Scanner scan = new Scanner(System.in);
        
        try 
        {
            RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
            
            System.out.println("Enter employee ID");
            id = scan.nextInt();
            
            int position = (id - 1) * (4 + 20 * 2 + 4);
            
            file.seek(position);
            
            double currentSalary = file.readDouble();
            
            System.out.println("Enter new Salary: ");
            double newSalary = scan.nextDouble();
            
            file.seek(position + 4 + 20 *2);
            
            file.writeDouble(newSalary);
            file.close();
            
            System.out.println("Employee record updated successfully");
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void getEmployee() 
    {
        Scanner scan = new Scanner(System.in);
        try 
        {
            System.out.println("Enter employee ID");
            id = scan.nextInt();
            
            int position = (id - 1) * (4 + 20 * 2 + 4);
            int recordSIze = (4 + 20 * 2 + 4);
            
            readFromFile(FILEPATH, position, recordSIze);
            
            System.out.println("Employee record updated successfully");
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
}
