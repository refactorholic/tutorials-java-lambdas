package com.refactorholic.tutorials.javalambdas;

public class SmallTransactionPredicate implements TransactionPredicate {
	@Override
	public boolean test(Transaction transaction) {
		return transaction.amount() < 10;
	}
}
