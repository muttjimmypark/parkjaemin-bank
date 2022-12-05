package studio.aroundhub.application.bankstart.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import studio.aroundhub.application.bankstart.AppConfig;
import studio.aroundhub.application.bankstart.dto.BankAccountDTO;
import studio.aroundhub.application.bankstart.repository.BankAccountRepository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BankingServiceTest {

    ApplicationContext ac;
    BankingService bankingService;
    BankAccountRepository bankAccountRepository;

    BankAccountDTO account1;
    BankAccountDTO account2;

    @BeforeEach
    void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        bankingService = ac.getBean(BankingService.class);
        bankAccountRepository = ac.getBean(BankAccountRepository.class);

        account1 = new BankAccountDTO();
        account1.setId(1001L);
        account1.setUserName("hello");
        account1.setBalance(500L);

        account2 = new BankAccountDTO();
        account2.setId(1002L);
        account2.setUserName("world");
        account2.setBalance(70000L);
    }

    @Test
    void openAccount_findById_findAll() {

        bankingService.join(account1);
        assertThat(bankingService.findById(1001L).get()).isSameAs(account1);

        bankingService.join(account2);
        assertThat(bankingService.findAll()).isEqualTo(Arrays.asList(account1, account2));
    }

    @Test
    void deposit_withdraw_transfer() {
        bankingService.join(account1);
        bankingService.deposit(1001L, 300L);
        assertThat(bankingService.findById(1001L).get().getBalance()).isEqualTo(800L);

        bankingService.withdraw(1001L, 100L);
        assertThat(bankingService.findById(1001L).get().getBalance()).isEqualTo(700L);

        bankingService.join(account2);
        bankingService.transfer(1002L, 1001L, 1000L);
        assertThat(bankingService.findById(1001L).get().getBalance()).isEqualTo(1700L);
        assertThat(bankingService.findById(1002L).get().getBalance()).isEqualTo(69000L);
    }
}