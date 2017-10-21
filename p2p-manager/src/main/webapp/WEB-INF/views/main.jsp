<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 

<%@ include file="/base.jsp" %>
<%@ include file="/top.jsp" %>
<%@ include file="/left-beforepage.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台管理系统</title>
		<meta name="keywords" content="后台管理" />
		<meta name="description" content="后台管理" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${ctx}/static/assets/css/index.css" />
		<link rel="stylesheet" href="${ctx}/static/assets/css/common.css" />
		<script src="${ctx }/static/assets/js/echarts.common.min.js"></script>
		
	</head>

	<body>
		<div id="index">
		<!-- 平台数据 -->
		<div id="investInfo">
		
		<div class="ipubs"><span class="o1">平台成交总额:<strong>
			<fmt:formatNumber value="${total}" pattern="#,###.##"/>
		</strong>元</span> <span class="o2">今日投资:<strong>400,507,750.81</strong>元</span><span class="o2">余额:<strong>677,679,983.07</strong>元</span><span class="o4">今日投资金额:<strong>20649</strong>￥</span></div>
		</div>
		
		<!-- 近期还款 -->
		<div class="mod-borrow">
        <div class="hd">
          <h2 class="pngbg"><i class="icon icon-ttyx"></i>即将到期</h2>
        </div>
        <div class="bd">
          <div class="des"><span class="fn-left">7天内应还款项共计<span class="f24 c-orange">7</span>项</span><a href="list.html" class="fn-right">提醒还款&gt;&gt;</a></div>
          <div class="borrow-list">
            <ul>
              <li>
                <div class="title"><a href="infor.html" target="_blank"><i class="icon icon-zhai" title="债权贷"></i></a><a href="infor.html" class="f18" title="金女士债权质押借款1万元" target="_blank">金女士债权质押借款1万元</a></div>
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tbody>
                    <tr>
                      <td width="260">借款金额<span class="f24 c-333">10000.00</span>元</td>
                      <td width="165">年利率<span class="f24 c-333">10.70% </span></td>
                      <td width="180" align="center">期限<span class="f24 c-orange">4</span>天</td>
                      <td><div class="circle">
                          <div class="left progress-bar">
                            <div class="progress-bgPic progress-bfb5">
                              <div class="show-bar"> 56.3% </div>
                            </div>
                          </div>
                        </div></td>
                      <td align="right"><a class="ui-btn btn-gray" href="#">还款中</a> </td>
                    </tr>
                  </tbody>
                </table>
              </li>
              <li>
                <div class="title"><a href="infor.html" target="_blank"><i class="icon icon-zhai" title="债权贷"></i></a><a href="infor.html" class="f18" title="周先生债权质押借款0.1万元" target="_blank">周先生债权质押借款0.1万元</a></div>
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tbody>
                    <tr>
                      <td width="260">借款金额<span class="f24 c-333">1000.00</span>元</td>
                      <td width="165">年利率<span class="f24 c-333">10.85% </span></td>
                      <td width="180" align="center">期限<span class="f24 c-orange">7</span>天</td>
                      <td><div class="circle">
                          <div class="left progress-bar">
                            <div class="progress-bgPic progress-bfb1">
                              <div class="show-bar"> 10.07% </div>
                            </div>
                          </div>
                        </div></td>
                      <td align="right"><a class="ui-btn btn-gray" href="#">还款中</a> </td>
                    </tr>
                  </tbody>
                </table>
              </li>
            </ul>
          </div>
        </div>
      </div>
		
		<!-- 注册人数图表 -->
		<div style="width: 600px;height:400px;"><div id="main" style="width: 600px;height:400px;"></div><div id="cover"></div></div>
			<!-- 图表脚本 -->
		<script type="text/javascript">
		    // 基于准备好的dom，初始化echarts实例
		   
		   // $.ajax({url:"demo_test.txt",success:function(data){ 
		    	
		    	var data = eval(${jsonStr});
		    	initChat(data);
		    	
		    
		   // }}); 
	        
		    
		    
		    /*
		    *渲染图表
		    */
	       function initChat(data){
	    	   var myChart = echarts.init(document.getElementById('main'));
	   		
			    // 指定图表的配置项和数据
			     
			
				
				var dateList = data.map(function (item) {
				    return item[0];
				});
				 var valueList = data.map(function (item) {
				    return item[1];
				}); 
				
				option = {
				
				    // Make gradient line here
				    visualMap: [{
				        show: false,
				        type: 'continuous',
				        seriesIndex: 0,
				        min: 0,
				        max: 400
				    }, {
				        show: false,
				        type: 'continuous',
				        seriesIndex: 1,
				        dimension: 0,
				        min: 0,
				        max: dateList.length - 1
				    }],
				
				
				    title: [{
				        left: 'center',
				        text: '近两月注册人数走势图'
				    }, {
				        top: '55%',
				        left: 'center',
				        text: 'Gradient along the x axis'
				    }],
				    tooltip: {
				        trigger: 'axis'
				    },
				    xAxis: [{
				        data: dateList
				    }, {
				        data: dateList,
				        gridIndex: 1
				    }],
				    yAxis: [{
				        splitLine: {show: false}
				    }, {
				        splitLine: {show: false},
				        gridIndex: 1
				    }],
				    grid: [{
				        bottom: '60%'
				    }, {
				        top: '60%'
				    }],
				    series: [{
				        type: 'line',
				        showSymbol: false,
				        data: valueList
				    }, {
				        type: 'line',
				        showSymbol: false,
				        data: valueList,
				        xAxisIndex: 1,
				        yAxisIndex: 1
				    }]
				};
		
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
	       } 
	        
	        
	    </script>
	</div>



















				

</body>
	<%@ include file="/left-afterpage.jsp" %>
</html>

