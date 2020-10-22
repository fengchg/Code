SELECT
	md.dishes_name,
  tst.typename,
  mds.unit_price,
  IFNULL(FORMAT((select sum(mcf.quantity) from maro_client__foodorder mcf where mcf.food_id = md.id),0),0) frequency_quantity,
  IFNULL(((select sum(mcf.quantity) from maro_client__foodorder mcf where mcf.food_id = md.id) * mds.unit_price),0) frequency_amount,
  (select SUM(mcf.total_price) from maro_client__foodorder mcf) all_amount,
  FORMAT((
		IFNULL(((select sum(mcf.quantity) from maro_client__foodorder mcf where mcf.food_id = md.id) * mds.unit_price) / (select SUM(mcf.total_price) from maro_client__foodorder mcf),0)
  ) * 100 ,2 ) paid_in_proportion
FROM
	maro_dishes md,
  maro_dishes_specifications mds,
  t_s_typegroup tstg,
  t_s_type tst
WHERE
	md.id = mds.maro_dishes_id
  and mds.`name` = tst.typecode
  and tst.typegroupid = tstg.id
  and tstg.typegroupcode = 'maro_specifications'
  and (md.sys_company_code = :shopId or md.sys_company_code = '0')
ORDER BY frequency_amount DESC