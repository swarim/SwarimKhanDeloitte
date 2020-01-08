package com.deloitte.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.deloitte.exception.BankingException;
import com.deloitte.service.BankingService;
import com.deloitte.service.BankingServiceImpl;

public class BankingMain {
	private BankingService bService;

	public static void main(String[] args) {
		new BankingMain();
	}

	public BankingMain() {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		bService = new BankingServiceImpl();
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Deposit Amount");
				System.out.println("Enter amount to deposit");
				double amount;
				boolean success = false;
				boolean notCorrect = true;
				do {
					try {
						amount = scan.nextDouble();
						success = bService.depositAmount(amount);
						notCorrect = false;
					} catch (InputMismatchException e) {
						System.out.println("Enter numbers only.");
						scan.nextLine();
					}
				} while (notCorrect);
				break;
			case 2:
				System.out.println("Withdraw Amount");
				double wAmount;
				boolean wSuccess = false;
				boolean wNotCorrect = true;
				do {
					try {
						System.out.println("Enter amount to withdraw");
						wAmount = scan.nextDouble();
						wSuccess = bService.withdrawAmount(wAmount);
						if (wSuccess)
							System.out.println("Amount withdrawn = " + wAmount);
						else {
							System.out.println("Cannot withdraw, Minimum balance should be 1000. ");
						}
						wNotCorrect = false;
					} catch (InputMismatchException e) {
						System.out.println("Enter numbers only.");
						scan.nextLine();
					} catch (BankingException e) {
						System.out.println(e.getMessage());
						System.out.println("Do you want to continue with withdraw? [Y/N]");
						String answer = scan.next();
						if (answer.equalsIgnoreCase("N")) {
							wNotCorrect = false;
						}
					}
				} while (wNotCorrect);

				break;
			case 3:
				System.out.println("Check Balance");
				double balance = bService.getBalance();
				System.out.println("Your balance is " + balance);
				break;
			case 4:
				System.out.println("Exiting the system");
				System.exit(0);
				break;

			default:
				System.out.println("Please enter 1 to 4 only.");
				break;
			}
		}
	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("BANKING SYSTEM");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit");
		System.out.println("Enter your choice");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter numbers only");
			scan.nextLine();// consume keyboard input
		}
		return choice;
	}

}
