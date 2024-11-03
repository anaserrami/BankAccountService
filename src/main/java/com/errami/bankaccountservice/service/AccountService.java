package com.errami.bankaccountservice.service;

import com.errami.bankaccountservice.dto.BankAccountRequestDTO;
import com.errami.bankaccountservice.dto.BankAccountResponseDTO;
import com.errami.bankaccountservice.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
