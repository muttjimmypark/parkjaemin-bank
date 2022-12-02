package studio.aroundhub.application.bankstart.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import studio.aroundhub.application.bankstart.AppConfig;
import studio.aroundhub.application.bankstart.dto.BankAccountDTO;
import studio.aroundhub.application.bankstart.repository.BankAccountRepository;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BankingServiceTest {

    BankingService bankingService;
    BankAccountRepository bankAccountRepository;

    @BeforeEach
    void setUp() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        bankingService = ac.getBean(BankingService.class);
        bankAccountRepository = ac.getBean(BankAccountRepository.class);
    }

    @Test
    void openAccount_findById_findAll() {
        BankAccountDTO account1 = new BankAccountDTO();
        BankAccountDTO account2 = new BankAccountDTO();

        account1.setId(1001L);
        account1.setUserName("hello");
        account1.setBalance(500L);

        account2.setId(1002L);
        account2.setUserName("world");
        account2.setBalance(70000L);

        bankingService.join(account1);
        assertThat(bankingService.findById(1001L)).isEqualTo(account1);
    }
}