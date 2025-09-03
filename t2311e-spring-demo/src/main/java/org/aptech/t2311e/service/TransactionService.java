package org.aptech.t2311e.service;

public interface TransactionService {
    void deposit(String depositType, long  amount, int accountId);
    // depositType : ATM , SDT , Chi phiếu
    void withdraw();
    void transfer();
}
