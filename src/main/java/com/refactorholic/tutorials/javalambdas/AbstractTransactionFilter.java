package com.refactorholic.tutorials.javalambdas;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTransactionFilter implements TransactionFilter {

	protected List<Transaction> filterTransactions(List<Transaction> transactions, TransactionPredicate predicate) {

		List<Transaction> result = new ArrayList<>();

		for (Transaction transaction : transactions) {
			if (predicate.test(transaction)) {
				result.add(transaction);
			}
		}

		return result;
	}
}
