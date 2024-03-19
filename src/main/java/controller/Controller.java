package controller;
import view.Interface;
import model.Polinom;
import model.Monom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private  Interface view;
    private Polinom pol1;
    private Polinom pol2;

    public Controller(Interface view) {
        this.view = view;
        adunare();
        scadere();
        inmultire();
        impartire();
        integrare();
        derivare();
    }
    private void adunare() {
        view.getButonAdunare().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField p1=view.tf3();
                JTextField p2=view.tf1();
                pol1=new Polinom(p1.getText());
                pol2=new Polinom(p2.getText());
                Polinom x= pol1.adunare(pol2);
                JTextField rez=view.tf2();
                rez.setText(x+"");
            }
        });
    }

    private void scadere() {
        view.getButonScadere().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField p1=view.tf3();
                JTextField p2=view.tf1();
                pol1=new Polinom(p1.getText());
                pol2=new Polinom(p2.getText());
                Polinom x= pol1.scadere(pol2);
                JTextField rez=view.tf2();
                rez.setText(x+"");
            }
        });
    }
    private void inmultire() {
        view.getButonInmultire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField p1=view.tf3();
                JTextField p2=view.tf1();
                pol1=new Polinom(p1.getText());
                pol2=new Polinom(p2.getText());
                Polinom x= pol1.inmultire(pol2);
                JTextField rez=view.tf2();
                rez.setText(x+"");
            }
        });
    }
    private void impartire() {
        view.getButonImpartire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField p1=view.tf3();
                JTextField p2=view.tf1();
                pol1=new Polinom(p1.getText());
                pol2=new Polinom(p2.getText());
                ArrayList<Polinom> x=new ArrayList<Polinom>();
                try {
                    x=pol1.impartire(pol2);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                JTextField rez=view.tf2();
                rez.setText(x+"");
            }
        });
    }
    private void derivare() {
        view.getButonDerivare().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField p1=view.tf3();
                pol1=new Polinom(p1.getText());
                Polinom x= pol1.derivare();
                JTextField rez=view.tf2();
                rez.setText(x+"");
            }
        });
    }
    private void integrare() {
        view.getButonIntegrare().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField p1=view.tf3();
                pol1=new Polinom(p1.getText());
                Polinom x= pol1.integrare();
                JTextField rez=view.tf2();
                rez.setText(x+"");
            }
        });
    }
}
