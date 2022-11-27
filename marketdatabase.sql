DROP TABLE BUYING;

CREATE TABLE BUYING
(

    Offer         VarCHAR(20),
    Time/Location VarCHAR(100),
    QAsking       Number(20),
    Seller        VarCHAR(20),
    QItem         VarCHAR(20),
    
    /* easily scalable through adding columns here 
       since entries are added so easily through java almost no change is required in the backend */

    CONSTRAINT PK_BUYING
        PRIMARY KEY(Seller,Offer) /* this uniquely identifies every trade offer */

);
