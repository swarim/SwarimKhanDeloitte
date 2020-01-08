package com.deloitte.dao;

import com.deloitte.exception.BankingException;
import com.deloitte.util.BankingMessage;

public class BankingDaoImpl implements BankingDao {
	private static final double MIN_BALANCE = 0;
	private double balance;
	@Override
	public boolean depositAmount(double amount) {
		balance += amount;
		return true;
	}
	@Override
	public double getBalance() {
		return balance;
	}
	@Override
	public boolean withdrawAmount(double wAmount) throws BankingException {
		double balanceCheck = balance - wAmount;
		if(balanceCheck>= MIN_BALANCE)
		{
			balance = balanceCheck;
			return true;	
		}
		else 
			throw new BankingException(BankingMessage.INSUFFICIENT_BALANCE);
	}

}
