package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import cn.pojo.OutputFood;
import cn.pojo.Search;




public class OutputFoodDao extends BaseDao {
	
	public List<OutputFood> getAllOutputFood() {
        Connection conn = this.getConn();
        ResultSet rs = null;		       
        String sql = "select * from outputfood";
        List<OutputFood> list = new ArrayList<OutputFood>();
        try {
       	    Statement statement = conn.createStatement();		       
            rs = statement.executeQuery(sql);
           while (rs.next()) {
        	   OutputFood outputFood = new OutputFood();
        	   outputFood.setFoodEntryNum(rs.getString(1));
        	   outputFood.setFoodNumber(rs.getString(2));
        	   outputFood.setFoodName(rs.getString(3));
        	   outputFood.setFoodPurchasePrice(rs.getString(4));
        	   outputFood.setFoodSellingprice(rs.getString(5));
        	   outputFood.setOutNumber(rs.getString(6));
        	   outputFood.setProfit(rs.getString(7));
        	   outputFood.setCustomer(rs.getString(8));
        	   outputFood.setAllTotal(rs.getString(9));
        	   outputFood.setOutDate(rs.getString(10));
               list.add(outputFood);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	   
	   public List<OutputFood> getOutputFood(String FoodNumber) {		 
		     Connection conn = this.getConn();
	         ResultSet rs = null;		       
	         String sql = "select * from outputfood where FoodNumber=?";
	         List<OutputFood> list = new ArrayList<OutputFood>();
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,FoodNumber);
				 rs = pstmt.executeQuery();
				while (rs.next()) {
					   OutputFood outputFood = new OutputFood();
		        	   outputFood.setFoodEntryNum(rs.getString(1));
		        	   outputFood.setFoodNumber(rs.getString(2));
		        	   outputFood.setFoodName(rs.getString(3));
		        	   outputFood.setFoodPurchasePrice(rs.getString(4));
		        	   outputFood.setFoodSellingprice(rs.getString(5));
		        	   outputFood.setOutNumber(rs.getString(6));
		        	   outputFood.setProfit(rs.getString(7));
		        	   outputFood.setCustomer(rs.getString(8));
		        	   outputFood.setAllTotal(rs.getString(9));
		        	   outputFood.setOutDate(rs.getString(10));
		               list.add(outputFood);
	             }
								
			}catch (SQLException e) {
				e.printStackTrace();
			}
	         return list;
	     }
	   
		
		
		public boolean deleteOutputFood(String FoodNumber){
			boolean flag = false;
			conn = this.getConn();
			String sql = "delete from outputfood where FoodNumber=?";
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
		
		public boolean addOutputFood(OutputFood outputFood){
			boolean flag = false;
			conn = this.getConn();
			String sql = "insert into outputfood(FoodEntryNum,FoodNumber,FoodName,FoodPurchasePrice,FoodSellingprice,OutNumber,Profit,Customer,AllTotal,OutDate) values (?,?,?,?,?,?,?,?,?,?)";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,outputFood.getFoodEntryNum());
				pstmt.setString(2,outputFood.getFoodNumber());
				pstmt.setString(3,outputFood.getFoodName());
				pstmt.setString(4,outputFood.getFoodPurchasePrice());
				pstmt.setString(5,outputFood.getFoodSellingprice());
				pstmt.setString(6,outputFood.getOutNumber());
				pstmt.setString(7,outputFood.getProfit());
				pstmt.setString(8,outputFood.getCustomer());
				pstmt.setString(9,outputFood.getAllTotal());
				pstmt.setString(10,outputFood.getOutDate());
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
		
		public boolean modifyOutputFood(OutputFood outputFood){
			boolean flag = false;
			PreparedStatement pstmt = this.getPstmt();		
			Connection conn = this.getConn();			
			String sql = "update outputfood set FoodEntryNum=?,FoodName=?,FoodPurchasePrice=?,FoodSellingprice=?,OutNumber=?,Profit=?,Customer=?,AllTotal=?,OutDate=? where FoodNumber=?";	
			PreparedStatement pstmt1 = this.getPstmt();	
			Connection conn1 = this.getConn();	
			String sql1 = "update food set FoodName=?,FoodPurchasePrice=?,FoodSellingprice=? where FoodNumber=?";
			PreparedStatement pstmt2 = this.getPstmt();	
			Connection conn2 = this.getConn();	
			String sql2 = "update inputfood set FoodName=?,FoodPurchasePrice=?,AllTotal=? where FoodNumber=?";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,outputFood.getFoodEntryNum());			
				pstmt.setString(2,outputFood.getFoodName());
				pstmt.setString(3,outputFood.getFoodPurchasePrice());
				pstmt.setString(4,outputFood.getFoodSellingprice());
				pstmt.setString(5,outputFood.getOutNumber());
				pstmt.setString(6,outputFood.getProfit());
				pstmt.setString(7,outputFood.getCustomer());
				pstmt.setString(8,outputFood.getAllTotal());
				pstmt.setString(9,outputFood.getOutDate());	
				pstmt.setString(10,outputFood.getFoodNumber());
				
				
				pstmt1 = conn1.prepareStatement(sql1);
				pstmt1.setString(1,outputFood.getFoodName());
				pstmt1.setString(2,outputFood.getFoodPurchasePrice());
				pstmt1.setString(3,outputFood.getFoodSellingprice());
				pstmt1.setString(4,outputFood.getFoodNumber());
				
				
				pstmt2 = conn2.prepareStatement(sql2);
				pstmt2.setString(1,outputFood.getFoodName());
				pstmt2.setString(2,outputFood.getFoodPurchasePrice());
				pstmt2.setString(3,outputFood.getAllTotal());
				pstmt2.setString(4,outputFood.getFoodNumber());
				
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
			
		public List<OutputFood> searchOutputFood(Search search) {
			 String sql = null;
			 String FoodNumber = "商品编号";
			 String FoodName = "商品名称";
			 
			
			 List<OutputFood> list = new ArrayList<OutputFood>();
			 Connection conn = this.getConn();
			 if (search.getSearchType().compareTo(FoodNumber) == 0) {  
				 sql = "select * from outputfood where FoodNumber like '%"    
			           + search.getInputSearchInfo()     
			           + "%' ";  
				 } else if (search.getSearchType().compareTo(FoodName) == 0) { 
				 sql = "select * from outputfood where FoodName like '%"     
				        + search.getInputSearchInfo()    
				        + "%' ";  
				 } 
				   else if (search.getSearchType() == null) { 
					   sql = "select * from outputfood ";  
					}
			 if (sql != null) {
				   try {
					   PreparedStatement pstmt = conn.prepareStatement(sql);
					   ResultSet rs = pstmt.executeQuery();
				    while (rs.next()) {
				    	   OutputFood outputFood = new OutputFood();
			        	   outputFood.setFoodEntryNum(rs.getString(1));
			        	   outputFood.setFoodNumber(rs.getString(2));
			        	   outputFood.setFoodName(rs.getString(3));
			        	   outputFood.setFoodPurchasePrice(rs.getString(4));
			        	   outputFood.setFoodSellingprice(rs.getString(5));
			        	   outputFood.setOutNumber(rs.getString(6));
			        	   outputFood.setProfit(rs.getString(7));
			        	   outputFood.setCustomer(rs.getString(8));
			        	   outputFood.setAllTotal(rs.getString(9));
			        	   outputFood.setOutDate(rs.getString(10));
			               list.add(outputFood);
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
