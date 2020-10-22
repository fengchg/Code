package com.maro.client.common.dao.impl;

import com.maro.client.common.dao.ClientCommonDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 常用数据库操作接口实现类
 * @author 冯成果
 * @date 2018-3-26
 * @since 版本号 01.00.0001
*/
@Repository
public class ClientCommonDaoImpl implements ClientCommonDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        // 事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }

    @Override
    public <T> Serializable save(T entity) {
        Serializable e = getSession().save(entity);
        return e;
    }

    @Override
    public <T> void batchSave(List<T> entitys) {
        if(entitys != null && entitys.size() > 0){
            for(T entity:entitys){
                getSession().save(entity);
            }
        }
    }

    @Override
    public <T> T get(Class<T> entityName, Serializable id) {
        return (T) getSession().get(entityName,id);
    }


    @Override
    public <T> List<T> list(String hql,Object... params){
        Query query = getSession().createQuery(hql);

        if(params != null && params.length>0){
            for(int i=0;i<params.length;i++){
                Object param = params[i];
                query.setParameter(i,param);
            }
        }

        return query.list();
    }

    @Override
    public <T> void updateEntitie(T pojo) {
        getSession().update(pojo);
    }

    @Override
    public <T> void executeUpdateSql(String sql, Object... params) {
        SQLQuery sqlQuery = getSession().createSQLQuery(sql);
        if(params != null && params.length>0){
            for(int i=0;i<params.length;i++){
                Object param = params[i];
                sqlQuery.setParameter(i,param);
            }
        }
        sqlQuery.executeUpdate();
    }

    @Override
    public Object getObjectBySql(String sql, Object... params) {
        SQLQuery sqlQuery = getSession().createSQLQuery(sql);
        if(params != null && params.length>0){
            for(int i=0;i<params.length;i++){
                Object param = params[i];
                sqlQuery.setParameter(i,param);
            }
        }
        return sqlQuery.uniqueResult();
    }
}
