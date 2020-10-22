SELECT
	seat.flag,
	if(ISNULL(reserve.typename),'空闲',reserve.typename) status
FROM
	maro_shop_seat seat
LEFT JOIN (
	SELECT
		r.dest_seat_id,
		type.typename
	FROM
		maro_client_reserve r,
		(
			SELECT
				t.typecode,
				t.typename
			FROM
				t_s_type t,
				t_s_typegroup g
			WHERE
				t.typegroupid = g.id
			AND g.typegroupcode = 'reserveStatusEnum'
		) type
	WHERE
		r.`status` = type.typecode and r.`status` = 0 and period=:period
) reserve ON seat.id = reserve.dest_seat_id
where  seat.flag=:seatCode and seat.shop_id=:shopId
ORDER BY
	seat.flag