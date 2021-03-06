<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="${ctx}/static/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/user.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="${ctx}/static/script/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/script/common.js"></script>
<script src="${ctx}/static/script/user.js" type="text/javascript"></script>
<script type="text/javascript">
    var ctx='${ctx}';
</script>
</head>
<body>
    <!-- 页面头部 -->
    <jsp:include page="/top.jsp">
        <jsp:param value="title" name="apply"/>
    </jsp:include>
<!--个人中心-->
<div class="wrapper wbgcolor">
      <!-- 个人消息列表 -->
    <jsp:include page="/personnal-left.jsp">
        <jsp:param value="pleft-cur" name="drawings"/>
    </jsp:include>
    <script>
        //<![CDATA[
            function showSpan(op){
                $("body").append("<div id='mask'></div>");
                $("#mask").addClass("mask").css("display","block");
    
                $("#"+op).css("display","block");
            }
    
            function displaySpan(op){
                $("#mask").css("display","none");
                $("#"+op).css("display","none");
            }
        //]]>
        </script>
    <script type="text/javascript">
        //<![CDATA[
            function checkActualMoney()
            {
                var actualMoney=Number($("#form\\:actualMoney").val());
                var actualMessage=$("#actualMoney_message");
                var nullFlag=actualMoney=="";
                if(nullFlag==true)
                {
                    $(actualMessage).text("请输入您要提现的金额");
                    $(actualMessage).show();
                    return false;
                }
                else
                {
                    $(actualMessage).hide();
                }
                var numberFlag=isNaN(actualMoney);
                if(numberFlag==true)
                {
                    $(actualMessage).text("提现金额必须为数字");
                    $(actualMessage).show();
                    return false;
                }
                else
                {
                    $(actualMessage).hide();
                }
                var legalFlag1=actualMoney>2;
                var legalFlag2=actualMoney<=500000;
                if(!legalFlag1||!legalFlag2)
                {
                    $(actualMessage).text("提现金额必须大于2.00 元，单笔不超过50 万");
                    $(actualMessage).show();
                    return false;
                }
                else
                {
                    $(actualMessage).hide();
                }
                //提现金额小数位
                var legalRegex="^(([1-9]+[0-9]*)|((([1-9]+[0-9]*)|0)\\.[0-9]{1,2}))$";
                var legalPattern=new RegExp(legalRegex);
                var legalFlag3=legalPattern.test(actualMoney);
                if(!legalFlag3)
                {
                    $(actualMessage).text("小数位最多两位!");
                    $(actualMessage).show();
                    return false;
                }
                else
                {
                    $(actualMessage).hide();
                }
                var balance=Number($("#form\\:blance")[0].innerHTML);
                //提现金额小于余额 
                var legalFlag=(actualMoney-balance).toFixed(2)<=0;
                if(!legalFlag)
                {
                    $(actualMessage).text("余额不足");
                    $(actualMessage).show();
                    return false;
                }
                else
                {
                    $(actualMessage).hide();
                }
                return true;
            }
            
            function amount(th){
                var regStrs = [
                    ['^0(\\d+)$', '$1'], //禁止录入整数部分两位以上，但首位为0
                    ['[^\\d\\.]+$', ''], //禁止录入任何非数字和点
                    ['\\.(\\d?)\\.+', '.$1'], //禁止录入两个以上的点
                    ['^(\\d+\\.\\d{2}).+', '$1'] //禁止录入小数点后两位以上
                ];
                for(i=0; i<regStrs.length; i++){
                    var reg = new RegExp(regStrs[i][0]);
                    th.value = th.value.replace(reg, regStrs[i][1]);
                }
                if(th.value>500000){
                    th.value = th.value.substr(0,th.value.length-1);
                }
            }
            //]]>
        
          //提现时计算提款费用
         function num_checked(){ 
        	 var money = $("#form\\:actualMoney").val();
             var cost = money*0.05;
             var cashFine = money-cost;
             var flag = money - 2;
             if(flag > 2 && cost < 2){
            	 $("#fee").text(2);  
                 $("#cashFine").text(flag);  
             }else{
                 $("#fee").text("最低2");
                 $("#cashFine").text(0);  
             }
             
             if(cost > 2 ){
                 $("#fee").text(cost);  
                 $("#cashFine").text(cashFine);  
             }
          }
        </script>
    <div class="personal-main">
      <div class="personal-deposit">
        <h3><i>提现</i></h3>
        <form id="form" name="form" method="post" action="${ctx}/drawings" enctype="application/x-www-form-urlencoded" >
          <input type="hidden" name="form" value="form">
          <div class="deposit-form" style="margin-top:0px;border-top:0px none;">
            <h6>填写提现金额</h6>
            <ul>
              <li> <span class="deposit-formleft">可用金额</span> <span class="deposit-formright"> <i>
                <label id="form:blance"> ${requestScope.usableMoney} </label>
                </i>元 </span> </li>
              <li> <span class="deposit-formleft">提现金额</span> <span class="deposit-formright">
                <input id="form:actualMoney" onkeyup="num_checked()" type="text" name="cashNumber" class="deposite-txt" maxlength="10">
                元 </span> <span id="actualMoneyErrorDiv"><span id="actualMoney_message" style="display:none" class="error"></span></span> </li>
              <li> <span class="deposit-formleft">提现费用</span> <em id="txfy" class="markicon fl"></em> <span class="deposit-formright deposit-formright1"> <i>
                <label id="fee"> 最低2</label>
                </i>元 </span> <span class="txarrow-show">提现金额的0.1%，最低不低于2元，最高100元封顶</span><span class="txicon-show"></span> </li>
              <li><span class="deposit-formleft">实际到账金额</span> <em id="dzje" class="markicon fl"></em> <span class="deposit-formright deposit-formright1"> <i>
                <label id="cashFine"> 0.00</label>
                </i> 元</span> <span class="dzarrow-show">提现金额 - 提现费用</span><span class="dzicon-show"></span> </li>
              <li>
                <input type="submit" name="form:j_idt78" value="提现" class="btn-depositok" onclick="return checkActualMoney()">
              </li>
            </ul>
          </div>
        </form>
        <div class="deposit-tip"> 温馨提示：<br>
          1、用户需在完成身份认证、开通丰付托管账户并绑定银行卡后，方可申请提现；<br>
          2、请务必在提现时使用持卡人与身份认证一致的银行卡号，且确保填写信息准确无误；<br>
          3、工作日当天16:00前提交的提现申请将在当天处理，默认为T+1到账；<br>
          4、提现金额单笔上限为50万元，单日累计总额不可超过100万元；<br>
          5、提现手续费为提现金额的0.1%，最低每笔2元，100元封顶，手续费由第三方托管账户收取，用户自行承担。<br>
        </div>
      </div>
    </div>
    <script type="text/javascript">
            $("#form\\:actualMoney").focus(
                       function(){
                            $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe"});
                           if($("#form\\:actualMoney").val() == value) { 
                                $("#form\\:actualMoney").val("")
                                $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
                           }
                        }).blur(
                        function(){
                           $(this).css("border","1px solid #D0D0D0");
                           if($("#form\\:actualMoney").val() == "") {
                                $(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal"});
                    }
                })
                
                function keyUpcheck()
                {
                    $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
                }
            </script>
    <div class="clear"></div>
  </div>
</div>
    <!--网站底部-->
    <%@include file="/foot.jsp" %>

</html>