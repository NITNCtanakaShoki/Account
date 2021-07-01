import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;



public class TimeAccountTest {
    @Test
    public void コンストラクタ() {
        TimeAccount timeAccount = new TimeAccount("None", "0000", new CalDate(2020, 12, 31));
        assertEquals( "None(0000) :Normal(0) Time(0)", timeAccount.toString() );
    }

    @Test
    public void 普通預金から定期預金へ残高未満の金額を移動() {
        TimeAccount timeAccount = new TimeAccount("None", "0000", new CalDate(2020, 12, 31));

        timeAccount.deposit(1000);

        assertTrue( timeAccount.moveToTime(140) );
        assertEquals( "None(0000) :Normal(860) Time(140)", timeAccount.toString() );
    }

    @Test
    public void 普通預金から定期預金へ残高分の金額を移動() {
        TimeAccount timeAccount = new TimeAccount("None", "0000", new CalDate(2020, 12, 31));

        timeAccount.deposit(1050);

        assertTrue( timeAccount.moveToTime(1050) );
        assertEquals( "None(0000) :Normal(0) Time(1050)", timeAccount.toString() );
    }

    @Test
    public void 普通預金から定期預金へ残高オーバーの金額を移動() {
        TimeAccount timeAccount = new TimeAccount("None", "0000", new CalDate(2020, 12, 31));

        timeAccount.deposit(12);

        assertFalse( timeAccount.moveToTime(14) );
        assertEquals( "None(0000) :Normal(12) Time(0)", timeAccount.toString() );
    }

    @Test
    public void 期限前に定期預金の引き出し() {
        TimeAccount timeAccount = new TimeAccount( "None", "0000", new CalDate(2020, 12, 31) );

        timeAccount.deposit(1000);
        timeAccount.moveToTime(200);

        assertFalse( timeAccount.moveToNormal( new CalDate(2020, 12, 30 ) ) );

        assertEquals("None(0000) :Normal(800) Time(200)", timeAccount.toString() );
    }

    @Test
    public void 期限に定期預金の引き出し() {
        TimeAccount timeAccount = new TimeAccount( "None", "0000", new CalDate(2020, 12, 31) );

        timeAccount.deposit(1000);
        timeAccount.moveToTime(200);

        assertTrue( timeAccount.moveToNormal( new CalDate(2020, 12, 31 ) ) );

        assertEquals("None(0000) :Normal(1000) Time(0)", timeAccount.toString() );
    }

    @Test
    public void 期限後に定期預金の引き出し() {
        TimeAccount timeAccount = new TimeAccount( "None", "0000", new CalDate(2020, 12, 31) );

        timeAccount.deposit(1000);
        timeAccount.moveToTime(200);

        assertTrue( timeAccount.moveToNormal( new CalDate(2021, 1, 1 ) ) );

        assertEquals("None(0000) :Normal(1000) Time(0)", timeAccount.toString() );
    }
}
