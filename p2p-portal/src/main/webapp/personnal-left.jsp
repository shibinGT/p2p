<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
   <div class="w1200 personal">
                <div class="credit-ad"><img src="${ctx}/static/images/clist1.jpg" width="1200" height="80"></div>
                <div id="personal-left" class="personal-left">
                    <ul>
                        <li><span><a href="${ctx }/user/userIndex"><i class="dot dot01"></i>账户总览</a></span></li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">资金记录</a></span></li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">投资记录</a></span></li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">回款计划</a></span></li>
                        <li><span><a href="#"><i class="dot dot02"></i>开通第三方</a>
                            </span>
                        </li>
                        <li class="${param.pay} "><span><a href="${ctx}/toPay"><i class="dot dot3"></i>充值</a></span></li>
                        <li class="${param.drawings}"><span><a href="${ctx}/toDrawings"><i class="dot dot04 "></i>提现</a></span></li>
                        <li style="position:relative;">
                            <span>
                                <a href="#">
                                <i class="dot dot06"></i>
                                我的红包
                                 
                                </a>
                            </span>
                        </li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">兑换历史</a></span></li>
                            <li><span><a href="#"><i class="dot dot07"></i>自动投标</a></span></li>
                         
                        
                        <li style="position:relative;">
                            <span>
                                <a href="#"><i class="dot dot08"></i>系统信息
                                     
                                </a>
                            </span>
                        </li>
                        <li><span><a href="${ctx }/user/userSettings"><i
								class="dot dot09"></i>账户设置</a></span></li>
                    </ul>
                </div>
                <label id="typeValue" style="display:none;"></label>
                <script type="text/javascript">
                $(function(){
                    $('.quick-tit').click(function(){
                      
                      $(this).addClass('pay-cur');
                      $(this).siblings().removeClass('pay-cur');
                      $('.quick-main').show();
                      $('.online-main').hide();
                      
                      $(".pay-tipcon").hide();
                      $(".pay-tipcon2").show();

                    })

                    $('.online-tit').click(function(){
                      
                      $(this).addClass('pay-cur');
                      $(this).siblings().removeClass('pay-cur');
                      $('.quick-main').hide();
                      $('.online-main').show();

                      $(".pay-tipcon2").hide();
                      $(".pay-tipcon").show();
                    })
              });
                </script>
</body>

</html>