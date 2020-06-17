package cn.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.FoodDao;
import cn.pojo.Food;
import cn.pojo.Page;
import cn.pojo.Search;


@Results({@Result(name="input",location="/error.jsp")})
@Action(value="yanzen",results={@Result(name="success",location="/success.jsp")})
public class FoodAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Food food;
	private List<Food> userlist;
	private List<Page> userlist2;
	private String FoodNumber;
	private String message;
	private static int onlinecount;
	private String tip;
	private Search search;
	private Page page;
	private int pageNo=1;     //默认当前页为第一页
	private int pageSize=5;    //每页显示5条记录
	private String sRet;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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

	public List<Food> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<Food> userlist) {
		this.userlist = userlist;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
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

	
	public String saveFood(){
	    String target= ServletActionContext.getServletContext().getRealPath("img/food/"+fileFileName);
        File targetFile=new File(target);
        System.out.println(fileFileName);
        try {
            FileUtils.copyFile(file,targetFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        food.setFoodPicture("img/food/"+fileFileName);	
		
		FoodDao foodDao = new FoodDao();
		foodDao.modify(food);
		FoodDao foodDao1 = new FoodDao();
		userlist = foodDao1.getAllFood();
		
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
	
	public String addFood(){
		    String target= ServletActionContext.getServletContext().getRealPath("img/food/"+fileFileName);
	        File targetFile=new File(target);
	        System.out.println(fileFileName);
	        try {
	            FileUtils.copyFile(file,targetFile);
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	        food.setFoodPicture("img/food/"+fileFileName);	
	        
		FoodDao foodDao = new FoodDao();			
		foodDao.add(food);
		//userDao.adduser(user);
		FoodDao foodDao1 = new FoodDao();
		
		
        
		userlist = foodDao1.getAllFood();
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
		 HttpServletRequest request = ServletActionContext.getRequest();
		 request.setAttribute("tipMessage", "提交成功！");
		 
		return SUCCESS;
	}
	
	
	public String deleteFood(){
		FoodDao foodDao = new FoodDao();
		foodDao.delete(FoodNumber);
		FoodDao foodDao1 = new FoodDao();
		userlist = foodDao1.getAllFood();
		
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
	   // session.setAttribute("inputSearchInfo", search.getInputSearchInfo());
		return SUCCESS;
	}
	public String modifyFood(){
		FoodDao foodDao = new FoodDao();	
		userlist =foodDao.getFood(FoodNumber);
		return SUCCESS;
	}

	public String searchFood() throws Exception {
		    FoodDao fooddao = new FoodDao();
		    fooddao.search(search);

			userlist = fooddao.search(search);
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
	 public String add(){

		 return SUCCESS;
	 }

}
