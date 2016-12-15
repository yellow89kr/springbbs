package mybatis.test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
import mybatis.service.IServiceBoard;
import mybatis.service.ServiceBoard;

public class TestServiceBoard {
    
    private static SqlSession         session = null;
    
    // SLF4J Logging
    private static Logger             logger  = LoggerFactory
            .getLogger(TestServiceBoard.class);
    private static ApplicationContext context = null;
    private static IServiceBoard      serviceboard = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext(
                "classpath:ApplicationContext.xml");
        
        serviceboard = context.getBean("serviceBoard", IServiceBoard.class);
        
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
    public void test() {
        fail("Not yet implemented");
    }
    
    @Test
    public void getBoardName() {
        
 
        String result = serviceboard.getBoardName("free");
        assertEquals(result, "자유게시판");
    }
    
    @Test
    public void getBoardOne() {
        
 
        ModelBoard result = serviceboard.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
    }
    
    @Test
    public void getBoardTotalRecord() {
        // TODO Auto-generated method stub
        
    }
    
    @Test
    public void getBoardList() {
 
        List<ModelBoard> result = serviceboard.getBoardList();
        assertSame(result.size(), 3);
    }
    
    @Test
    public void getBoardListResultMap() {
 
        List<ModelBoard> result = serviceboard.getBoardListResultMap();
        assertSame(result.size(), 3);
    }
    
    @Test
    public void insertBoard() throws SQLException {
        ModelBoard board = new ModelBoard();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        board.setBoardcd("네네");
        board.setBoardnm("맵스터");
        board.setUseYN(true);
        board.setInsertDT(form);
        board.setInsertUID("빌빌");
        board.setUpdateDT(form);
        board.setUpdateUID("볼볼");
       
        int result = serviceboard.insertBoard(board);
        assertSame(result, 1);
    }
    
    @Test
    public void updateBoard() throws SQLException {
        ModelBoard updateValue = new ModelBoard();
        updateValue.setBoardnm("멕시칸");
        updateValue.setUseYN(false);
        
        ModelBoard SearchValue = new ModelBoard();
        SearchValue.setBoardcd("data");
        
  
        int result = serviceboard.updateBoard(updateValue, SearchValue);
        assertSame(result, 1);
    }
    
    @Test
    public void deleteBoard() throws SQLException {
        ModelBoard SearchValue = new ModelBoard();
        SearchValue.setBoardcd("굽네");
        
  
        int result = serviceboard.deleteBoard(SearchValue);
        assertSame(result, 1);
    }
    
    @Test
    public void getBoardSearch() {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("d");
  
        List<ModelBoard> result = serviceboard.getBoardSearch(board);
        assertSame(result.size(), 1);
        
    }
    
    @Test
    public void getBoardPaging() {
  
        String boardCd = "";
        String boardnm = "";
        int start = 1;
        int end = 2;
        List<ModelBoard> result = serviceboard.getBoardPaging(boardCd, boardnm,
                start, end);
        assertSame(result.size(), 2);
        
    }
    
    @Test
    public void insertBoardList() {
        ModelBoard Board = null;
        List<ModelBoard> list = new ArrayList<ModelBoard>();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        String dtm = day.format(form);
        for (int i = 0; i < 10; i = i + 1) {
            
            Board = new ModelBoard();
            Board.setBoardcd("호식이" + dtm + "-" + i);
            Board.setBoardnm("고추바사삭" + dtm + "-" + i);
            Board.setUseYN(true);
            
            list.add(Board);
        }
  
        int result = serviceboard.insertBoardList(list);
        assertSame(result, 10);
    }
    
    @Test
    public void getArticleList() {
  
        String boardCd = "free";
        String searchWord = "article";
        int start = 2;
        int end = 7;
        List<ModelArticle> result = serviceboard.getArticleList(boardCd, searchWord,
                start, end);
        assertEquals(result.size(), 6);
        
    }
    
    @Test
    public void getArticle() {
  
        ModelArticle result = serviceboard.getArticle(1);
        assertSame(result.getArticleno(), 1);
        
    }
    
    @Test
    public void getArticleTotalRecord() {
        ModelArticle Article = new ModelArticle();
        String title = "test";
        String Content = ("test");
  
        int result = serviceboard.getArticleTotalRecord(title, Content);
        assertSame(result, 14);
        
    }
    
    @Test
    public void insertArticle() {
        ModelArticle board = new ModelArticle();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        board.setBoardcd("free");
        board.setTitle("Ocle1");
        board.setuseyn(true);
        board.setContent("bong");
        board.setEmail("yellow89kranmail.net");
        board.setRegdate(form);
        board.setInsertuid("강상");
        board.setInsertdt(form);
        board.setUpdatedt(form);
        board.setUpdateuid("빵상");
        
  
        int result = serviceboard.insertArticle(board);
        assertSame(result, 1);
    }
    
    @Test
    public void updateArticle() {
        ModelArticle updateValue = new ModelArticle();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        // updateValue.setBoardcd("free");
        updateValue.setContent("bbong");
        updateValue.setEmail("yellow89kr@hanmail.net");
        updateValue.setInsertdt(form);
        updateValue.setInsertuid("Qkd");
        // updateValue.setRegdate(form);
        updateValue.setTitle("zzang");
        updateValue.setUpdatedt(form);
        updateValue.setUpdateuid("Qld");
        updateValue.setuseyn(true);
        
        ModelArticle SearchValue = new ModelArticle();
        SearchValue.setTitle("article test 01");
        
  
        int result = serviceboard.updateArticle(updateValue, SearchValue);
        assertSame(result, 1);
    }
    
    @Test
    public void deleteArticle() {
        ModelArticle SearchValue = new ModelArticle();
        SearchValue.setBoardcd("free");
        
  
        int result = serviceboard.deleteArticle(SearchValue);
        assertSame(result, 1);
    }
    
    @Test
    public void increaseHit() {
  
        int articleno = 1;
        
        ModelArticle beforearticle = serviceboard.getArticle(articleno);
        serviceboard.increaseHit(articleno);
        ModelArticle afterarticle = serviceboard.getArticle(articleno);
        
        assertSame(beforearticle.getHit() + 2, afterarticle.getHit());
    }
    
    @Test
    public void getNextArticle() {
  
        ModelArticle result = serviceboard.getNextArticle(1, "free", "");
        assertSame(result.getArticleno(), 2);
        
    }
    
    @Test
    public void getPrevArticle() {
  
        ModelArticle result = serviceboard.getPrevArticle(4, "free", "");
        assertSame(result.getArticleno(), 3);
        
    }
    
    @Test
    public void getAttachFileList() {
  
        List<ModelAttachfile> result = serviceboard.getAttachFileList(1);
        assertSame(result.size(), 6);
        
    }
    
    @Test
    public void getAttachFile() {
  
        ModelAttachfile result = serviceboard.getAttachFile(2);
        assertSame(result.getArticleno(), 1);
        
    }
    
    @Test
    public void insertAttachFile() {
        ModelAttachfile board = new ModelAttachfile();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        board.setFilename("박파일");
        board.setFilesize(2);
        board.setFiletype("퐕타입");
        board.setArticleno(2);
        board.setInsertDT(form);
        board.setInsertUID("어탯치");
        board.setUpdateDT(form);
        board.setUpdateUID("어태취");
        board.setUseYN(true);
        
  
        int result = serviceboard.insertAttachFile(board);
        assertSame(result, 1);
    }
    
    @Test
    public void deleteAttachFile() {
        ModelAttachfile SearchValue = new ModelAttachfile();
        SearchValue.setAttachfileno(1);
        
  
        int result = serviceboard.deleteAttachFile(SearchValue);
        assertSame(result, 1);
    }
    
    @Test
    public void getCommentList() {
  
        List<ModelComments> result = serviceboard.getCommentList(2);
        assertSame(result.size(), 1);
        
    }
    
    @Test
    public void getComment() {
  
        ModelComments result = serviceboard.getComment(1);
        assertSame(result.getCommentno(), 1);
        
    }
    
    @Test
    public void insertComment() {
        ModelComments board = new ModelComments();
        Date form = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        board.setArticleno(2);
        board.setEmail("yellow89kr@hanmail.net");
        board.setInsertDT(form);
        board.setInsertUID("톼톼");
        board.setMemo("틔틔");
        board.setRegdate(form);
        board.setUpdateDT(form);
        board.setUpdateUID("붱붱");
        board.setUseYN(true);
        
  
        int result = serviceboard.insertComment(board);
        assertSame(result, 1);
    }
    
    @Test
    public void updateComment() {
        ModelComments updateValue = new ModelComments();
        // Date form = new Date();
        // SimpleDateFormat day = new SimpleDateFormat("yy-mm-dd");
        // updateValue.setArticleno(5);
        // updateValue.setCommentno(commentno);
        updateValue.setEmail("hite89@hanmail.net");
        // updateValue.setInsertDT(form);
        // updateValue.setInsertUID("달봉쩔지");
        updateValue.setMemo("달래");
        // updateValue.setRegdate(form);
        // updateValue.setUpdateDT(form);
        // updateValue.setUpdateUID("플럼시즌");
        updateValue.setUseYN(false);
        
        ModelComments searchValue = new ModelComments();
        searchValue.setArticleno(1);
        
  
        int result = serviceboard.updateComment(updateValue, searchValue);
        assertSame(result, 1);
    }
    
    @Test
    public void deleteComment() {
        ModelComments searchValue = new ModelComments();
        searchValue.setCommentno(1);
        
  
        int result = serviceboard.deleteComment(searchValue);
        assertSame(result, 1);
    }
    
    public static SqlSession getSession() {
        return session;
    }
    
    public static void setSession(SqlSession session) {
        TestServiceBoard.session = session;
    }
}
