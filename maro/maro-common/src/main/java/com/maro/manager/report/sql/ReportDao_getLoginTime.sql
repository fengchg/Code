SELECT
  DATE_FORMAT(t.login_time, '%Y-%m-%d %H:%i:%s') login_time
FROM
	maro_client_shift t
WHERE
	t.user_id = :userId
AND DATE_FORMAT(t.login_time, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d')
AND t.shift_code = :shiftCode
AND (
	t.is_check IS NULL
	OR t.is_check != 1
)
LIMIT 0,1