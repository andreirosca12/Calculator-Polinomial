package model;


public class Monom {
    private Number coeficient;
    private int grad;

    public Monom(double coeficient,int grad){
        this.coeficient= coeficient;
        this.grad=grad;
    }

    public Monom(int coeficient,int grad){
        this.coeficient= coeficient;
        this.grad=grad;
    }

    public double getCoeficient(){
        return this.coeficient.doubleValue();
    }

    public int getGrad(){
        return this.grad;
    }

    public String toString(){
        if (this.coeficient.doubleValue()==0)
            return "";
        if(this.coeficient.doubleValue()<0) {
            if (this.coeficient.doubleValue() - this.coeficient.intValue() < 0.01)
                return  this.coeficient.intValue() + "*x^" + this.grad;
            else
                return  String.format("%.2f", this.coeficient.doubleValue()) + "*x^" + this.grad;
        }
        else
            if(this.coeficient.doubleValue()-this.coeficient.intValue()<0.01)
            return "+"+this.coeficient.intValue()+"*x^"+this.grad;
                else
            return "+"+String.format("%.2f", this.coeficient.doubleValue())+"*x^"+this.grad;
    }
}
