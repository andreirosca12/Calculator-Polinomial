import model.Monom;
import model.Polinom;
import view.Interface;
import controller.Controller;
public class Main {
    public static void main(String[] args) {

        Interface view = new Interface();
        Controller controller = new Controller(view);
    }
}