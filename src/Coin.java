
/**
 * This is a coin class
 * 
 * @author Satjarporn Chindalikit 
 * @version 2012.01.10
 */
public final class Coin extends AbstractValuable
{
    /**
     * declare value of coin
     */
    private int value;
    public Coin(int value){
        this.value=value;
    }
    /**
     * send a coin value.
     */
    public int getValue(){
        return value;
    }
    /**
     * check the input object is it the coin and is it same value.
     */
   /* public boolean equals(Object obj){
        if(obj!=null)
            if(obj instanceof Coin)
                if(this.value==((Coin)obj).getValue()) return true;
        return false;
    }*/
    /**
	 * Compare two coins by their value.
	 * @param other a Coin to compare to this one.
	 */
    /*public int compareTo(Valuable obj){
        return obj.getValue()-this.value;
    }*/
    /**
     * send a string which tell the value of coin.
     */
    public String toString(){
        return value+"-Bath coin";
    }
}
