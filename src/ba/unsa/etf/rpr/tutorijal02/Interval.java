package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

     double t1,t2;
     boolean pripada1, pripada2;

     public Interval(double t1, double t2,boolean pripada1, boolean pripada2)throws IllegalArgumentException{
          setInterval(t1,t2,pripada1,pripada2);
     }
     public Interval(){
         this.t1=0;
         this.t2=0;
         this.pripada1=false;
         this.pripada2=false;
     }

    public void setInterval(double t1, double t2, boolean pripada1, boolean pripada2) throws IllegalArgumentException {
        if(t1>t2)
            throw IllegalArgumentException("Greska");
         this.t2=t2;
         this.t1=t1;
         this.pripada1=pripada1;
         this.pripada2=pripada2;
    }
    public static boolean isNull(){
         if(t1==0 && t2==0)
             return true;
         return false;
    }
    public static boolean isIn(double t){
         if(t>=t1 && t<=t2)
             return true;
         return false;
    }
    public  Interval intersect(Interval i){
         return i;
    }
    public static Interval intersect(Interval i1, Interval i2) throws IllegalArgumentException{
         Interval i=null;
         if(i1.t1< i2.t1 && i1.t2<i2.t2){
             i=setInterval(i2.t1, i1.t2, true, true);
             return intersect(i);
         }
         return i;
    }
}
