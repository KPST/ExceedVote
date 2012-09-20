 
import java.util.Scanner;

/** 
 * User Interface for the Coin Purse. 
 */
public class ConsoleDialog {

    // create a java.util.Scanner object for use in all methods
    private static Scanner console = new Scanner( System.in );
	private static String currency = "Baht";
    
    private Purse purse;
    
    /** 
     * Initialize a new user interface.
	 * @param purse is the Purse to communicate with.
     */
    public ConsoleDialog(Purse purse) {
        this.purse = purse;
    }
    
    /** run the user interface */
    public void run() {

        while( true ) {
            //System.out.println("Purse contains "+purse.getBalance()+" "+currency);
            if ( purse.isFull() ) System.out.println("Purse is FULL.");

            // print a list of choices
            System.out.print("\nChose action (d, w, p, q):");
            String inline=console.nextLine();//Line().trim();
            Scanner scanline = new Scanner(inline);
            String choice = scanline.next();
            if ( choice.equalsIgnoreCase("d")|| choice.equalsIgnoreCase("D")){ 
                    
					depositDialog(scanline);
				}
            else if ( choice.equalsIgnoreCase("w")||choice.equalsIgnoreCase("W") ) 
					withdrawDialog(scanline);
			else if ( choice.equalsIgnoreCase("p")||choice.equalsIgnoreCase("P") )
					printDialog();
            else if ( choice.equalsIgnoreCase("q")||choice.equalsIgnoreCase("Q") ) 
					break; // leave the loop
            else 
					System.out.println( "\""+choice+"\" is not a valid choice.");
        }
        // confirm that we are quitting
        System.out.printf("Goodbye. The bank keeps %d %s\n", purse.getBalance(),currency);
    }

    /** 
	 *  Ask the user what coins to deposit, then deposit them.
     *  Show result of success or failure.
     */
    public void depositDialog(Scanner scanline) {
        //System.out.print("Enter the VALUE of coin(s) to deposit [eg: 5 5 1]: ");
        //String inline = console.nextLine();
        // parse the input line into numbers
        //Scanner scanline = new Scanner(inline);
        //scanline.next();
        while( scanline.hasNext() ) {
            if(scanline.hasNextInt()){
                int value = scanline.nextInt();
                if(value<=10){
                    Coin coin = new Coin(value);
                    System.out.printf("Deposit %d-%s coin... ", value, currency);
                    boolean ok = purse.insert(coin);
                    System.out.println( (ok? "ok" : "FAILED") );
                }
                else if(value>=20){
                    Banknote bank = new Banknote(value);
                    System.out.printf("Deposit %d-%s Banknote... ", value, currency);
                    boolean ok = purse.insert(bank);
                    System.out.println( (ok? "ok" : "FAILED") );
                }
                else System.out.printf("Invalid value: %d\n", value);
            }
            else{
                String s=scanline.next();
                Coupon cp=new Coupon(s);
                System.out.printf("Deposit %s coupon... ",s, currency);
                boolean ok = purse.insert(cp);
                System.out.println( (ok? "ok" : "FAILED") );
            }
        }
        if ( scanline.hasNext() )
            System.out.println("Invalid input: "+scanline.next() );
    }
    
    /** 
	 *  Ask how much money to withdraw and then do it.
     *  After withdraw, show the values of the coins we withdrew.
     */
    public void withdrawDialog(Scanner console) {
        //System.out.print("How much to withdraw? ");
        if (console.hasNext()) {

                int amount = console.nextInt( );
                Valuable [] coins = purse.withdraw(amount);
                if ( coins == null ) 
                    System.out.printf("Sorry, couldn't withdraw %d Baht\n", amount);
                else {
                    System.out.print("You withdrew:");
                    String space = " ";
                    for(int k=0; k<coins.length; k++) {
                    	System.out.print(space + coins[k].toString());
                    }
                    System.out.println();
                }
        }
        else System.out.printf("Invalid amount." );
        // discard remainder of the input line
        //console.nextLine();
    }

	/**
	 * print contents of purse.
	 */
	public void printDialog() {
		System.out.println( purse.toString() );
	}
    public static void main(String[] xxx){
    	Purse p=new Purse(10);
    	ConsoleDialog c=new ConsoleDialog(p);
    	PurseObserver po=new PurseObserver(p);
    	p.addObserver(po);
    	//po.setVisible(true);
    	c.run();
    }
}
