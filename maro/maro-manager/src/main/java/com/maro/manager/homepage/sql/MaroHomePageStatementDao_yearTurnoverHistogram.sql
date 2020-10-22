SELECT
	any_value(FROM_UNIXTIME(begin_time / 1000,'%m')) hour_time,
  	any_value(SUM(receivable_amount)) receivable_amount,
	any_value(SUM(collected_amount)) collected_amount
FROM
	maro_client__serverorder
WHERE
	DATE_FORMAT(FROM_UNIXTIME(begin_time / 1000,'%Y-%m-%d %H:%i:%S'),'%Y') = DATE_FORMAT(:tynData, '%Y')
AND restaurant_id = :shopId
GROUP BY
	FROM_UNIXTIME(begin_time / 1000,'%Y-%m')
ORDER BY 
	hour_time