
(function(){
function k(c,d,b){
	var a="on"+d;
	if(c.addEventListener)c.addEventListener(d,b,false);
	else if(c.attachEvent)c.attachEvent(a,b);
	else{var f=c[a];c[a]=function(){
	var g=f.apply(this,arguments),e=b.apply(this,arguments);
	return g==undefined?e:(e==undefined?g:e&&g)}}};
	//var l="../css/css_default/img/toolbar_animation_20070919.gif",m=52,n=37,o=75,p=100;  
function q(c,d,b,a,f){return{url:c,name:d,tooltip:b,color:a,yAdjust:f}}
var r=[],s=[];
if(currentSubsystem.indexOf('business')>=0){
	r[r.length]=q("myFlash_DoFSCommand('business')","\u9879\u76ee\u7ba1\u7406","\u79D1\u7814\u5DE5\u4F5C\uFF0C\u8F7B\u677E\u7BA1\u7406","#000",[2,5]);
}
if(currentSubsystem.indexOf('business')>=0){
	r[r.length]=q("myFlash_DoFSCommand('product')","成果知识库","\u79D1\u7814\u5DE5\u4F5C\uFF0C\u8F7B\u677E\u7BA1\u7406","#000",[2,5]);
}
if(currentSubsystem.indexOf('business')>=0){
	r[r.length]=q("myFlash_DoFSCommand('activity')","科研办公","\u79D1\u7814\u5DE5\u4F5C\uFF0C\u8F7B\u677E\u7BA1\u7406","#000",[2,5]);
}
if(currentSubsystem.indexOf('business')>=0){
	r[r.length]=q("myFlash_DoFSCommand('personnel_management')","\u4eba\u529b\u8d44\u6e90","\u79D1\u7814\u5DE5\u4F5C\uFF0C\u8F7B\u677E\u7BA1\u7406","#000",[2,5]);
}
/*Split before
if(currentSubsystem.indexOf('business')>=0){
	r[r.length]=q("myFlash_DoFSCommand('business')","\u4E1A\u52A1\u7BA1\u7406","\u79D1\u7814\u5DE5\u4F5C\uFF0C\u8F7B\u677E\u7BA1\u7406","#000",[2,5]);
}*/
if(currentSubsystem.indexOf('website')>=0){
	r[r.length]=q("myFlash_DoFSCommand('website')","\u79D1\u7814\u95E8\u6237","\u4FE1\u606F\u516C\u544A\uFF0C\u53CA\u65F6\u4F20\u9012","#000",[2,5]);
}
if(currentSubsystem.indexOf('assess')>=0){
	r[r.length]=q("myFlash_DoFSCommand('assess')","\u8BC4\u4F30\u51B3\u7B56","\u8003\u6838\u6D25\u8D34\uFF0C\u51B3\u7B56\u534F\u52A9","#000",[2,5]);
}
/*if(currentSubsystem.indexOf('maintain')>=0){
	r[r.length]=q("myFlash_DoFSCommand('maintain')","\u4FDD\u969C\u5E73\u53F0","\u7CFB\u7EDF\u652F\u6491\uFF0C\u7A33\u5B9A\u5B89\u5168","#000",[2,5]);
}*/
function t(c,d){while(d&&c!=d)d=d.parentNode;return d==c}
function v(c,d){

   return function(b){
	b=b||window.event;
	var a=s[d],
	f=c=="mouseover",
	g=b.target||b.srcElement,
	e=b.relatedTarget||(f?b.fromElement:b.toElement),
	h=!e||t(a.element,e),i=t(a.element,g);
	if(f&&!h||!f&&(!e||i&&!h)){
 	 var j=a.icon;j.mouseTimeout=window.clearTimeout(j.mouseTimeout);
 	 var u=f?1:-1;if(j.b!=u)j.mouseTimeout=window.setTimeout(j.e(u,undefined),f?p/3:p)}}}
function w(c,d,b){k(c,d,v(d,b))}
function x(c,d,b){
	this.c=c;
	var a=document.createElement("div"),
	f=c.color,g="background-color:"+f,
	e="width:1px;height:1px;"+g+";float:",
	h='<div style="height:0px;overflow:hidden"><div style="'+e+'left"></div><div style="'+e+'right"></div></div>',
	i="margin:0 1px;height:1px;overflow:hidden;"+g;a.innerHTML='<div style="display:none;position:absolute;top:0;left:0;z-index:2;background:none;cursor:pointer;cursor:hand"><a href="'+d+'" style="color:#444;text-decoration:none" target=_blank><div style="'+i+'"></div><div style="text-align:center;border-left:1px solid;border-right:1px solid;border-color:'+
f+'">'+h+'<div style="margin:0 auto;white-space:nowrap;padding:.2em 0 0"><span>'+b+"</span></div>"+h+'</div><div style="'+i+'"></div><div style="height:0px" align="center"><div style="position:relative;top:-1px;z-index:3;width:8px;overflow:hidden;margin:0 auto;height:0px;background:no-repeat -260px '+-c.spriteCoordinateList[0].y+'px"></div></div></a></div>';
	this.h=a.getElementsByTagName("span")[0];
	document.body.appendChild(a);a.firstChild.firstChild.lastChild.firstChild.style.backgroundImage="url("+l+")";
	this.element=a.firstChild;
	var j=s.length;s.push({icon:c,element:this.element});
		w(this.element,"mouseover",j);w(this.element,"mouseout",j)}
x.prototype.play=function(c){
	var d=this.c.element.firstChild,b={left:-d.offsetLeft,top:0};
    while(d){b.left+=d.offsetLeft;b.top+=d.offsetTop;d=d.offsetParent}
    var a=this.element.style;
    if(a.display=="none"){a.visibility="hidden";a.display="block"}
    var f=this.element.offsetHeight,g=this.h.offsetWidth+14;
    if(a.visibility=="hidden"){a.display="none";a.visibility="visible"}
    a.width=g+"px";
    b.left-=(g-this.c.element.parentNode.offsetWidth)/2;
    b.top-=f-3;b.top+=20*Math.pow(1-c/this.c.frames,3);
    a.left=b.left+"px";a.top=b.top+"px";
    if(c==0||this.c.b<0)a.display="none";
    else{
     a.display="";
     var e=c/this.c.frames;
     if("opacity"in a)a.opacity=e;
     	else if("MozOpacity"in a)a.MozOpacity=e;
     	else if("KhtmlOpacity"in a)a.KhtmlOpacity=e;
     	else if("filter"in a)a.filter="alpha(opacity="+e*100+")"}};
function y(c,d,b,a,f){
	this.element=c;
	this.mouseTimeout=null;
	this.frames=d.length-1;this.spriteCoordinateList=d;
	this.color=b;
	this.d=null;
	this.g=c.getElementsByTagName("div")[1];
	this.i=new x(this,a,f);
	this.b=-1;
	this.a=1;
	var g=s.length;s.push({icon:this,element:c});
		w(c,"mouseover",g);
		w(c,"mouseout",g)}
y.prototype.e=function(c,d){var b=this;return function(){b.f(c,d)}};
y.prototype.f=function(c,d){
	if(c){
		this.b=c;
		this.mouseTimeout=window.clearTimeout(this.mouseTimeout);
		this.d=window.clearTimeout(this.d)}
	if(typeof d!="undefined")
		this.a=d;
	    var b=this.spriteCoordinateList[this.a];
	    this.g.style.backgroundPosition=-b.x+"px "+-b.y+"px";
	    this.i.play(this.a);
	    var a=this.element.style;
	    if(this.b<0){a.color="#444";a.textDecoration="none"}
	    else{a.color=this.color;a.textDecoration="underline"}
	    this.a+=this.b;
	    if(this.a>this.frames)this.a=this.frames-1;else if(this.a<0)this.a=1;
	    else this.d=window.setTimeout(this.e(undefined,undefined),o)};
k(window,"load",function(){
  try{document.execCommand("BackgroundImageCache",false,true)}
  catch(c){}
  var d='<table style="margin:2em auto;border-collapse:collapse;line-height:1.4em" cellpadding="3" cellspacing="2" border="0" ><tr>';
  for(var b=0;b<r.length;++b){
    var a=r[b];
    a.url=encodeURIComponent(a.url);
//    a.url="/url?ct=pro&cd="+b+"&source=cwh&q="+encodeURIComponent(a.url);
  	var f=[],g=n*b;
  	for(var e=0;e<7;++e)
  	if(e>4)f.push({x:m*4,y:g-a.yAdjust[e-5]});
  	else f.push({x:m*e,y:g});
  	a.coordinates=f;d+='<td style="text-align:center;padding:0 .35em 0 .4em;margin:0;cursor:pointer;cursor:hand"><a style="color:#444;text-decoration:none;" href="javascript:'+a.url+'" ><div><div style="width:52px;height:37px;margin:.5em auto;cursor:pointer;cursor:hand;background: no-repeat 0 '+
-g+'px"></div><span style="white-space:nowrap">'+a.name+"</span></div></a></td>"}
  d+="</tr></table>";
  var h=document.getElementById("topnav");
  h.innerHTML=d;
  var i=h.getElementsByTagName("a");
  for(var b=0;b<i.length;++b){i[b].firstChild.firstChild.style.backgroundImage="url("+l+")";
  new y(i[b],r[b].coordinates,r[b].color,r[b].url,r[b].tooltip)}});
})();
