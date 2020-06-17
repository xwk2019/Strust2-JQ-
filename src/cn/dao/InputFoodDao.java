package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.pojo.InputFood;
import cn.pojo.Search;




public class InputFoodDao extends BaseDao {
	
	public List<InputFood> getAllInputFood() {
        Connection conn = this.getConn();
        ResultSet rs = null;		       
        String sql = "select * from inputfood";
        List<InputFood> list = new ArrayList<InputFood>();
        try {
       	    Statement statement = conn.createStatement();		       
            rs = statement.executeQuery(sql);
           while (rs.next()) {
        	   InputFood inputFood = new InputFood();
        	   inputFood.setFoodEntryNum(rs.getString(1));
        	   inputFood.setFoodNumber(rs.getString(2));
        	   inputFood.setFoodName(rs.getString(3));
        	   inputFood.setFoodPurchasePrice(rs.getString(4));
        	   inputFood.setInNumber(rs.getString(5));
        	   inputFood.setCost(rs.getString(6));
        	   inputFood.setSupplier(rs.getString(7));
        	   inputFood.setAllTotal(rs.getString(8));
        	   inputFood.setInDate(rs.getString(9));
               list.add(inputFood);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	   
	   public List<InputFood> getInputFood(String FoodNumber) {		 
		     Connection conn = this.getConn();
	         ResultSet rs = null;		       
	         String sql = "select * from inputfood where FoodNumber=?";
	         List<InputFood> list = new ArrayList<InputFood>();
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,FoodNumber);
				 rs = pstmt.executeQuery();
				while (rs.next()) {
		        	   InputFood inputFood = new InputFood();
		        	   inputFood.setFoodEntryNum(rs.getString(1));
		        	   inputFood.setFoodNumber(rs.getString(2));
		        	   inputFood.setFoodName(rs.getString(3));
		        	   inputFood.setFoodPurchasePrice(rs.getString(4));
		        	   inputFood.setInNumber(rs.getString(5));
		        	   inputFood.setCost(rs.getString(6));
		        	   inputFood.setSupplier(rs.getString(7));
		        	   inputFood.setAllTotal(rs.getString(8));
		        	   inputFood.setInDate(rs.getString(9));
		               list.add(inputFood);
	             }
								
			}catch (SQLException e) {
				e.printStackTrace();
			}
	         return list;
	     }
	   
		
		
		public boolean deleteInputFood(String FoodNumber){
			boolean flag = false;
			conn = this.getConn();
			String sql = "delete from inputfood where FoodNumber=?";
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
		
		public boolean addInputFood(InputFood inputFood){
			boolean flag = false;
			conn = this.getConn();
			String sql = "insert into inputfood(FoodEntryNum,FoodNumber,FoodName,FoodPurchasePrice,InNumber,Cost,Supplier,AllTotal,InDate) values (?,?,?,?,?,?,?,?,?)";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,inputFood.getFoodEntryNum());
				pstmt.setString(2,inputFood.getFoodNumber());
				pstmt.setString(3,inputFood.getFoodName());
				pstmt.setString(4,inputFood.getFoodPurchasePrice());
				pstmt.setString(5,inputFood.getInNumber());
				pstmt.setString(6,inputFood.getCost());
				pstmt.setString(7,inputFood.getSupplier());
				pstmt.setString(8,inputFood.getAllTotal());
				pstmt.setString(9,inputFood.getInDate());
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
		
		public boolean modifyInputFood(InputFood inputFood){
			boolean flag = false;
			PreparedStatement pstmt = this.getPstmt();		
			Connection conn = this.getConn();			
			String sql = "update inputfood set FoodNumber=?,FoodName=?,FoodPurchasePrice=?,InNumber=?,Cost=?,Supplier=?,AllTotal=?,InDate=? where FoodEntryNum=?";	
			PreparedStatement pstmt1 = this.getPstmt();	
			Connection conn1 = this.getConn();	
			String sql1 = "update food set FoodName=?,FoodPurchasePrice=? where FoodNumber=?";
			PreparedStatement pstmt2 = this.getPstmt();	
			Connection conn2 = this.getConn();	
			String sql2 = "update outputfood set FoodName=?,FoodPurchasePrice=?,AllTotal=? where FoodNumber=?";
			try{
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(9,inputFood.getFoodEntryNum());
				pstmt.setString(1,inputFood.getFoodNumber());
				pstmt.setString(2,inputFood.getFoodName());
				pstmt.setString(3,inputFood.getFoodPurchasePrice());
				pstmt.setString(4,inputFood.getInNumber());
				pstmt.setString(5,inputFood.getCost());
				pstmt.setString(6,inputFood.getSupplier());
				pstmt.setString(7,inputFood.getAllTotal());
				pstmt.setString(8,inputFood.getInDate());	
				
				pstmt1 = conn1.prepareStatement(sql1);
				pstmt1.setString(1,inputFood.getFoodName());
				pstmt1.setString(2,inputFood.getFoodPurchasePrice());
				pstmt1.setString(3,inputFood.getFoodNumber());
				
				pstmt2 = conn2.prepareStatement(sql2);
				pstmt2.setString(1,inputFood.getFoodName());
				pstmt2.setString(2,inputFood.getFoodPurchasePrice());
				pstmt2.setString(3,inputFood.getAllTotal());
				pstmt2.setString(4,inputFood.getFoodNumber());
				
				int num = pstmt.executeUpdate();
				int num1 = pstmt1.executeUpdate();
				int num2 = pstmt2.executeUpdate();
				
				if(num == 1&&num1 == 1&&num2 == 1)
					flag = true;
				if(pstmt != null&&pstmt1 != null&&num2 == 1){
					pstmt.close();
					pstmt1.close();
				}
				if(conn != null&&conn1 != null&&num2 == 1){
					conn.close();
					conn1.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return flag;
}
			
		public List<InputFood> searchInputFood(Search search) {
			 String sql = null;
			 String FoodNumber = "商品编号";
			 String FoodName = "商品名称";
			 
			
			 List<InputFood> list = new ArrayList<InputFood>();
			 Connection conn = this.getConn();
			 if (search.getSearchType().compareTo(FoodNumber) == 0) {  
				 sql = "select * from inputfood where FoodNumber like '%"    
			           + search.getInputSearchInfo()     
			           + "%' ";  
				 } else if (search.getSearchType().compareTo(FoodName) == 0) { 
				 sql = "select * from inputfood where FoodName like '%"     
				        + search.getInputSearchInfo()    
				        + "%' ";  
				 } 
				   else if (search.getSearchType() == null) { 
					   sql = "select * from inputfood ";  
					}
			 if (sql != null) {
				   try {
					   PreparedStatement pstmt = conn.prepareStatement(sql);
					   ResultSet rs = pstmt.executeQuery();
				    while (rs.next()) {
				    	 InputFood inputFood = new InputFood();
			        	   inputFood.setFoodEntryNum(rs.getString(1));
			        	   inputFood.setFoodNumber(rs.getString(2));
			        	   inputFood.setFoodName(rs.getString(3));
			        	   inputFood.setFoodPurchasePrice(rs.getString(4));
			        	   inputFood.setInNumber(rs.getString(5));
			        	   inputFood.setCost(rs.getString(6));
			        	   inputFood.setSupplier(rs.getString(7));
			        	   inputFood.setAllTotal(rs.getString(8));
			        	   inputFood.setInDate(rs.getString(9));
			               list.add(inputFood);
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
