CREATE OR REPLACE PROCEDURE proc_chatlogin(p_id IN varchar2
                                          ,p_pw IN varchar2
                                          ,msg  OUT SYS_REFCURSOR)
IS

BEGIN
    OPEN msg FOR
    SELECT
        NVL((SELECT mem_nick FROM CHAT_MEMBER 
            WHERE mem_id = p_id
            AND   mem_pw =p_pw),'실패') mem_nick
    FROM dual;    
END;


----------------------------------------------------------------------

variable msg varchar2(50);

exec proc_login(UserID,UserPW, :msg);    --Procerdure 실행

print msg; 


----------------------------------------------------------------------

INSERT INTO CHAT_MEMBER 
       VALUES ( '3', 'cherryBon', 'Cherrybts', 'Boni', 'cherry', 'cheery@goole.com'
                , '01041543652', '1991-07-28', '2019-06-30' );

commit;

----------------------------------------------------------------------

SELECT
        NVL(SELECT mem_nick FROM CHAT_MEMBER 
            WHERE mem_id = 'test'
            AND   mem_pw ='123') mem_nick
    FROM dual
    
----------------------------------------------------------------------