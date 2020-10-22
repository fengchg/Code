select 
	seat.flag,
	if(ISNULL(x.typename),'空闲',x.typename) status
FROM
maro_shop_seat seat
left join 
(
SELECT
	sc.dest_seat_id,
	so.`status`,
	type.typename
from
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
		select t.typename,t.typecode from t_s_typegroup g,t_s_type t where g.ID=t.typegroupid and g.typegroupcode='serverOrderStatusEnum'
	) type
WHERE
	sc.server_order_id = so.id
	and type.typecode=so.`status`
) x ON seat.id = x.dest_seat_id
where seat.flag=:seatCode and seat.shop_id=:shopId