package com.refactorholic.tutorials.javalambdas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TransactionFilterTest {

	static abstract class AbstractTransactionFilterTest {
		abstract TransactionFilter transactionFilter();

		@Nested
		@DisplayName("filterBigTransactions()")
		class FilterBigTransactions {

			@Test
			@DisplayName("throws NullPointerException if transaction list is null")
			void throws_NullPointerException_if_transaction_list_is_null() {
				// When
				assertThatThrownBy(() -> transactionFilter().filterBigTransactions(null))
						.isInstanceOf(NullPointerException.class);
			}

			@Test
			@DisplayName("returns empty list if transaction list is empty")
			void returns_empty_list_if_transaction_list_is_empty() {
				// When
				List<Transaction> result = transactionFilter().filterBigTransactions(emptyList());

				// Then
				assertThat(result).isEmpty();
			}

			@Test
			@DisplayName("returns empty list if no transaction is greater than 1000")
			void returns_empty_list_if_no_transaction_is_greater_than_1000() {
				// Given
				List<Transaction> transactions = Arrays.asList(
						new Transaction(1),
						new Transaction(240),
						new Transaction(1000)
				);

				// When
				List<Transaction> result = transactionFilter().filterBigTransactions(transactions);

				// Then
				assertThat(result).isEmpty();
			}

			@Test
			@DisplayName("returns transactions with amount greater than 1000")
			void returns_transactions_with_amount_greater_than_1000() {
				// Given
				List<Transaction> transactions = Arrays.asList(
						new Transaction(1),
						new Transaction(10),
						new Transaction(1000),
						new Transaction(1001),
						new Transaction(200000)
				);

				// When
				List<Transaction> result = transactionFilter().filterBigTransactions(transactions);

				// Then
				assertThat(result)
						.containsExactly(
								new Transaction(1001),
								new Transaction(200000)
						);
			}
		}

		@Nested
		@DisplayName("filterSmallTransactions()")
		class FilterSmallTransactions {

			@Test
			@DisplayName("throws NullPointerException if transaction list is null")
			void throws_NullPointerException_if_transaction_list_is_null() {
				// When
				assertThatThrownBy(() -> transactionFilter().filterSmallTransactions(null))
						.isInstanceOf(NullPointerException.class);
			}

			@Test
			@DisplayName("returns empty list if transaction list is empty")
			void returns_empty_list_if_transaction_list_is_empty() {
				// When
				List<Transaction> result = transactionFilter().filterSmallTransactions(emptyList());

				// Then
				assertThat(result).isEmpty();
			}

			@Test
			@DisplayName("returns empty list if no transaction is smaller than 10")
			void returns_empty_list_if_no_transaction_is_smaller_than_10() {
				// Given
				List<Transaction> transactions = Arrays.asList(
						new Transaction(240),
						new Transaction(1000),
						new Transaction(Integer.MAX_VALUE)
				);

				// When
				List<Transaction> result = transactionFilter().filterSmallTransactions(transactions);

				// Then
				assertThat(result).isEmpty();
			}

			@Test
			@DisplayName("returns transactions with amount smaller than 10")
			void returns_transactions_with_amount_smaller_than_10() {
				// Given
				List<Transaction> transactions = Arrays.asList(
						new Transaction(1),
						new Transaction(8),
						new Transaction(9),
						new Transaction(1001),
						new Transaction(200000)
				);

				// When
				List<Transaction> result = transactionFilter().filterSmallTransactions(transactions);

				// Then
				assertThat(result)
						.containsExactly(
								new Transaction(1),
								new Transaction(8),
								new Transaction(9)
						);
			}
		}
	}

	@Nested
	@DisplayName("InitialTransactionFilter")
	class InitialTransactionFilterTest extends AbstractTransactionFilterTest {

		@Override
		TransactionFilter transactionFilter() {
			return new InitialTransactionFilter();
		}
	}

	@Nested
	@DisplayName("StrategyBasedTransactionFilter")
	class StrategyBasedTransactionFilterTest extends AbstractTransactionFilterTest {

		@Override
		TransactionFilter transactionFilter() {
			return new StrategyBasedTransactionFilter();
		}
	}

	@Nested
	@DisplayName("InnerClassBasedTransactionFilter")
	class InnerClassBasedTransactionFilterTest extends AbstractTransactionFilterTest {

		@Override
		TransactionFilter transactionFilter() {
			return new InnerClassBasedTransactionFilter();
		}
	}

	@Nested
	@DisplayName("MethodReferenceTransactionFilter")
	class MethodReferenceTransactionFilterTest extends AbstractTransactionFilterTest {

		@Override
		TransactionFilter transactionFilter() {
			return new MethodReferenceTransactionFilter();
		}
	}

	@Nested
	@DisplayName("LambdaTransactionFilter")
	class LambdaTransactionFilterTest extends AbstractTransactionFilterTest {

		@Override
		TransactionFilter transactionFilter() {
			return new LambdaTransactionFilter();
		}
	}
}