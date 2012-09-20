import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class PurseStatus extends JFrame{
	private JLabel unitLabel1;
	private JProgressBar bar;
	public PurseStatus(){
		initComponents();
		this.pack();
	}
	private void initComponents() {
		unitLabel1 = new JLabel("EMPTY");
		bar=new JProgressBar(0,10);
		Container contents = this.getContentPane();
		LayoutManager layout = new GridLayout(2, 1);
		contents.setLayout(layout);
		this.setTitle("Purse Ststus");
		contents.add(unitLabel1);
		contents.add(bar);
		
	}
	public void change(Purse purse){
		if(purse.isFull())unitLabel1.setText("FULL");
		else unitLabel1.setText(purse.count()+"");
		bar.setMaximum(purse.getCapacity());
		bar.setValue(purse.count());
		this.pack();
	}
}
