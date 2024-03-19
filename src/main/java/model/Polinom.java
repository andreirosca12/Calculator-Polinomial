package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private HashMap<Integer, Monom> monomi;
    public Polinom(){
        monomi=new HashMap<Integer, Monom>();
    }
    public Polinom (String s){
        monomi=new HashMap<Integer, Monom>();
        if(s=="")
        {
            this.addMonom(new Monom(0,0));
            return;
        }
        String model = "([-+]?\\d+)\\*x\\^(\\d+)";
        Pattern pattern=Pattern.compile(model);
        Matcher match=pattern.matcher(s);
        while (match.find()) {
            double coefficient = Double.parseDouble(match.group(1));
            int power = Integer.parseInt(match.group(2));
            this.addMonom(new Monom(coefficient, power));
        }
        if(this.monomi.isEmpty())
            JOptionPane.showMessageDialog(null,"Numerele introduse nu sunt corecte!");
    }
    public void addMonom(Monom x)
    {
        this.monomi.put(x.getGrad(),x);
    }
    public Polinom adunare(Polinom x){
        Polinom y=new Polinom();
        for(Map.Entry<Integer, Monom> aux : this.monomi.entrySet())
        {
            int gradnou=aux.getKey();
            double coefnou=aux.getValue().getCoeficient();
            if(x.monomi.containsKey(gradnou))
               coefnou+=x.monomi.get(gradnou).getCoeficient();
            y.monomi.put(gradnou,new Monom(coefnou,gradnou));
        }
        for(Map.Entry<Integer, Monom> aux : x.monomi.entrySet())
        {
            int cheie=aux.getKey();
            if(!y.monomi.containsKey(cheie)) {
                y.monomi.put(cheie, new Monom(aux.getValue().getCoeficient(),cheie));
            }
        }
        return y;
    }
    public Polinom scadere(Polinom x){
        Polinom y=new Polinom();
        for(Map.Entry<Integer, Monom> aux : this.monomi.entrySet())
        {
            int gradnou=aux.getKey();
            double coefnou=aux.getValue().getCoeficient();
            if(x.monomi.containsKey(gradnou))
                coefnou-=x.monomi.get(gradnou).getCoeficient();
            y.monomi.put(gradnou,new Monom(coefnou,gradnou));
        }
        for(Map.Entry<Integer, Monom> aux : x.monomi.entrySet())
        {
            int cheie=aux.getKey();
            if(!y.monomi.containsKey(cheie)) {
                y.monomi.put(cheie, new Monom((-1)*aux.getValue().getCoeficient(),cheie));
            }
        }
        Iterator<Map.Entry<Integer, Monom>> it = y.monomi.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Monom> entry = it.next();
            if(entry.getValue().getCoeficient()==0)
                it.remove();
        }
        return y;
    }
    public Polinom inmultire(Polinom x){
        Polinom y=new Polinom();
        for(Map.Entry<Integer, Monom> aux : this.monomi.entrySet())
        {
            Polinom y2=new Polinom();
            for(Map.Entry<Integer, Monom> aux2 : x.monomi.entrySet())
            {
                int gradnou= aux.getKey()+aux2.getKey();
                double coefnou=aux.getValue().getCoeficient()*aux2.getValue().getCoeficient();
                y2.monomi.put(gradnou,new Monom(coefnou,gradnou));
            }
            y=y.adunare(y2);
        }
        return y;
    }
    public ArrayList<Polinom> impartire(Polinom x){
        ArrayList<Polinom> rezu=new ArrayList<Polinom>();
        Polinom cat=new Polinom();
        Polinom rest=new Polinom();
        rest.monomi=this.monomi;
        Polinom copie=new Polinom();
        copie.monomi=x.monomi;
        if(Collections.max(x.monomi.keySet())==0 && x.monomi.get(0).getCoeficient()==0)
            JOptionPane.showMessageDialog(null,"Impartire cu 0 nu este permisa!");
        if(Collections.max(rest.monomi.keySet()) >= Collections.max(copie.monomi.keySet())){
            while(!rest.monomi.isEmpty() &&Collections.max(rest.monomi.keySet()) >= Collections.max(copie.monomi.keySet())){
                int gradx = Collections.max(copie.monomi.keySet());
                int gradthis = Collections.max(rest.monomi.keySet());
                double coeficient=rest.monomi.get(gradthis).getCoeficient() / copie.monomi.get(gradx).getCoeficient();//impartim cel mai mare monom din fiecare polinom
                Monom mo1=new Monom(coeficient,gradthis-gradx);
                cat.addMonom(mo1);
                Polinom aux=new Polinom();
                aux.addMonom(mo1);
                aux=aux.inmultire(copie);
                rest=rest.scadere(aux);
            }
            rezu.add(cat);
            rezu.add(rest);
            return rezu;
        }
        else {
            rezu.add(new Polinom(""));
            rezu.add(copie);
            return rezu;
        }
    }
    public Polinom derivare(){
        Polinom der=new Polinom();
    for(Map.Entry<Integer, Monom> aux : this.monomi.entrySet())
        {
            Monom nou= new Monom(aux.getValue().getCoeficient()* aux.getKey(), aux.getKey()-1);
            der.addMonom(nou);
        }
        return der;
    }
    public Polinom integrare(){
        Polinom der=new Polinom();
        for(Map.Entry<Integer, Monom> aux : this.monomi.entrySet())
        {
            Monom nou= new Monom((double)aux.getValue().getCoeficient()/(aux.getKey()+1), aux.getKey()+1);
            der.addMonom(nou);
        }
        return der;
    }
    @Override
    public String toString() {
        String s="";
        for(Map.Entry<Integer, Monom> aux : this.monomi.entrySet())
        {
            s+=aux.getValue();
        }
        if(s.isEmpty())
            return "  0";
        if(s.charAt(0) == ' ')
            s=s.substring(1);
        if(s.charAt(0) == '+')
            s=s.substring(1);
        return s;
    }
}
