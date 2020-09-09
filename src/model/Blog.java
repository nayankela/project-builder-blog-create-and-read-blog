package model;

import java.sql.Date;
import java.time.LocalDate;

public class Blog {

	private int blogId;
	private String blogTitle;
	private String blogDescription;
	private Date postedOn;

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog(int blogId, String blogTitle, String blogDescription, Date postedOn) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.postedOn = postedOn;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

}
