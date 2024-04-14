package CardClasses;

import MainClasses.CreditCard;

public class BonusCreditCard extends CreditCard {
    private final Double bonusPercentage;
    private Double bonusBalance;

    public BonusCreditCard(Double creditLimit, Double balance, Double bonusPercentage) {
        super(creditLimit, balance);
        this.bonusPercentage = bonusPercentage;
        this.bonusBalance = (double) 0;
    }

    @Override
    public void AvailableFunds() {
        System.out.println("Процент начисляемого бонуса: "+bonusPercentage+"\nДоступный бонусный баланс: "+getBonusBalance());
        super.AvailableFunds();
    }

    @Override
    public boolean pay(Double WriteOffAmount) {
        boolean result = super.pay(WriteOffAmount);
        if (result) {
            Double bonusSum = (WriteOffAmount/100)*bonusPercentage;
            setBonusBalance(getBonusBalance() + bonusSum);
            return true;
        }
        return false;
    }

    public Double getBonusBalance() {
        return bonusBalance;
    }

    public void setBonusBalance(Double bonusBalance) {
        this.bonusBalance = bonusBalance;
    }
}
