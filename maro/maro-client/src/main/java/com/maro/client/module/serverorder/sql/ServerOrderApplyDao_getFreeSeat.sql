SELECT
	x.number personnum,
	count(1) total,
	x.typename type
FROM
	(
		SELECT
			t.*, type.typename typename
		FROM
			maro_shop_seat t,
			(
				SELECT
					a.typename,
					a.typecode
				FROM
					t_s_type a,
					t_s_typegroup b
				WHERE
					a.typegroupid = b.ID
				AND b.typegroupcode = 'maro_seat_type'
			) type
		WHERE
			type.typecode = t.type
	) x
LEFT JOIN (
	SELECT
		x.dest_seat_id,
		so1.`status`
	FROM
		(
			SELECT
				dest_seat_id,
				max(so.begin_time) begin_time
			FROM
				maro_client__serverorder so,
				maro_client_seatchange sc
			WHERE
				so.id = sc.server_order_id
			AND sc.delete_flag = 0
			AND so.restaurant_id =  :shopId
			GROUP BY
				sc.dest_seat_id
		) x,
		maro_client__serverorder so1
	WHERE
		x.begin_time = so1.begin_time
) y ON x.id = y.dest_seat_id
WHERE
	x.shop_id =  :shopId
AND (y.`status` = 4 OR y.`status` = 7 or status is null)
GROUP BY
	x.typename,
	x.number;