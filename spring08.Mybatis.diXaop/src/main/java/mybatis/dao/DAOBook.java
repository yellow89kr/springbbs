package mybatis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.model.modelBook;

//@Repository
public class DAOBook implements IDAOBook {
    
    //@Autowired
    private SqlSession session;
    
    
    
    @Override
    public List<modelBook> getSQLSelectLike(String bookname) {
        List<modelBook> result = null;
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike",
                bookname);
        return result;
    }
    
    @Override
    public List<modelBook> getSQLSelectEqual(String bookname) {
        List<modelBook> result = null;
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectEqual",
                bookname);
        return result;
    }
    
    @Override
    public List<modelBook> getSQLSelectAND(int price, int price1) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<modelBook> getSQLSelectBetween(int price, int price1) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<modelBook> getSQLSelectOr(int price, int price1) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int setSQLInsert(modelBook book) {
        
        int result = 0;
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);
        
        return result;
    }
    
    @Override
    public int setSQLInsertMulit(List<modelBook> books) {
        
        int result = 0;
    
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsertMulit",
                books);
        
        return result;
    }
    
    @Override
    public int setSQLUpdate(modelBook updatevalue, modelBook searchvalue) {
        int result = 0;
        Map<String, Object> parameter = new HashMap<String, Object>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        // parameter.put("bookname", updatevalue.getBookname());
        // parameter.put("publisher", updatevalue.getPublisher());
        // parameter.put("year", updatevalue.getYear());
        // parameter.put("price", updatevalue.getPrice());
        // parameter.put("dtm", updatevalue.getDtm());
        // parameter.put("use_yn", updatevalue.isUse_yn());
        // parameter.put("authid", updatevalue.getAuthid());
        
        // parameter.put("search_bookid", searchvalue.getBookid());
        // parameter.put("search_bookname", searchvalue.getBookname());
        
        result = session.update("mybatis.mapper.mapperBook.setSQLUpdate",
                parameter);
        return result;
    }
    
    @Override
    public int setSQLDelete(modelBook searchvalue) {
        int result = 0;
        Map<String, Object> parameter = new HashMap<String, Object>();
        
        parameter.put("searchvalue", searchvalue);
        
        result = session.update("mybatis.mapper.mapperBook.setSQLDelete",
                parameter);
        return result;
    }
    
    @Override
    public int setSQLDelete2(String publisher, String year) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<modelBook> getSQLSelectAll() {
        // TODO Auto-generated method stub
        List<modelBook> result = null;
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
        return result;
    }

    public SqlSession getsession() {
        return session;
    }

    public void setsession(SqlSession session) {
        this.session = session;
    }

    public DAOBook(SqlSession session) {
        super();
        this.session = session;
    }


    public DAOBook() {
        super();
    }

    @Override
    public String toString() {
        return "DAOBook [session=" + session + "]";
    }

}
