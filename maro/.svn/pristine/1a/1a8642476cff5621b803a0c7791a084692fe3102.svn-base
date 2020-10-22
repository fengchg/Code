select 
  (select ms.name from maro_shop ms where ms.id = :shopId) shop_name,
  IFNULL((select sum(mcs1.collected_amount) from maro_client__serverorder mcs1 where mcs1.restaurant_id = :shopId and DATE_FORMAT(FROM_UNIXTIME(mcs1.begin_time / 1000,'%Y-%m-%d'),'%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d')),0) today,
	IFNULL((select sum(mcs1.collected_amount) from maro_client__serverorder mcs1 where mcs1.restaurant_id = :shopId and YEARWEEK(FROM_UNIXTIME(mcs1.begin_time / 1000,'%Y-%m-%d'),'%Y-%m-%d') = YEARWEEK(NOW(),'%Y-%m-%d')),0) this_week,
	IFNULL((select sum(mcs1.collected_amount) from maro_client__serverorder mcs1 where mcs1.restaurant_id = :shopId and date_format(FROM_UNIXTIME(mcs1.begin_time / 1000,'%Y-%m-%d'),'%Y-%m') = date_format(NOW(),'%Y-%m')),0) this_month
