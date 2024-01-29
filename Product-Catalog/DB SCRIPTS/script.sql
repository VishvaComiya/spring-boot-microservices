CREATE TABLE DMO_D_USR.PROD_DM_PROD (
                                        PROD_ID NUMBER(38,0) NOT NULL,
                                        PROD_NAME VARCHAR2(100) NULL,
                                        PROD_DESCRIPTION VARCHAR2(100) NULL,
                                        ADDED_BY VARCHAR2(100) NULL,
                                        ADDED_DATE DATE NULL,
                                        MODIFY_BY VARCHAR2(100) NULL,
                                        MODIFY_DATE DATE NULL
);



CREATE SEQUENCE PROD_SEQ_NO
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;


ALTER TABLE DMO_D_USR.PROD_DM_PROD
    ADD CONSTRAINT PROD_DM_PROD_UN UNIQUE (PROD_ID)
    ENABLE;
