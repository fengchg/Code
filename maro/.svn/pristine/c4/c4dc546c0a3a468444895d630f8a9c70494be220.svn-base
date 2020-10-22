SELECT
	(
		SELECT
			`name`
		FROM
			maro_shop_store
		WHERE
			id = t.store_id
	) storename
FROM
	maro_store_goods t
WHERE
	t.store_id IN (
		SELECT
			t1.id
		FROM
			maro_shop_store t1,
			maro_shop_store t2
		WHERE
			t1.shop_id = t2.shop_id
		AND t2.id = :storeId
		AND t1.id != :storeId
	)
AND t.goods_id = :goodsId