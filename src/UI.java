import java.util.Scanner;


public class UI {
		Scanner sc;
		public UI() {
				// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		}
		public void update(String p){
			System.out.println(p);
		}
		public int getInput(){
			return Integer.parseInt(sc.nextLine());
		}
}
