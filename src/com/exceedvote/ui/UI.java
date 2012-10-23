package com.exceedvote.ui;
import java.util.Scanner;

/**
 * UI class.
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 *
 */
public class UI {
		Scanner sc;
		public UI() {
				// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		}
		/**
		 * update console ui
		 * @param p String that want to update
		 */
		public void update(String p){
			System.out.println(p);
		}
		/**
		 * get int Input from keyboard
		 * @return int of input
		 */
		public int getInput(){
			try{
			return Integer.parseInt(sc.nextLine());
			}catch(Exception e){
				System.out.print("Input is not integer");
				return -1;
			}
		}
		/**
		 * get String Input from keyboard
		 * @return String of input
		 */
		public String getString(){
			return sc.nextLine();
		}
}
