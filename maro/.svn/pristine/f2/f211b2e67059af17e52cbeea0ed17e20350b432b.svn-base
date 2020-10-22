package com.maro.manager.common.entity;

public class ComboTree {
	private String id;
	private String pid;
	private String text;
	private String state;
	public ComboTree(){}
	public ComboTree(String id, String pid, String text, String state) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.state = state;
		if(this.state!=null&&this.state.equals("0")){
			this.state="open";
		}else{
			this.state="closed";
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
		if(this.state.equals("0")){
			this.state="open";
		}else{
			this.state="closed";
		}
	}
}
