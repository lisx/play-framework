package framework.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import framework.base.PagerRS;
import framework.logs.LogUtil;

import play.db.DB;
import play.db.jpa.JPA;
import play.db.jpa.GenericModel.JPAQuery;

public class JPAUtil {
	private final static Logger logger = LogUtil.getInstance(JPAUtil.class);
	
	public static void setAutoCommit(boolean autoCommit) {
		try {
			DB.getConnection().setAutoCommit(autoCommit);
		} catch (SQLException e) {
			logger.error("setAutoCommit error!", e);
		}
	}
	//事务开始
	public static void begin() {
		JPA.em().getTransaction().begin();
	}
	
	//事务提交
	public static void commit() {
		JPA.em().getTransaction().commit();
	}
	
	//事务回滚
	public static void rollback() {
		JPA.em().getTransaction().rollback();
	}
}
