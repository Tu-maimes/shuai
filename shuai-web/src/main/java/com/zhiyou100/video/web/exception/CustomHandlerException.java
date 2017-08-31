package com.zhiyou100.video.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj,
			Exception exception) {
		ModelAndView view = new ModelAndView();
		view.addObject("obj",obj);
		view.addObject("error",exception);
		view.setViewName("/error/error");
		return view;
	}

}
