package com.exceedvote.core;
/**
 * Statement
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 */
public class Statement {
	public String description = "";
	public Choice[] choice;
	/**
	 * Constructor
	 */
		public Statement() {
		}
		/**
		 * getDescription
		 * @return description
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * setDescription
		 * @param description description that come from database
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		
}
