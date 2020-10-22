select * from 
	t_s_base_user tsbu, 
	t_s_user tsu 
where 
	tsbu.id = tsu.id 
	and tsu.emp_no = :empNo
 