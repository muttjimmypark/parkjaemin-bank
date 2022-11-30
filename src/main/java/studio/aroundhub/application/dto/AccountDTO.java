package studio.aroundhub.application.dto;

public class AccountDTO {
    public String owner;
    public String accountCode;
    public String password;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "owner='" + owner + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
