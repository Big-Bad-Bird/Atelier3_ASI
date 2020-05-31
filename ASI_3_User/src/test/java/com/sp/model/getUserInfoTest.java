package com.sp.model;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import CardShop.userService.User;
import CardShop.userService.UserRepository;
import CardShop.userService.UserService;

public class getUserInfoTest {
	private List<String> stringList;
	private List<Integer> intList;
	@Autowired
	UserService uService;

	@Before
	public User setUp() {
		System.out.println("[BEFORE TEST] -- debut");
		User UserTestInfo = new User();
		UserTestInfo.setName("UnNom");
		UserTestInfo.setId(1);
		return UserTestInfo;
	}

	@After
	public void tearDown() {
		System.out.println("[AFTER TEST] -- end");
		
	}

	@Test
	public void createHero() {
		User UserTestInfo = setUp();
		assertTrue(UserTestInfo.toString().equals(uService.getUserInfo(UserTestInfo.getId()).toString()));
		}
}
