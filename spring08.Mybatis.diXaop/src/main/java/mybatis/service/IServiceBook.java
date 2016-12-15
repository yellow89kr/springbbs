package mybatis.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.dao.DAOBook;
import mybatis.model.modelBook;

public interface IServiceBook {

    public List<modelBook> getSQLSelectAll() ;
     
    public List<modelBook> getSQLSelectLike(String bookname);

    public List<modelBook> getSQLSelectEqual(String bookname);

    public int setSQLInsert( modelBook book );
    
    public int setSQLInsertMulit(List<modelBook> books);
    
    public int setSQLUpdate(modelBook updateValue , modelBook searchValue) ;

    public int setSQLDelete(modelBook searchValue) ;
    
    public int setTransCommit(modelBook delbook , modelBook insbook , modelBook updbook , modelBook searchbook);

    public int setTransRollback(modelBook delbook,modelBook insbook,modelBook updbook,modelBook searchbook) ;
    
}

    

