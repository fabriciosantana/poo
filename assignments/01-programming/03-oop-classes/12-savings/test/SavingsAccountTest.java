import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(1000.00);
        SavingsAccount.setAnnualInterestRate(12); 
    }

    @Test
    void testCalculateMonthlyInterest() {
        account.calculateMonthlyInterest();
        assertEquals(1009.49, account.getSavingsBalance(), 0.01);
    }

    @Test
    void testModifyInterestRate() {
        SavingsAccount.setAnnualInterestRate(10);
        account.calculateMonthlyInterest();
        assertEquals(1007.97, account.getSavingsBalance(), 0.01);
    }

    @Test
    void testBalanceAfter12Months() {
        for (int i = 0; i < 12; i++) {
            account.calculateMonthlyInterest();
        }
        assertEquals(1120.00, account.getSavingsBalance(), 0.01);
    }

    @Test
    void testBalanceAfter13MonthsWithUpdatedRate() {
        for (int i = 0; i < 12; i++) {
            account.calculateMonthlyInterest();
        }
        SavingsAccount.setAnnualInterestRate(10);
        account.calculateMonthlyInterest();
        assertEquals(1128.93, account.getSavingsBalance(), 0.01);
    }

    @Test
    void testNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount(-1000));
    }

    @Test
    void testNegativeInterestRate() {
        assertThrows(IllegalArgumentException.class, () -> SavingsAccount.setAnnualInterestRate(-5));
    }
}
