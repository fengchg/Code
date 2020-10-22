package com.maro.client.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 常用的数据库操作接口类
 * @author 冯成果
 * @date 2018-03-26
 * @since 01.00.0001
 */
public interface ClientCommonDao {

    /**
     * 保存实体
     * @param entity，要保存的实体
     * @return Serializable，保存的实体
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    <T> Serializable save(T entity);
    /**
     * 批量保存实体列表
     * @param entitys，要批量保存的实体列表
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    <T> void batchSave(List<T> entitys);
    /**
     * 根据实体类型和主键获取对应的实体信息
     * @param entityName：实体类型，id：主键
     * @return T，实体信息
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    <T> T get(Class<T> entityName, Serializable id);

    /**
     * 根据HQL查询符合条件的实体列表
     * @param hql，hql语句;param,参数
     * @return List<T>，实体列表
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    <T> List<T> list(String hql, Object... param);


    /**
     * 更新指定的实体
     * @param pojo：要更新的实体
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-05】进行添加
     */
    public <T> void updateEntitie(T pojo);

    /**
     * 执行更新sql语句
     * @param sql：要执行的更改/插入语句
     * @param params：参数
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-05】进行添加
     */
    public <T> void executeUpdateSql(String sql, Object... params);
    /**
     * 执行查询sql语句
     * @param sql：要执行的查询语句
     * @param params：参数
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-04-15】进行添加
     */
    Object getObjectBySql(String sql, Object... params);
}
