package com.maro.platform.tag.core.easyui;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.maro.platform.core.util.MutiLangUtil;
import com.maro.platform.core.util.ResourceUtil;

/**
 *  @author 张代浩
 * 类描述：列表工具条标签
 */
public class DataGridToolBarTag extends TagSupport {
	protected String url;
	protected String title;
	private String exp;//判断链接是否显示的表达式
	private String funname;//自定义函数名称
	private String icon;//图标
	private String onclick;
	private String width;
	private String height;
	private String operationCode;//按钮的操作Code
	private String langArg;//按钮的操作Code

	private String id;//控件ID
    private String show;//是否显示
	private String roleCanSee;//何种角色可见
	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}
	public int doEndTag() throws JspTagException {
		if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//不是管理员
			Object dgToolBar=pageContext.getServletContext().getAttribute("dgToolBar");
			if(dgToolBar!=null&&dgToolBar.equals("hidden")&&show!=null&&show.equals("hidden")){
				return SKIP_BODY;
			}
			if(roleCanSee!=null){
				String userId = ResourceUtil.getSessionUser().getId();
				//获取角色编码
				String roleCodes = (String)pageContext.getSession().getAttribute("maroRoleCodes");
				String[] roles=roleCanSee.split(",");
				boolean have=false;
				for(String role:roles){
					if(roleCodes.contains(role)){
						have=true;
						break;
					}
				}
				if(!have){
					return SKIP_BODY;
				}
			}
		}
		title = MutiLangUtil.doMutiLang(title, langArg);
		Tag t = findAncestorWithClass(this, DataGridTag.class);
		DataGridTag parent = (DataGridTag) t;
		parent.setToolbar(url, title, icon, exp,onclick, funname,operationCode,width,height,id);
		return EVAL_PAGE;
	}
	
	public void setFunname(String funname) {
		this.funname = funname;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public void setLangArg(String langArg) {
		this.langArg = langArg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

	public String getRoleCanSee() {
		return roleCanSee;
	}

	public void setRoleCanSee(String roleCanSee) {
		this.roleCanSee = roleCanSee;
	}
}
