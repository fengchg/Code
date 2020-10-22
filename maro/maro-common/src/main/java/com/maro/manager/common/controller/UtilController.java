package com.maro.manager.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.maro.common.listener.MqServerListener;
import com.maro.common.util.MqUtil;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.apache.log4j.Logger;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.maro.common.util.Util;
import com.maro.manager.common.entity.ComboTree;
import com.maro.manager.common.entity.CustomMultipartFile;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.ContextHolderUtils;
import com.maro.platform.core.util.IpUtil;
import com.maro.platform.core.util.PasswordUtil;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.manager.ClientManager;
import com.maro.platform.web.system.pojo.base.Client;
import com.maro.platform.web.system.pojo.base.TSUser;
import com.maro.platform.web.system.service.MutiLangServiceI;
import com.maro.platform.web.system.service.SystemService;

/**
 * @Title: Controller
 * @Description: 通用
 * @author 龚道海
 * @date 2018-03-26 16:00:55
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/utilController")
public class UtilController extends BaseController {
	private static Map<String,String> TOKENMAP=new HashMap<String,String>();
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(UtilController.class);

	@Autowired
	private UtilServiceI utilService;
	@Autowired
	private SystemService systemService;
	@Autowired
    private MutiLangServiceI mutiLangService;
	/**
	 * 上传文件通用接口
	 * @param request
	 * @param resp
	 * @param file 文件对象
	 * @throws IOException
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = "upload")
	@ResponseBody
	public AjaxJson upload(HttpServletRequest request,HttpServletResponse resp,@RequestParam("files") MultipartFile[] files) throws IOException {
		AjaxJson j=new AjaxJson();
		StringBuffer returnPath=new StringBuffer();
		if(files!=null&&files.length>0){
			for(MultipartFile file:files){
				try {
					if(file.getSize() > 100000000){
						resp.getWriter().print("文件大小不能大于 500M");
					}
					//上传的文件路径
					String uploadPath=(request.getParameter("uploadPath")==null||request.getParameter("uploadPath").equals("undefined"))?"files":request.getParameter("uploadPath");
					//上传文件
					Map<String, Object> map = new HashMap<String, Object>();
					//获取项目路径
					String projectPath=request.getSession().getServletContext().getRealPath("/");
					//目录路径
					String filePath = "upload/"+uploadPath+"/";
					//获取文件名(UUID+文件名)
					String fileName=UUID.randomUUID().toString().replace("-", "")+getExtensionName(file.getOriginalFilename());
					//上传全路径
					String pathUrl=projectPath+filePath;
					//上传文件
					uploadFile(pathUrl,fileName,file.getBytes());
					//获取文件路径
					String path=filePath+fileName;
					//文件路径按‘;’分割
					returnPath.append(path+";");
				} catch (Exception e) {
					e.printStackTrace();
					j.setSuccess(false);
					j.setMsg("上传错误！");
				}
			}
			j.setObj(returnPath.substring(0, returnPath.length()-1));
		}
		return j;
	}
	/**
	 * 根据文件路径删除文件
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = "remove")
	@ResponseBody
	public AjaxJson remove(HttpServletRequest request) {
		AjaxJson j=new AjaxJson();
		try {
			//获取项目路径
			String projectPath=request.getSession().getServletContext().getRealPath("/");
			//获取文件路径
			String filePath = request.getParameter("filePath");
			Boolean result=removeFileByFilePath(projectPath+filePath);
			if(!result.booleanValue()){
				j.setMsg(Util.getMessageFromTypeByKey("deleteError"));
				j.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 通过文件路径删除文件
	 * @param filePath
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	private Boolean removeFileByFilePath(String filePath) {
		// TODO Auto-generated method stub
		File f=new File(filePath);
		if(f.exists()){
			f.delete();
			return true;
		}else{
			return true;
		}
	}
	/**
	 * 封装的上传方法
	 * @param fileDirectory 路径
	 * @param fileName 文件名
	 * @param fileData 文件二进制对象
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	public static void uploadFile(String fileDirectory,String fileName,byte[] fileData){
		CustomMultipartFile cm = new CustomMultipartFile(fileDirectory,fileName,fileData);
		cm.submit();
	}
	/**
	 * 通用的tree方法
	 * @param request
	 * @author gongdaohai
	 * @since v1.0 2018年4月2日
	 */
	@RequestMapping(params = "tree")
	@ResponseBody
	public Object tree(HttpServletRequest request) {
		try {
			//点击的id值
			String id = request.getParameter("id");
			//id
			String id_field_name = request.getParameter("id_field_name");
			//pid
			String pid_field_name = request.getParameter("pid_field_name");
			//显示的字段名
			String tree_field = request.getParameter("tree_field");
			//表名
			String table_name = request.getParameter("table_name");
			List<ComboTree> comboTrees = utilService.getComboTree(id,id_field_name,pid_field_name,tree_field,table_name);
			return comboTrees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取下拉框的值
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年4月3日
	 * @version
	 */
	@RequestMapping(params = "combobox")
	@ResponseBody
	public Object combobox(HttpServletRequest request) {
		try {
			//点击的id值
			String id = request.getParameter("id");
			//id
			String text = request.getParameter("text");
			//表名
			String table_name = request.getParameter("table_name");
			//条件
			String conditions= request.getParameter("conditions");
			List<Map> comboboxs = (List<Map>)utilService.getCombobox(id,text,table_name,conditions);
			return comboboxs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据部门id获取部门名称
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年4月24日
	 * @version
	 */
	@RequestMapping(params = "getDepartNameByDepartId")
	@ResponseBody
	public String getDepartNameByDepartId(HttpServletRequest request) {
		String departName=null;
		try {
			//部门id
			String departId = request.getParameter("departId");
			departName = utilService.getDepartNameByDepartId(departId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departName;
	}
	/**
	 * 生成标签码
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月3日
	 * @version
	 */
	@RequestMapping(params = "makeLableCode")
	@ResponseBody
	public AjaxJson makeLableCode(HttpServletRequest request) {
		AjaxJson j=new AjaxJson();
		try {
			//String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
			String uuid = String.valueOf(new Date().getTime());
			j.setObj(uuid);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 验证用户
	 * @param request
	 * @param user
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月22日
	 * @version
	 */
	@RequestMapping(params = "approveUser")
	@ResponseBody
	public AjaxJson approveUser(HttpServletRequest request,String userName,String password) {
		AjaxJson json=new AjaxJson();
		try {
			//密码加密
			password=PasswordUtil.encrypt(userName,password, PasswordUtil.getStaticSalt());
			TSUser user=utilService.approveUser(userName,password);
			if(user==null){
				json.setSuccess(false);
				json.setMsg("用户名或者密码错误！");
			}else{
				saveLoginSuccessInfo(request,user);
				json.setObj(request.getSession().getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("用户名或者密码错误！");
		}
		return json;
	}

	/**
	 * 认证用户并获取用户所在部门信息
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(params = "approveUserAndGetDepart")
	@ResponseBody
	public AjaxJson approveUserAndGetDepart(HttpServletRequest request,String userName,String password) {
		AjaxJson json=new AjaxJson();
		try {
			//密码加密
			password=PasswordUtil.encrypt(userName,password, PasswordUtil.getStaticSalt());
			TSUser user=utilService.approveUser(userName,password);
			if(user==null){
				json.setSuccess(false);
				json.setMsg("用户名或者密码错误！");
			}else{
				TSDepart currentDepart = utilService.getDepartByUserId(user.getId());
				if(currentDepart!=null){
					json.setObj(currentDepart);
				}else{
					json.setSuccess(false);
					json.setMsg("无相关记录！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("用户名或者密码错误！");
		}
		return json;
	}

	/**
	 * 初始化数据
	 * @param request
	 * @param queueName
	 * @return
	 */
	@RequestMapping(params = "initMQ")
	@ResponseBody
	public AjaxJson initMQ(HttpServletRequest request,String queueName) {
		AjaxJson json=new AjaxJson();
		try {
			//初始化队列
			MqUtil.initClientMq(queueName);
			//initDB和刷新字典表
			utilService.initDB(queueName,null);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("初始化数据失败！");
		}
		return json;
	}

	/**
	 * 同步数据字典
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "syncGroup")
	@ResponseBody
	public AjaxJson syncGroup(HttpServletRequest request) {
		AjaxJson json=new AjaxJson();
		try {
			utilService.syncGroup(null);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("初始化数据失败！");
		}
		return json;
	}


	/**
	 * 初始化数据
	 * @param request
	 * @param queueName
	 * @return
	 */
	@RequestMapping(params = "startInit")
	@ResponseBody
	public AjaxJson startInit(HttpServletRequest request,String queueName) {
		AjaxJson json=new AjaxJson();
		try {
			//监听队列名
			MqServerListener.LISTENERQUEUENAME=queueName;
			MqServerListener.listenMQ();
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("初始化数据失败！");
		}
		return json;
	}
	/**
	 * 初始化数据库
	 * @param request
	 * @param queueName 需要发送出去的队列名
	 * @param tableName
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月23日
	 * @version
	 */
	@RequestMapping(params = "initDB")
	@ResponseBody
	public void initDB(HttpServletRequest request,String queueName,String tableName) {
		try {
			if(queueName!=null){
				utilService.initDB(queueName,tableName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    private void saveLoginSuccessInfo(HttpServletRequest req, TSUser user) {
        String message = null;
        HttpSession session = ContextHolderUtils.getSession();
//        TSDepart currentDepart = systemService.get(TSDepart.class, orgId);
//        user.setCurrentDepart(currentDepart);
//
//
//        user.setDepartid(orgId);

        session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
        message = mutiLangService.getLang("common.user") + ": " + user.getUserName() + "["+ user.getCurrentDepart().getDepartname() + "]" + mutiLangService.getLang("common.login.success");

//        String browserType = "";
//        Cookie[] cookies = req.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            Cookie cookie = cookies[i];
//            if("BROWSER_TYPE".equals(cookie.getName())){
//                browserType = cookie.getValue();
//            }
//        }
//        session.setAttribute("brower_type", browserType);

        //当前session为空 或者 当前session的用户信息与刚输入的用户信息一致时，则更新Client信息
        Client clientOld = ClientManager.getInstance().getClient(session.getId());
        if(clientOld == null || clientOld.getUser() ==null ||user.getUserName().equals(clientOld.getUser().getUserName())){
            Client client = new Client();
            client.setIp(IpUtil.getIpAddr(req));
            client.setLogindatetime(new Date());
            client.setUser(user);
            ClientManager.getInstance().addClinet(session.getId(), client);
        } else {//如果不一致，则注销session并通过session=req.getSession(true)初始化session
            ClientManager.getInstance().removeClinet(session.getId());
            session.invalidate();
            session = req.getSession(true);//session初始化
            session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
            session.setAttribute("randCode",req.getParameter("randCode"));//保存验证码
//            checkuser(user,req);
        }
        // 添加登陆日志
        systemService.addLog(message, Globals.Log_Type_LOGIN, Globals.Log_Leavel_INFO);
    }
	/**
	 *  获取文件扩展名 
	 * @param filename 文件全名称
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年4月4日
	 * @version
	 */
    public static String getExtensionName(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length() - 1))) {   
                return filename.substring(dot);   
            }   
        }   
        return filename;   
    } 
}
