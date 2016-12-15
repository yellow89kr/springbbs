package mybatis.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
import mybatis.model.modelBook;

@Repository("boardDao")
public class DaoBoard implements IDaoBoard {

    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String getBoardName(String boardcd) {
        String result = "";
        result = session.selectOne("mybatis.mapper.mapperBoard.getBoardName",
                boardcd);
        return result;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard result = null;
        result = session.selectOne("mybatis.mapper.mapperBoard.getBoardOne",
                boardcd);
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
        List<ModelBoard> result = null;
        result = session.selectList("mybatis.mapper.mapperBoard.getBoardList");
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardListResultMap() {
        List<ModelBoard> result = null;
        result = session
                .selectList("mybatis.mapper.mapperBoard.getBoardListResultMap");
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
        int result = 0;
        result = session.insert("mybatis.mapper.mapperBoard.insertBoard", board);
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue)
            throws SQLException {
        int result = 0;
        Map<String, Object> parameter = new HashMap<String, Object>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        result = session.update("mybatis.mapper.mapperBoard.updateBoard",
                parameter);
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard searchValue) throws SQLException {
        int result = 0;
        result = session.delete("mybatis.mapper.mapperBoard.deleteBoard",
                searchValue);
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        List<ModelBoard> result = null;
        result = session.selectList("mybatis.mapper.mapperBoard.getBoardSearch",
                board);
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd , String boardnm ,  int start , int end) {
        List<ModelBoard> result = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("boardnm", boardnm);
        map.put("start", start);
        map.put("end", end);
        result = session.selectList(
                "mybatis.mapper.mapperBoard.getBoardPaging", map);
        return result;
    }
    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int result = 0;
        result = session.insert("mybatis.mapper.mapperBoard.insertBoardList",
                list);
        return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int result = 0;
        Map<String, String> map = new HashMap<String, String>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        result = session.selectOne(
                "mybatis.mapper.mapperBoard.getArticleTotalRecord", map);
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord,
            int start, int end) {
        List<ModelArticle> result = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardCd", boardCd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        result = session.selectList("mybatis.mapper.mapperBoard.getArticleList",map);
        return result;
    }
    
    @Override
    public ModelArticle getArticle(int articleno) {
        ModelArticle result = null;
        result = session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleno);
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
        int result = 0;
        result = session.insert("mybatis.mapper.mapperBoard.insertarticle", article);
        return result;
    }
    
    @Override
    public int updateArticle(ModelArticle updatevalue ,ModelArticle searchvalue) {
        int result = 0;
        Map<String, Object> parameter = new HashMap<String, Object>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        result = session.update("mybatis.mapper.mapperBoard.updateArticle",
                parameter);
        return result;
    }
    @Override
    public int deleteArticle(ModelArticle articleNo) {
        int result = 0;
        result = session.delete("mybatis.mapper.mapperBoard.deleteArticle",
                articleNo);
        return result;
    }
    
    @Override
    public int increaseHit(int articleNo) {
        int result = 0;
        result = session.update("mybatis.mapper.mapperBoard.increaseHit",articleNo);
        return result;
    }
    
    @Override
    public ModelArticle getNextArticle(Map<String, Object> hashmap) {
        ModelArticle result = null;
        result = session.selectOne("mybatis.mapper.mapperBoard.getNextArticle", hashmap);
        return result;
    }
    @Override
    public ModelArticle getPrevArticle(Map<String, Object> hashmap) {
        ModelArticle result = null;
        result = session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle", hashmap);
        return result;
    }
    
    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        ModelAttachfile result = null;
        result = session.selectOne("mybatis.mapper.mapperBoard.getAttachFile", attachFileNo);
        return result;
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
        List<ModelAttachfile> result = null;
        result = session.selectList("mybatis.mapper.mapperBoard.getAttachFileList",articleno);
        return result;
    }
    
    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        int result = 0;
        result = session.insert("mybatis.mapper.mapperBoard.insertAttachFile", attachFile);
        return result;
    }
    
    
    @Override
    public int deleteAttachFile(ModelAttachfile attachFileNo) {
        int result = 0;
        result = session.delete("mybatis.mapper.mapperBoard.deleteAttachFile",
                attachFileNo);
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        int result = 0;
        result = session.insert("mybatis.mapper.mapperBoard.insertComment", comment);
        return result;
    }
    
    
    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        int result = 0;
        Map<String, Object> parameter = new HashMap<String, Object>();
        
        parameter.put("updateValue", updateValue);
        parameter.put("searchValue", searchValue);
        
        result = session.update("mybatis.mapper.mapperBoard.updateComment",parameter);
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments commentno) {
        int result = 0;
        result = session.delete("mybatis.mapper.mapperBoard.deleteComment", commentno);
        return result;
    }
    
    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments result = null;
        result = session.selectOne("mybatis.mapper.mapperBoard.getComment", commentNo);
        return result;
    }
    @Override
    public List<ModelComments> getCommentList(int articleno) {
        List<ModelComments> result = null;
        result = session.selectList("mybatis.mapper.mapperBoard.getCommentList",articleno);
        return result;
    }
    
    public SqlSession getsession() {
        return session;
    }
    
    public void setsession(SqlSession session) {
        this.session = session;
    }
    
    public DaoBoard(SqlSession session) {
        super();
        this.session = session;
    }
    
    public DaoBoard() {
        super();
    }

    @Override
    public String toString() {
        return "DaoBoard [session=" + session + "]";
    }

    
}
