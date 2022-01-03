package com.example.testso58552671;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class LocalTransactionStep2 {
    
	@Autowired
	private ApplicationEventPublisher publisher;

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.MANDATORY)
    public void step2() {
        //Run a service
        publisher.publishEvent(new TransactionEvent3("step2-done"));
        throw new RuntimeException("Katakroker");
    }

}
