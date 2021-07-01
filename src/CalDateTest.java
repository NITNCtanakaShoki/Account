import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalDateTest {

    // isAfterOfメソッドのみのテスト
    @Test
    public void 年() {
        CalDate date1 = new CalDate(2020, 12, 31);
        CalDate date2 = new CalDate(2021, 1, 1);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }

    @Test
    public void 月() {
        CalDate date1 = new CalDate(2020, 1, 1);
        CalDate date2 = new CalDate(2020, 2, 1);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }

    @Test
    public void 日() {
        CalDate date1 = new CalDate(2020, 3, 1);
        CalDate date2 = new CalDate(2021, 3, 2);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }

    @Test
    public void 年と月() {
        CalDate date1 = new CalDate(2020, 9, 9);
        CalDate date2 = new CalDate(2021, 10, 1);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }

    @Test
    public void 月と日() {
        CalDate date1 = new CalDate(2020, 9, 9);
        CalDate date2 = new CalDate(2020, 10, 10);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }

    @Test
    public void 年と日() {
        CalDate date1 = new CalDate(2020, 9, 9);
        CalDate date2 = new CalDate(2021, 8, 10);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }
    @Test
    public void 全てが大きい() {
        CalDate date1 = new CalDate(2020, 9, 1);
        CalDate date2 = new CalDate(2021, 10, 2);

        assertFalse( date1.isAfterOf( date2 ) );
        assertTrue( date2.isAfterOf( date1 ) );
    }

    @Test
    public void 等しい() {
        CalDate date1 = new CalDate(2020, 9, 1);
        CalDate date2 = new CalDate(2020, 9, 1);

        assertFalse( date1.isAfterOf( date2 ) );
        assertFalse( date2.isAfterOf( date1 ) );
    }


}
