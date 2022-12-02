package studio.aroundhub.application.bankstart.repository;

import studio.aroundhub.application.bankstart.dto.BankAccountDTO;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository {
    void save(BankAccountDTO bankAccountDTO);

    Optional<BankAccountDTO> findById(Long accountId);

    List<BankAccountDTO> findAll();
}
