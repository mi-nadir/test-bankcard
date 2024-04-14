package MainClasses;

public abstract class BankCard {
    private Double balance = (double) 0;

    public abstract void AvailableFunds();

    public abstract boolean pay(Double WriteOffAmount);

    public void topUpBalance(Double replenishmentAmount) {
        setBalance(getBalance() + replenishmentAmount);
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
