public class Account {
    private String name;
    private String no;
    private int balance;

    Account( String name, String no ) {
        this.name = name;
        this.no = no;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public int getBalance() {
        return balance;
    }

    private boolean isSufficientAmount(int amount ) {
        return balance >= amount;
    }

    void deposit( int amount ) {
        balance += amount;
    }



    boolean withdraw( int amount ) {
        if ( !isSufficientAmount( amount ) ) return false;

        this.balance -= amount;
        return true;
    }

    public String toString() {
        return String.format(
                "%s(%s) :%d",
                this.name,
                this.no,
                this.balance
        );
    }
}
