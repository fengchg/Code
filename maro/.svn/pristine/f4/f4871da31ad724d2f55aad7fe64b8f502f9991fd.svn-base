SELECT
	t.buy_dishes_id buyid,
	(
		SELECT
			dishes_name
		FROM
			maro_dishes
		WHERE
			id = t.buy_dishes_id
	) buyname,
	t.buy_number buynum,
	t.buy_specifications_id buyspecificationid,
	(
		SELECT
			b.typename
		FROM
			t_s_typegroup a,
			t_s_type b
		WHERE
			a.ID = b.typegroupid
		AND a.typegroupcode = 'maro_specifications'
		AND b.typecode = (
			SELECT
				NAME
			FROM
				maro_dishes_specifications c
			WHERE
				c.id = t.buy_specifications_id
		)
	) buyspecificationname,
	t.free_dishes_id freeid,
	(
		SELECT
			dishes_name
		FROM
			maro_dishes
		WHERE
			id = t.free_dishes_id
	) freename,
	t.free_number freenum,
	t.free_specifications_id freespecificationid,
	(
		SELECT
			b.typename
		FROM
			t_s_typegroup a,
			t_s_type b
		WHERE
			a.ID = b.typegroupid
		AND a.typegroupcode = 'maro_specifications'
		AND b.typecode = (
			SELECT
				NAME
			FROM
				maro_dishes_specifications c
			WHERE
				c.id = t.free_specifications_id
		)
	) freespecificationname,
	t.is_add
FROM
	maro_special_offer t
WHERE
	t.is_enable IS NULL
OR t.is_enable = 'Y'