package mybatis.dao;

import java.util.List;

import mybatis.model.ModelUser;

public interface IDaoUser {
    

   int insertUser(ModelUser user);

   ModelUser login(ModelUser user);

   int logout(String userid);

   int updateUserInfo(ModelUser updateValue, ModelUser searchValue);

   int updatePasswd(ModelUser user);

   int deleteUser(ModelUser user);

   ModelUser selectUserOne(ModelUser userid);

   List<ModelUser> selectUserList(ModelUser ModelUser);

    
}
