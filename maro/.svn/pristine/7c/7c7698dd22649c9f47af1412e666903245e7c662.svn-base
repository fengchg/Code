SELECT
  :shopId shopId,
	(SELECT a.`name` from maro_shop a where a.id=:shopId) shopName,
	t.id goodsId,
	t.material_name materialName,
	t.type type,
	t.denominated_unit unit,
	t.scattered scattered
FROM
	maro_material_class t
WHERE
	t.coding = :labelCode