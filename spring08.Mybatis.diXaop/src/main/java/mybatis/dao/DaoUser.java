package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelUser;

@Repository("Userdao")
public class DaoUser implements IDaoUser {

    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession    session;
    public SqlSession getSession() {
        return session;
    }
    public void setSession(SqlSession session) {
        this.session = session;
    }
    public DaoUser() {
        super();
    }
    
    
    @Override
    public int insertUser(ModelUser user) {
       return session.insert("mybatis.mapper.mapperUser.insertUser", user);
 
    }
    
    @Override
    public ModelUser login(ModelUser user) {
   return session.selectOne("mybatis.mapper.mapperUser.login", user);
    
    }
    
    
    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        
        Map<String, Object> parameter = new HashMap<String, Object>();
        
        parameter.put("updateValue", updateValue);
        parameter.put("searchValue", searchValue);
        
        return session.update("mybatis.mapper.mapperUser.updateUserInfo", parameter);
     
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
