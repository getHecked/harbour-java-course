public class Atm_out implements Chain {
    private Chain chain = null;

    String currency;
    int value;
    int notes;

    public Atm_out(String currency, int value, int notes) {
        this.currency = currency;
        this.value = value;
        this.notes = notes;
    }

    @Override
    public void setNextChain(Chain nextChain) {

        this.chain = nextChain;
    }


    @Override
    public Chain nextChain() {

        return chain;
    }

    @Override
    public void give(int remaining) {
        if (remaining >= value) {
            int num = remaining / value;
            if (num > notes)
                num = notes;
            remaining -= num * value;
            notes -= num;
            System.out.println("Withdrawing " + num + " " + value + currency + " note" + (num > 1 ? "s" : ""));
        }
        if (remaining > 0) {
            if (nextChain() != null) {
                nextChain().give(remaining);
            }
            else
            {
                System.out.println("Could not dispense the rest " +currency+remaining);

            }
        }
        else {
            System.out.println("Withdrawn Successfully");
        }
    }
}