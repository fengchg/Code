SELECT
	*
FROM
	t_s_user tsu,
	t_s_base_user tsbu,
  t_s_user_org tsuo
WHERE
	tsu.id = tsbu.id
and tsu.id = tsuo.user_id
and tsuo.org_id = :departId
and tsbu.delete_flag = 0