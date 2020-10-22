/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.vo;

/**
 * className:org.fengxl.lms.bean.UserExp.java
 * author:冯成果
 * date:2013-2-27
 * description:
 */
public class UserExp {

	private int id;
	private int userId;	//用户标识号
	private String realName; //真实姓名
	private String gender;	//性别
	private int age;	//年龄
	private String phoneNumber;	//手机号码
	private String address;	//住址
	private String email;	//邮箱
	private String code;	//身份证号码
	private String remark;		//备注说明
	public UserExp(){}
	/**
	 * @param userId
	 * @param gender
	 * @param age
	 * @param phoneNumber
	 * @param address
	 * @param email
	 * @param code
	 * @param remark
	 */
	public UserExp(int userId,String realName, String gender, int age, String phoneNumber,
			String address, String email, String code, String remark) {
		super();
		this.userId = userId;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.code = code;
		this.remark = remark;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
