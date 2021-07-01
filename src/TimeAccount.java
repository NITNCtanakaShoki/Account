public class TimeAccount extends Account {
    private CalDate kigen;
    private int timeBalance;

    TimeAccount(String name, String no, CalDate kigen) {
        super(name, no);
        this.kigen = kigen;
    }

    boolean moveToTime(int amount) {
        if ( !withdraw(amount) ) return false;
        timeBalance += amount;
        return true;
    }

    boolean moveToNormal(CalDate d) {
        if ( kigen.isAfterOf(d) ) return false;

        deposit( timeBalance );
        timeBalance = 0;
        return true;
    }

    public String toString() {
        return String.format(
                "%s(%s) :Normal(%d) Time(%d)",
                getName(),
                getNo(),
                getBalance(),
                timeBalance
        );
    }
}
