SELECT
	(SELECT a.typename from t_s_type a,t_s_typegroup b WHERE a.typegroupid=b.id and b.typegroupcode='maro_seat_type' and a.typecode=t1.type) typename,
	SUM(t.amount) amount
FROM
	maro_client__serverorder t,
	maro_shop_seat t1
WHERE
	t.seat_id = t1.id
AND DATE_FORMAT(NOW(), '%Y-%m-%d') = FROM_UNIXTIME(t.end_time / 1000, '%Y-%m-%d')
AND t.shift_code=:shiftCode
AND (t.is_check is null or t.is_check !=1)
GROUP BY typename