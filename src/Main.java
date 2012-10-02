
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		UI ui = new UI();
		ClientController c = new ClientController(client,ui);
		c.run();
	}

}
