/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.vo;

/**
 * className:org.fengxl.lms.bean.BookType.java
 * author:��ɹ�
 * date:2013-2-26
 * description:
 */
public class BookType {
	private int id;	
	private String name;	//������
	private String remark;		//��ע˵��
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
