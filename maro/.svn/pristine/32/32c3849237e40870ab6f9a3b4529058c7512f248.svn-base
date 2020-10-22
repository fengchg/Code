SELECT
	seat.flag,
	'空闲' AS status
FROM
	maro_shop_seat seat
LEFT JOIN (
	SELECT
		sc.dest_seat_id,
		so.`status`,
		type.typename
	FROM
		(
			SELECT
				dest_seat_id,
				server_order_id
			FROM
				maro_client_seatchange
			WHERE
				delete_flag = 0
			GROUP BY
				dest_seat_id,
				server_order_id
		) sc,
		maro_client__serverorder so,
		(
			SELECT
				t.typename,
				t.typecode
			FROM
				t_s_typegroup g,
				t_s_type t
			WHERE
				g.ID = t.typegroupid
			AND g.typegroupcode = 'serverOrderStatusEnum'
		) type
	WHERE
		sc.server_order_id = so.id
	AND type.typecode = so.`status`
) x ON seat.id = x.dest_seat_id
WHERE
	seat.type = :seatTypeCode
AND x.`status` IS NULL or x.`status`=4 in (3,4,7)
and seat.shop_id=:shopId