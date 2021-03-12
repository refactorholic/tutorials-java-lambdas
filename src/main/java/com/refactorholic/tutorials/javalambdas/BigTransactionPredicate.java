package com.refactorholic.tutorials.javalambdas;

public class BigTransactionPredicate implements TransactionPredicate {
	@Override
	public boolean test(Transaction transaction) {
		return transaction.amount() > 1000;
	}
}
