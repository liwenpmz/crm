package com.briup.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Chance implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	//主键由数据库自动增长并从数据库初始值开始增长
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String source;
	
	private String customer;
	
	private String rate;
	
	private String title;
	
	private String address;
	
	private String linkman;
	
	private Integer phone;
	
	@JoinColumn(name="creator_id" ,referencedColumnName="id",unique = true)  
    @ManyToOne
	@JsonIgnore	
	//创建者   当前user 所指主管
	private User creator;
	@JoinColumn(name="handler_id",referencedColumnName="id",unique = true) 
	@ManyToOne
	@JsonIgnore	
	//执行者  当前user 所指部门经理
	private User handler;
	
	private String description;
	
	private String status;

	//@OneToMany(mappedBy = "plan",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	//private List<Plan> plans;
	 
	public Chance() {
	} 

	public Chance(Integer id, String source, String customer, String rate, String title, String address, String linkman,
			Integer phone, User creator, User handler, String description) {
		this.id = id;
		this.source = source;
		this.customer = customer;
		this.rate = rate;
		this.title = title;
		this.address = address;
		this.linkman = linkman;
		this.phone = phone;
		this.creator = creator;
		this.handler = handler;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getHandler() {
		return handler;
	}

	public void setHandler(User handler) {
		this.handler = handler;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Chance [id=" + id + ", source=" + source + ", customer=" + customer + ", rate=" + rate + ", title="
				+ title + ", address=" + address + ", linkman=" + linkman + ", phone=" + phone + ", creator=" + creator
				+ ", handler=" + handler + ", description=" + description + ", status=" + status + "]";
	}

	
}
