package cn.pojo;

import java.util.List;

public class Page {
	private List list;          //���һҳ�ļ�¼
	private int currentPage;    //��ǰҳ
	private int pageSize;       //ÿһҳ�ļ�¼��
	private int pageTotalNum;   //��ҳ��
	private int rowTotalNum;    //�ܼ�¼��
	
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
	public int countFrom(int pageNo,int pageSize){   //����һҳ��ʼ��¼��
		  return (pageNo-1)*pageSize;
     }

	 public int countTo(int pageNo,int rowTotalNum,int pageSize){   //����һҳ��ֹ��¼��
	      if(pageNo != pageTotalNum)
	    {
		  return pageNo*pageSize;
	    }else{
	      return rowTotalNum;
	    }  
	  }
	 public int countCurrentPage(int pageNo){
		  if(pageNo<1)     //�����ǰҳ����С��1�����赱ǰҳ����Ϊ1
		  {        
		   pageNo = 1;
		  }
		   if(pageNo>pageTotalNum)   //�����ǰҳ����������ҳ���������赱ǰҳ����Ϊ��ҳ����
		  {
		   pageNo = pageTotalNum;
		  }
		   return pageNo;
		 }
}
