package cn.hg.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(isDouble(".135"));
	}

	private boolean isDouble(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

}
