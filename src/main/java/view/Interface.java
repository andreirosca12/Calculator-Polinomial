package view;

import javax.swing.*;

public class Interface {
    private JPanel principal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel Numar1;
    private JLabel Rezultat;
    private JLabel Numar2;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton impartireButton;
    private JButton integrareButton;
    private JButton derivareButton;

    public Interface(){
        JFrame frame = new JFrame("Calculator de Polinoame");
        frame.setContentPane(principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    public JButton getButonAdunare(){
        return adunareButton;
    };
    public JButton getButonScadere(){
        return scadereButton;
    };
    public JButton getButonInmultire(){
        return inmultireButton;
    };
    public JButton getButonImpartire(){
        return impartireButton;
    };
    public JButton getButonDerivare(){
        return derivareButton;
    };
    public JButton getButonIntegrare(){
        return integrareButton;
    };
    public JTextField tf3(){
        return textField3;
    };
    public JTextField tf2(){
        return textField2;
    };
    public JTextField tf1(){
        return textField1;
    };

}
