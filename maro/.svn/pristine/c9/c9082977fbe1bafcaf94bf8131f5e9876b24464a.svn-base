SELECT
	b.${id_field_name} id ,b.${pid_field_name} pid ,b.${tree_field} text,
	(
		SELECT
			count(*)
		FROM
			${table_name} a
		WHERE
			a.${pid_field_name} =b.${id_field_name}
	) state
FROM
	${table_name} b
<#if id ?exists>
WHERE b.${pid_field_name} =:id
</#if>
