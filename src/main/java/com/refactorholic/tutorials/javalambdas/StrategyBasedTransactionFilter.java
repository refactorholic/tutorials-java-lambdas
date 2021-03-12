package com.refactorholic.tutorials.javalambdas;

import java.util.List;

public class StrategyBasedTransactionFilter extends AbstractTransactionFilter {

	public List<Transaction> filterBigTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, new BigTransactionPredicate());
	}

	public List<Transaction> filterSmallTransactions(List<Transaction> transactions) {
		return filterTransactions(transactions, new SmallTransactionPredicate());
	}
}
