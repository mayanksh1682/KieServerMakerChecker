package com.company.service;

import java.io.IOException;

import org.kie.api.task.UserGroupCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


	@Bean
	public UserGroupCallback userGroupCallback() throws IOException {
		UserGroupCallbackImpl ugCallBack = new UserGroupCallbackImpl(true);
		ugCallBack.setUserGrpMapStr("mayank:maker-group,parul:checker-group");
		return ugCallBack;
	}
	
	@Bean
	public CustomLDAPUserInfoImpl userInfoCallback() throws IOException {
	    return new CustomLDAPUserInfoImpl(true);
	}
}