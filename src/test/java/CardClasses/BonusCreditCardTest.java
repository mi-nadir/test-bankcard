package CardClasses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusCreditCardTest {
    private BonusCreditCard myCard;

    @Before
    public void setUp() {
        System.out.println("Начальный баланс собственных - 5000, кредитных - 5000, процент бонуса - 1\n\n");
        myCard = new BonusCreditCard((double) 5000, (double) 5000, (double) 1);
    }

    @Test
    public void TestPay() {
        System.out.println("Оплата с кредитной бонусной карты: 3000");
        assertTrue(myCard.pay((double) 3000));
        assertEquals(2000, myCard.getBalance(), 0.001);
        assertEquals(5000, myCard.getCreditBalance(), 0.001);
        assertEquals(30, myCard.getBonusBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestPay2() {
        System.out.println("Оплата с кредитной бонусной карты: 13000");
        assertFalse(myCard.pay((double) 13000));
        assertEquals(5000, myCard.getBalance(), 0.001);
        assertEquals(5000, myCard.getCreditBalance(), 0.001);
        assertEquals(0, myCard.getBonusBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestCredit() {
        System.out.println("Оплата с кредитной бонусной карты: 5000");
        assertTrue(myCard.pay((double) 5000));
        assertEquals(0, myCard.getBalance(), 0.001);
        assertEquals(5000, myCard.getCreditBalance(), 0.001);
        assertEquals(50, myCard.getBonusBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestCredit2() {
        System.out.println("Оплата с кредитной бонусной карты: 7000");
        assertTrue(myCard.pay((double) 7000));
        assertEquals(0, myCard.getBalance(), 0.001);
        assertEquals(3000, myCard.getCreditBalance(), 0.001);
        assertEquals(70, myCard.getBonusBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestCredit3() {
        System.out.println("Оплата с кредитной бонусной карты: 7000 и пополнение 3000");
        assertTrue(myCard.pay((double) 7000));
        myCard.topUpBalance((double) 3000);
        assertEquals(1000, myCard.getBalance(), 0.001);
        assertEquals(5000, myCard.getCreditBalance(), 0.001);
        assertEquals(70, myCard.getBonusBalance(), 0.001);
        myCard.AvailableFunds();
    }
}