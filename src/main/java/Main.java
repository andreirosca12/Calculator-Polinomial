import model.Monom;
import model.Polinom;
import view.Interface;
import controller.Controller;
public class Main {
    public static void main(String[] args) {

        //Monom x0=new Monom(0,0);
        ///Monom x2=new Monom(0,2);

        //Monom x4=new Monom(1,2);
        //Monom x5=new Monom(2,2);
        //Polinom p1;
        //p1 = new Polinom("3**x^2");
        //p1.addMonom(x0);
        //p1.addMonom(x2);

        //Polinom p2=new Polinom();
        //p2.addMonom(x4);
        //p2.addMonom(x5);

        ///System.out.println(p1);
        ///System.out.println(p2);
        ///System.out.println(p1.scadere(p2));
        ///System.out.println(p1.adunare(p2));
        ///System.out.println(p1.inmultire(p2));
        try {
           /// System.out.println(p2.impartire(p1));
        }
        catch (Exception e) {
            ///System.out.println(e.getMessage());
        }
        ///System.out.println(p2.derivare());
        ///System.out.println(p2.integrare());
        Interface view = new Interface();
        Controller controller = new Controller(view);
    }
}