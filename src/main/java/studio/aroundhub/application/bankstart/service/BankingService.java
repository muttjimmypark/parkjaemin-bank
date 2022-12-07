package studio.aroundhub.application.bankstart.service;

import studio.aroundhub.application.bankstart.dto.BankAccountDTO;

import java.util.List;
import java.util.Optional;

public interface BankingService {

    void join(BankAccountDTO bankAccountDTO);

    List<BankAccountDTO> findAll();

    Optional<BankAccountDTO> findById(Long accountId);

    void deposit(Long id, Long moneyIn);

    void withdraw(Long id, Long moneyOut);

    void transfer(Long sendId, Long takeId, Long money);
}
