
/**
 * This is a banknote class.
 * 
 * Satjarporn Chindalikit
 * 2012/01/17
 */
public class Banknote extends AbstractValuable
{
    /**
     * declare value of banknote
     */
    private int value;
    private long serialNumber;
    static private long nextSerialNumber=1;
    public Banknote(int value){
        this.value=value;
        serialNumber=nextSerialNumber;
        nextSerialNumber++;
    }
    /**
     * send a banknote value.
     */
    public int getValue(){
        return value;
    }
    /**
     * send a banknote serialNumber.
     */
    public long getSerialNumber(){
        return serialNumber;
    }
    /**
     * check the input object is it the Bank and is it same value and same serialNumber.
     */
    public boolean equals(Object obj){
        if(obj!=null)
            if(obj instanceof Banknote)
                if(this.value==((Banknote)obj).getValue()) return true;
        return false;
    }
    /**
	 * Compare two banknotes by their value.
	 * @param other a banknote to compare to this one.
	 */
    public int compareTo(Valuable obj){
        return obj.getValue()-this.value;
    }
    /**
     * send a string which tell the value of banknote.
     */
    public String toString(){
        return value+"-Bath Banknote";
    }
}
