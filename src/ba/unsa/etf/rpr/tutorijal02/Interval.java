package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

     private double t1,t2;
     private boolean pripada1, pripada2;

     public Interval(double t1, double t2,boolean pripada1, boolean pripada2)throws IllegalArgumentException{
          setInterval(t1,t2,pripada1,pripada2);
     }
     public Interval(){
        this.t1=0;
        this.t2=0;
        this.pripada2=false;
        this.pripada1=false;
     }

    public void setInterval(double t1, double t2, boolean pripada1, boolean pripada2) throws IllegalArgumentException {
        if(t1>t2)
            throw new IllegalArgumentException("Greska");
         this.t2=t2;
         this.t1=t1;
         this.pripada1=pripada1;
         this.pripada2=pripada2;
    }
    public boolean isNull(){
         if(t1==0 && t2==0)
             return true;
         return false;
    }
    public boolean isIn(double t){
         if(t>t1 && t<t2)
             return true;
         if(t==t1 && pripada1)
             return true;
         else if(t==t1 && !pripada1)
             return false;
        if(t==t2 && pripada2)
            return true;
        else if(t==t2 && !pripada2)
            return false;


         return false;
    }
    public Interval intersect(Interval i){
        if(t1< i.t1 && t2<i.t2){
            if(i.pripada1 && pripada2) {
                Interval i1 = new Interval(i.t1, t2, true, true);
                return i1;
            }
            else if(i.pripada1 && !pripada2){
                Interval i1 = new Interval(i.t1, t2, true, false);
                return i1;
            }
            else if(!i.pripada1 && !pripada2){
                Interval i1 = new Interval(i.t1, t2, false, false);
                return i1;
            }
            else if(!i.pripada1 && pripada2){
                Interval i1 = new Interval(i.t1, t2, false, false);
                return i1;
            }

        }
        else if(t1> i.t1 && t2<i.t2){
            Interval i1=new Interval(t1,t2,pripada1,pripada2);
            return i1;

        }
        else if(t1<i.t1 && t2>i.t2) {
            Interval i1=new Interval(i.t1,i.t2,i.pripada1,i.pripada2);
            return i1;
        }
        return null;

    }
    public static Interval intersect(Interval i1, Interval i2) throws IllegalArgumentException{

         if(i1.t1< i2.t1 && i1.t2<i2.t2){
             if(i2.pripada1 && i1.pripada2) {
                 Interval i = new Interval(i2.t1, i1.t2, true, true);
                 return i;
             }
             else if(i2.pripada1 && !i1.pripada2){
                 Interval i = new Interval(i2.t1, i1.t2, true, false);
                 return i;
             }
             else if(!i2.pripada1 && !i1.pripada2){
                 Interval i = new Interval(i2.t1, i1.t2, false, false);
                 return i;
             }
             else if(!i2.pripada1 && i1.pripada2){
                 Interval i = new Interval(i2.t1, i1.t2, false, false);
                 return i;
             }

         }
         else if(i1.t1> i2.t1 && i1.t2<i2.t2){
             return i1;

         }
         else if(i1.t1<i2.t1 && i1.t2>i2.t2) {
             return i2;
         }
         return null;
    }
    @Override
    public String toString(){

         if(t1==0 && t2==0)
             return "()";

         if(pripada1 && pripada2)
             return "["+t1+","+t2+"]";
         else  if(pripada1 && !pripada2)
             return "["+t1+","+t2+")";
         else if(!pripada1 && pripada2)
            return "("+t1+","+t2+"]";
         return "("+t1+","+t2+")";

     }
    @Override
    public boolean equals(Object o){
         Interval i=(Interval) o;
         return t1==i.t1 && t2==i.t2 && pripada1==i.pripada1 && pripada2==i.pripada2;
    }
}
