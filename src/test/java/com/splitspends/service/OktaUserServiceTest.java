package com.splitspends.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OktaUserServiceTest {
    @Autowired
    OktaUserService oktaUserService;

    @Test
    public void testVerifyOktaUserId() {

	assertTrue(oktaUserService.verifyOktaUserID("00u177jrtsQldmmV7357"));
	assertFalse(oktaUserService.verifyOktaUserID("00u177jabcQldmmV7357"));

    }

}
