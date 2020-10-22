SELECT
	t.id id,
	t.`name` text
FROM
	maro_shop_seat t
WHERE
	t.shop_id = :shopId
AND t.number >= :personNumber
AND t.id NOT IN (
	SELECT
		a.dest_seat_id
	FROM
		maro_client_reserve a
	WHERE
		a.restaurant_id = :shopId
	AND a.reserve_time = :time
	AND a.period = :period
)
ORDER BY t.number