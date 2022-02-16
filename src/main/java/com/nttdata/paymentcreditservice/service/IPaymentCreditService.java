package com.nttdata.paymentcreditservice.service;

import com.nttdata.paymentcreditservice.model.PaymentCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPaymentCreditService {
    Flux<PaymentCredit> findAll();

    Mono<PaymentCredit> findById(String id);

    Mono<PaymentCredit> create(PaymentCredit paymentCredit);

    Mono<PaymentCredit> update(String id, PaymentCredit paymentCredit);

    Mono<Void> delete(String id);
}
