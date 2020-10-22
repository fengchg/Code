SELECT
	(SELECT a.typename from t_s_type a,t_s_typegroup b WHERE a.typegroupid=b.id and b.typegroupcode='serverOrderPayedTypeEnum' and a.typecode=t2.pay_type) payname,
	count(*) num,
	SUM(t2.amount) amountpart
FROM
	maro_client__serverorder t,
	maro_client_payed t1,
	maro_client_payed_detail t2
WHERE
	t.id = t1.server_order_id
AND t1.id = t2.pay_id
AND DATE_FORMAT(NOW(), '%Y-%m-%d') = FROM_UNIXTIME(t.end_time / 1000, '%Y-%m-%d')
AND t.shift_code=:shiftCode
AND (t.is_check is null or t.is_check !=1)
GROUP BY
	payname
