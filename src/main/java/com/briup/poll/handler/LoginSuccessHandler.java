package com.briup.poll.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.poll.util.JwtTokenUtils;
import com.briup.poll.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 *     登陆成功处理器，返回Token,放在请求头
 * </p>
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	//选择注入我们的userDetailsService的实现类对象
	@Autowired
	@Qualifier("userDetailServiceImpl")
	private UserDetailsService userDetailsService;
	
	//转JSON的工具类，Spring会自动创建
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		try {
			//用户名密码正确
			User details = (User) userDetailsService.loadUserByUsername(authentication.getName());
			//创建Token
			String token = JwtTokenUtils.TOKEN_PREFIX  + JwtTokenUtils.createToken(details, false);

			// 将Token放在请求头
			response.setHeader(JwtTokenUtils.TOKEN_HEADER, token);
			//使用response写出去
			response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.success(token)));
		} catch (Exception e) {
			response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"创建token失败，请与管理员联系")));
		}

	}

}
