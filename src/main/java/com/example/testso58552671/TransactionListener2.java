package com.example.testso58552671;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionListener2 {

	private static final Log logger = LogFactory.getLog(TransactionListener.class);

	@Autowired
	private LocalTransactionStep2 localTransactionStep2;

	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK, classes = TransactionEvent2.class)
	public void onEventRollbackHandler(TransactionEvent2 event) {
		logger.info("after rollback. event2 = " + event);
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK, classes = TransactionEvent3.class)
	public void onEventRollbackHandler2(TransactionEvent3 event) {
		logger.info("after rollback. event3 = " + event);
	}

	@TransactionalEventListener(classes = TransactionEvent2.class)
	public void onEventHandler2(TransactionEvent2 event) {
		logger.info("running transaction 2 = " + event);
		localTransactionStep2.step2();
	}
}