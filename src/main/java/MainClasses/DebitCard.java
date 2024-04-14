package MainClasses;

public class DebitCard extends BankCard {
    public DebitCard(Double balance) {
        setBalance(balance);
    }

    @Override
    public void AvailableFunds() {
        System.out.println("Собственные средства: "+getBalance()+"\n\n");
    }

    @Override
    public boolean pay(Double WriteOffAmount) {
        if(getBalance() >= WriteOffAmount) {
            setBalance(getBalance()-WriteOffAmount);
            return true;
        }
        return false;
    }
}
