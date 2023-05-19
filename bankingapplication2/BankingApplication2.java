/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingapplication2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class BankingApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("SCB");
        int option = 0;
        int accountNumber = 0;
        String accountName;
        double amount;
        int balance;

        while (option != 6) {
            System.out.println("main Menu");
            System.out.println("1. Display All Accouts");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your chioce: ");
            option = sc.nextInt();
            switch (option) {

                case 1:
                    bank.listAccout();
                    break;

                case 2:
                
                    accountNumber = gennerateAccnumber();
                    sc.nextLine(); // ต้อ้งเคลียย์ก่อน
                    System.out.print("Enter Account Name: ");
                    accountName = sc.nextLine();
                    System.out.print("Enter Balance: ");
                    balance = sc.nextInt();
                    bank.openAccount(accountNumber, accountName,balance);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextInt();
                    sc.nextLine(); // ต้อ้งเคลียย์ก่อน
                    bank.closeAccount(accountNumber);
                    ;
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextInt();
                    sc.nextLine(); // ต้อ้งเคลียย์ก่อน
                    System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();
                    bank.depositMoney(accountNumber, amount);
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextInt();
                    sc.nextLine(); // ต้อ้งเคลียย์ก่อน
                    System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();
                    bank.withdrawMoney(accountNumber, amount);
                    break;

            }
            System.out.println();

        }

    }

    public static int gennerateAccnumber(){
        Random rand = new Random();
        int accNumber = 100000 + rand.nextInt(900000);
        return accNumber;
    }

}
