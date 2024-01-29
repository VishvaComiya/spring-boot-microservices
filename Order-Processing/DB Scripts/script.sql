CREATE SEQUENCE ORDER_SEQ_NO
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;




CREATE TABLE DMO_D_CRD.ORDER_DM_ORDER (
                                          ORDER_ID NUMBER(38,0) NOT NULL,
                                          ORDER_DECS VARCHAR2(100) NULL,
                                          USER_ID NUMBER(38,0) NULL,
                                          PRODUCT_ID NUMBER(38,0) NULL,
                                          ADDED_DATE DATE NULL,
                                          STATUS VARCHAR2(100) NULL,
                                          CONSTRAINT ORDER_DM_ORDER_PK PRIMARY KEY (ORDER_ID),
                                          CONSTRAINT FK_USER_DM_USER FOREIGN KEY (USER_ID) REFERENCES DMO_D_CRD.USER_DM_USER(USER_ID),
                                          CONSTRAINT FK_PROD_DM_PROD FOREIGN KEY (PRODUCT_ID) REFERENCES DMO_D_CRD.PROD_DM_PROD(PROD_ID)
);
