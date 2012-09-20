import java.util.List;
import java.util.ArrayList;
/**
 * This is purse of coin.
 * 
 * @author Satjarporn Chindalikit
 * @version 2012.01.10
 */
public class Purse extends java.util.Observable
{
    /**
     * declare capacity of coin.
     * declare list of coin.
     */
    private int capacity;
    private List<Valuable> money;
    /**
     * Create a purse with a specified capacity.
     * @param capacity is maximum number of coins the purse can hold.
     */
    public  Purse(int capacity){
        this.capacity=capacity;
        money=new ArrayList<Valuable>();
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of money, not their value.
     * @return the number of money in the purse
     */
    public int count(){
        return money.size();
    }

    /**
     * send the summation value of all valuable. 
     */
    public int getBalance(){
        int sum=0;
        for(int i=0;i<money.size();i++) sum+=money.get(i).getValue();
        return sum;
    }

    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity(){
        return capacity;
    }

    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of money equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull(){
        if(money.size()==capacity) return true;
        else return false;
    }

    /** 
     *  Insert a valueable into the purse.
     *  The coin is only inserted if the purse has space for it.
     *  Don't allow inserting a valueable with a value <= 0 (fake coin).
     *  @param valuable is a valusble object to insert into purse
     *  @return true if valueble inserted, false if can't insert
     */
    public boolean insert(Valuable obj){
        if(isFull()||obj.getValue()<1) return false;
        else{
            money.add(obj);
            super.setChanged();
            super.notifyObservers(this);
            for(int i=0;i<money.size()-1;i++){
                for(int j=0;j<money.size()-i-1;j++){
                    if(money.get(j).compareTo(money.get(j+1))<0){
                        Valuable temp=money.get(j);
                        money.remove(j);
                        money.add(j+1,temp);
                    }
                }
            }
            return true;
        }
    }

    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of money withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valueable objects for money withdrawn, 
     *    or null if cannot withdraw.
     */
    public Valuable[] withdraw(int amout){
        List<Valuable> chose=dfs(null,0,0,amout);
        if(chose==null)return null;
        else{
            Valuable []out=new Valuable[chose.size()];
            for(int i=0;i<chose.size();i++)out[i]=chose.get(i);
            for(int i=0;i<chose.size();i++){
                int j;
                for(j=0;j<money.size();j++)
                    if(out[i].equals(money.get(j))){
                        money.remove(j);
                        break;
                }
            }
            super.setChanged();
            super.notifyObservers(this);
            return out;
        }
    }

    /** 
     * toString returns a string description of what is in the Purse.
     * It should return a count of each size coin that it contains,
     * such as: "3 10-Baht, 4 5-Baht, 1 1-Baht".
     * Use coin.equals and coin.toString to build up this string.
     * Don't assume that the only kinds of Coin are 10, 5, and 1.
     */
    public String toString(){
        StringBuilder s=new StringBuilder();
        boolean []iscount=new boolean[money.size()];
        int sum;
        int count=0;
        int i;
        boolean isfirst=true;
        for(;count<money.size();){
            for(i=0;iscount[i];i++);
            if(i==money.size())break;
            sum=0;
            for(int j=i;money.get(i).getValue()==money.get(j).getValue();j++){
                if(money.get(i).getClass()==money.get(j).getClass()){
                    sum++;
                    iscount[j]=true;
                    count++;
                }
                if(j==money.size()-1)break;
            }
            if(!(isfirst)){
                s.append(", ");
            }
            s.append(sum);
            s.append(" ");
            s.append(money.get(i).toString());
            isfirst=false;
        }
        return s.toString();
    }

    /**
     * chose the coin to withdraw.
     */
    private List<Valuable> dfs(List chose,int now,int nowvalue,int amout){
        List<Valuable> out;
        if(now==0) chose=new  ArrayList<Valuable>();
        for(int i=now;i<money.size();i++){
            if(nowvalue+money.get(i).getValue()==amout){
                chose.add(money.get(i));
                return chose;
            }
            else if(nowvalue+money.get(i).getValue()<amout){
                chose.add(money.get(i));
                out=dfs(chose,i+1,nowvalue+money.get(i).getValue(),amout);
                if(out!=null)return out;
                chose.remove(chose.size()-1);
            }
            else return null;
        }
        return null;
    }
    /*public void tesst(){
    for(int i=0;i<money.size();i++)System.out.printf(money.get(i).toString()+", ");
    System.out.printf("\n");
    }*/
}
