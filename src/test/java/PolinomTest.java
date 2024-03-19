import model.Polinom;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolinomTest {
    @Test
    public void testAdunare() {
        Polinom p1 = new Polinom("1*x^0");
        Polinom p2 = new Polinom("1*x^0");
        Polinom p3 = p1.adunare(p2);
        assertEquals("2*x^0", p3.toString());
    }
    @Test
    public void testScadere() {
        Polinom p1 = new Polinom("3*x^2+2*x^1");
        Polinom p2 = new Polinom("2*x^2+1*x^1");
        Polinom p3 = p1.scadere(p2);
        assertEquals("1*x^1+1*x^2", p3.toString());
    }
    @Test
    public void testInmultire() {
        Polinom p1 = new Polinom("3*x^2+2*x^1");
        Polinom p2 = new Polinom("2*x^2+1*x^1");
        Polinom p3 = p1.inmultire(p2);
        assertEquals("2*x^2+7*x^3+6*x^4", p3.toString());
    }
    @Test
    public void testImpartire() {
        Polinom p1 = new Polinom("3*x^2+2*x^1");
        Polinom p2 = new Polinom("2*x^2+1*x^1");
        ArrayList<Polinom> p3 = p1.impartire(p2);
        assertEquals("[1.50*x^0, 0.50*x^1]", p3.toString());
    }
    @Test
    public void testDerivare() {
        Polinom p1 = new Polinom("3*x^2+2*x^1+1");
        Polinom p2 = p1.derivare();
        assertEquals("2*x^0+6*x^1", p2.toString());
    }
    @Test
    public void testIntegrare() {
        Polinom p1 = new Polinom("3*x^2+2*x^1+1*x^0");
        Polinom p2 = p1.integrare();
        assertEquals("1*x^1+1*x^2+1*x^3", p2.toString());
    }
}
