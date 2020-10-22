SELECT
	t1.food_type,
	t1.food_name,
	SUM(t1.quantity) num,
	SUM(t1.total_price) total_price
FROM
	maro_client__serverorder t,
	maro_client__foodorder t1
WHERE
  DATE_FORMAT(NOW(), '%Y-%m-%d') = FROM_UNIXTIME(t.end_time / 1000, '%Y-%m-%d')
AND t.shift_code=:shiftCode
AND (t.is_check is null or t.is_check !=1)
AND t.id = t1.server_order_id
GROUP BY
	t1.food_type,
	t1.food_name