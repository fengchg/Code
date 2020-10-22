package org.maro.manager;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-*.xml" })
public class aaaa {

	@Autowired
	//private MaroDishesServiceI maroDishesServiceI;

	@Before
	public void before() {
		System.out.println("=================before=================");
	}

	@After
	public void after() {
		System.out.println("=================after=================");
	}

	@Test
	public void test() {
	}
}