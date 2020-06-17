package cn.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.pojo.Food;
import cn.pojo.Search;




public class FoodDao extends BaseDao {
	private File file;
    private String fileContentType;
    private String fileFileName;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<Food> getAllFood() {
        Connection conn = this.getConn();
        ResultSet rs = null;		       
        String sql = "select * from food";
        List<Food> list = new ArrayList<Food>();
        try {
       	    Statement statement = conn.createStatement();		       
            rs = statement.executeQuery(sql);
           while (rs.next()) {
               Food food = new Food();
               food.setFoodNumber(rs.getString(1));
               food.setFoodName(rs.getString(2));
               food.setFoodPurchasePrice(rs.getString(3));
               food.setFoodSellingprice(rs.getString(4));
               food.setFoodPicture(rs.getString(5));
               list.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	   
	   public List<Food> getFood(String FoodNumber) {		 
		     Connection conn = this.getConn();
	         ResultSet rs = null;		       
	         String sql = "select * from food where FoodNumber=?";
	         List<Food> list = new ArrayList<Food>();
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,FoodNumber);
				 rs = pstmt.executeQuery();
				while (rs.next()) {
	                 Food food = new Food();
	                 food.setFoodNumber(rs.getString(1));
	                 food.setFoodName(rs.getString(2));
	                 food.setFoodPurchasePrice(rs.getString(3));
	                 food.setFoodSellingprice(rs.getString(4));
	                 food.setFoodPicture(rs.getString(5));
	                 list.add(food);
	             }
								
			}catch (SQLException e) {
				e.printStackTrace();
			}
	         return list;
	     }
	   
		
		
		public boolean delete(String FoodNumber){
			boolean flag = false;
			conn = this.getConn();
			String sql = "delete from food where FoodNumber=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, FoodNumber);
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
		
		public boolean add(Food food){	        
			boolean flag = false;		
			conn = this.getConn();
			String sql = "insert into food(FoodNumber,FoodName,FoodPurchasePrice,FoodSellingprice,FoodPicture) values (?,?,?,?,?)";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,food.getFoodNumber());
				pstmt.setString(2,food.getFoodName());
				pstmt.setString(3,food.getFoodPurchasePrice());
				pstmt.setString(4,food.getFoodSellingprice());
				pstmt.setString(5,food.getFoodPicture());			
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
		
		public boolean modify(Food food){
			boolean flag = false;
			conn = this.getConn();
			String sql = "update food set FoodName=?,FoodPurchasePrice=?,FoodSellingprice=?,FoodPicture=? where FoodNumber=?";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,food.getFoodName());
				pstmt.setString(2,food.getFoodPurchasePrice());
				pstmt.setString(3,food.getFoodSellingprice());
				pstmt.setString(4,food.getFoodPicture());
				pstmt.setString(5,food.getFoodNumber());	
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
		
		public Food selectByName(String FoodNumber){
			Food food = null;
	        String sql = "select * from food where FoodName =?";
			Connection conn = this.getConn();
			 List<Food> list = new ArrayList<Food>();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, FoodNumber);
				ResultSet rs = pstmt.executeQuery();
				if(rs != null && rs.next()){
					food = new Food();
					food.setFoodNumber(rs.getString(1));
	                food.setFoodName(rs.getString(2));
	                food.setFoodPurchasePrice(rs.getString(3));
	                food.setFoodSellingprice(rs.getString(4));
	                food.setFoodPicture(rs.getString(5));
	                list.add(food);
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
			return food;
}
		
		public List<Food> search(Search search) {
			 String sql = null;
			 String FoodNumber = "商品编号";
			 String FoodName = "商品名称";
			 
			
			 List<Food> list = new ArrayList<Food>();
			 Connection conn = this.getConn();
			 if (search.getSearchType().compareTo(FoodNumber) == 0) {  
				 sql = "select * from food where FoodNumber like '%"    
			           + search.getInputSearchInfo()     
			           + "%' ";  
				 } else if (search.getSearchType().compareTo(FoodName) == 0) { 
				 sql = "select * from food where FoodName like '%"     
				        + search.getInputSearchInfo()    
				        + "%' ";  
				 } 
				   else if (search.getSearchType() == null) { 
					   sql = "select * from food ";  
					}
			 if (sql != null) {
				   try {
					   PreparedStatement pstmt = conn.prepareStatement(sql);
					   ResultSet rs = pstmt.executeQuery();
				    while (rs.next()) {
				    	 Food food = new Food();
		                 food.setFoodNumber(rs.getString(1));
		                 food.setFoodName(rs.getString(2));
		                 food.setFoodPurchasePrice(rs.getString(3));
		                 food.setFoodSellingprice(rs.getString(4));
		                 food.setFoodPicture(rs.getString(5));
		                 list.add(food);
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
