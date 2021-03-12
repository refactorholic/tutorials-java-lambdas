package com.refactorholic.tutorials.javalambdas;

import java.util.ArrayList;
import java.util.List;

public class InitialTransactionFilter implements TransactionFilter {

	public List<Transaction> filterBigTransactions(List<Transaction> transactions) {

		List<Transaction> result = new ArrayList<>();

		for (Transaction transaction : transactions) {
			if (transaction.amount() > 1000) {
				result.add(transaction);
			}
		}

		return result;
	}

	public List<Transaction> filterSmallTransactions(List<Transaction> transactions) {

		List<Transaction> result = new ArrayList<>();

		for (Transaction transaction : transactions) {
			if (transaction.amount() < 10) {
				result.add(transaction);
			}
		}

		return result;
	}
}
