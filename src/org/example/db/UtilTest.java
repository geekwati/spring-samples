package org.example.db;

import java.util.List;

public class UtilTest {
private H2DbUtil h2DbUtil;
	
	public H2DbUtil getH2DbUtil() {
		return h2DbUtil;
	}

	public void setH2DbUtil(H2DbUtil h2DbUtil) {
		this.h2DbUtil = h2DbUtil;
	}

	public void test() {
		User user = new User();
		List<User> users = h2DbUtil.select();
		users.stream().forEach(i->System.out.println(i));
	}

}
