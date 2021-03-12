package com.refactorholic.tutorials.javalambdas;

import java.util.List;

public class MethodReferenceTransactionFilter extends AbstractTransactionFilter {


	@Override
	public List<Transaction> filterBigTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, this::isBig);
	}

	@Override
	public List<Transaction> filterSmallTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, this::isSmall);
	}

	private boolean isBig(Transaction transaction) {
		return transaction.amount() > 1000;
	}

	private boolean isSmall(Transaction transaction) {
		return transaction.amount() < 10;
	}
}
