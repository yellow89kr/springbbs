package mybatis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import mybatis.model.modelBook;

public interface IDAOBook {


    public List<modelBook> getSQLSelectAll( ) ;
    
    public List<modelBook> getSQLSelectLike(String bookname) ;
    
    public List<modelBook> getSQLSelectEqual(String bookname) ;
    
    public List<modelBook> getSQLSelectAND(int price,int price1) ;
    
    public List<modelBook> getSQLSelectBetween(int price,int price1) ;

    public List<modelBook> getSQLSelectOr(int price,int price1) ;

    public int setSQLInsert(modelBook book ) ;
    
    public int setSQLInsertMulit(List<modelBook> books) ;

    public int setSQLUpdate(modelBook updatevalue, modelBook searchvalue) ;
    
    public int setSQLDelete(modelBook searchvalue) ;

    public int setSQLDelete2(String publisher,String year) ;
    
}
