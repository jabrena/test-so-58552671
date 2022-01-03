package com.example.testso58552671;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
class TestSo58552671ApplicationTests {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private LocalTransactionStep1 localTransactionStep1;

	@Test
	public void noTransaction() throws InterruptedException {
		publisher.publishEvent(new TransactionEvent("test"));
		Thread.sleep(1000);
	}

	@Test
	public void rollbackTransaction() throws InterruptedException {
		transactionTemplate.execute((Void) -> {
			publisher.publishEvent(new TransactionEvent("test"));
			throw new IllegalStateException("Rollback!");
		});
		Thread.sleep(1000);
	}

	@Test
	public void runTransaction() {

		localTransactionStep1.step1();
	}

}
