$(
	function(){
		/*
		 * 日期插件
		 */
		
		$('#birthday').datepicker();
		$('#birthday').datepicker( "option", "dateFormat","yy-mm-dd");
		
		/*
		 * 后台交互学校、院系、专业
		 */
		$.getJSON(
			'json/showSchools',
			function(data)
			{
				$.each(data,function(i,item){
					$('#school').append('<option value='+item.id+'>'+item.name+'</option>');
				});
		});
		
		$('#school').change(function(){
			var sc=$(this).val();
			$('#department').html('');
			$('#major').html('');
			$.getJSON(
				'json/showDepartments',
				{"sch_id":sc},
				function(json){
					$('#department').append('<option value="">&nbsp;</option>');
					$.each(json,function(i,dep){
						$('#department').append("<option value="+dep.id+">"+dep.name+"</option>");
	    			});
				}
			);
		});
    	$('#department').change(function(){
			var sc=$(this).val();
			$('#major').html('');
			$.getJSON(
				'json/showMajors',
				{"dep_id":sc},
				function(json){
					$('#major').append('<option value="">&nbsp;</option>');
					$.each(json,function(i,major){
						$('#major').append("<option value="+major.id+">"+major.name+"</option>");
	    			});
				}
			);
		});
    	
		/*
		 * 用户名验证
		 */
    	var flag = false;
    	$('#userName').focus(function(){
			$('#userNameMsg').html('3~12位不含非法字符').css('color','red');
		});
		$('#userName').blur(checkName);
		function checkName(){
			var username = $('#userName').val();
			if (username==null||username=='') {
				$('#userNameMsg').html('用户名不能为空').css('color','red');
				flag = false;
			}else if (!/^[a-zA-Z0-9\u4e00-\u9fa5]+$/.test(username)){
				$('#userNameMsg').html('3~12位不含非法字符').css('color','red')
				flag = false;
			} else {
				$.getJSON('json/checkStudentUserName',{'student.userName':username},aa);
			}
		}
		function aa(data){
			if(data) {  //可以注册
				$('#userNameMsg').html('OK').css('color','green');
				flag =  true;
			}else{  //不能注册
				$('#userNameMsg').html('用户名已存在').css('color','red');
				flag =  false;
			}	
		}
		/**
		 *密码验证 
		 */
		$('#password').focus(function(){
			var passwd = $('#password').val();
			if(passwd == '' || passwd.length < 6){
				$('#passwordMsg').html('请输入6~14位密码').css('color','red');
			}
		});
		$('#password').blur(function(){
			var password = $('#password').val();
			if(password == null || password == '')
			{
				$('#passwordMsg').html('密码不能为空').css('color','red');
			}else if(password.length >=6 && password.length < 15){
				$('#passwordMsg').html('OK').css('color','green');
			}else if(password.length <6 || password.length >14){
				$('#passwordMsg').html('请输入6~14位密码').css('color','red');
			}
		});
		$('#password').keyup(checkPwd);
		function checkPwd(){
			var password = $('#password').val();
			if(password.length < 6){
				$('#passwordMsg').html('请输入6~14位密码').css('color','red');
				return false;
			}
			else if(password.length >= 6 && password.length < 9)
			{
				$('#passwordMsg').html('弱').css('color','red');
				return true;
			}
			else if(password.length >= 9 && password.length < 12)
			{
				$('#passwordMsg').html('中').css('color','yellow');
				return true;
			}
			else if(password.length >= 12 && password.length <15)
			{
				$('#passwordMsg').html('强').css('color','green');
				return true;
			}	
			else if(password.length >14){
				$('#passwordMsg').html('密码长度超过了14位').css('color','red');
				return false;
			}
		}
		$('#rePassword').focus(function(){
			$('#pwdMsg1').html('');
		});
		$('#rePassword').blur(checkRepwd);
		function checkRepwd()
		{
			var repwd = $('#rePassword').val();
			var pwd = $('#password').val();
			if(repwd != pwd)
			{
				$('#rePasswordMsg').html('两次密码不一致').css('color','red');
				return false;
			}else if(repwd == pwd && repwd.length >= 6){
				$('#rePasswordMsg').html('OK').css('color','green');
				return true;
			}else {
				$('#rePasswordMsg').html('');
				return false;
			}
		}
		function checkNumber(){
			var number = $('#number').val();
			if(number==null||number==''){
				$('#numberMsg').html('学号不能为空').css('color','red');
				return false;
			}else if(!/^\d{1,11}$/.test(number)){
				$('#numberMsg').html('请输入有效学号').css('color','red');
				return false;
			}else {
				$('#numberMsg').html('');
				return true;
			}
		}
		$('#realName').blur(checkRealName);
		function checkRealName(){
			var realName = $('#realName').val();
			if(realName==null||realName==''){
				$('#realNameMsg').html('姓名不能为空').css('color','red');
				return false;
			}else if(!/^[\u4e00-\u9fa5]{2,5}$/.test(realName)){
				$('#realNameMsg').html('请输入真实姓名').css('color','red');
				return false;
			}else {
				$('#realNameMsg').html('');
				return true;
			}
		}
		function checkSchool(){
			var school = $('#school').val();
			if(school==null||school==''){
				$('#schoolMsg').html('请选择学校').css('color','red');
				return false;
			}else {
				$('#schoolMsg').html('');
				return true;
			}
		}
		function checkDep(){
			var department = $('#department').val();
			if(department==null||department==''){
				$('#depMsg').html('请选择院系').css('color','red');
				return false;
			}else {
				$('#depMsg').html('');
				return true;
			}
		}
		function checkMajor(){
			var major = $('#major').val();
			if(major==null||major==''){
				$('#majorMsg').html('请选择专业').css('color','red');
				return false;
			}else {
				$('#majorMsg').html('');
				return true;
			}
		}
		function checkDate(){
			var birthday = $('#birthday').val();
			if(birthday==null||birthday==''){
				$('#dateMsg').html('出生日期不能为空').css('color','red');
				return false;
			}else if(!/^\d{4}-\d{2}-\d{2}$/.test(birthday)){
				$('#dateMsg').html('格式不正确').css('color','red');
				return false;
			}else {
				$('#dateMsg').html('');
				return true;
			}
		}
		function checkAddress(){
			var address = $('#address').val().trim();
			if(address==null||address==''){
				$('#addressMsg').html('家庭住址不能为空').css('color','red');
				return false;
			}else if(!/^[a-zA-Z0-9\u4e00-\u9fa5\s]{10,40}$/.test(address)){
				$('#addressMsg').html('请输入有效地址').css('color','red');
				return false;
			}else {
				$('#addressMsg').html('');
				return true;
			}
			
		}
		function checkTelephone(){
			var telephone = $('#telephone').val();
			if(telephone==null||telephone==''){
				$('#telephoneMsg').html('号码不能为空').css('color','red');
				return false;
			}else if(!/^1[358]\d{9}$/.test(telephone)){
				$('#telephoneMsg').html('请输入有效号码').css('color','red');
				return false;
			}else {
				$('#telephoneMsg').html('');
				return true;
			}
			
		}
		function checkEmail(){
			var email = $('#email').val();
			if(email==null||email==''){
				$('#emailMsg').html('邮箱不能为空').css('color','red');
				return false;
			}else if(!/\w+([-+.]\w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*/.test(email)){
				$('#emailMsg').html('格式不正确').css('color','red');
				return false;
			}else {
				$('#emailMsg').html('');
				return true;
			}
			
		}
		$('input[type="submit"]').click(function(){
			if(flag&&checkPwd()&&checkRepwd()&&checkNumber()&&checkRealName()&&checkSchool()&&checkDep()&&checkMajor()&&checkDate()&&checkAddress()&&checkTelephone()&&checkEmail()){
				document.regForm.submit();
			}
		});
	}	
);