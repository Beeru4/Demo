package com.beerus.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Bean
 * @author J.z
 *
 */
public class EdocEntry {
	private Integer id;
	private Integer categoryId;
	private String title;
	private String summary;
	private String uploaduser;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUploaduser() {
		return uploaduser;
	}
	public void setUploaduser(String uploaduser) {
		this.uploaduser = uploaduser;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	

}
