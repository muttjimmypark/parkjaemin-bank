package studio.aroundhub.application.bankstart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import studio.aroundhub.application.bankstart.dto.BankAccountDTO;
import studio.aroundhub.application.bankstart.repository.BankAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankingServiceImpl implements BankingService {

    private BankAccountRepository bankAccountRepository;


    @Override
    public void join(BankAccountDTO bankAccountDTO) {
        bankAccountRepository.save(bankAccountDTO);
    }

    @Override
    public List<BankAccountDTO> findAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public Optional<BankAccountDTO> findById(Long accountId) {
        return bankAccountRepository.findById(accountId);
    }

    @Override
    public void deposit(Long id, Long moneyIn) {

        BankAccountDTO account = findById(id).get();
        account.setBalance(account.getBalance() + moneyIn);
        join(account);
    }

    @Override
    public void withdraw(Long id, Long moneyOut) {

        BankAccountDTO account = findById(id).get();
        account.setBalance(account.getBalance() - moneyOut);
        join(account);
    }

    @Override
    public void transfer(Long sendId, Long takeId, Long money) {

        withdraw(sendId, money);
        deposit(takeId, money);
    }
}
