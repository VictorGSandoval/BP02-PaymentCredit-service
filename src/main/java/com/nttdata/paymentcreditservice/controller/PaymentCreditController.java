package com.nttdata.paymentcreditservice.controller;


import com.nttdata.paymentcreditservice.model.PaymentCredit;
import com.nttdata.paymentcreditservice.service.IPaymentCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paymentCredit")
public class PaymentCreditController {

    private final IPaymentCreditService service;

    @GetMapping
    public Flux<PaymentCredit> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PaymentCredit> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<PaymentCredit> create(@RequestBody PaymentCredit paymentCredit) {
        return service.create(paymentCredit);
    }

    @PutMapping("/{id}")
    public Mono<PaymentCredit> update(@PathVariable String id, @RequestBody PaymentCredit paymentCredit) {
        return service.update(id, paymentCredit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
