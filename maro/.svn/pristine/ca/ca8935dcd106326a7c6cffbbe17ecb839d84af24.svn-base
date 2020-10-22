SELECT
	fo.server_order_id id,
	fo.seat_code seat_code,
	sum(fo.total_price) money,
	count(fo.id) as quantity
FROM
	maro_client__serverorder so,
	(select dest_seat_id,server_order_id from maro_client_seatchange where delete_flag = 0 group by server_order_id,dest_seat_id) sc,
	maro_shop_seat mss,
	maro_client__foodorder fo
WHERE
	so.restaurant_id = :shopId
	and sc.server_order_id=so.id
	and sc.dest_seat_id=mss.id
	and mss.flag=:seatCode_billNumber
	and fo.server_order_id=so.id
	and fo.seat_id = sc.dest_seat_id
	and so.status!=:cancelStatus and so.status!=:finishStatus
	and fo.status!=:foodStatus
group by fo.server_order_id,fo.seat_code
order by so.begin_time desc
LIMIT 0,1
