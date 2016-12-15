package mybatis.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mybatis.dao.DAOBook;
import mybatis.dao.IDAOBook;
import mybatis.model.modelBook;
//@Service
public class ServiceBook implements IServiceBook {
    private static Logger           logger    = LoggerFactory
            .getLogger(ServiceBook.class);
    //public static SqlSessionFactory sqlMapper = MyBatisManager.getInstance();
    
    //@Autowired
    private SqlSession session;
    
    @Override
    public List<modelBook> getSQLSelectAll() {
        
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        List<modelBook> result = Book.getSQLSelectAll();
        //session.close();
        return result;
    }
    
    @Override
    public List<modelBook> getSQLSelectLike(String bookname) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        List<modelBook> result = Book.getSQLSelectLike(bookname);
        //session.close();
        
        return result;
    }
    
    @Override
    public List<modelBook> getSQLSelectEqual(String bookname) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        List<modelBook> result = Book.getSQLSelectEqual(bookname);
        //session.close();
        
        return result;
    }
    
    @Override
    public int setSQLInsert(modelBook book) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        int result = 0;
        result = Book.setSQLInsert(book);
        session.commit();
        //session.close();
        
        return result;
    }
    
    @Override
    public int setSQLInsertMulit(List<modelBook> books) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        int result = 0;
        
        try {
            for (int i = 0; i < books.size(); i = i + 1) {
                result += Book.setSQLInsert(books.get(i));
            }
        } catch (Exception e) {
            
            logger.error("setSQLInsertMulit" + e.getMessage());
            session.rollback();
        } finally {
            session.commit();
            //session.close();
        }
        return result;
    }
    
    @Override
    public int setSQLUpdate(modelBook updateValue, modelBook searchValue) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        int result = 0;
        result = Book.setSQLUpdate(updateValue, searchValue);
        session.commit();
        //session.close();
        
        return result;
    }
    
    @Override
    public int setSQLDelete(modelBook searchValue) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        int result = 0;
        result = Book.setSQLDelete(searchValue);
        session.commit();
        //session.close();
        
        return result;
    }
    
    @Override
    public int setTransCommit(modelBook delbook, modelBook insbook,
            modelBook updbook, modelBook searchbook) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        int result = 0;
        try {
            Book.setSQLDelete(delbook);
            Book.setSQLInsert(insbook);
            Book.setSQLUpdate(updbook, searchbook);
            
            result = 1;
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setTransCommit" + e.getMessage());
            session.rollback();
            result = 0;
        } finally {
            session.commit();
            //session.close();
        }
        return result;
    }
    
    @Override
    public int setTransRollback(modelBook delbook, modelBook insbook,
            modelBook updbook, modelBook searchbook) {
        //SqlSession session = sqlMapper.openSession();
        IDAOBook Book = new DAOBook(session);
        int result = -1;
        try {
            Book.setSQLDelete(delbook);
            Book.setSQLInsert(insbook);
            Book.setSQLUpdate(updbook, searchbook);
            
            result = 1;
            
            throw new SQLException("rollback test");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("setTransCommit" + e.getMessage());
            session.rollback();
            result = -1;
            
        } finally {
            session.commit();
            //session.close();
        }
        return result;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public ServiceBook() {
        super();
    }
    
}
