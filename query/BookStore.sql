use BookStore

create table INFOMATION_AC (
	idInfo int identity(1,1),
	name nvarchar(50),
	birthOfDay nvarchar(50),
	gender bit,
	job nvarchar(50),
	phoneNumber nvarchar(20),
	primary key (idInfo)
)

create table ACCOUNT (
	idAc int identity(1,1),
	userName nvarchar(20),
	passwords nvarchar(20),
	idInfo int,
	primary key (idAc),
	foreign key (idInfo) references INFOMATION_AC (idInfo)
)

create table TYPEBOOK (
	idTy int identity(1,1),
	nameTy nvarchar(50)
	primary key(idTy)
)

create table AUTHOR(
	idAu int identity(1,1),
	nameAu nvarchar(50),
	primary key (idAu)
)

create table BOOK (
	idBook int identity(1,1),
	nameBook nvarchar(50),
	idType int,
	idAuthor int,
	idAccount int,
	primary key (idBook),
	foreign key (idType) references TYPEBOOK (idTy),
	foreign key (idAuthor) references AUTHOR (idAu),
	foreign key (idAccount) references ACCOUNT (idAc)
)

/**delete table */

drop table BOOK;
drop table ACCOUNT;
drop table INFOMATION_AC;
drop table TYPEBOOK;
drop table AUTHOR;