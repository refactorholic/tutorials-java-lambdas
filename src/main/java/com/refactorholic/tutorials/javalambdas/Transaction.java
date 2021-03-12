package com.refactorholic.tutorials.javalambdas;

import java.util.Objects;

public class Transaction {

	private final int amount;

	public Transaction(int amount) {
		if (amount < 1) {
			throw new IllegalArgumentException("Transaction amounts cannot be smaller than 1");
		}

		this.amount = amount;
	}

	public int amount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return amount == that.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
