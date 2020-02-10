CREATE TABLE tbl_member (
    userId      varchar2(50)    not null,
    userPass    varchar2(100)   not null,
    userName    varchar2(30)    not null,
    userPhon    varchar2(20)    not null,
    userAddr1   varchar2(20)    null,	--- 우편번호
    userAddr2   varchar2(50)    null,	--- 주소
    userAddr3   varchar2(50)    null,	--- 상세 주소
    regiDate    date            default sysdate,
    verify      number          default 0,	--- 이메일 인증(0:이메일 인증이 되지 않은 상태, 0이상:이메일 인증이 된 상태)
    primary key(userId)
);

CREATE TABLE tbl_goods (
    gdsNum       number          not null,
    gdsName      varchar2(50)    not null,
    cateCode     varchar2(30)    not null,	--- 상품 분류번호
    gdsPrice     number          not null,
    gdsStock     number          null,		--- 상품 수량
    gdsDes       varchar(500)    null,		--- 상품 설명
    gdsImg       varchar(200)    null,
    gdsDate      date            default sysdate,
    primary key(gdsNum)  
);


create table goods_category (		--- 2차 분류를 위한 TABLE
    cateName     varchar2(20)    not null,		--- 카테고리 이름
    cateCode     varchar2(30)    not null,		--- 카테고리 코드
    cateCodeRef  varchar2(30)    null,		--- 카테고리 참조 코드 : 상위 카테고리가 무엇인지 가리키는 코드 (NULL 이면 최상위 카테고리로 아무것도 참고 하지 않는다.)
    primary key(cateCode),
    foreign key(cateCodeRef) references goods_category(cateCode)
);

CREATE SEQUENCE tbl_goods_seq;