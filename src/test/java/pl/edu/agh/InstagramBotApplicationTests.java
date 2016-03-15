package pl.edu.agh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.application.InstagramBotApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InstagramBotApplication.class)
@WebAppConfiguration
public class InstagramBotApplicationTests {

	@Test
	public void contextLoads() {
	}

}
