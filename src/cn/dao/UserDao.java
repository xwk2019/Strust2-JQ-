package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.pojo.Search;
import cn.pojo.User;


public class UserDao extends BaseDao {
	public User login(String userId,String userPass,String role){
		User user = null;
		  String sql = "select * from user where userId =? and userPass =? and role =?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			pstmt.setString(3, role);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				user = new User();
				user.setUserId(rs.getString(1));
				user.setUserPass(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setPicture(rs.getString(5));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}	
		return user;
	}
	
	public boolean register(User user){
		boolean flag = false;
		conn = this.getConn();
		String sql = "insert into user(userId,userPass,email,role) values (?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserId());
			pstmt.setString(2,user.getUserPass());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getRole());
			int num = pstmt.executeUpdate();
			if(num == 1)
				flag = true;
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	 
	public User selectByName(String userId){
		User user = null;
        String sql = "select * from user where userId =?";
		Connection conn = this.getConn();
		 List<User> list = new ArrayList<User>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				user = new User();
				user = new User();
				user.setUserId(rs.getString(1));
				user.setUserPass(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setPicture(rs.getString(5));
				list.add(user);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}		
		return user;
}
	public User selectByrole(String userId,String role){
		User user = null;
        String sql = "select * from user where userId =? and role =?";
		Connection conn = this.getConn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, role);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				user = new User();
				user = new User();
				user.setUserId(rs.getString(1));
				user.setUserPass(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setPicture(rs.getString(5));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}	
		return user;	
       }
	
	  public List<User> getUser(String userId) {		 
		     Connection conn = this.getConn();
	         ResultSet rs = null;		       
	         String sql = "select * from user where userId=?";
	         List<User> list = new ArrayList<User>();
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,userId);
				 rs = pstmt.executeQuery();
				while (rs.next()) {
	                 User user = new User();
	             	user = new User();
					user.setUserId(rs.getString(1));
					user.setUserPass(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setRole(rs.getString(4));
					user.setPicture(rs.getString(5));
	                 list.add(user);
	             }
								
			}catch (SQLException e) {
				e.printStackTrace();
			}
	         return list;
	     }
	  
	  public boolean modify(User user){
			boolean flag = false;
			conn = this.getConn();   			
			String sql = "update user set userPass=?,email=?,picture=? where userId=?";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,user.getUserPass());
				pstmt.setString(2,user.getEmail());
				pstmt.setString(3,user.getPicture());
				pstmt.setString(4,user.getUserId());				
				int num = pstmt.executeUpdate();
				if(num == 1)
					flag = true;
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
      }
	  
	   public List<User> getUserInfo() {
	         Connection conn = this.getConn();
	         ResultSet rs = null;		       
	         String sql = "select * from user";
	         List<User> list = new ArrayList<User>();
	         try {
	        	 Statement statement = conn.createStatement();		       
	             rs = statement.executeQuery(sql);
	            while (rs.next()) {
	                User user = new User();
	            	user = new User();
					user.setUserId(rs.getString(1));
					user.setUserPass(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setRole(rs.getString(4));
					user.setPicture(rs.getString(5));
	                 list.add(user);

	             }
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	         return list;
	     }
	   
		public boolean delete(String userId){
			boolean flag = false;
			conn = this.getConn();
			String sql = "delete from user where userId=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				int num = pstmt.executeUpdate();
				if(num == 1)
					flag = true;
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		public boolean adduser(User user){
			boolean flag = false;
			conn = this.getConn();
			String sql = "insert into user(userId,userPass,email,role,picture) values (?,?,?,?,?)";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,user.getUserId());
				pstmt.setString(2,user.getUserPass());
				pstmt.setString(3,user.getEmail());
				pstmt.setString(4,user.getRole());
				pstmt.setString(5,user.getPicture());
				int num = pstmt.executeUpdate();
				if(num == 1)
					flag = true;
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
	   
		  public boolean usermodify(User user){
				boolean flag = false;
				conn = this.getConn();   			
				String sql = "update user set userPass=?,email=?,role=?,picture=? where userId=?";
				try{
					pstmt = conn.prepareStatement(sql);
/*					pstmt.setString(1,user.getUserPass());
					pstmt.setString(2,user.getUserName());
					pstmt.setString(3,user.getEmail());
					pstmt.setString(4,user.getUserId());
					pstmt.setString(5,user.getRole());*/
					pstmt.setString(1,user.getUserPass());
					pstmt.setString(2,user.getEmail());
					pstmt.setString(3,user.getRole());
					pstmt.setString(4,user.getPicture());
					pstmt.setString(5,user.getUserId());
					int num = pstmt.executeUpdate();
					if(num == 1)
						flag = true;
					if(pstmt != null)
						pstmt.close();
					if(conn != null)
						conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return flag;
	      }
		  
	   public List<User> searchUser(Search search) {
			 String sql = null;
			 String ZH = "’À∫≈";
			 String YHM = "–’√˚";
			 String EMAIL = "” œ‰";
			 
			
			 List<User> list = new ArrayList<User>();
			 Connection conn = this.getConn();
			 if (search.getSearchType().compareTo(ZH) == 0) {  
				 sql = "select * from user where userId like '%"    
			           + search.getInputSearchInfo()     
			           + "%' ";  
				 } else if (search.getSearchType().compareTo(YHM) == 0) { 
				 sql = "select * from user where userName like '%"     
				        + search.getInputSearchInfo()    
				        + "%' ";  
				 } else if (search.getSearchType().compareTo(EMAIL) == 0) { 
				 sql = "select * from user where email like '%"   
					    + search.getInputSearchInfo()    
					    + "%' ";  
				 }
				   else if (search.getSearchType() == null) { 
					   sql = "select * from user ";  
					}
			 if (sql != null) {
				   try {
					   PreparedStatement pstmt = conn.prepareStatement(sql);
					   ResultSet rs = pstmt.executeQuery();
				    while (rs.next()) {
				    	User user = new User();
				    	user = new User();
						user.setUserId(rs.getString(1));
						user.setUserPass(rs.getString(2));
						user.setEmail(rs.getString(3));
						user.setRole(rs.getString(4));
						user.setPicture(rs.getString(5));
						list.add(user);
				       }
				    }catch (SQLException e) {
				        e.printStackTrace();
				    } finally {
				    	this.closeAll();
				    	   }
			          return list;
			 }else{
				   return null;
				  }
				
		}
}
