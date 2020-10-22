SELECT plan.*,mmt.`value` threshold from (
  SELECT
    t4.id,
    t4.material_name name,
    SUM(t3.consumption_quantity) plannum,
    (SELECT a.typename from
    (
    SELECT 0 type,t1.typecode,t1.typename from t_s_typegroup t ,t_s_type t1 where t.id=t1.typegroupid and t.typegroupcode='maro_ordinary_unit' UNION
    SELECT 1 type,t1.typecode,t1.typename from t_s_typegroup t ,t_s_type t1 where t.id=t1.typegroupid and t.typegroupcode='maro_ordinary_unit' UNION
    SELECT 2 type,t1.typecode,t1.typename from t_s_typegroup t ,t_s_type t1 where t.id=t1.typegroupid and t.typegroupcode='maro_weighing_unit'
    )a where t4.type=a.type and t4.denominated_unit=a.typecode) unit
  FROM
    maro_client__serverorder t,
    maro_client__foodorder t1,
    maro_dishes_specifications t2,
    maro_specifications_food_costs t3,
    maro_material_class t4
  WHERE
    t.id = t1.server_order_id
  AND t1.food_id = t2.maro_dishes_id
  AND t2.id = t3.specifications_id
  AND t3.materialclass_id=t4.id
  AND FROM_UNIXTIME(t.begin_time/1000, '%Y-%m-%d %H:%i:%S') BETWEEN :startTime AND :endTime
  AND t.restaurant_id = :shopId
  AND t.`status` = :flag
  GROUP BY
    t4.id,
    t4.material_name,
    unit
) plan LEFT JOIN maro_material_threshold mmt ON plan.id=mmt.material_class_id