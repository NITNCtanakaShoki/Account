import java.util.Date;

class CalDate {
    int year;
    int month;
    int day;
    String dayOfWeek;

    CalDate( int year, int month, int day ) {
        this.change( year, month, day );
    }
    CalDate( CalDate copy ) {
        this.year = copy.year;
        this.month = copy.month;
        this.day = copy.day;
        this.dayOfWeek = copy.dayOfWeek;
    }

    boolean isAfterOf( CalDate d ) {
        Date mine = new Date(year, month, day, 0, 0, 0);
        Date compare = new Date(d.year, d.month, d.day, 0, 0, 0);

        return compare.before(mine);
    }

    boolean isSameWith( CalDate target ) {
        if ( this.year != target.year ) return false;
        if ( this.month != target.month ) return false;
        if ( this.day != target.day ) return false;
        return true;
    }

    String dayOfWeek() {
        int year = this.year;
        int month = this.month;
        int day = this.day;

        if ( month == 1 || month == 2 ) {
            year--;
            month += 12;
        }

        int indexOfDay = ( year + year / 4 - year / 100 + year / 400 + ( 13 * month + 8 ) / 5 + day) % 7;

        String[] dayWords = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        return dayWords[indexOfDay];
    }
    String fullDate() {
        String result = String.format(
                "%d/%d/%d(%s)",
                this.year,
                this.month,
                this.day,
                this.dayOfWeek
        );
        return result;
    }

    void change( int year, int month, int day ) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = this.dayOfWeek();
    }
}
