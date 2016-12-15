package mybatis.test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.modelBook;
import mybatis.service.IServiceBook;
import mybatis.service.ServiceBook;

public class TestServiceBook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceBook.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetSQLSelectAll() {
       IServiceBook service = new ServiceBook();
       List<modelBook> result  = service.getSQLSelectAll();
       assertSame(result.size(), 14);
    }
    @Test
    public void testGetSQLSelectLike() {
       IServiceBook service = new ServiceBook();
       List<modelBook> result  = service.getSQLSelectLike("JA");
       assertSame(result.size(), 1);
    }
    @Test
    public void testgetSQLSelectEqual() {
        IServiceBook service = new ServiceBook();
        List<modelBook> result  = service.getSQLSelectEqual("JAVA");
        assertSame(result.size(), 1);
     }
    @Test
    public void testsetSQLInsert() {
        modelBook book = new modelBook();
        book.setAuthid(10);
        book.setBookname("titro");
        book.setDtm("2016-06-23");
        book.setPrice(20000);
        book.setPublisher("soro");
        book.setUse_yn(true);
        book.setYear("2016");
       
        IServiceBook service = new ServiceBook();
        int result  = service.setSQLInsert(book);
        assertSame(result, 1);
     }
    
    @Test
    public void testsetSQLInsertMulti() {
        List<modelBook> books = new ArrayList<modelBook>();
        
        for(int i = 0 ; i < 10; i = i+1) {
        
            modelBook book = new modelBook();
            book.setAuthid(10);
            book.setBookname("test insert mulit" + i);
            book.setDtm("2016-06-23");
            book.setPrice(20000);
            book.setPublisher("test insert mulit" + i);
            book.setUse_yn(true);
            book.setYear("2016");
            
            books.add(book);
        }
        IServiceBook service = new ServiceBook();
        int result  = service.setSQLInsertMulit(books);
        assertSame(result, 10);
     }
    
    @Test
    public void testsetSQLUpdateWithauthid() {
        
        modelBook updateValue= new modelBook();
        updateValue.setAuthid(50);
        updateValue.setBookname("metro");
        updateValue.setDtm("2016-06-23");
        updateValue.setPrice(20000);
        updateValue.setPublisher("soro");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        //updateValue.setBookid(10);
       
        modelBook searchValue = new modelBook();
        searchValue.setBookid(2);
        
        IServiceBook service = new ServiceBook();
        int result  = service.setSQLUpdate(updateValue ,searchValue);
        assertSame(result, 1);
     }
    @Test
    public void testsetSQLupdateWithauthidAndBookname() {
        
        modelBook updateValue= new modelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("mememi");
        updateValue.setDtm("2016-06-23");
        updateValue.setPrice(20000);
        updateValue.setPublisher("soro");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
       
        modelBook searchValue = new modelBook();
        searchValue.setBookid(3);
        searchValue.setBookname("JAVA");
        IServiceBook service = new ServiceBook();
        int result  = service.setSQLUpdate(updateValue ,searchValue);
        assertSame(result, 1);
     }
    @Test
    public void testsetSQLDelete() {
        
       
        modelBook searchValue = new modelBook();
       
        searchValue.setBookname("JAVA");
        searchValue.setPublisher("Hall");
        IServiceBook service = new ServiceBook();
        int result  = service.setSQLDelete(searchValue);
        assertSame(result, 1);
     }
    @Test
    public void testSetTransCommit() {
        
        modelBook delbook =  new modelBook();
        delbook.setBookid(1);
        
        modelBook insbook= new modelBook();
        insbook.setAuthid(11);
        insbook.setBookname("meemi");
        insbook.setDtm("2016-06-23");
        insbook.setPrice(20000);
        insbook.setPublisher("soro");
        insbook.setUse_yn(true);
        insbook.setYear("2016");
        
        modelBook updbook= new modelBook();
        updbook.setAuthid(10);
        updbook.setBookname("memi");
        updbook.setDtm("2016-06-23");
        updbook.setPrice(20000);
        updbook.setPublisher("soro");
        updbook.setUse_yn(true);
        updbook.setYear("2016");
        
       
        modelBook searchbook = new modelBook();
        searchbook.setBookid(2);
        
        
        IServiceBook service = new ServiceBook();
        int result  = service.setTransCommit(delbook, insbook, updbook, searchbook);
        assertSame(result, 1);
     }
    @Test
    public void testSetTransrollback() {
        
        modelBook delbook =  new modelBook();
        delbook.setBookid(1);
        
        modelBook insbook= new modelBook();
        insbook.setAuthid(11);
        insbook.setBookname("meemi");
        insbook.setDtm("2016-06-23");
        insbook.setPrice(20000);
        insbook.setPublisher("soro");
        insbook.setUse_yn(true);
        insbook.setYear("2016");
        
        modelBook updbook= new modelBook();
        updbook.setAuthid(10);
        updbook.setBookname("memi");
        updbook.setDtm("2016-06-23");
        updbook.setPrice(20000);
        updbook.setPublisher("soro");
        updbook.setUse_yn(true);
        updbook.setYear("2016");
        
       
        modelBook searchbook = new modelBook();
        searchbook.setBookid(2);
        
        
        IServiceBook service = new ServiceBook();
        int result  = service.setTransRollback(delbook, insbook, updbook, searchbook);
        assertSame(result, -1);
     }
}
