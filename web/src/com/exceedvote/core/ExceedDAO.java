package com.exceedvote.core;

import java.util.List;

import com.exceedvote.jpa.Auth;
import com.exceedvote.jpa.Ballot;
import com.exceedvote.jpa.Choice;
import com.exceedvote.jpa.Statement;

public interface ExceedDAO {
public Statement[] getStatement();
public Choice[] getChoice();
public Ballot findBallot(int id);
public List<Ballot> findBallots(int userid,int question,int flag);
public void deleteBallot(int id);
public void saveBallot(Ballot b);
public Auth findUser(String user,String pass);
public void saveUser(Auth a);
public void deleteUser(int id);
public void saveStatement(Statement s);
public void deleteStatement(int id);
public void saveChoice(Choice c);
public void deleteChoice(int id);
public Auth[] getAllUser();
}
