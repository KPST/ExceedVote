package com.exceedvote.core;


public class ExceedJpaFactory implements IFactory{
	private static ExceedJpaFactory ef = new ExceedJpaFactory();
	private ExceedDAO ed;
	private ExceedJpaFactory(){
		ed = new JpaDAO();
	}
	public static ExceedJpaFactory getInstance(){
		return ef;
	}
	@Override
	public ExceedDAO getDAO() {
		return ed;
	}

}
