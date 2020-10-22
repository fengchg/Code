select md.*,mds.name as specificationsCode,mds.id as specificationId from maro_dishes as md 
left join maro_dishes_specifications mds on md.id = mds.maro_dishes_id

<#if !userName>
	where md.sys_company_code = '0' or md.sys_company_code = :shopId
<#else>
	where 1=1 
</#if>

<#if maroDishes.sysCompanyCode ?? &&  maroDishes.sysCompanyCode != ''>
	and md.sys_company_code like '%${maroDishes.sysCompanyCode}%'
</#if>
<#if maroDishes.coding ?? && maroDishes.coding != ''>
	and md.coding like '%${maroDishes.coding}%'
</#if>
<#if maroDishes.dishesName ?? && maroDishes.dishesName != ''>
	and md.dishes_name like '%${maroDishes.dishesName}%'
</#if>
<#if maroDishes.pinyinCode ?? && maroDishes.pinyinCode != ''>
	and md.pinyin_code like '%${maroDishes.pinyinCode}%'
</#if>
<#if maroDishes.type ?? && maroDishes.type != ''>
	and md.type like '%${maroDishes.type}%'
</#if>
<#if maroDishes.dishesClassification ?? && maroDishes.dishesClassification != ''>
	and md.dishes_classification like '%${maroDishes.dishesClassification}%'
</#if>

ORDER BY md.create_date LIMIT :pageNo,:rowsNo