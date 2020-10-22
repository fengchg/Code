/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.struts2.ServletActionContext;

/**
 * className:org.fengxl.lms.dao.LocaleDAO.java author:冯成果 date:2013-2-16
 * description:
 */
public class BaseDAO {

	private static BaseDAO dao;

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String pass = "pass";
	private String url = "jdbc:mysql://localhost:3306/lms?characterEncoding=utf8";

	public void beginConnection() throws ClassNotFoundException, SQLException{
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		}catch (SQLException e){
			ServletActionContext.getRequest().setAttribute("tip","数据库连接错误，请检查数据库用户名或者密码是否正确");
			throw e;
		}
	}
	
	public static BaseDAO getInstance() {
		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}

	public ResultSet doQuery(String sql) throws SQLException {
		stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}

	public int doUpdate(String sql) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		return result;
	}

	public void endRes() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
