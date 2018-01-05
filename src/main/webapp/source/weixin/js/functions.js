/**
 * Created by Administrator on 2017/5/16.
 */
function btnVerify4(btn, target) {

	$("input").on('input propertychange', function() {
		console.log($(target).val().length)
		var nickname = true;
		if ($(target).val() == "") {
			nickname = false;
			$(btn).addClass("undone");
		} else {
			$(btn).removeClass("undone");
			return true
		}

	});
	if ($(target).val().length > 0) {
		$(btn).removeClass("undone");
		return true
	}

}

/**
 * 输入框位数检验（没有初始值） 针对验证码是否高亮的输入框位数监听 just-btn - 验证码div
 * 
 * @param {target}
 *            需要验证的输入框
 * @param {btn}
 *            验证码class/id
 */

function NumVerify(target, btn) {
	/* 已有初始值 */
	if ($(target).val().length == 11) {
		$(btn).removeClass("undone");
	} else {
		$(btn).addClass("undone");
	}
	/* 实时监控 */
	$(target).on('input propertychange', function() {
		if ($(this).val().length == 11) {
			$(btn).removeClass("undone");
		} else {
			$(btn).addClass("undone");
		}
	});
}

/**
 * 手机号码验证
 * 
 * @param {target}
 *            需要验证的输入框
 */

function PhoneVerify(target) {
	if (!(/^1[34578]\d{9}$/.test(phone))) {
		return false;
	} else {
		return true;
	}
	/*
	 * var phonereg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; var
	 * phoneNum = $(target).val(); if(!phonereg.test(phoneNum)) { return false; }
	 * else { return true; }
	 */
}
/**
 * 验证码倒计时
 * 
 * @param {target}
 *            需要验证的输入框
 * @param {btn}
 *            验证码class/id
 */
function CountDown(target, btn) {
	$(btn).on("touchstart", function() {
		// var validCode = PhoneVerify(target);//手机号码验证
		var time = 120;
		var code = $(this)
		var phone = $("#phone").val();
		// var vertify = $("#vertify").val();
		var weixinid = $("#weixinid").val();
		/*
		 * if(vertify==null||vertify.length==0){ layer.msg("请输入验证码！"); return; }
		 */
		$.ajax({
			url : "/reg/weixin/smsSend.html",
			data : {
				"phone" : phone,
				"weixinid" : weixinid
			},
			dataType : "text",
			method : "post",
			success : function(res) {
				if (res != '0') {
					layer.msg(res);
					$("#er").html(res);
					$("#er").css("display", "block");
				}
			},
			error : function(res) {
				layer.msg("微信身份获取失败，请关闭页面重新打开！");
			}
		});
		validCode = false;
		code.addClass("undone").addClass("on");
		$(target).attr("disabled", "disabled");
		var t = setInterval(function() {
			time--;
			code.html(time + "秒");
			if (time == 0) {
				clearInterval(t);
				code.html("重新获取");
				validCode = true;
				code.removeClass("undone").removeClass("on");
				$(target).removeAttr("disabled");
			}
		}, 1000)

	})

}
$(function() {
	$("input").focus(function() {
		$('.txterror').hide();
	})
})
