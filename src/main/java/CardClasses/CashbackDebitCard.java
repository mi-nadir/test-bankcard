package CardClasses;

import MainClasses.DebitCard;

public class CashbackDebitCard extends DebitCard {
    private final Double cashbackPercentage;
    private final Double requiredMonthlySpendingAmount;
    private Double monthlyExpenses;

    public CashbackDebitCard(Double balance, Double cashbackPercentage, Double requiredMonthlySpendingAmount) {
        super(balance);
        this.cashbackPercentage = cashbackPercentage; // процент кэшбека
        this.monthlyExpenses = (double) 0; // траты за этот месяц
        this.requiredMonthlySpendingAmount = requiredMonthlySpendingAmount; // требуемая сумма трат в месяц для кешбэка
    }

    @Override
    public void AvailableFunds() {
        System.out.println("Процент кэшбека: "+this.cashbackPercentage+"%\nНеобходимая сумма трат за месяц для получения кэшбека: "+
                this.requiredMonthlySpendingAmount+"\nТраты за месяц: "+this.monthlyExpenses);
    super.AvailableFunds();
    }

    @Override
    public boolean pay(Double WriteOffAmount) {
        boolean result = super.pay(WriteOffAmount);
        if(result) {
            if (this.monthlyExpenses >= this.requiredMonthlySpendingAmount || WriteOffAmount >= this.requiredMonthlySpendingAmount) { // траты за месяц больше требуемой суммы?
                Double cashbackSum = (WriteOffAmount / 100) * cashbackPercentage;
                super.topUpBalance(cashbackSum); //пополняем на сумму кэшбека
            }
            this.monthlyExpenses += WriteOffAmount;
        } else {
            return false;
        }
        return true;
    }
}
