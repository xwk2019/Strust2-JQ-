package cn.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.UserDao;
import cn.pojo.User;

public class JsonAction extends ActionSupport{
   
	private static final long serialVersionUID = 1L;
	private String userId;
     private String tip;
     private User user;
     
      public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String A(){
		try {
			UserDao userDao = new UserDao();
			User u = userDao.selectByName(userId);
			if(u == null){
				 tip = userId +"�˻���ע�ᣡ";
			 }else{
				 tip ="��ã�"+ userId +"����û��Ѿ����ڣ�";
			 }
		} catch (Exception e) {
			tip = e.getMessage();
		}
    	  
    	  return SUCCESS;
      }
	public String B(){
		try {
			UserDao userDao = new UserDao();
			User u = userDao.selectByName(userId);
			if(u == null){
				 tip = userId +"�˻�����ʹ�ã�";
			 }else{
				 tip ="��ã�"+ userId +"���½��";
			 }
		} catch (Exception e) {
			tip = e.getMessage();
		}
    	  
    	  return SUCCESS;
      }
}
