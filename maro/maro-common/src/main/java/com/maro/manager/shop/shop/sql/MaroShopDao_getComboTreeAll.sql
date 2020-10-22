SELECT
	t.ID id,
	t.parentdepartid pid,
	t.departname text,
	(
		SELECT
			count(*)
		FROM
			t_s_depart a
		WHERE
			a.parentdepartid = t.ID
	) state,
	t.or_not_store isstore
FROM
	t_s_depart t
<#if id ?exists>
WHERE 
	t.parentdepartid =:id 
<#else>
WHERE
	t.parentdepartid = ''
OR t.parentdepartid IS NULL
</#if>