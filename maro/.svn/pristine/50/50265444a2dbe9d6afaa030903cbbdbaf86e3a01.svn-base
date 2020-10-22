SELECT
	t.goods_id,
	t1.material_name name,
	SUM(t.number) realnum
FROM
	maro_store_flow t,
	maro_material_class t1
WHERE
	t.goods_id = t1.id
AND t.create_date BETWEEN :startTime AND :endTime
AND t.shop_id = :shopId
AND t.type = :flag
GROUP BY
	t.goods_id;