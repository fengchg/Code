select 
	md.coding,
  mds.ds_code,
	mds.unit_price,
  (
			select tst.typename from t_s_typegroup tstg ,t_s_type tst where tst.typegroupid = tstg.id and tstg.typegroupcode = 'maro_unit_name' and tst.typecode = md.unit
	)as unit,
  (select 1) munber
from 
	maro_dishes md,
  maro_dishes_specifications mds
where
	md.id = mds.maro_dishes_id
  and (md.sys_company_code = :company or md.sys_company_code = '0')
  and the_label like '%${code}%'

