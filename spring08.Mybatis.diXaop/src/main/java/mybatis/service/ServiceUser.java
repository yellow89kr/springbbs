package mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.DaoUser;
import mybatis.dao.IDaoUser;
import mybatis.model.ModelUser;

@Service("userservice")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    @Autowired
    @Qualifier("Userdao")
    IDaoUser dao;
    

    public IDaoUser getDao() {
        return dao;
    }

    public void setDao(IDaoUser dao) {
        this.dao = dao;
    }

    public ServiceUser(IDaoUser dao) {
        super();
        this.dao = dao;
    }

    public ServiceUser() {
        super();
    }
    
    @Override
    public int insertUser(ModelUser user) {
        
        int result = 0;
        
        try {
            result = dao.insertUser(user);

        } catch (Exception e) {
            logger.error("getBoardName" + e.getMessage());

        } 
        return result;
        
    }
    
    @Override
    public ModelUser login(ModelUser user) {
   
        
        ModelUser result = null;
        
        try {
            result = dao.login(user);

        } catch (Exception e) {
            logger.error("login" + e.getMessage());

        } 
        return result;
        
    }
    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {

        
        int result = 0;
        
        try {
            result = dao.updateUserInfo(updateValue,searchValue);
            
            
        } catch (Exception e) {
            
            logger.error("updateUserInfo" + e.getMessage());
            
      
            
        } 
        return result;
        
    }
    @Override
    public int updatePasswd(ModelUser user) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ModelUser selectUserOne(ModelUser userid) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser ModelUser) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
