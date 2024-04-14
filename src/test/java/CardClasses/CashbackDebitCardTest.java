package CardClasses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CashbackDebitCardTest {
    private CashbackDebitCard myCard;

    @Before
    public void setUp() {
        System.out.println("Начальный баланс собственных - 15000, потенциальный кэшбек - 5%, требуемая сумма месячных трат - 7000\n\n");
        myCard = new CashbackDebitCard((double) 15000, (double) 5, (double) 7000);
    }

    @Test
    public void TestPay() {
        System.out.println("Оплата с дебетовой карты с потенциальным кэшбеком: 3000");
        assertTrue(myCard.pay((double) 3000));
        assertEquals(12000, myCard.getBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestPay2() {
        System.out.println("Оплата с дебетовой карты с потенциальным кэшбеком: 16000");
        assertFalse(myCard.pay((double) 16000));
        System.out.println(myCard.getBalance());
        assertEquals(15000, myCard.getBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestPay3() {
        System.out.println("Оплата с дебетовой карты с потенциальным кэшбеком: 5000");
        assertTrue(myCard.pay((double) 5000));
        assertEquals(10000, myCard.getBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestPay4() {
        System.out.println("Оплата с дебетовой карты с потенциальным кэшбеком: 7000");
        assertTrue(myCard.pay((double) 7000));
        assertEquals(8350, myCard.getBalance(), 0.001);
        myCard.AvailableFunds();
    }

    @Test
    public void TestPay5() {
        System.out.println("Оплата с дебетовой карты с потенциальным кэшбеком: минус 9000, плюс 3000");
        assertTrue(myCard.pay((double) 9000));
        myCard.topUpBalance((double) 3000);
        assertEquals(9450, myCard.getBalance(), 0.001);
        myCard.AvailableFunds();
    }
}