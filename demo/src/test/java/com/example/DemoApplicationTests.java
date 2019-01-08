package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.TestUser;
import com.example.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private RedisService redisService;

	/**
	 * 放置缓存
	 * */
	@Test
	public void test() throws Exception {
		//放置缓存
		stringRedisTemplate.opsForValue().set("abc", "测试");
		//获取Redis缓存数据
		ValueOperations<String, String> redisGetValues = stringRedisTemplate.opsForValue();
		System.out.println("Redis值："+redisGetValues.get("abc"));
	}

	/**
	 * 超时失效
	 * */
	@Test
	public void testExpire() throws InterruptedException {
		/*
		* 要缓存的JavaBean必须实现Serializable接口，因为Spring会将对象先序列化再存入 Redis
		* */
		TestUser user=new TestUser(123, "expire", "123456");
		ValueOperations<String, TestUser> operations=redisTemplate.opsForValue();
		operations.set("expire", user,100, TimeUnit.MILLISECONDS);
		Thread.sleep(1000);
		boolean exists=redisTemplate.hasKey("expire");
		if(exists){
			System.out.println("exists is true");
		}else{
			System.out.println("exists is false");
		}
	}
	/**
	 * 删除数据
	 * */
	@Test
	public void testDelete() {
		ValueOperations<String, TestUser> operations=redisTemplate.opsForValue();
		redisTemplate.opsForValue().set("deletekey", "ityouknow");
		redisTemplate.delete("deletekey");
		boolean exists=redisTemplate.hasKey("deletekey");
		if(exists){
			System.out.println("exists is true");
		}else{
			System.out.println("exists is false");
		}
	}

	/**
	 * 放置List
	 * */
	@Test
	public void testList() {
		ListOperations<String, String> list = redisTemplate.opsForList();
		list.leftPush("list","it");
		list.leftPush("list","you");
		list.leftPush("list","know");
		String value=(String)list.leftPop("list");
		System.out.println("list value :"+value.toString());
	}

	@Test
	public void testObj(){
		TestUser user=new TestUser(123, "expire", "123456");
		TestUser user2=new TestUser(456, "张三", "111111");
		boolean name = redisService.set("name", "张三");
		boolean age = redisService.set("age","23");
		boolean testUser = redisService.set("testUser", user);
		boolean testUser2 = redisService.set("testUser2", user2);
		if(testUser&&testUser2){
			Object nameStr = redisService.get("name");
			Object ageStr = redisService.get("age");
			System.out.println("nameStr: "+nameStr+"ageStr:"+ageStr);
		}
	}
}
