package com.refactorholic.tutorials.javalambdas;

import java.util.List;

public class LambdaTransactionFilter extends AbstractTransactionFilter {

	public List<Transaction> filterBigTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, transaction -> transaction.amount() > 1000);
	}

	public List<Transaction> filterSmallTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, transaction -> transaction.amount() < 10);
	}
}
