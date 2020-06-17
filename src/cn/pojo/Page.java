package cn.pojo;

import java.util.List;

public class Page {
	private List list;          //存放一页的记录
	private int currentPage;    //当前页
	private int pageSize;       //每一页的记录数
	private int pageTotalNum;   //总页数
	private int rowTotalNum;    //总记录数
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotalNum() {
		return pageTotalNum;
	}
	public void setPageTotalNum(int pageTotalNum) {
		this.pageTotalNum = pageTotalNum;
	}
	public int getRowTotalNum() {
		return rowTotalNum;
	}
	public void setRowTotalNum(int rowTotalNum) {
		this.rowTotalNum = rowTotalNum;
	}
	
	public int countPageTotalNum(int rowTotalNum,int pageSize){
	  return pageTotalNum=((rowTotalNum-1+pageSize)/pageSize);
	 }
	public int countFrom(int pageNo,int pageSize){   //计算一页开始记录数
		  return (pageNo-1)*pageSize;
     }

	 public int countTo(int pageNo,int rowTotalNum,int pageSize){   //计算一页终止记录数
	      if(pageNo != pageTotalNum)
	    {
		  return pageNo*pageSize;
	    }else{
	      return rowTotalNum;
	    }  
	  }
	 public int countCurrentPage(int pageNo){
		  if(pageNo<1)     //如果当前页面数小于1，则设当前页面数为1
		  {        
		   pageNo = 1;
		  }
		   if(pageNo>pageTotalNum)   //如果当前页面数大于总页面数，则设当前页面数为总页面数
		  {
		   pageNo = pageTotalNum;
		  }
		   return pageNo;
		 }
}
