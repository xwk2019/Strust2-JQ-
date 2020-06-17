package cn.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

import cn.dao.UserDao;
import cn.pojo.Page;
import cn.pojo.Search;
import cn.pojo.User;



public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	private List<User> userlist;

	private List<Page> userlist2;
	private String userId;
	private static int onlinecount;
	private String tip;
	private Search search;
	private Page page;
	private int pageNo=1;     //默认当前页为第一页
	private int pageSize=5;  //每页显示5条记录
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

	public static int getOnlinecount() {
		return onlinecount;
	}

	public static void setOnlinecount(int onlinecount) {
		LoginAction.onlinecount = onlinecount;
	}

	private  int bar;
	
	public int getBar() {
		return bar;
	}

	public void setBar(int bar) {
		this.bar = bar;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

	public List<Page> getUserlist2() {
		return userlist2;
	}

	public void setUserlist2(List<Page> userlist2) {
		this.userlist2 = userlist2;
	}
	public String login() {	
		UserDao userDao = new UserDao();
		User u = userDao.login(user.getUserId(),user.getUserPass(),user.getRole());	
		UserDao userdao = new UserDao();
		userlist =userdao.getUser(user.getUserId());
		Map<String,Object> sessionmap = ServletActionContext.getContext().getSession();
		sessionmap.clear();
		if(u != null) {							
			sessionmap.put("user",user.getUserId());						
			if(user.getRole().equals("admin")){					
				sessionmap.put("role", user.getRole());
			}
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String register(){
		UserDao userDao = new UserDao();
		userDao.register(user);
		
		UserDao userdao1 = new UserDao();
		userlist =userdao1.getUser(user.getUserId());

		return SUCCESS;
	}
	
     public String saveUser(){
    	 String target= ServletActionContext.getServletContext().getRealPath("img/user/"+fileFileName);
         File targetFile=new File(target);
         System.out.println(fileFileName);
         try {
             FileUtils.copyFile(file,targetFile);
         }catch (IOException e){
             e.printStackTrace();
         }
         user.setPicture("img/user/"+fileFileName);	
    	 
		UserDao userDao = new UserDao();
		userDao.modify(user);
		UserDao userDao1 = new UserDao();
		userlist = userDao1.getUser(userId);	
		
		 HttpServletRequest request = ServletActionContext.getRequest();
		 request.setAttribute("tipMessage", "更改头像后要重新登陆才显示！");
		 
		return SUCCESS;
	}
     
 	public String usermodify(){
		UserDao userDao = new UserDao();	
		userlist =userDao.getUser(userId);
		return SUCCESS;
	}

	public String saveAllUser(){	
   	 String target= ServletActionContext.getServletContext().getRealPath("img/user/"+fileFileName);
     File targetFile=new File(target);
     System.out.println(fileFileName);
     try {
         FileUtils.copyFile(file,targetFile);
     }catch (IOException e){
         e.printStackTrace();
     }
     user.setPicture("img/user/"+fileFileName);	
		
		UserDao userDao = new UserDao();
		userDao.usermodify(user);
		UserDao userDao1 = new UserDao();
		userlist = userDao1.getUserInfo();
		
		Page page = new Page();
		int rowTotalNum = userlist.size();            
		int pageTotalNum = page.countPageTotalNum(rowTotalNum, pageSize);
		int currentPage = page.countCurrentPage(pageNo);     
		int from = page.countFrom(currentPage, pageSize);     
		int to = page.countTo(currentPage, rowTotalNum,pageSize);   
		userlist = userlist.subList(from, to);      
		page.setPageSize(pageSize); 
		page.setCurrentPage(currentPage);
		page.setRowTotalNum(rowTotalNum);
		page.setPageTotalNum(pageTotalNum);
		page.setList(userlist);              
		HttpSession session = ServletActionContext.getRequest().getSession();
		  //将数据用session保存
		session.setAttribute("page", page); 
	   // session.setAttribute("searchType", search.getSearchType());
	   // session.setAttribute("inputSearchInfo", search.getInputSearchInfo());
		
		return SUCCESS;
	}
	
	public String addUser(){
   	 String target= ServletActionContext.getServletContext().getRealPath("img/user/"+fileFileName);
     File targetFile=new File(target);
     System.out.println(fileFileName);
     try {
         FileUtils.copyFile(file,targetFile);
     }catch (IOException e){
         e.printStackTrace();
     }
     user.setPicture("img/user/"+fileFileName);	
		
		UserDao userDao = new UserDao();
		userDao.adduser(user);
		//userDao.adduser(user);
		UserDao userDao1 = new UserDao();
		userlist = userDao1.getUserInfo();
		Page page = new Page();
		int rowTotalNum = userlist.size();            
		int pageTotalNum = page.countPageTotalNum(rowTotalNum, pageSize);
		int currentPage = page.countCurrentPage(pageNo);     
		int from = page.countFrom(currentPage, pageSize);     
		int to = page.countTo(currentPage, rowTotalNum,pageSize);   
		userlist = userlist.subList(from, to);      
		page.setPageSize(pageSize); 
		page.setCurrentPage(currentPage);
		page.setRowTotalNum(rowTotalNum);
		page.setPageTotalNum(pageTotalNum);
		page.setList(userlist);              
		HttpSession session = ServletActionContext.getRequest().getSession();
		  //将数据用session保存
		session.setAttribute("page", page); 
	  //  session.setAttribute("searchType", search.getSearchType());
	  //  session.setAttribute("inputSearchInfo", search.getInputSearchInfo());		
		return SUCCESS;
	}
	

	
	public String delete(){
		UserDao userDao = new UserDao();
		userDao.delete(userId);
		
		UserDao userDao1 = new UserDao();
		userlist = userDao1.getUserInfo();
		Page page = new Page();
		int rowTotalNum = userlist.size();            
		int pageTotalNum = page.countPageTotalNum(rowTotalNum, pageSize);
		int currentPage = page.countCurrentPage(pageNo);     
		int from = page.countFrom(currentPage, pageSize);     
		int to = page.countTo(currentPage, rowTotalNum,pageSize);   
		userlist = userlist.subList(from, to);      
		page.setPageSize(pageSize); 
		page.setCurrentPage(currentPage);
		page.setRowTotalNum(rowTotalNum);
		page.setPageTotalNum(pageTotalNum);
		page.setList(userlist);              
		HttpSession session = ServletActionContext.getRequest().getSession();
		  //将数据用session保存
		session.setAttribute("page", page); 
	  //  session.setAttribute("searchType", search.getSearchType());
	  //  session.setAttribute("inputSearchInfo", search.getInputSearchInfo());
		return "list";
	}
	public String modify(){
		UserDao userDao = new UserDao();	
		userlist =userDao.getUser(userId);
		return SUCCESS;
	}
	public String adduser(){
		
		return SUCCESS;
	}
	
	public String search() throws Exception {
	    UserDao userDao = new UserDao();
		userDao.searchUser(search);
		userlist = userDao.searchUser(search);
		Page page = new Page();
		int rowTotalNum = userlist.size();            
		int pageTotalNum = page.countPageTotalNum(rowTotalNum, pageSize);
		int currentPage = page.countCurrentPage(pageNo);     
		int from = page.countFrom(currentPage, pageSize);     
		int to = page.countTo(currentPage, rowTotalNum,pageSize);   
		userlist = userlist.subList(from, to);      
		page.setPageSize(pageSize); 
		page.setCurrentPage(currentPage);
		page.setRowTotalNum(rowTotalNum);
		page.setPageTotalNum(pageTotalNum);
		page.setList(userlist);              
		HttpSession session = ServletActionContext.getRequest().getSession();
		  //将数据用session保存
		session.setAttribute("page", page); 
	    session.setAttribute("searchType", search.getSearchType());
	    session.setAttribute("inputSearchInfo", search.getInputSearchInfo());
		return SUCCESS;
	}
}
