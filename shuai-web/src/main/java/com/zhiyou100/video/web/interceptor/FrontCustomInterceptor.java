package com.zhiyou100.video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.User;

/**   
*    
* 项目名称：shuai-web   
* 类名称：FrontCustomInterceptor   
* 类描述：   
* 创建时间：2017年8月31日 下午3:31:56   
* 修改人：汪帅   
* 修改时间：2017年8月31日 下午3:31:56   
* 修改备注：   
* @version    
*    
*/
public class FrontCustomInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		User us = (User)req.getSession().getAttribute("_front_user");
		if(us != null){
			return true;
		}
		res.sendRedirect(req.getContextPath()+"/front/user.do");
		return false;
	}

}
