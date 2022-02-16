package com.nttdata.paymentcreditservice.repository;

import com.nttdata.paymentcreditservice.model.PaymentCredit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PaymentCreditRepository extends ReactiveCrudRepository<PaymentCredit, String> {

}