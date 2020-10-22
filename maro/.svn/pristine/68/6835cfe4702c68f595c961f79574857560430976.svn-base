package com.maro.client.module.serverorder.service.impl;

import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.module.serverorder.service.MaroClientCodeNumService;
import com.maro.platform.core.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class MaroClientCodeNumServiceImpl implements MaroClientCodeNumService {

    @Resource
    private ClientCommonDao dao;

    @Override
    public Integer getCode(String shopId,Date date) {
        final String SQL_GET_GETCODE = "select code_num from maro_client_code_num where create_date = ? and shop_id=?";
        Integer codeNum = (Integer) dao.getObjectBySql(SQL_GET_GETCODE, DateUtils.formatDate(date),shopId);
        if(codeNum == null){
            codeNum = 1;
        }else{
            codeNum++;
        }
        updateCode(codeNum,date,shopId);
        return codeNum;
    }

    private void updateCode(Integer codeNum,Date date,String shopId){
        if(codeNum == 1){
            final String SQL_INSERT_UPDATECODE = "insert into maro_client_code_num(id,code_num,create_date,shop_id) values(?,?,?,?)";
            dao.executeUpdateSql(SQL_INSERT_UPDATECODE, UUID.randomUUID().toString(),codeNum,date,shopId);
        }else {
            final String SQL_UPDATE_UPDATECODE = "update maro_client_code_num set code_num = ? where create_date = ? and shop_id = ?";
            dao.executeUpdateSql(SQL_UPDATE_UPDATECODE, codeNum, DateUtils.formatDate(date),shopId);
        }
    }


}
