package mybatis.test;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mybatis.model.ModelUser;
import mybatis.service.IServiceUser;
import mybatis.service.ServiceUser;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    
    private static SqlSession    session = null;
    private static ApplicationContext context = null;
    private static IServiceUser service = null;
    
    // SLF4J Logging
    private static Logger logger  = LoggerFactory.getLogger(TestServiceUser.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("userservice",IServiceUser.class);
        
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {        
       // ((ClassPathXmlApplicationContext)context).close();        
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void insertUser() {
        ModelUser User = new ModelUser();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        
        User.setEmail("yonee@hanmail.net");
        User.setInsertdt(form);
        User.setInsertuid("yonee1111");
        User.setMobile("010-7399-0797");
        User.setName("yon");
        User.setPasswd("1234");
        User.setRetireyn(false);
        User.setUpdatedt(form);
        User.setUpdateuid("hite89");
        User.setUserid("yonee");
        
        //IServiceUser service = new ServiceUser(session);
        int result = service.insertUser(User);
        assertSame(result, 1);
        
    }
    
    @Test
    public void login() {
        ModelUser User = new ModelUser();
        User.setUserid("yell");
        User.setPasswd("1234");
       
        
        //IServiceUser service = new ServiceUser(session);
        ModelUser result = service.login(User);
        assertEquals(result.getName(), "Park");
        
    }
    @Test
    public void logout() {
        fail("Not yet implemented");
    }
    
    @Test
    public void updateUserInfo() {
        fail("Not yet implemented");
    }
    
    @Test
    public void updatePasswd() {
        fail("Not yet implemented");
    }
    
    @Test
    public void deleteUser() {
        fail("Not yet implemented");
    }
    
    @Test
    public void selectUserOne() {
        fail("Not yet implemented");
    }
    
    @Test
    public void selectUserList() {
        fail("Not yet implemented");
    }
    
}
