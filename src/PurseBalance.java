import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PurseBalance extends JFrame{
	private JLabel unitLabel1;
	public PurseBalance(){
		initComponents();
		this.pack();
	}
	private void initComponents() {
		unitLabel1 = new JLabel("0 Bath");
		Container contents = this.getContentPane();
		LayoutManager layout = new FlowLayout();
		contents.setLayout(layout);
		this.setTitle("Purse Ststus");
		contents.add(unitLabel1);
	}
	public void change(Purse purse){
		unitLabel1.setText(purse.getBalance()+" Bath");
		this.pack();
	}
}
