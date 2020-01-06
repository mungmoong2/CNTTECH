package com.my.vo;

public class Search {

	private String selectType;
	private String startDate;
	private String endDate;
	private String searchType;
	private String search;
	private String salesType;
	private String detailsearchType;
	private String detailsearch;

	public Search() {
		super();
	}

	public Search(String selectType, String startDate, String endDate, String searchType, String search,
			String salesType, String detailsearchType, String detailsearch) {
		super();
		this.selectType = selectType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.searchType = searchType;
		this.search = search;
		this.salesType = salesType;
		this.detailsearchType = detailsearchType;
		this.detailsearch = detailsearch;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public String getDetailsearchType() {
		return detailsearchType;
	}

	public void setDetailsearchType(String detailsearchType) {
		this.detailsearchType = detailsearchType;
	}

	public String getDetailsearch() {
		return detailsearch;
	}

	public void setDetailsearch(String detailsearch) {
		this.detailsearch = detailsearch;
	}

	@Override
	public String toString() {
		return "Search [selectType=" + selectType + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", searchType=" + searchType + ", search=" + search + ", salesType=" + salesType
				+ ", detailsearchType=" + detailsearchType + ", detailsearch=" + detailsearch + "]";
	}
	
	

}