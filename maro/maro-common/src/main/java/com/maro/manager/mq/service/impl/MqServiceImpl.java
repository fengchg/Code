package com.maro.manager.mq.service.impl;

import com.maro.common.util.Util;
import com.maro.manager.mq.service.MqServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("mqService")
@Transactional
public class MqServiceImpl extends CommonServiceImpl implements MqServiceI {
	@Autowired
	private SystemService systemService;
	@Override
	public void saveEntity(Object obj) {
		// TODO Auto-generated method stub
		//保存该对象
		systemService.save(obj);
	}

	@Override
	public void insertData(String tableName,List<List> data) {
		// TODO Auto-generated method stub
		//sql语句
		StringBuffer sqls=new StringBuffer();
		String sql="";
		List fields=null;
		for(List oneData:data){
			try{
				//获取id
				String id=oneData.get(0).toString();
				//判断是否已有数据
				int num=systemService.findListbySql("SELECT * FROM "+tableName+" t WHERE t.id='"+id+"'").size();
				if(num==0){//无记录就插入
					sql=listToInsertSql(tableName,oneData);
				}else{//有记录就更新
					//获取表结构信息
					if(fields==null){
						fields=systemService.findListbySql("SHOW FULL FIELDS FROM "+tableName);
					}
					sql=listToUpdateSql(tableName,oneData,fields);
				}
				System.out.println(sql+";");
				sqls.append(sql+";\n");
				systemService.executeSql(sql);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		Util.writeToFile("C://"+new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt",sqls.toString());
	}

	@Override
	public void deleteData(String tableName, List<String> data) {
		for(String id:data){
			systemService.executeSql("delete from "+tableName+" t where t.id='"+id+"'");
		}
	}

	/**
	 * @param tableName
	 * @param oneData
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月23日
	 * @version
	 */
	private String listToInsertSql(String tableName, List oneData) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("INSERT INTO "+tableName+" VALUES(");
		for(int i=0;i<oneData.size();i++){
			Object o = oneData.get(i);
			if(i==oneData.size()-1){
				if(o instanceof String){
					sql.append("'"+o+"'");
				}else{
					sql.append(o);
				}
			}else{
				if(o instanceof String){
					sql.append("'"+o+"',");
				}else{
					sql.append(o+",");
				}
			}
		}
		sql.append(")");
		return sql.toString();
	}

	/**
	 *
	 * @param tableName 表名
	 * @param data
	 * @param oneData 数据集合
	 * @return
	 */
	private String listToUpdateSql(String tableName, List oneData, List<Object[]> fields) {
		// TODO Auto-generated method stub
		String id=oneData.get(0).toString();
		StringBuffer sql=new StringBuffer();
		sql.append("UPDATE "+tableName+" SET ");
		for(int i=0;i<oneData.size();i++){
			String field=fields.get(i)[0].toString();
			Object o = oneData.get(i);
			sql.append(field+"=");
			if(i==oneData.size()-1){
				if(o instanceof String){
					sql.append("'"+o+"'");
				}else{
					sql.append(o);
				}
			}else{
				if(o instanceof String){
					sql.append("'"+o+"',");
				}else{
					sql.append(o+",");
				}
			}
		}
		sql.append(" WHERE ID='"+id+"'");
		return sql.toString();
	}
}