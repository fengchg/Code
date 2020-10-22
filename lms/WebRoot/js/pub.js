//短日期格式验证，形如 (2003-12-05)
function strDateTime(str)
{
var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
if(r==null)return false;
var d= new Date(r[1], r[3]-1, r[4]);
return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
}