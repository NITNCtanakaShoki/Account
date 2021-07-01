import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    public void コンストラクタとgetter() {
        Account account = new Account("None", "0000");
        assertEquals( "None", account.getName() );
        assertEquals( "0000", account.getNo() );
        assertEquals( 0, account.getBalance() );
    }

    @Test
    public void 入金() {
        Account account = new Account("None", "0000");

        account.deposit(100);

        assertEquals( "None(0000) :100", account.toString() );
    }

    @Test
    public void 残高未満の出金() {
        Account account = new Account("None", "0000");

        account.deposit(100);

        assertTrue( account.withdraw(91) );

        assertEquals( "None(0000) :9", account.toString() );
    }

    @Test
    public void 残高分の出金() {
        Account account = new Account("None", "0000");

        account.deposit(21);

        assertTrue( account.withdraw(21) );

        assertEquals( "None(0000) :0", account.toString() );
    }

    @Test
    public void 残高オーバーの出金() {
        Account account = new Account("None", "0000");

        assertFalse( account.withdraw(1) );

        assertEquals( "None(0000) :0", account.toString() );
    }
}
