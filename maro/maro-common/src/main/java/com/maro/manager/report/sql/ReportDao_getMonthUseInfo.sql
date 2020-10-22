SELECT
	SUM(t.number) / 10 avgnum,
	t.goods_id classId
FROM
	maro_store_flow t
WHERE
	t.create_date > (
		SELECT
			date_sub(curdate(), INTERVAL 10 DAY)
	)
AND t.goods_id IN (
<#list ids as id>
  '${id}',
</#list>
''
)
GROUP BY
	t.goods_id;