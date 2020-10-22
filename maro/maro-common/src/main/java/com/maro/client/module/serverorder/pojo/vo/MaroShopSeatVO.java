package com.maro.client.module.serverorder.pojo.vo;

import com.maro.client.module.reserve.pojo.vo.MaroClientReserveVO;

import java.util.List;

public class MaroShopSeatVO {
    /**主键*/
    private String id;
    /** 创建人名称 */
    private String createName;
    /**创建人登录名称*/
    private String createBy;
    /**创建日期*/
    private java.util.Date createDate;
    /**更新人名称*/
    private String updateName;
    /**更新人登录名称*/
    private String updateBy;
    /**更新日期*/
    private java.util.Date updateDate;
    /**所属部门*/
    private String sysOrgCode;
    /**所属公司*/
    private String sysCompanyCode;
    /**流程状态*/
    private String bpmStatus;
    /**主键id*/

    private String shopId;
    /**座位名称*/

    private String name;
    /**座位类型*/

    private Integer type;
    /**座位类型*/

    private String typeString;
    /**座位号*/

    private String flag;
    /**座位标准人数*/

    private Integer number;
    /**使用标志*/

    private Integer useFlag;
    /**最近流水id*/

    private String lateOperatinId;

    /**
     * 预定记录列表
     */
    private List<MaroClientReserveVO> maroClientReserveVOList;

    /**删除标志*/

    private Integer deleteFlag;

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键
     */


    public String getId(){
        return this.id;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  创建人名称
     */


    public String getCreateName(){
        return this.createName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  创建人名称
     */
    public void setCreateName(String createName){
        this.createName = createName;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  创建人登录名称
     */


    public String getCreateBy(){
        return this.createBy;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  创建日期
     */


    public java.util.Date getCreateDate(){
        return this.createDate;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  创建日期
     */
    public void setCreateDate(java.util.Date createDate){
        this.createDate = createDate;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  更新人名称
     */


    public String getUpdateName(){
        return this.updateName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  更新人名称
     */
    public void setUpdateName(String updateName){
        this.updateName = updateName;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  更新人登录名称
     */


    public String getUpdateBy(){
        return this.updateBy;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  更新日期
     */


    public java.util.Date getUpdateDate(){
        return this.updateDate;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  更新日期
     */
    public void setUpdateDate(java.util.Date updateDate){
        this.updateDate = updateDate;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  所属部门
     */


    public String getSysOrgCode(){
        return this.sysOrgCode;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  所属部门
     */
    public void setSysOrgCode(String sysOrgCode){
        this.sysOrgCode = sysOrgCode;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  所属公司
     */


    public String getSysCompanyCode(){
        return this.sysCompanyCode;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  所属公司
     */
    public void setSysCompanyCode(String sysCompanyCode){
        this.sysCompanyCode = sysCompanyCode;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  流程状态
     */


    public String getBpmStatus(){
        return this.bpmStatus;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  流程状态
     */
    public void setBpmStatus(String bpmStatus){
        this.bpmStatus = bpmStatus;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键id
     */


    public String getShopId(){
        return this.shopId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键id
     */
    public void setShopId(String shopId){
        this.shopId = shopId;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  座位名称
     */


    public String getName(){
        return this.name;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  座位名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  座位类型
     */


    public Integer getType(){
        return this.type;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  座位类型
     */
    public void setType(Integer type){
        this.type = type;
    }

    /**
     *方法: 获取java.lang.String
     *@param: java.lang.String  座位类型字符串
     */
    public String getTypeString() {
		return typeString;
	}
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  座位类型字符串
     */
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	/**
     *方法: 取得java.lang.String
     *@return: java.lang.String  座位号
     */


    public String getFlag(){
        return this.flag;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  座位号
     */
    public void setFlag(String flag){
        this.flag = flag;
    }

    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  座位标准人数
     */


    public Integer getNumber(){
        return this.number;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  座位标准人数
     */
    public void setNumber(Integer number){
        this.number = number;
    }

    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  使用标志
     */


    public Integer getUseFlag(){
        return this.useFlag;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  使用标志
     */
    public void setUseFlag(Integer useFlag){
        this.useFlag = useFlag;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  最近流水id
     */


    public String getLateOperatinId(){
        return this.lateOperatinId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  最近流水id
     */
    public void setLateOperatinId(String lateOperatinId){
        this.lateOperatinId = lateOperatinId;
    }

    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  删除标志
     */


    public Integer getDeleteFlag(){
        return this.deleteFlag;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  删除标志
     */
    public void setDeleteFlag(Integer deleteFlag){
        this.deleteFlag = deleteFlag;
    }


    private MaroClientSeatchangeVO maroClientSeatchangeVO;

    public MaroClientSeatchangeVO getMaroClientSeatchangeVO() {
        return maroClientSeatchangeVO;
    }

    public void setMaroClientSeatchangeVO(MaroClientSeatchangeVO maroClientSeatchangeVO) {
        this.maroClientSeatchangeVO = maroClientSeatchangeVO;
    }


    public List<MaroClientReserveVO> getMaroClientReserveVOList() {
        return maroClientReserveVOList;
    }

    public void setMaroClientReserveVOList(List<MaroClientReserveVO> maroClientReserveVOList) {
        this.maroClientReserveVOList = maroClientReserveVOList;
    }
}
