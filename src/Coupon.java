
/**
 * Write a description of class Coupon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coupon extends AbstractValuable
{
    /**
     * declare value of coupon.
     * declare color of coupon.
     */
    private int value;
    private String color;
    public Coupon(String color){
        this.color=color;
        if(color.toLowerCase().compareTo("red")==0)value=100;
        else if(color.toLowerCase().compareTo("bule")==0)value=50;
        else value=20;
    }
    /**
     * send a value of coupon.
     */
    public int getValue(){
        return value;
    }
    /**
     * send a color of coupon.
     */
    public String getColor(){
        return color;
    }
    /**
     * return true if obj is a object of coupon and same color as this coupon.
     */
    public boolean equals(Object obj){
        if(obj==null)return false;
        if(obj instanceof Coupon){
            if(((Coupon)obj).getColor().toLowerCase().compareTo(color.toLowerCase())==0) return true;
        }
        return false;
    }
    /**
     * send a string which decribing the coupon.
     */
    public String toString(){
        return color+" coupon";
    }
    public int compareTo(Valuable obj){
        return obj.getValue()-this.getValue();
    }
}