package bankexercise.entity;

import java.util.List;

public class User {
    private final long id;
    private String username;
    private String tel;
    private String email;
    private String identity;
    private List<BankAccount> bankAccounts;

    public User(long id, String username, String tel, String email, String identity) {
        this.id = id;
        this.username = username;
        this.tel = tel;
        this.email = email;
        this.identity = identity;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
