<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- 在主页面前引入 -->
<div class="main-container" id="main-container">
            <script type="text/javascript">
                try{ace.settings.check('main-container' , 'fixed')}catch(e){}
            </script>

            <div class="main-container-inner">
                <a class="menu-toggler" id="menu-toggler" href="#">
                    <span class="menu-text"></span>
                </a>
                <div class="sidebar" id="sidebar">
                    <script type="text/javascript">
                        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
                    </script>

                    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                            <button class="btn btn-success">
                                <i class="icon-signal"></i>
                            </button>

                            <button class="btn btn-info">
                                <i class="icon-pencil"></i>
                            </button>

                            <button class="btn btn-warning">
                                <i class="icon-group"></i>
                            </button>

                            <button class="btn btn-danger">
                                <i class="icon-cogs"></i>
                            </button>
                        </div>

                        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                            <span class="btn btn-success"></span>

                            <span class="btn btn-info"></span>

                            <span class="btn btn-warning"></span>

                            <span class="btn btn-danger"></span>
                        </div>
                    </div><!-- #sidebar-shortcuts -->

                    <ul class="nav nav-list">
                        <li>
                            <a href="${ctx }/main">
                                <i class="icon-dashboard"></i>
                                <span class="menu-text"> 首 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页 </span>
                            </a>
                        </li>

                        

                        <li>
                            <a href="#" class="dropdown-toggle">
                                <i class="icon-desktop"></i>
                                <span class="menu-text">用户管理</span>
                                <b class="arrow icon-angle-down"></b>
                            </a>

                            <ul class="submenu">
                             	<li>
		                            <a href="${ctx}/user/list">
		                                <i class="icon-double-angle-right"></i>
		                                员工管理
		                            </a>
		                        </li>
                             	<li>
		                            <a href="${ctx}/users/list">
		                                <i class="icon-double-angle-right"></i>
		                                用户管理
		                            </a>
		                        </li>
								<shiro:hasPermission name="admin:*">
		                      	  	<li>
		                            <a href="${ctx}/auth/list">
		                                <i class="icon-double-angle-right"></i>
		                                <span class="menu-text">权限管理</span>
		                            </a>
		                      	  </li>
								</shiro:hasPermission>
                                <li>
                                    <a href="${ctx}/role/list">
                                        <i class="icon-double-angle-right"></i>
                                       角色管理
                                    </a>
                                </li>
                                 <li>
                                    <a href="${ctx}/group/list">
                                        <i class="icon-double-angle-right"></i>
                                      分组管理
                                    </a>
                                </li>
                               

                            </ul>
                        </li>
						<!-- 监控管理 -->
						 <li>
                            <a href="${ctx}/druid">
                                <i class=" icon-eye-open"></i>
                                <span class="menu-text">监控管理</span>
                            </a>
                        </li>
                        <!-- - -->
                        <li>
                            <a href="#" class="dropdown-toggle">
                                <i class="icon-tag"></i>
                                <span class="menu-text"> 更多页面 </span>

                                <b class="arrow icon-angle-down"></b>
                            </a>

                            <ul class="submenu">
                                <li>
                                    <a href="profile.html">
                                        <i class="icon-double-angle-right"></i>
                                        用户信息
                                    </a>
                                </li>

                                <li>
                                    <a href="inbox.html">
                                        <i class="icon-double-angle-right"></i>
                                        收件箱
                                    </a>
                                </li>

                                <li>
                                    <a href="pricing.html">
                                        <i class="icon-double-angle-right"></i>
                                        售价单
                                    </a>
                                </li>

                                <li>
                                    <a href="invoice.html">
                                        <i class="icon-double-angle-right"></i>
                                        购物车
                                    </a>
                                </li>

                                <li>
                                    <a href="timeline.html">
                                        <i class="icon-double-angle-right"></i>
                                        时间轴
                                    </a>
                                </li>

                                <li>
                                    <a href="login.html">
                                        <i class="icon-double-angle-right"></i>
                                        登录 &amp; 注册
                                    </a>
                                </li>
                            </ul>
                        </li>
                    <div class="sidebar-collapse" id="sidebar-collapse">
                        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
                    </div>

                    <script type="text/javascript">
                        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
                    </script>
                </div>
    <!-- left-beforepage.jsp -->
    <div class="main-content">
