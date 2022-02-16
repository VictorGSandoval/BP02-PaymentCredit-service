package com.nttdata.paymentcreditservice.service;

import com.nttdata.paymentcreditservice.model.PaymentCredit;
import com.nttdata.paymentcreditservice.repository.PaymentCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentCreditService implements IPaymentCreditService {
    private final PaymentCreditRepository repository;

    @Override
    public Flux<PaymentCredit> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<PaymentCredit> findById(String id) {
        return  repository.findById(id);
    } 

    @Override
    public Mono<PaymentCredit> create(PaymentCredit paymentCredit) {
        return repository.save(paymentCredit);
    }

    @Override
    public Mono<PaymentCredit> update(String id, PaymentCredit paymentCredit) {
        return repository.findById(id).flatMap(newPaymentCredit -> {
            paymentCredit.setId(newPaymentCredit.getId());
            return repository.save(paymentCredit);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id).flatMap(paymentCredit -> repository.deleteById(paymentCredit.getId()));
    }
}
