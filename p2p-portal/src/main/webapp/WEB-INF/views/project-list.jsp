<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/top.jsp">
    <jsp:param value="title" name="investment"/>
</jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${ctx}/static/css/index.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/detail.css" rel="stylesheet" type="text/css">

</head>
<body>


<div class="page-filter wrap">
  <div class="breadcrumbs"><a href="index.html">首页</a>&gt;<span class="cur">散标投资列表</span></div>
  <div class="invest-filter" data-target="sideMenu">
    <div class="filter-inner clearfix">
      <div class="filter-item">
        <div class="hd">
          <h3>筛选投资项目</h3>
          <label>
          <input id="filterMulti" name="multiple_choice" type="checkbox">
          多选</label>
        </div>
        <div class="bd">
          <dl>
            <dt>项目类型</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('post_type','');" id="post_type_" class="active">不限</a></li>
                <li class="n2"><a href="javascript:url('post_type','car');" id="post_type_car">车易贷</a></li>
                <li class="n3"><a href="javascript:url('post_type','house');" id="post_type_house">房易贷</a></li>
                <li class="n4"><a href="javascript:url('post_type','bridge');" id="post_type_bridge">赎楼贷</a></li>
                <li class="n5"><a href="javascript:url('post_type','worth');" id="post_type_worth">债权贷</a> </li>
              </ul>
            </dd>
          </dl>
          <dl>
            <dt>年利率</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('borrow_interestrate','');" id="borrow_interestrate_" class="active">不限</a></li>
                <li class="n2"><a id="borrow_interestrate_1" href="javascript:url('borrow_interestrate','1');">12%以下</a> </li>
                <li class="n3"><a id="borrow_interestrate_2" href="javascript:url('borrow_interestrate','2');">12%-14%</a> </li>
                <li class="n4"><a id="borrow_interestrate_3" href="javascript:url('borrow_interestrate','3');">14%-16%</a> </li>
                <li class="n5"><a id="borrow_interestrate_4" href="javascript:url('borrow_interestrate','4');">16%及以上</a> </li>
              </ul>
            </dd>
          </dl>
          <dl>
            <dt>期限</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('spread_month','');" id="spread_month_" class="active">不限</a> </li>
                <li class="n2"><a id="spread_month_1" href="javascript:url('spread_month','1');">1月以下</a> </li>
                <li class="n3"><a id="spread_month_2" href="javascript:url('spread_month','2');">1-3月</a> </li>
                <li class="n4"><a id="spread_month_3" href="javascript:url('spread_month','3');">3-6月</a> </li>
                <li class="n5"><a id="spread_month_4" href="javascript:url('spread_month','4');">6-12月</a> </li>
                <li class="n6"><a id="spread_month_5" href="javascript:url('spread_month','5');">12月及以上</a> </li>
              </ul>
            </dd>
          </dl>
          <dl class="repayment">
            <dt>还款方式</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('repay_style','');" id="repay_style_" class="active">不限</a></li>
                <li class="n2"><a id="repay_style_end" href="javascript:url('repay_style','end');">到期还本付息</a> </li>
                <li class="n2"><a id="repay_style_endmonth" href="javascript:url('repay_style','endmonth');">按月付息,到期还本</a> </li>
                <li class="n2"><a id="repay_style_month" href="javascript:url('repay_style','month');">等额本息</a> </li>
              </ul>
            </dd>
          </dl>
        </div>
      </div>
      <div class="common-problem">
        <h3>常见问题</h3>
        <ul>
          <li><a href="#">什么是债权贷？</a></li>
          <li><a href="#">关于"债权贷"产品的说明</a></li>
          <li><a href="#">易贷网P2P理财收费标准</a></li>
          <li><a href="#">债权贷和房易贷、车易贷有什么区别？</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="invest-list mrt30 clearfix">
    <div class="hd">
      <h3>投资列表</h3>
      <div class="count">
        <ul>
          <li class="line">散标投资交易金额&nbsp;&nbsp;<span class="f20 bold">73.54亿元</span></li>
          <li>累计赚取收益&nbsp;&nbsp;<span class="f20 bold">2.52亿元</span></li>
        </ul>
      </div>
    </div>
    <div class="bd">
      <div class="invest-table clearfix">
        <div class="title clearfix">
         <table>
           <thead>
             <tr>
               
            <th><li class="col-330">借款标题</li></th>
            <th><li class="col-180"><a href="javascript:url('order','account_up');" class="">借款金额</a> </li></th>
            <th><li class="col-110"><a href="javascript:url('order','apr_up');" class="">年利率</a> </li></th>
            <th><li class="col-150"><a href="javascript:url('order','period_up');" class="">借款期限</a> </li></th>
            <th><li class="col-150">还款方式</li></th>
            <th><li class="col-120"><a href="javascript:url('order','scale_up');" class="">借款进度</a></li></th>
            <th><li class="col-120-t">操作</li></th>
             
             </tr>
           </thead>
        <!------------投资列表-------------->
           <tbody>
             <c:forEach items="#" var="project">
               <tr>
                 <td><li class="col-330 col-t"><a href="infor.html" target="_blank"><i class="icon icon-che" title="车易贷"></i></a><a class="f18" href="infor.html" title="赵女士长安福特福克斯汽车质押贷款4万元" target="_blank"> 赵女士长安福特福克斯汽车质... </a></li></td>
                 <td><li class="col-180"><span class="f20 c-333">40,000.00</span>元</li></td>
                 <td><li class="col-110 relative"><span class="f20 c-orange">12.00% </span></li></td>
                 <td><li class="col-150"> <span class="f20 c-333">1</span>个月 </li></td>
                 <td><li class="col-150">按月付息,到期还本</li></td>
                 <td><li class="col-120">
              <div class="circle">
                <div class="left progress-bar">
                  <div class="progress-bgPic progress-bfb5">
                    <div class="show-bar"> 50% </div>
                  </div>
                </div>
              </div>
            </li></td>
                <td><li class="col-120-2"> <a class="ui-btn btn-gray" href="infor.html">还款中</a></li></td>
               </tr>
             </c:forEach>
           </tbody>
         </table>
        </div>
        
       
      
    </div>
  </div>
</div>


<%@include file="/foot.jsp" %>
</body>
</html>