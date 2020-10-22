SELECT
	mp.printer_name,
    mp.printer_ip,
    mp.printer_port
FROM
	maro_printer mp,
	maro_printer_classification mpc
WHERE
	mp.id = mpc.printrt_id
AND mp.sys_company_code = :shopId
AND mpc.classification_id = :classificationId