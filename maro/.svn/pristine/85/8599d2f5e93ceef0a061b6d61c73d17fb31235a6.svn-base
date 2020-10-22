SELECT
	t.id,
	t.`name`,
	t.remark,
	t.discount_money money
FROM
	maro_group_discount t
WHERE
	t.shop_id = :shopId
AND t.is_enable IS NULL
OR t.is_enable = 'Y'