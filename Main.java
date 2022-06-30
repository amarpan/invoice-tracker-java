/*
File Name: main.java
Name: Amar Panjwani
Description: This program processes a record of daily trash transactions and confirms whether the actual amount of cash at the end of the day equals the expected value.
Date: 04/26/21
Email: panjwania@student.vvc.edu
*/

import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException; 

class Main 
{
  /**
    Checks final cash amount from a text file of daily cash transactions.
    @param invoice - the name of the text file to sort through
    @param totalAmount - the starting balance from which to count from
    @param expectedEndAmount - the expected end amount to check against
    @return void
  */
  public static void checkFinalAmount (String invoice, double totalAmount, double expectedEndAmount) throws FileNotFoundException
  {
    File invoice1 = new File(invoice);
    Scanner in2 = new Scanner(invoice1);
    while (in2.hasNextLine())
    {
      int invoiceNumber = in2.nextInt();
      double price = in2.nextDouble();
      String status = in2.next();
      if (status.equals("P"))
      {
        totalAmount = totalAmount - price;
      }
      else if (status.equals("R"))
      {
        totalAmount = totalAmount + price;
      }
    }
    in2.close();
    System.out.println("");
    System.out.println("Expected total amount of cash at the end of the day was: " + expectedEndAmount);
    System.out.print("Actual calculated total amount of cash at the end of the day is: ");
    System.out.printf("%.2f",totalAmount);
    System.out.println("");
    System.out.println("");

    final double EPSILON = 1E-12;

    if(Math.abs(totalAmount - expectedEndAmount) < EPSILON)
    {
      System.out.println("The expected total equals the calculated total.");
    }
    else
    {
      System.out.println("The expected total does not equal the calculated total.");
    }
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    
    Scanner in1 = new Scanner(System.in);
    System.out.print("Enter the name of the input file: ");
    String invoice = in1.next();
    System.out.print("Enter amount of cash at beginning of day: ");
    double totalAmount = in1.nextDouble();
    System.out.print("Enter amount of cash at end of day: ");
    double expectedEndAmount = in1.nextDouble();
    in1.close();
    checkFinalAmount(invoice, totalAmount, expectedEndAmount);
  }
}

  
  