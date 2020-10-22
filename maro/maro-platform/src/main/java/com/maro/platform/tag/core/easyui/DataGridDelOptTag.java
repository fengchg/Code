package com.maro.platform.tag.core.easyui;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.maro.platform.core.util.MutiLangUtil;
import com.maro.platform.core.util.ResourceUtil;

/**
 * 
 * 类描述：列表删除操作项标签
 * 
 * @author 张代浩
 * @date： 日期：2012-12-7 时间：上午10:17:45
 * @version 1.0
 */
public class DataGridDelOptTag extends TagSupport {
	protected String url;
	protected String title;
	private String message;//询问链接的提示语
	private String exp;//判断链接是否显示的表达式
	private String funname;//自定义函数名称
	
	private String operationCode;//按钮的操作Code
	private String langArg;
	private String urlStyle;//样式

	private String urlclass;//按钮样式
	private String urlfont;//按钮图标
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
		parent.setDelUrl(url, title, message, exp, funname,operationCode,urlStyle,urlclass,urlfont);
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
	public void setMessage(String message) {
		this.message = message;
	}
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
	
	public void setLangArg(String langArg) {
		this.langArg = langArg;
	}
	public void setUrlStyle(String urlStyle) {
		this.urlStyle = urlStyle;
	}
	public String getUrlStyle() {
		return urlStyle;
	}

		public String getUrlclass() {
			return urlclass;
		}
		public void setUrlclass(String urlclass) {
			this.urlclass = urlclass;
		}
		public String getUrlfont() {
			return urlfont;
		}
		public void setUrlfont(String urlfont) {
			this.urlfont = urlfont;
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
