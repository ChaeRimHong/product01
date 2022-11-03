# product01
가계부 
SpringBoot로 가계부(게시판)만들기

//프로젝트 개요
- https://docs.google.com/document/d/1d3hVYmBePPIEpAue3NcyP8CYCF3LTdBQ_N5SRccC974/edit?usp=sharing

DB
```
<![CDATA[
CREATE TABLE product(
    id INTEGER not null PRIMARY key,
    name VARCHAR2(100) NOT NULL,
    count INTEGER not null,
    price INTEGER not null,
    cost INTEGER not null,
    market VARCHAR2(100),
    category VARCHAR2(100),
    readcnt INTEGER,
    writeday date DEFAULT sysdate 
    updateday date DEFAULT sysdate );
    
create SEQUENCE product_seq;
]]>

<![CDATA[
CREATE TABLE file01(
    fileid INTEGER not null PRIMARY key,
    storefilename VARCHAR2(100) NOT NULL,
    uploadfilename VARCHAR2(100) NOT NULL );
    
create SEQUENCE fileid_seq;

]]>
```

>깃허브 마크다운 
>https://gist.github.com/ihoneymon/652be052a0727ad59601
