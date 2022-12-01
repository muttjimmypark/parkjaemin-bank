package studio.aroundhub.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDTO {
    public String owner;
    public String accountCode;
    public String password;
}
