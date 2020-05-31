package com.sp.model;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import CardShop.userService.CardModel;
import CardShop.userService.User;
import CardShop.userService.UserService;


public class UserTest {
		
		@Autowired
		UserService uService;
		
		@Before
		public User setUp() {
			System.out.println("[BEFORE TEST] -- Add User to test");
			User UserTest = new User();
			UserTest.setName("UnNom");
			UserTest.setUsername("UnUsername");
			UserTest.setPassword("UnPassword");
			UserTest.setId(1);
			UserTest.setArgent(0);
			return UserTest;
		}

		@After
		public void tearDown() {
			System.out.println("[AFTER TEST] -- end");
		}

		@Test
		public void createUser() {
			User UserTest = setUp();
			System.out.println(UserTest);
			assertTrue(uService.createUser(UserTest).getName()=="UnNom");
			assertTrue(uService.createUser(UserTest).getUsername() == "UnUsername");
			assertTrue(uService.createUser(UserTest).getPassword() =="UnPassword");
			assertTrue(uService.createUser(UserTest).getId().intValue() == 1);
			assertTrue(uService.createUser(UserTest).getArgent().intValue() == 0);
						}
					}
