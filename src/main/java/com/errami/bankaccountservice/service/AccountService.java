package com.errami.bankaccountservice.service;

import com.errami.bankaccountservice.dto.BankAccountRequestDTO;
import com.errami.bankaccountservice.dto.BankAccountResponseDTO;

import java.util.List;

public interface AccountService {
    List<BankAccountResponseDTO> getAllAccounts();
    BankAccountResponseDTO getAccountById(String id);
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO requestDTO);
    void deleteAccount(String id);
}
