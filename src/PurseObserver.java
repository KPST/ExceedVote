import java.util.Observable;
import java.util.Observer;

public class PurseObserver implements Observer{
	private Purse purse;
	private PurseStatus ui;
	private PurseBalance ui2;
	public PurseObserver(Purse purse){
		this.purse=purse;
		ui=new PurseStatus();
		ui.setVisible(true);
		ui2=new PurseBalance();
		ui2.setVisible(true);
		
	}
	
	public void update(Observable o, Object obj) {
		ui.change(purse);
		ui2.change(purse);
		//System.out.println("Balance is: "+Balance);
	}
	
}