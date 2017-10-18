package com.qhcs.ssm.tag;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.github.pagehelper.PageInfo;

/**
 * @author yixuefei
 * @since JDK1.6
 * @history 2017年8月20日 yixuefei 新建 分页标签处理类
 */
public class PagerTag extends TagSupport {
	private static final long serialVersionUID = 5729832874890369508L;
	private String url; // 请求URI
	private PageInfo pageInfo;

	public int doStartTag() throws JspException {

		// 拼写要输出到页面的HTML文本
		StringBuilder sb = new StringBuilder();

		sb.append("<div>");
		if (pageInfo.getTotal()>0) {
			sb.append("<form method=\"post\" action=\"").append(this.url).append("\" name=\"qPagerForm\">\r\n");

			// 获取请求中的所有参数
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			Enumeration<String> enumeration = request.getParameterNames();
			String name = null; // 参数名
			String value = null; // 参数值
			// 把请求中的所有参数当作隐藏表单域
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement();
				value = request.getParameter(name);
				// 去除页号
				if (name.equals("pageNum")) {
					continue;
				}
				sb.append("<input type=\"hidden\" name=\"").append(name).append("\" value=\"").append(value)
						.append("\"/>\r\n");
			}

			// 把当前页号设置成请求参数
			sb.append("<input type=\"hidden\" name=\"").append("pageNum").append("\" value=\"").append(pageInfo.getPageNum())
					.append("\"/>\r\n");
			
			
			sb.append("<ul class='pagination'>");
			
			
			
			//判断是否有上一页
			if(pageInfo.isHasPreviousPage()){
				sb.append("<li>");//有上一页
				sb.append("<a href='javascript:void(0)' title='上一页' onclick='turnOverPage("+(pageInfo.getPageNum()-1)+")'>");
			}else{
				sb.append("<li class='disabled' >");//不可选
				sb.append("<a href='javascript:void(0)'>");
			}
			sb.append("<i class='icon-double-angle-left'></i></a></li>");
			
			for(int i=0;i<pageInfo.getNavigatepageNums().length;i++){
				sb.append("<li");
				int pageNo  = pageInfo.getNavigatepageNums()[i];
				if(pageNo== pageInfo.getPageNum()){
					sb.append(" class='active'");
				}
				sb.append("><a href='javascript:void(0)' onclick='turnOverPage("+pageNo+")'>"+pageNo+"</a></li>");
			}
			
			
			//判断是否有下一页
			if(pageInfo.isHasNextPage()){
				sb.append("<li>");//有下一页
				sb.append("<a href='javascript:void(0)' title='下一页' onclick='turnOverPage("+(pageInfo.getPageNum()+1)+")'>");
			}else{
				sb.append("<li class='disabled' >");//不可选
				sb.append("<a href='javascript:void(0)' >");
			}
			sb.append("<i class='icon-double-angle-right'></i></a></li>");
		
			sb.append("</ul></form>\r\n");

			// 生成提交表单的JS
			sb.append("<script language=\"javascript\">\r\n");
			sb.append("  function turnOverPage(no){\r\n");
			sb.append("    if(no>").append(pageInfo.getPages()).append("){");
			sb.append("      no=").append(pageInfo.getPages()).append(";}\r\n");
			sb.append("    if(no<1){no=1;}\r\n");
			sb.append("    document.qPagerForm.pageNum.value=no;\r\n");
			sb.append("    document.qPagerForm.submit();\r\n");
			sb.append("  }\r\n");
			sb.append("</script>\r\n");
		}
		sb.append("</div>\r\n");

		// 把生成的HTML输出到响应中
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY; // 本标签主体为空,所以直接跳过主体
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	

}
