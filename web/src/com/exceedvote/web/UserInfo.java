package com.exceedvote.web;
/**
 * UserInfo is use for web indentify who login.
 * @author Kunat Pipatanakul
 * @version 2012.11.01
 */
public class UserInfo {
	int userid;
	int no_ballot;
	public UserInfo(int userid,int no_ballot) {
	this.userid = userid;
	this.no_ballot = no_ballot;
	}
	public int getUserid() {
		return userid;
	}
	public int getBallotCount(){
		return no_ballot;
	}
}
