-- �μ� ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Bbs_Board CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Bbs_Article CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Bbs_Comments CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Bbs_Attachfile CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

-- �Խ��� ���� ���̺�
CREATE TABLE TB_Bbs_Board (
      boardcd       VARCHAR2(20)    NOT NULL ENABLE
    , boardnm       VARCHAR2(40)    NOT NULL ENABLE
                                   
    , UseYN         NUMBER(1)       DEFAULT 1 NOT NULL ENABLE
                                   
    , InsertUID     VARCHAR(40)     NULL                            
    , InsertDT      Date            NULL
    , UpdateUID     VARCHAR(40)     NULL                            
    , UpdateDT      Date            NULL
    
    , PRIMARY KEY(boardcd)
);

insert into TB_Bbs_Board(boardcd, boardnm) values ('free','�����Խ���');
insert into TB_Bbs_Board(boardcd, boardnm) values ('qna' ,'QnA�Խ���' );
insert into TB_Bbs_Board(boardcd, boardnm) values ('data','�ڷ��'    );

select * from TB_Bbs_Board;



-- �Խñ� ���̺�
CREATE TABLE TB_Bbs_Article (
      articleno     NUMBER(10)    generated as identity
    , boardcd       VARCHAR2(20)
    , title         VARCHAR2(200) NOT NULL
    , content       VARCHAR2(200)
    , email         VARCHAR2(60)
    , hit           NUMBER(10)    DEFAULT 0  NOT NULL ENABLE
    , regdate       Date
                       
    , UseYN         NUMBER(1)    DEFAULT 1 NOT NULL ENABLE 
                                  
    , InsertUID     VARCHAR(40)   NULL                            
    , InsertDT      Date      NULL
    , UpdateUID     VARCHAR(40)   NULL                            
    , UpdateDT      Date      NULL
    
    , PRIMARY KEY(articleno)
    , FOREIGN KEY(boardcd) REFERENCES TB_Bbs_Board(boardcd)
);

insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 01', 'article test 01', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 02', 'article test 02', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 03', 'article test 03', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 04', 'article test 04', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 05', 'article test 05', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 06', 'article test 06', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 07', 'article test 07', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 08', 'article test 08', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 09', 'article test 09', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 10', 'article test 10', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 11', 'article test 11', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 12', 'article test 12', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 13', 'article test 13', 'aa@aa.co.kr', 0, sysdate, 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article test 14', 'article test 14', 'aa@aa.co.kr', 0, sysdate, 1 );

select * from TB_Bbs_Article;



-- ���� ���̺�
CREATE TABLE TB_Bbs_Comments (
      commentno     NUMBER(10)     generated as identity 
    , articleno     NUMBER(10)     NOT NULL     
    , email         VARCHAR2(60)  
    , memo          VARCHAR2(4000)
    , regdate       Date 
                       
    , UseYN         NUMBER(1)       DEFAULT 1 NOT NULL ENABLE      
                                     
    , InsertUID     VARCHAR(40)      NULL                            
    , InsertDT      Date         NULL
    , UpdateUID     VARCHAR(40)      NULL                            
    , UpdateDT      Date         NULL
    
    , PRIMARY KEY(commentno)
);

insert into TB_Bbs_Comments( articleno, email, memo, regdate, UseYN  ) values ( 1, 'aa@aa.co.kr', 'comment test', sysdate, 1 );
      
select * from TB_Bbs_Comments;     
           
           
-- ÷������ ���̺�
CREATE TABLE TB_Bbs_Attachfile (
      attachfileno   NUMBER(10)    generated as identity 
    , filename       VARCHAR2(50)    NOT NULL
    , filetype       VARCHAR2(30)    
    , filesize       NUMBER(10)             
    , articleno      NUMBER(10)             
                                     
    , UseYN          NUMBER(1)      DEFAULT 1 NOT NULL ENABLE     
                                     
    , InsertUID      VARCHAR(40)     NULL                            
    , InsertDT       Date        NULL
    , UpdateUID      VARCHAR(40)     NULL                            
    , UpdateDT       Date        NULL
    
    , PRIMARY KEY(attachfileno)
);

select * from TB_Bbs_Attachfile;   


