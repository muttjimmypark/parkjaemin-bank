package studio.aroundhub.application.bankstart.repository;

import org.springframework.stereotype.Repository;
import studio.aroundhub.application.bankstart.dto.BankAccountDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBankAccountRepository implements BankAccountRepository {

    Map<Long, BankAccountDTO> memoryDB;

    public MemoryBankAccountRepository() {
        memoryDB = new HashMap<>();
    }

    @Override
    public void save(BankAccountDTO bankAccountDTO) {
        memoryDB.put(bankAccountDTO.getId(), bankAccountDTO);
    }

    @Override
    public Optional<BankAccountDTO> findById(Long accountId) {
        return Optional.ofNullable(memoryDB.get(accountId));
    }

    @Override
    public List<BankAccountDTO> findAll() {
        return memoryDB.values().stream().toList();
    }
}
