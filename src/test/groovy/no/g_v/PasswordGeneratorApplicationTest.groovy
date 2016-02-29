package no.g_v

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = PasswordGeneratorApplication)
@WebAppConfiguration
class PasswordGeneratorApplicationTest {

    @Test
    public void contextLoads() throws Exception {
    }
}
