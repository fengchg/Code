SELECT
	*
FROM
	maro_client_shift t
WHERE
	t.user_id = :userId
AND DATE_FORMAT(t.login_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d')
AND t.shift_code = :shiftCode
AND (t.is_check is null or t.is_check !=1)