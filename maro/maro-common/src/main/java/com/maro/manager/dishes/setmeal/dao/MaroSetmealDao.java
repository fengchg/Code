package com.maro.manager.dishes.setmeal.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface MaroSetmealDao {
	/**
 	 * 根据套餐类id去删除 套餐菜
 	 */
	@Arguments("setmealDishesId")
	@Sql("DELETE FROM maro_setmeal_dishes_select WHERE setmeal_dishes_id =:setmealDishesId")
	Integer deleteSetmealSelect(String setmealDishesId);
}
