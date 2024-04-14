package MainClasses;

public class CreditCard extends BankCard {
    private Double creditLimit;
    private Double creditBalance;

    public CreditCard(Double creditLimit, Double balance) {
        setCreditLimit(creditLimit);
        setCreditBalance(creditLimit);
        setBalance(balance);
    }

    @Override
    public void AvailableFunds() {
        System.out.println("Собственные средства: "+getBalance()+"\nКредитная карта с лимитом: "+getCreditLimit()+
                "\nКредитные средства: "+getCreditBalance()+"\n\n");
    }

    @Override
    public boolean pay(Double WriteOffAmount) {
        if ((getCreditBalance() + getBalance()) >= WriteOffAmount) {
            if (getBalance() >= WriteOffAmount) {
                setBalance(getBalance() - WriteOffAmount);
            } else {
                Double AmountOfCredit = WriteOffAmount - getBalance();
                setBalance((double) 0);
                setCreditBalance(getCreditBalance() - AmountOfCredit);
            }
            return true;
        }
        return false;
    }

    @Override
    public void topUpBalance(Double replenishmentAmount) {
        Double amountOfDebt = getCreditLimit() - getCreditBalance();
        if (replenishmentAmount <= amountOfDebt) {
            setCreditBalance(getCreditBalance() + amountOfDebt);
        } else {
            setCreditBalance(getCreditLimit());
            setBalance(replenishmentAmount - amountOfDebt);
        }
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
