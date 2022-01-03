package com.example.testso58552671;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocalTransactionStep1 {
    
	@Autowired
	private ApplicationEventPublisher publisher;

    @Transactional(propagation = Propagation.REQUIRED)
    public void step1() {
        //Run a service
        publisher.publishEvent(new TransactionEvent2("step1-done"));
    }

}
