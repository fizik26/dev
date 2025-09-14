import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.test.context.*;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.sql.Connection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChangeUserRoleOnAUnitTest {
    
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void configure() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();

        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            // example of execution of SQL script for the tests
            ScriptUtils.executeSqlScript(connection, new ClassPathRessource("/path_scripts_sql"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @WithMockUser(authorities = Roles.ROLE_3)
    public void testMethodToTestSomething() {
        // do tests

        // change user role and set why not a new user name
        TestSecurityContextHolder.setContext(TestSecurityContextBuilder.withRoleAndUserName(Roles.ROLE_2, "212151"));

        // now the user has a new role and maybe a new username
    }
}
