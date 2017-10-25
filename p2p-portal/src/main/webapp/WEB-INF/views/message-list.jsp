<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="page" uri="http://weborder.qhcs.com/tags/pager" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<style type="text/css">
.row-1{
	display: inline-flex;
}
button,select{
	margin: 5px 50px;
	padding:0px 27px;
    height: 35px;
    background-color: rgba(80, 133, 152, 0.88);
    border-radius: 5px;
    border: 1px solid black;
}
.choiceButtun{
	background-color: rgb(126, 231, 234);
}
th{
	height:50px;
}
table{
	text-align: center;
}


</style>

</head>
<body>
    <!-- 页面头部 -->
    <jsp:include page="/top.jsp">
        <jsp:param value="title" name="apply"/>
    </jsp:include>
<!--个人中心-->
<div class="wrapper wbgcolor">
            <div class="w1200 personal">
                <div class="credit-ad"><img src="images/clist1.jpg" width="1000" height="80"></div>
                
                <div id="personal-left" class="personal-left">
                    <ul>
                        <li><span><a href="#"><i class="dot dot01"></i>账户总览</a></span></li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">资金记录</a></span></li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">投资记录</a></span></li>
                        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="#">回款计划</a></span></li>
                        <li><span><a href="#"><i class="dot dot02"></i>开通第三方</a>
                            </span>
                        </li>
                        <li class="pleft-cur"><span><a href="${ctx}/toPay"><i class="dot dot3"></i>充值</a></span></li>
                        <li><span><a href="#"><i class="dot dot04"></i>提现</a></span></li>
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
                        <li><span><a href="#"><i class="dot dot09"></i>账户设置</a></span></li>
                    </ul>
                </div><label id="typeValue" style="display:none;"></label>
            <div class="personal-main">
      <div class="personal-xtxx">
        <h3><i>系统消息</i></h3>
         
         <div class="page-content">
			<div class="col-xs-12">
				<div class="table-responsive">
					<div id="sample-table-2_wrapper" class="dataTables_wrapper"
						group="grid">
						<div class="row-1">
							<div hidden="hidden">
								<form id="listForm" name="form" method="post" action="${ctx }/message/list">
						          <input type="hidden" name="messageStatus" id ="status" value="">
								</form>
							</div>
							<div >
								<button onclick="listFormSubmit(null)"
								<c:if test="${status != 0 and status != 1 }">
								class="choiceButtun" 
								</c:if>
								>全部</button>
							</div>
							<div >
								<button 
								<c:if test="${status == 0 }">
								class="choiceButtun" 
								</c:if>
								onclick="listFormSubmit(0)">未读</button>
							</div>
							<div >
								<button 
								<c:if test="${status == 1 }">
								class="choiceButtun" 
								</c:if>
								onclick="listFormSubmit(1)">已读</button>	
							</div>
							
							<div >
								<select style="margin-right: 0px;border-radius:5px 0px 0px 5px ">
								  <option value ="readgroup"> 全部设为已读</option>
								  <option value ="unreadgroup"> 全部设为未读</option>
								  <option value="delgroup"> 批量删除</option>
								</select>
								<a href="javaScript:;" style="height: 33px; background-color: rgba(80, 133, 152, 0.88);border: 1px solid black;border-radius:0px 5px 5px 0px;margin-left: -5px;line-height: 34px;display: inline-block;padding:0px 5px" id="action">执行</a>
                            </div>
						</div>
						<form action="" method="post" id="batchForm">
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover dataTable"
							aria-describedby="sample-table-2_info">
							<thead class="theadClass">
								<tr group="row">
									<th  style="width: 106px;"><label>
									<input type="checkbox"    id="choose_group" > <span class="lbl"></span>
									</label></th>

									<th style="width: 98px;" >消息类型</th>
									<th style="width: 458px;" >内容</th>
									<th style="width: 179px;">消息状态</th>
									<th style="width: 179px;">发送时间</th>
								</tr>
							</thead>
							<tbody group="alert" aria-live="polite" aria-relevant="all" id="group_content">
								<c:if test="${pageInfo.list.size()==0 }">
									<tr class="odd">
										<td colspan="6" class="center">没有查询道任何数据...</td>
									</tr>
								</c:if>
								<c:forEach items="${pageInfo.list }" var="message">
									<tr class="odd">
										<td class="center  sorting_1">
										<label> 
										<c:if test="${message.messageStatus == 0}">
										<input type="checkbox" class="ace" name="lists" value="${message.messageId }"> <span class="lbl"></span>
										</label>
										<a href='${ctx}/message/batchRead?lists=${message.messageId }&messageStatus=1&userId=${loginUser.userId}'>
										<svg t="1508732730705" class="icon" style="" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6618" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20">
										<path d="M869.539604 344.621898l-716.314339 0c-42.318828 0-76.747965 34.429137-76.747965 76.747965l0 460.487789c0 42.318828 34.429137 76.747965 76.747965 76.747965l716.314339 0c42.318828 0 76.747965-34.429137 76.747965-76.747965l0-460.487789C946.287569 379.051035 911.859455 344.621898 869.539604 344.621898zM127.64261 881.857653 127.64261 431.17723l225.961358 225.961358-0.215918 0L127.668193 882.858446C127.65489 882.525871 127.64261 882.193297 127.64261 881.857653zM164.61057 395.787208l693.542706 0L511.382435 742.559073 164.61057 395.787208zM389.675512 693.210132l121.707946 121.707946 122.325-122.325L848.554664 907.440307 175.445336 907.440307 389.675512 693.210132zM670.612972 657.138588l-1.451048 0 225.960335-225.961358 0 450.472692L670.612972 657.138588z" fill="#07f5f9" p-id="6619"></path>
										</svg>
										</a>
										</c:if>
										<c:if test="${message.messageStatus == 1}">
										<input type="checkbox" class="ace" name="lists" value="${message.messageId }"> <span class="lbl"></span>
										</label>
										<svg t="1508932051156" class="icon" style="" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="9116" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20">
										<defs><style type="text/css"></style></defs><path d="M883.2 403.2l-166.4-115.2L716.8 256l-38.4 0L512 140.8 486.4 160l0 0L345.6 256 307.2 256l0 25.6L140.8 403.2 128 403.2l0 480L896 883.2 896 403.2 883.2 403.2zM832 403.2 832 448l-108.8 51.2L723.2 326.4 832 403.2zM691.2 288 691.2 512 512 588.8 332.8 505.6 332.8 300.8 332.8 288l19.2 0L691.2 288zM512 179.2 627.2 256 396.8 256 512 179.2zM307.2 326.4l0 166.4L256 473.6l-64-25.6L192 403.2l0 0L307.2 326.4zM179.2 486.4l192 89.6-192 224L179.2 486.4zM217.6 832l198.4-236.8L505.6 640c0 0 0 0 0 0 0 0 6.4 0 6.4 0 0 0 6.4 0 6.4 0 0 0 0 0 0 0l89.6-44.8 198.4 236.8L217.6 832zM844.8 800 659.2 576l185.6-89.6L844.8 800z" p-id="9117" fill="#aae0a7"></path>
										<path d="M390.4 364.8l160 0c6.4 0 12.8-6.4 12.8-12.8S563.2 332.8 550.4 332.8L390.4 332.8C384 332.8 377.6 339.2 377.6 345.6S384 364.8 390.4 364.8z" p-id="9118" fill="#aae0a7"></path>
										<path d="M390.4 454.4l224 0c6.4 0 12.8-6.4 12.8-12.8l0 0c0-6.4-6.4-12.8-12.8-12.8L390.4 428.8C384 422.4 377.6 428.8 377.6 435.2l0 0C377.6 448 384 454.4 390.4 454.4z" p-id="9119" fill="#aae0a7"></path>
										</svg>
										</c:if>
										</td>
										<td class=" ">
										<c:if test="${message.messageType == 0 }">公司公告</c:if>
            							<c:if test="${message.messageType == 1 }">个人通知</c:if>
            							</td>
										<td class=" ">${message.messageContent}</td>
										<td class=" ">
										<c:if test="${message.messageStatus == 0 }">未读</c:if>
            							<c:if test="${message.messageStatus == 1 }">已读</c:if>
            							</td>
										<td class=" ">
										<fmt:formatDate value="${message.messageModificationTime}" pattern="yyyy-MM-dd"/>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</form>
					</div>

				</div>
			</div>
		</div>
    </div>
                <div class="clear"></div>
            </div>
        </div>
    <!--网站底部-->
    <%@include file="/foot.jsp" %>
</body>
<script type="text/javascript">
// 全部、未读、已读的onclick事件
function listFormSubmit(status){
	$("#status").val(status);
	$("#listForm").submit();
}


//		全选
	$("#choose_group").click(function(){
        var checked = this.checked;
        $("#group_content input:checkbox").prop("checked",checked);
    })
    
    
    // 批量删除
    $("#action").click(function(){
    	if($("select").val() == "delgroup"){
    	 if($("#group_content input:checked").length==0){
    	        alert("请至少选中一条数据!");
    	        return;
    	    }
    		if(confirm("确定要删除吗?")){
    	    	$("#batchForm").attr("action","${ctx}/message/batchDel")
    	        $("#batchForm").submit();
    	        }
    	    }
    })
    // 全部设为已读
    $("#action").click(function(){
    	if($("select").val() == "readgroup"){
    	 if($("#group_content input:checked").length==0){
    	        alert("请至少选中一条数据!");
    	        return;
    	    }
    		if(confirm("确定要全部设已读吗?")){
    	    	$("#batchForm").attr("action","${ctx}/message/batchRead?messageStatus=1&userId="+'${loginUser.userId}')
    	        $("#batchForm").submit();
    	        }
    	    }
    })
    // 全部设为未读
    $("#action").click(function(){
    	if($("select").val() == "unreadgroup"){
    	 if($("#group_content input:checked").length==0){
    	        alert("请至少选中一条数据!");
    	        return;
    	    }
    		if(confirm("确定要全部设未读吗?")){
    	    	$("#batchForm").attr("action","${ctx}/message/batchRead?messageStatus=0&userId="+'${loginUser.userId}')
    	        $("#batchForm").submit();
    	        }
    	    }
    })

    
    // 选中有蓝色
    $("button").click(function(){
    	$("button").attr("class","");
    	$(this).attr("class","choiceButtun");
    })
</script>

</html>