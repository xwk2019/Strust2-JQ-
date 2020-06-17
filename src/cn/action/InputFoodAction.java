package cn.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.InputFoodDao;
import cn.pojo.InputFood;
import cn.pojo.Page;
import cn.pojo.Search;

public class InputFoodAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private InputFood inputFood;
	private List<InputFood> userlist;
	private List<Page> userlist2;
	private String FoodNumber;
	private static int onlinecount;
	private String tip;
	private Search search;
	private Page page;
	private int pageNo=1;     //默认当前页为第一页
	private int pageSize=5;    //每页显示5条记录
	private String sRet;


	public String getsRet() {
		return sRet;
	}

	public void setsRet(String sRet) {
		this.sRet = sRet;
	}

	public static int getOnlinecount() {
		return onlinecount;
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
	
	public String getFoodNumber() {
		return FoodNumber;
	}

	public void setFoodNumber(String foodNumber) {
		FoodNumber = foodNumber;
	}

	
	public InputFood getInputFood() {
		return inputFood;
	}

	public void setInputFood(InputFood inputFood) {
		this.inputFood = inputFood;
	}

	public List<InputFood> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<InputFood> userlist) {
		this.userlist = userlist;
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

	
	public String saveInputFood(){
		
		InputFoodDao inputFoodDao = new InputFoodDao();
		inputFoodDao.modifyInputFood(inputFood);
		InputFoodDao inputFoodDao1 = new InputFoodDao();
		userlist = inputFoodDao1.getAllInputFood();
		
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
	    //session.setAttribute("searchType", search.getSearchType());
	    //session.setAttribute("inputSearchInfo", search.getInputSearchInfo());
		
		return SUCCESS;
	}
	
	public String addInputFood(){
		InputFoodDao inputFoodDao = new InputFoodDao();
		inputFoodDao.addInputFood(inputFood);
		InputFoodDao inputFoodDao1 = new InputFoodDao();
		userlist = inputFoodDao1.getAllInputFood();
		
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
	    //session.setAttribute("searchType", search.getSearchType());
	    //session.setAttribute("inputSearchInfo", search.getInputSearchInfo());		
		return SUCCESS;
	}
	
	
	public String deleteInputFood(){
		InputFoodDao inputFoodDao = new InputFoodDao();
		inputFoodDao.deleteInputFood(FoodNumber);
		InputFoodDao inputFoodDao1 = new InputFoodDao();
		userlist = inputFoodDao1.getAllInputFood();
		
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
	    //session.setAttribute("searchType", search.getSearchType());
	    //session.setAttribute("inputSearchInfo", search.getInputSearchInfo());
		return SUCCESS;
	}
	public String modifyInputFood(){
		InputFoodDao inputFoodDao = new InputFoodDao();
		userlist =inputFoodDao.getInputFood(FoodNumber);
		return SUCCESS;
	}

	public String searchInputFood() throws Exception {
		    InputFoodDao inputFoodDao = new InputFoodDao();
		    inputFoodDao.searchInputFood(search);
			userlist = inputFoodDao.searchInputFood(search);
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
	 public String addinputFood(){
		 return SUCCESS;
	 }
	 

}
