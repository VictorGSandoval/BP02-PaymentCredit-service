package com.nttdata.paymentcreditservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document
public class PaymentCredit {
    @Id
    private String id;
    private String creditId;
    private Double amount;
    private Date dateStart;
    private Date dateLimit;
    //0.1 = 10%
    private Double commission;
    private String description;

}
