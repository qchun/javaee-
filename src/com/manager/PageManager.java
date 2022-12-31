package com.manager;

public class PageManager {
	int pageNow;
	int pageSize;
	int totalPage;
	int totalSize;
	boolean hasFirst;
	boolean hasLast;
	boolean hasNext;
	boolean hasPre;
	public PageManager(int pageNow, int totalSize) {
		super();
		this.pageNow = pageNow;
		this.totalSize = totalSize;
	}
	public PageManager(int pageNow, int pageSize, int totalSize) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		totalPage=totalSize/pageSize;
		if(totalSize % pageSize==0){
			return totalPage;
		}else{
			return totalPage+1;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public boolean isHasFirst() {
		if(pageNow==1){
			return false;
		}else{
			return true;
		}
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	public boolean isHasLast() {
		if(pageNow>=getTotalPage()){
			return false;
		}else{
			return true;
		}
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	public boolean isHasNext() {
		if(pageNow>=getTotalPage()){
			return false;
		}else{
			return true;
		}
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasPre() {
		if(pageNow==1){
			return false;
		}else{
			return true;
		}
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
}
