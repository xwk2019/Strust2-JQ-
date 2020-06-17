package cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConn(){
		if(conn == null) this.getConnection();
		return conn;
	}

	public void getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jq?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String pwd = "123456";
			this.conn = DriverManager.getConnection(url, user, pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		try{
			this.stmt = this.conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void closeConn(){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeStmt(){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt != null){
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
