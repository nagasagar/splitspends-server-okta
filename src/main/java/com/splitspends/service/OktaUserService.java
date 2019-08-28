package com.splitspends.service;

import org.springframework.stereotype.Service;

import com.okta.sdk.client.Client;
import com.okta.sdk.client.ClientBuilder;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.user.User;

@Service
public class OktaUserService {
    
    public boolean verifyOktaUserID(String oktaUserId) {
	ClientBuilder builder = Clients.builder();
	Client client = builder.build();
	try {
	    User oktaUser = client.getUser(oktaUserId);
	    return oktaUser!=null?true:false;
	}catch(com.okta.sdk.resource.ResourceException e) {
	    return false;
	}
	
	
    }

}
