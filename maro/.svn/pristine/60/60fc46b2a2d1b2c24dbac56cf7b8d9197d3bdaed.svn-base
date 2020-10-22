SELECT
	t.id,
	t.person_number,
	t.amount,
	t.collected_amount,
	t.small_change
FROM
	maro_client__serverorder t
WHERE
  DATE_FORMAT(NOW(), '%Y-%m-%d') = FROM_UNIXTIME(t.end_time / 1000, '%Y-%m-%d')
AND t.shift_code=:shiftCode
AND (t.is_check is null or t.is_check !=1)