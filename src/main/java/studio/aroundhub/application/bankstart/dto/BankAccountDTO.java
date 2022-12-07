package studio.aroundhub.application.bankstart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountDTO {
    private Long id;
    private String userName;
    private Long balance;
}
