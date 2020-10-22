SELECT
	t.customer_name,
	(
		SELECT
			a.typename
		FROM
			t_s_type a,
			t_s_typegroup b
		WHERE
			a.typegroupid = b.ID
		AND b.typegroupcode = 'maro_period'
		AND a.typecode = t.period
	) period,
	FROM_UNIXTIME(t.plan_come_time / 1000,'%H:%i:%S') plan_come_time
FROM
	maro_client_reserve t,
	maro_shop_seat t1
WHERE
	t.dest_seat_id = t1.id
AND t1.shop_id = :shopId
AND t1.flag = :seatCode
AND DATE_FORMAT(now(), '%Y-%m-%d') = FROM_UNIXTIME(t.reserve_time / 1000,'%Y-%m-%d')
AND t.status=0