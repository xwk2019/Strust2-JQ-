function enableSubmit(bool) {

	if(bool) jQuery("#submit").removeAttr("disabled");

	else jQuery("#submit").attr("disabled", "disabled");

}
var flags = [false, false, false, false];

function v_submitbutton() {

	if(jQuery("#agree").attr("checked") != "checked") {

		enableSubmit(false);

		jQuery(".readagreement-wrap").css("outline", "1px solid red");

		return;

	} else { jQuery(".readagreement-wrap").css("outline", "1px solid #9f9"); }

	for(f in flags)
		if(!flags[f]) { enableSubmit(false); return; }

	enableSubmit(true);

}

function showAgreement() {

	jQuery("#readagreement").removeAttr("onclick");

	jQuery("#agreement").show();

	jQuery("#agreement iframe").attr("src", "http://www.baidu.com"); //此处为链接地址

}

function agree() {

	jQuery("#agreement").hide();

	jQuery("#readagreement").attr("onclick", "showAgreement();");

	if(jQuery("#agree").attr("checked") != "checked") jQuery("#agree").trigger("click");

}

function onReadAgreementClick() {

	return;

	if(jQuery("#agree").attr("checked")) {

		jQuery("#agree").removeAttr("checked");

	} else {

		jQuery("#agree").attr("checked", "checked");

	}

	v_submitbutton();

}





function lineState(name, state, msg) {

	if(state == "none") { jQuery("#line_" + name + " .input div").attr("class", "none"); return; }
	if(state == "corect") { jQuery("#line_" + name + " .input div").attr("class", "corect"); return; }
	jQuery("#line_" + name + " .input span").text(msg);
	jQuery("#line_" + name + " .input div").attr("class", "error");

}

function v_account() {
	var RegEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var account = jQuery("#account").val();
	if(!RegEmail.test(account)) {
		lineState("account", "error", "邮箱格式不正确");
		flags[0] = false;
		enableSubmit(false);
	} else {
		lineState("account", "corect", "");
		flags[0] = true;
	}

	v_submitbutton();

}

function v_name() {

	var name = jQuery("#userId").val();

	if(name.length == 0) { lineState("name", "error", "不得为空");
		flags[1] = false; } else {

		if(name.length > 32) { lineState("name", "error", "必须少于32个字符");
			flags[1] = false; } else { lineState("name", "corect", "");
			flags[1] = true; }

	}

	v_submitbutton();

}

function v_password() {

	var password = jQuery("#password").val();

	if(password.length < 6) { lineState("password", "error", "必须多于或等于6个字符");
		flags[2] = false; } else {

		if(password.length > 16) { lineState("password", "error", "必须少于或等于16个字符");
			flags[2] = false; } else {

			lineState("password", "corect", "");

			flags[2] = true;

		}

	}

	v_repeat();

	v_submitbutton();

}

function v_repeat() {

	if(!flags[2]) { lineState("repeat", "none", ""); return; }

	if(jQuery("#password").val() != jQuery("#repeat").val()) { lineState("repeat", "error", "密码不一致");
		flags[3] = false; } else {

		lineState("repeat", "corect", "");

		flags[3] = true;

	}

	v_submitbutton();

}

function adaptValue() {

	return true;

}