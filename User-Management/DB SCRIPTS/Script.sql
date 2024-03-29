CREATE TABLE DMO_D_CRD."USER_DM_USER" (
                                  USER_ID NUMBER(38,0) NOT NULL,
                                  USER_NAME VARCHAR2(100) NULL,
                                  F_NAME VARCHAR2(100) NULL,
                                  M_NAME VARCHAR2(100) NULL,
                                  L_NAME VARCHAR2(100) NULL,
                                  DOB VARCHAR2(100) NULL,
                                  ADDED_DATE DATE NULL,
                                  ADDED_BY VARCHAR2(100) NULL,
                                  PASSWORD VARCHAR2(2000) NULL

);


CREATE INDEX USER_USER_ID_IDX ON DMO_D_CRD."USER_DM_USER" (USER_ID);

CREATE SEQUENCE USER_SEQ_NO
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;



ALTER TABLE USER_DM_USER
    ADD CONSTRAINT USER_DM_USER_PK PRIMARY KEY (USER_ID)
    ENABLE;

ALTER TABLE USER_DM_USER
    ADD CONSTRAINT USER_DM_USER_UN UNIQUE (USER_ID)
    ENABLE;


CREATE TABLE "USER_TOKEN_STORE"
(	"USER_NAME" VARCHAR2(100),
     "JWT_TOKEN" VARCHAR2(1000),
     "ADDED_DATE" DATE,
     "MODIFY_DATE" DATE
) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DMODAPP" ;