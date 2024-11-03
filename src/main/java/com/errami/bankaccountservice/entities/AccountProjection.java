package com.errami.bankaccountservice.entities;

import com.errami.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "projection1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
