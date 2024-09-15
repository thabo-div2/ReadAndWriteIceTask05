/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readandwriteicetask05;

import Classes.Employee;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Thabo Setsubi st10445734@vcconnnect.edu.za ST10445734
 */
public class ReadAndWriteIceTask05 {

    static final String FILEPATH = "emloyeeRecords.txt";
    
    //this is main method
    //------------------------------------------------------------------------//
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        int EXIT = 5;
        
        System.out.println("Welcome to ABC Ltd. Employee Records");
        
        try 
        {
            while (option != 5) 
        {
            System.out.println("===============================================\n" 
                    + "Please enter a number between (1-3) or enter 5 to EXIT: \n"
                    + "1) Add a new employee record \n"
                    + "2) Update an employees salary\n"
                    + "3) Retrieve an employees info\n"
                    + "Press 5 to exit the program\n"
                    + "===============================================");
            
            option = scan.nextInt();
            
            switch (option) 
            {
                case 1:
                    Employee.addNewEmployee();
                    break;
                case 2:
                    Employee.updateEmployee();
                    break;
                case 3:
                    Employee.getEmployee();
                    break;
                case 5:
                    System.out.println("Bye, have a great time!!!");
                    break;
                default:
                    System.out.println("Wrong input please enter 1-3 or 5");
                    break;
            }
        }
        }
        catch(InputMismatchException e) 
        {
            e.printStackTrace();
        }
    }
    
}
