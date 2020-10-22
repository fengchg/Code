$(function() {
	var rowNum = $("#rowNum").val();
	var options = $("#rowNumSel > option");
	if (rowNum == 5) {
		options[0].selected = "selected";
	} else if (rowNum == 10) {
		options[1].selected = "selected";
	} else {
		options[2].selected = "selected";
	}
	html = "<select id='pageSel' name='toPageNum_bottom' onchange='javascript:query(\"selPageGo\")'>"
			+ "\r\n";
	var size = $("#totalPages").val();
	var currentPage = $("#currentPage").val();
	for (i = 1; i <= size; i++) {
		if (currentPage == i) {
			html = html + "<option value=" + i + " selected='selected'>" + i
					+ "</option>" + "\r\n";
		} else {
			html = html + "<option value=" + i + ">" + i + "</option>" + "\r\n";
		}
	}
	html = html + "</select>";
	$(".go").append(html);

	$("#isAllCheck").click(
			function() {
				$("input[type='checkbox'][isDataItem='true']").attr("checked",
						this.checked);
			});
	var $subBox = $("input[type='checkbox'][isDataItem='true']");
	$subBox
			.click(function() {
				$("#isAllCheck")
						.attr(
								"checked",
								$subBox.length == $("input[type='checkbox'][isDataItem='true']:checked").length ? true
										: false);
			});
});
function myConfirm(msg) {
	$(document.body).fadeTo("fast", 0.26, function() {
		if (confirm(msg)) {
			$(document.body).fadeTo("fast", 1);
			return true;
		} else {
			$(document.body).fadeTo("fast", 1);
			return false;
		}
	});
}
function myAlert(msg) {
	$(document.body).fadeTo("fast", 0.26, function() {
		alert(msg);
		$(document.body).fadeTo("fast", 1);
	});
}
function deleteSingle(action) {
	var isDelete = confirm("真的要删除该数据?");
	if (isDelete) {
		submitForm(action);
	}
}
function query(operation) {
	if (operation == "query") {
		$("#currentPage").val(1);
		submitForm();
	} else if (operation == "selectRowNum") {
		var rowNum = $("#rowNumSel").val();
		$("#rowNum").val(rowNum);
		$("#currentPage").val(1);
		submitForm();
	} else {
		var currentPage = $("#currentPage").val();
		var num = 0;
		if (operation == "first") {
			num = 1;
		} else if (operation == "pre") {
			num = currentPage - 1;
		} else if (operation == "next") {
			num = parseInt(currentPage) + 1;
		} else if (operation == "selPageGo") {
			num = $("#pageSel").val();
		} else if (operation == "last") {
			num = $("#totalPages").val();
		}
		if (num > 0 && num <= $("#totalPages").val()) {
			$("#currentPage").val(num);
			submitForm();
		}
	}
}
function deleteMore(action) {
	var size = $("input[type='checkbox'][isDataItem='true']:checked").length;
	if (size > 0) {
		var isDelete = confirm("真的要删除该数据?");
		if (isDelete == true) {
			submitForm(action);
		}
	} else {
		alert("请选择要删除的数据!");
	}
}

function submitForm(action){
	var oldAction = "";
	if(action != null && action != ""){
		oldAction = $("form").attr("action");
		$("form").attr("action",action);
	}
	$("form").submit();
	if(oldAction != ""){
		$("form").attr("action",oldAction);
	}
}