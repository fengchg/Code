package com.maro.client.module.serverorder.controller;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.serverorder.apply.ServerorderService;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.ServerorderDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientServerorderVO;
import com.maro.client.module.user.service.UserService;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.pojo.base.TSUser;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Controller
@RequestMapping("/serverorderController")
public class ServerorderController {

    @Resource(name="clientUserServiceImpl")
    private UserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Resource
    private ServerorderService serverorderService;

    private Logger logger = Logger.getLogger(ServerorderController.class);

    @RequestMapping(params = "saveServerorder")
    @ResponseBody
    public AjaxJson saveServerorder(HttpServletRequest request){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setSuccess(false);
        ajaxJson.setMsg(StringConstant.TIP_FAIL);
        TSUser sessionUser = ResourceUtil.getSessionUser();
        String json = getParamByStream(request);
        if(json.isEmpty()){
            return ajaxJson;
        }
        logger.error("pppppppppppppppp-------------"+json);
        JSONObject jsonObject = JSONObject.fromObject(json);
        String user = jsonObject.getString("user");
        String pass = jsonObject.getString("pass");
        String message = jsonObject.getString("message");

        if(sessionUser == null) {
        	logger.error(user+","+pass+",login");
            userService.login(request, user, pass);
            sessionUser = ResourceUtil.getSessionUser();
        }else{

        	logger.error("存在用户："+sessionUser.getUserName());
        }
        if(sessionUser != null) {
        	logger.error("用户认证成功");
            try {
//            	message = new String(message.getBytes(),"utf-8");
//                logger.error(message);
                ServerorderDTO serverorderDTO = objectMapper.readValue(message, ServerorderDTO.class);
                serverorderService.saveServerorder(serverorderDTO);
                ajaxJson.setSuccess(true);
                ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
            } catch (Exception e) {
                if(e.getMessage().contains("Duplicate entry")){
                    ajaxJson.setSuccess(true);
                    ajaxJson.setMsg(e.getMessage());
                	logger.error("订单已经同步:"+e.getMessage());
                }
                e.printStackTrace();
            	logger.error(message);
            	logger.error("saveServerorder出现异常:"+e.getMessage());
            }
        }else{
        	logger.error(user+","+pass+"用户认证失败:saveServerorder");
        }
        return ajaxJson;
    }

    private static final String GET_SERVERORDER_PAGE = "com/maro/client/serverorder/getServerorderPage";
    private static final String LIST_SERVERORDER_PAGE = "com/maro/client/serverorder/listServerorderPage";

    @RequestMapping(params = "listServerOrderDOPage")
    public ModelAndView listServerOrderDOPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView(LIST_SERVERORDER_PAGE);
    }

    @RequestMapping(params = "listServerOrderDO")
    public void listServerOrderDO(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, MaroClientServerorderDTO maroClientServerorderDTO) {
        List<MaroClientServerorderDO> maroClientServerorderDOs = serverorderService.listServerOrderDO(maroClientServerorderDTO);
        List<MaroClientServerorderVO> maroClientServerorderVO = PojoUtil.convertBatchDO2VO(maroClientServerorderDOs, MaroClientServerorderVO.class);
        dataGrid.setResults(maroClientServerorderVO);
        TagUtil.datagrid(response, dataGrid);
    }

    @RequestMapping(params = "getServerOrder")
    public MaroClientServerorderDTO getServerOrder(String serverOrderId) {
        //结账获取订单信息时，更新该订单价格
        MaroClientServerorderDO maroClientServerorderDO = new MaroClientServerorderDO();
        maroClientServerorderDO.setId(serverOrderId);
//        serverorderService.updateServerOrderAmount(maroClientServerorderDO);
        return serverorderService.getServerOrder(serverOrderId);
    }

    @RequestMapping(params = "getServerOrderPage")
    public ModelAndView getServerOrderPage(HttpServletRequest request, HttpServletResponse response,String serverOrderId) {
        MaroClientServerorderDTO maroClientServerorderDTO = getServerOrder(serverOrderId);
        request.setAttribute("maroClientServerorderDTO",maroClientServerorderDTO);
        return new ModelAndView(GET_SERVERORDER_PAGE);
    }

    public static String getParamByStream(HttpServletRequest request){
        String param = "";
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            StringBuffer sb = new StringBuffer();
            is = request.getInputStream();
            isr = new InputStreamReader(is, "UTF-8");
            br = new BufferedReader(isr);
            String s = "";
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            param = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return param;

    }

}
