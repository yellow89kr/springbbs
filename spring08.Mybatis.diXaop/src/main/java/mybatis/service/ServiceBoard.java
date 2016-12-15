package mybatis.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import mybatis.dao.IDaoBoard;
import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;



@Service("serviceBoard")
public class ServiceBoard implements IServiceBoard {
   
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    @Autowired
    @Qualifier("boardDao")
    private IDaoBoard dao;
    
    
    public ServiceBoard(SqlSession session) {
        super();
         
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String getBoardName(String boardcd) {
        

        String result = null;
        
        try {
            result = dao.getBoardName(boardcd);
        } catch (Exception e) {
            
            logger.error("getBoardName" + e.getMessage());
            throw e;
        } 
        return result;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        

        ModelBoard result = null;
        
        try {
            result = dao.getBoardOne(boardcd);
        } catch (Exception e) {
            
            logger.error("getBoardOne" + e.getMessage());
            throw e;
        } 
        return result;
    }
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
       
        List<ModelBoard> result = null;
        
        try {
            result = dao.getBoardList();
        } catch (Exception e) {
            
            logger.error("getBoardList" + e.getMessage());
            throw e;
        } 
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardListResultMap() {
       
        
        List<ModelBoard> result = null;
        
        try {
            result = dao.getBoardListResultMap();
        } catch (Exception e) {
            
            logger.error("getBoardListResultMap" + e.getMessage());
            throw e;
        } 
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
        
        
        int result = 0;
        
        try {
            result = dao.insertBoard(board);
        } catch (Exception e) {
            
            logger.error("insertBoard" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue)
            throws SQLException {
       
        int result = 0;
        
        try {
            result = dao.updateBoard(updatevalue, searchvalue);
        } catch (Exception e) {
            
            logger.error("updateBoard" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard searchValue) {
       
        
        int result = 0;
        
        try {
            result = dao.deleteBoard(searchValue);
             
        } catch (Exception e) {
            
            logger.error("deleteBoard" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard boardcd) {
       
        
        List<ModelBoard> result = null;
        
        try {
            result = dao.getBoardSearch(boardcd);
        } catch (Exception e) {
            
            logger.error("getBoardSearch" + e.getMessage());
            
        } 
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String boardnm,
            int start, int end) {
        
        List<ModelBoard> result = null;
        
        try {
            result = dao.getBoardPaging(boardcd, boardnm, start, end);
        } catch (Exception e) {
            
            logger.error("getBoardPaging" + e.getMessage());
            
        }
        return result;
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> list) {
       
        int result = 0;
        
        try {
            result = dao.insertBoardList(list);
        } catch (Exception e) {
            
            logger.error("insertBoardList" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord,
            int start, int end) {
        
        List<ModelArticle> result = null;
        
        try {
            result = dao.getArticleList(boardCd, searchWord, start, end);
        } catch (Exception e) {
            
            logger.error("getArticleList" + e.getMessage());
            
        } 
        return result;
    }
    
    @Override
    public ModelArticle getArticle(int articleno) {
        
        ModelArticle result = null;
        
        try {
            dao.increaseHit(articleno);
            result = dao.getArticle(articleno);
        } catch (Exception e) {
            
            logger.error("getArticle" + e.getMessage());
            
        } 
        return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardCd, String searchWord) {
       
        int result = 0;
        
        try {
            result = dao.getArticleTotalRecord(boardCd, searchWord);
        } catch (Exception e) {
            
            logger.error("getArticleTotalRecord" + e.getMessage());
        } 
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
       
        int result = 0;
        
        try {
            result = dao.insertArticle(article);
        } catch (Exception e) {
            
            logger.error("insertArticle" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int updateArticle(ModelArticle updatevalue,
            ModelArticle searchvalue) {
       
        int result = 0;
        
        try {
            result = dao.updateArticle(updatevalue, searchvalue);
        } catch (Exception e) {
            
            logger.error("updateArticle" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int deleteArticle(ModelArticle articleNo) {
       
        int result = 0;
        
        try {
            result = dao.deleteArticle(articleNo);
        } catch (Exception e) {
            
            logger.error("deleteArticle" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int increaseHit(int articleNo) {
        
        int result = 0;
        
        try {
            result = dao.increaseHit(articleNo);
             
        } catch (Exception e) {
            
            logger.error("increaseHit" + e.getMessage());
             
        }
        return result;
    }
    
    @Override
    public ModelArticle getNextArticle(int articleNo, String boardCd,
            String searchWord) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("articleNo", articleNo);
        map.put("boardCd", boardCd);
        map.put("searchWord", searchWord);
        
        ModelArticle result = null;
        
        try {
            result = dao.getNextArticle(map);
        } catch (Exception e) {
            
            logger.error("getNextArticle" + e.getMessage());
            
        } 
        return result;
    }
    
    @Override
    public ModelArticle getPrevArticle(int articleNo, String boardCd,
            String searchWord) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("articleNo", articleNo);
        map.put("boardCd", boardCd);
        map.put("searchWord", searchWord);
        
        ModelArticle result = null;
        
        try {
            result = dao.getPrevArticle(map);
        } catch (Exception e) {
            
            logger.error("getPrevArticle" + e.getMessage());
            
        } 
        return result;
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
        
        List<ModelAttachfile> result = null;
        
        try {
            result = dao.getAttachFileList(articleNo);
        } catch (Exception e) {
            
            logger.error("getAttachFileList" + e.getMessage());
            
        }
        return result;
    }
    
    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
       
        ModelAttachfile result = null;
        
        try {
            result = dao.getAttachFile(attachFileNo);
        } catch (Exception e) {
            
            logger.error("getAttachFile" + e.getMessage());
            
        }
        return result;
    }
    
    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        
        int result = 0;
        
        try {
            result = dao.insertAttachFile(attachFile);
        } catch (Exception e) {
            
            logger.error("insertAttachFile" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachfile attachFileNo) {
        
        int result = 0;
        
        try {
            result = dao.deleteAttachFile(attachFileNo);
        } catch (Exception e) {
            
            logger.error("deleteAttachFile" + e.getMessage());
             
        }
        return result;
    }
    
    @Override
    public List<ModelComments> getCommentList(int commentno) {
        
        List<ModelComments> result = null;
        
        try {
            result = dao.getCommentList(commentno);
        } catch (Exception e) {
            
            logger.error("getCommentList" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public ModelComments getComment(int commentNo) {
      
        ModelComments result = null;
        
        try {
            result = dao.getComment(commentNo);
        } catch (Exception e) {
            
            logger.error("getComment" + e.getMessage());
             
        }
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
       
        int result = 0;
        
        try {
            result = dao.insertComment(comment);
        } catch (Exception e) {
            
            logger.error("insertComment" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
       
        int result = 0;
        
        try {
            result = dao.updateComment(updateValue, searchValue);
        } catch (Exception e) {
            
            logger.error("updateComment" + e.getMessage());
             
        } 
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments commentno) {
       
        int result = 0;
        
        try {
            result = dao.deleteComment(commentno);
        } catch (Exception e) {
            
            logger.error("deleteComment" + e.getMessage());
             
        }
        return result;
    }
    
    
    public void setSession(SqlSession session) {
         
    }
    
    public ServiceBoard() {
        super();
    }

    public IDaoBoard getDao() {
        return dao;
    }

    public void setDao(IDaoBoard dao) {
        this.dao = dao;
    }

    public ServiceBoard(IDaoBoard dao) {
        super();
        this.dao = dao;
    }


    
}
