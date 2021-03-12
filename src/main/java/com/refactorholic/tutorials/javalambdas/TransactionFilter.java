package com.refactorholic.tutorials.javalambdas;

import java.util.List;

public interface TransactionFilter {

	List<Transaction> filterBigTransactions(List<Transaction> transactions);

	List<Transaction> filterSmallTransactions(List<Transaction> transactions);
}
