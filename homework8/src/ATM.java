import java.util.*;

public class ATM implements Iterable<Atm_out> {

    public Atm_out[] bills;

    public ATM(List<Integer> temp, String currency, int start) {
        bills = new Atm_out[temp.size()];
        temp.sort((a, b) -> b - a);
        for (int i = 0; i < temp.size();i++) {
            bills[i] = new Atm_out(currency, temp.get(i), start);
        }
        for (int i = 0; i + 1 < temp.size();i++){
            bills[i].setNextChain(bills[i + 1]);
        }
    }

    public void withdraw(int amount) {
        bills[0].give(amount);
    }

    public int getBalance() {
        int balance = 0;
        for (Atm_out cd: this) {
            balance += cd.notes * cd.value;
        }
        return balance;
    }
    @Override
    public Iterator iterator() {
        return new CDIterator(0);
    }


    public class CDIterator implements Iterator {
        int position;

        public CDIterator(int position) {
            this.position = position;
        }

        @Override
        public boolean hasNext() {
            return position < bills.length;
        }

        @Override
        public Object next() {
            return bills[position++];
        }
    }




    public static void main(String[] args) {
        ArrayList<Integer> denom = new ArrayList();
        denom.add(100);
        denom.add(200);
        denom.add(500);
        denom.add(1000);
        denom.add(2000);
        ATM atm = new ATM(denom, "$", 5);
        atm.withdraw(1300);

        System.out.println(atm.getBalance());
    }

}