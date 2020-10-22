#t_s_depart
select  * from t_s_depart t where t.id=(select t1.parentdepartid from t_s_depart t1 where t1.ID=:departId)
#t_s_depart
SELECT * FROM t_s_depart WHERE id = :departId
#t_s_base_user
SELECT * FROM t_s_base_user t WHERE t.ID IN ( SELECT t1.user_id FROM t_s_user_org t1 WHERE t1.org_id =:departId)
#t_s_user
SELECT * FROM t_s_user t WHERE t.ID IN ( SELECT t1.user_id FROM t_s_user_org t1 WHERE t1.org_id =:departId)
#t_s_user_org
SELECT * FROM t_s_user_org t WHERE t.org_id =:departId
#t_s_role
SELECT * FROM t_s_role t WHERE t.ID IN ( SELECT t1.roleid FROM t_s_role_user t1 WHERE t1.userid IN ( SELECT t1.user_id FROM t_s_user_org t1 WHERE t1.org_id = :departId));
#t_s_role_user
SELECT * FROM t_s_role_user t WHERE t.userid IN ( SELECT t1.user_id FROM t_s_user_org t1 WHERE t1.org_id = :departId)
#t_s_function
SELECT * FROM t_s_function a WHERE a.ID IN ( SELECT t.functionid FROM t_s_role_function t WHERE t.roleid IN ( SELECT t1.roleid FROM t_s_role_user t1 WHERE t1.userid IN ( SELECT t2.user_id FROM t_s_user_org t2 WHERE t2.org_id = :departId )))
#t_s_role_function
SELECT * FROM t_s_role_function t WHERE t.roleid IN ( SELECT t1.roleid FROM t_s_role_user t1 WHERE t1.userid IN ( SELECT t2.user_id FROM t_s_user_org t2 WHERE t2.org_id = :departId ))
#maro_shop
SELECT * FROM maro_shop t WHERE t.id =:shopId
#maro_shop_seat
SELECT * FROM maro_shop_seat t WHERE t.shop_id =:shopId
#maro_member
SELECT * FROM maro_member t WHERE t.shop_id=:shopId
#maro_dishes
select * from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId
#maro_dishes_specifications
select * from maro_dishes_specifications where maro_dishes_id in (select id from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId)
#maro_specifications_food_costs
select * from maro_specifications_food_costs where specifications_id in (select id from maro_dishes_specifications where maro_dishes_id in (select id from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId))
#maro_specifications_price
select * from maro_specifications_price where specifications_id in(select id from maro_dishes_specifications where maro_dishes_id in (select id from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId))
#maro_specifications_food_costs
select t1.* from maro_specifications_food_costs t1 where t1.materialclass_id in (select id from maro_material_class) and (t1.id not in( select msfc.id from maro_specifications_food_costs msfc where msfc.specifications_id in (select id from maro_dishes_specifications where maro_dishes_id in (select id from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId)) ))
#maro_dishes_classification
select * from maro_dishes_classification
#maro_material_class
select * from maro_material_class
#maro_material_classification
select * from maro_material_classification
#t_s_typegroup
select * from t_s_typegroup
#t_s_type
select * from t_s_type
#maro_material_threshold
select * from maro_material_threshold t where t.shop_id=:shopId
#maro_shop_store
select * from maro_shop_store t where t.shop_id=:shopId
#maro_purchase
select * from maro_purchase t where t.shop_id=:shopId
#maro_purchase_detail
select * from maro_purchase_detail t where t.purchase_id in(select t1.id from maro_purchase t1 where t1.shop_id=:shopId)
#maro_store_flow
select * from maro_store_flow t where t.purchase_detail_id in ( select t1.id from maro_purchase_detail t1 where t1.purchase_id in ( select t2.id from maro_purchase t2 where t2.shop_id =:shopId ))
#maro_store_goods
SELECT * FROM maro_store_goods t WHERE t.store_id IN ( SELECT t1.id FROM maro_shop_store t1 WHERE t1.shop_id =:shopId )
#maro_special_offer
SELECT * FROM maro_special_offer t WHERE t.shop_id=:shopId
#maro_dishes_discount
SELECT * FROM maro_dishes_discount t WHERE t.shop_id=:shopId
#maro_dishes_discount_detail
SELECT * FROM maro_dishes_discount_detail t WHERE t.discount_id in(SELECT id FROM maro_dishes_discount t1 WHERE t1.shop_id=:shopId)
#maro_setmeal_dishes
select * from maro_setmeal_dishes where setmeal_id in (select id from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId)
#maro_setmeal_dishes_select
select * from maro_setmeal_dishes_select where setmeal_dishes_id in (select id from maro_setmeal_dishes where setmeal_id in (select id from maro_dishes where sys_company_code = '0' or sys_company_code = :shopId))
#maro_group_discount
SELECT * FROM maro_group_discount t WHERE t.shop_id = :shopId