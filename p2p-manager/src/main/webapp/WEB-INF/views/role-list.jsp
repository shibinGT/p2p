<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>角色管理</title>
<meta name="keywords" content="后台管理" />
<meta name="description" content="后台管理" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="icon-home home-icon"></i> <a href="${ctx}/main">首页</a></li>
				<li class="active">角色管理</li>

			</ul>
			<!-- .breadcrumb -->

			<div class="nav-search" id="nav-search">
				<form class="form-search">
					<span class="input-icon"> <input type="text"
						placeholder="Search ..." class="nav-search-input"
						id="nav-search-input" autocomplete="off" /> <i
						class="icon-search nav-search-icon"></i>
					</span>
				</form>
			</div>
			<!-- #nav-search -->
		</div>
		<div class="page-content">
			<div class="col-xs-12">
				<div class="table-responsive">
					<div id="sample-table-2_wrapper" class="dataTables_wrapper"
						role="grid">
						<div class="row">
							<div class="col-sm-3">
								<form class="form-group" action="${ctx }/role/list">
									<div class="input-group">
										<input name="roleDesc" placeholder="角色描述" class="form-control"
											value="${role.roleDesc }"> <span
											class="input-group-btn">
											<button class="btn btn-primary btn-sm" type="submit">查询</button>
										</span>
									</div>
								</form>
							</div>
							<div class="col-sm-2">
								<a href="${ctx }/role/toAdd" class="btn btn-primary btn-sm"
									role="button">新增角色</a>
							</div>
							
							<div class="col-sm-1">
							
							<input type="button" class="btn btn-primary btn-sm"
                                    role="button" value="批量删除" id="delRole"> 
                               
                            </div>
                            
						</div>
						<form action="${ctx }/role/batchDel" method="post" id="delRoleForm">
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover dataTable"
							aria-describedby="sample-table-2_info">
							<thead>
								<tr role="row">
									<th class="center sorting_disabled" role="columnheader"
										rowspan="1" colspan="1" aria-label="" style="width: 96px;"><label>
									<input type="checkbox"  class="ace"  id="choose_role" > <span class="lbl"></span>
									</label></th>

									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Domain: activate to sort column ascending"
										style="width: 258px;">角色id</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Domain: activate to sort column ascending"
										style="width: 258px;">角色描述</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;">权限描述</th>
									<th class="sorting_disabled" role="columnheader" rowspan="1"
										colspan="1" aria-label="" style="width: 266px;">操作</th>
								</tr>
							</thead>
							<tbody role="alert" aria-live="polite" aria-relevant="all" id="role_content">
								<c:if test="${pageInfo.list.size()==0 }">
									<tr class="odd">
										<td colspan="5" class="center">没有查询道任何数据...</td>
									</tr>
								</c:if>
								<c:forEach items="${pageInfo.list }" var="role">
									<tr class="odd">
										<td class="center  sorting_1"><label> <input
										
												type="checkbox" class="ace" name="lists" value="${role.id }"> <span class="lbl"></span>
												
										</label></td>
										<td class=" "><a href="#">${role.id }</a></td>
										<td class=" ">${role.roleDesc}</td>
										<td>
											<c:forEach items="${role.auths}" var="auth">
												${auth.authDesc }、&nbsp;&nbsp;&nbsp;
											</c:forEach>
										</td>
										<td class=" ">
											<div
												class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
												<a class="blue" href="#"> <i
													class="icon-zoom-in bigger-130"></i>
												</a>
												<shiro:hasPermission name="user:*">
													<!-- 分配权限 -->
													<a class="green" href="${ctx }/role/toUpdate?id=${role.id}"> <i
														class="icon-pencil bigger-130"></i>
													</a>
													  <!-- 	删除 -->
													<a class="red del_role" href="javascript:void(0)"  roleId="${role.id }"> <i  
														class="icon-trash bigger-130"></i>
													</a>
												</shiro:hasPermission>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</form>
					</div>
					<page:pager url="${ctx }/role/list" pageInfo="${pageInfo }" />

				</div>
			</div>
		</div>

	</div>
	<!-- /.main-content -->


	<script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="${ctx}/static/assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="${ctx}/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.resize.min.js"></script>


	<!-- inline scripts related to this page -->

	<script type="text/javascript">
	
		jQuery(function($) {
			$('.easy-pie-chart.percentage')
					.each(
							function() {
								var $box = $(this).closest('.infobox');
								var barColor = $(this).data('color')
										|| (!$box.hasClass('infobox-dark') ? $box
												.css('color')
												: 'rgba(255,255,255,0.95)');
								var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
										: '#E2E2E2';
								var size = parseInt($(this).data('size')) || 50;
								$(this)
										.easyPieChart(
												{
													barColor : barColor,
													trackColor : trackColor,
													scaleColor : false,
													lineCap : 'butt',
													lineWidth : parseInt(size / 10),
													animate : /msie\s*(8|7|6)/
															.test(navigator.userAgent
																	.toLowerCase()) ? false
															: 1000,
													size : size
												});
							})

			$('.sparkline').each(
					function() {
						var $box = $(this).closest('.infobox');
						var barColor = !$box.hasClass('infobox-dark') ? $box
								.css('color') : '#FFF';
						$(this).sparkline('html', {
							tagValuesAttribute : 'data-values',
							type : 'bar',
							barColor : barColor,
							chartRangeMin : $(this).data('min') || 0
						});
					});

			var placeholder = $('#piechart-placeholder').css({
				'width' : '90%',
				'min-height' : '150px'
			});
			var data = [ {
				label : "social networks",
				data : 38.7,
				color : "#68BC31"
			}, {
				label : "search engines",
				data : 24.5,
				color : "#2091CF"
			}, {
				label : "ad campaigns",
				data : 8.2,
				color : "#AF4E96"
			}, {
				label : "direct traffic",
				data : 18.6,
				color : "#DA5430"
			}, {
				label : "other",
				data : 10,
				color : "#FEE074"
			} ]
			function drawPieChart(placeholder, data, position) {
				$.plot(placeholder, data, {
					series : {
						pie : {
							show : true,
							tilt : 0.8,
							highlight : {
								opacity : 0.25
							},
							stroke : {
								color : '#fff',
								width : 2
							},
							startAngle : 2
						}
					},
					legend : {
						show : true,
						position : position || "ne",
						labelBoxBorderColor : null,
						margin : [ -30, 15 ]
					},
					grid : {
						hoverable : true,
						clickable : true
					}
				})
			}
			drawPieChart(placeholder, data);

			/**
			we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			so that's not needed actually.
			 */
			placeholder.data('chart', data);
			placeholder.data('draw', drawPieChart);

			var $tooltip = $(
					"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
					.hide().appendTo('body');
			var previousPoint = null;

			placeholder.on('plothover', function(event, pos, item) {
				if (item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : "
								+ item.series['percent'] + '%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({
						top : pos.pageY + 10,
						left : pos.pageX + 10
					});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}

			});

			var d1 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d1.push([ i, Math.sin(i) ]);
			}

			var d2 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d2.push([ i, Math.cos(i) ]);
			}

			var d3 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.2) {
				d3.push([ i, Math.tan(i) ]);
			}

			var sales_charts = $('#sales-charts').css({
				'width' : '100%',
				'height' : '220px'
			});
			$.plot("#sales-charts", [ {
				label : "Domains",
				data : d1
			}, {
				label : "Hosting",
				data : d2
			}, {
				label : "Services",
				data : d3
			} ], {
				hoverable : true,
				shadowSize : 0,
				series : {
					lines : {
						show : true
					},
					points : {
						show : true
					}
				},
				xaxis : {
					tickLength : 0
				},
				yaxis : {
					ticks : 10,
					min : -2,
					max : 2,
					tickDecimals : 3
				},
				grid : {
					backgroundColor : {
						colors : [ "#fff", "#fff" ]
					},
					borderWidth : 1,
					borderColor : '#555'
				}
			});

			$('#recent-box [data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			$('.dialogs,.comments').slimScroll({
				height : '300px'
			});

			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
			var agent = navigator.userAgent.toLowerCase();
			if ("ontouchstart" in document && /applewebkit/.test(agent)
					&& /android/.test(agent))
				$('#tasks').on('touchstart', function(e) {
					var li = $(e.target).closest('#tasks li');
					if (li.length == 0)
						return;
					var label = li.find('label.inline').get(0);
					if (label == e.target || $.contains(label, e.target))
						e.stopImmediatePropagation();
				});

			$('#tasks').sortable({
				opacity : 0.8,
				revert : true,
				forceHelperSize : true,
				placeholder : 'draggable-placeholder',
				forcePlaceholderSize : true,
				tolerance : 'pointer',
				stop : function(event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
					$(ui.item).css('z-index', 'auto');
				}
			});

			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click',
					function() {
						if (this.checked)
							$(this).closest('li').addClass('selected');
						else
							$(this).closest('li').removeClass('selected');
					});

		});
		
		
// 		删除角色链接
    $("a.del_role").click(function(){
        if(confirm("是否要删除吗?")){
            //获取id
            var id= $(this).attr("roleId");
            window.location.href=ctx+"/role/delById?id="+id;
        }
    });

// 		批量删除
		$("#choose_role").click(function(){
	        var checked = this.checked;
	        $("#role_content input:checkbox").prop("checked",checked);
	    })
	    
	    $("#delRole").click(function(){
        if($("#role_content input:checked").length==0){
            alert("请至少选中一条数据!");
            return;
        }
        if(confirm("确定要删除吗?")){
            $("#delRoleForm").submit();
            }
        })
	</script>
</body>
<%@ include file="/left-afterpage.jsp"%>
<%@ include file="/bottom.jsp"%>
</html>

