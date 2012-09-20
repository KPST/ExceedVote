
/**
 * Abstract class AbstrctValuable - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractValuable implements Valuable
{
    public int compareTo(Valuable obj){
        return obj.getValue()-this.getValue();
    }
    /*public boolean equals(Object obj){
        if(obj!=null)
            if(obj instanceof this.Class())
                if(this.value==((this)obj).getValue()) return true;
        return false;*/
    }
