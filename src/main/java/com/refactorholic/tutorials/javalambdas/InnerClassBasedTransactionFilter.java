package com.refactorholic.tutorials.javalambdas;

import java.util.List;

public class InnerClassBasedTransactionFilter extends AbstractTransactionFilter {

	public List<Transaction> filterBigTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, new TransactionPredicate() {
			@Override
			public boolean test(Transaction transaction) {
				return transaction.amount() > 1000;
			}
		});
	}

	public List<Transaction> filterSmallTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, new TransactionPredicate() {
			@Override
			public boolean test(Transaction transaction) {
				return transaction.amount() < 10;
			}
		});
	}
}
