package com.exceedvote.core;

/**
 * JpaFactory is create JPA DAO.
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */
public class ExceedJpaFactory implements IFactory{
	private static ExceedJpaFactory ef = new ExceedJpaFactory();
	private ExceedDAO ed;
	private ExceedJpaFactory(){
		ed = new JpaDAO();
	}
	/**
	 * Singleton
	 * @return this object
	 */
	public static ExceedJpaFactory getInstance(){
		return ef;
	}

	/**
	 * get JPA DAO
	 * @return DAO
	 */
	public ExceedDAO getDAO() {
		return ed;
	}

}
