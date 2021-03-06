USE [master]
GO
/****** Object:  Database [DeliveryManagement]    Script Date: 3/11/2018 10:54:31 AM ******/
CREATE DATABASE [DeliveryManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DeliveryManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\DeliveryManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DeliveryManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\DeliveryManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [DeliveryManagement] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DeliveryManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DeliveryManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DeliveryManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DeliveryManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DeliveryManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DeliveryManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [DeliveryManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DeliveryManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DeliveryManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DeliveryManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DeliveryManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DeliveryManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DeliveryManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DeliveryManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DeliveryManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DeliveryManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DeliveryManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DeliveryManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DeliveryManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DeliveryManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DeliveryManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DeliveryManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DeliveryManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DeliveryManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DeliveryManagement] SET  MULTI_USER 
GO
ALTER DATABASE [DeliveryManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DeliveryManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DeliveryManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DeliveryManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DeliveryManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DeliveryManagement] SET QUERY_STORE = OFF
GO
USE [DeliveryManagement]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [DeliveryManagement]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 3/11/2018 10:54:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[custID] [varchar](10) NOT NULL,
	[password] [varchar](30) NOT NULL,
	[custName] [varchar](15) NOT NULL,
	[lastName] [varchar](15) NULL,
	[middleName] [varchar](15) NULL,
	[address] [varchar](250) NULL,
	[phone] [varchar](11) NULL,
	[custLevel] [int] NOT NULL,
 CONSTRAINT [PK_customer] PRIMARY KEY CLUSTERED 
(
	[custID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_book]    Script Date: 3/11/2018 10:54:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_book](
	[booktID] [varchar](10) NOT NULL,
	[title] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_tbl_book] PRIMARY KEY CLUSTERED 
(
	[booktID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_order]    Script Date: 3/11/2018 10:54:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_order](
	[orderID] [varchar](10) NOT NULL,
	[orderDate] [datetime] NULL,
	[custID] [varchar](10) NOT NULL,
	[total] [float] NULL,
	[isDeliver] [bit] NOT NULL,
	[Reason] [varchar](250) NULL,
 CONSTRAINT [PK_tbl_order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_orderDetail]    Script Date: 3/11/2018 10:54:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_orderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[productID] [varchar](10) NOT NULL,
	[quantity] [int] NULL,
	[unitPrice] [float] NULL,
	[total] [float] NULL,
	[orderID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tbl_orderDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tbl_order]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_customer] FOREIGN KEY([custID])
REFERENCES [dbo].[customer] ([custID])
GO
ALTER TABLE [dbo].[tbl_order] CHECK CONSTRAINT [FK_tbl_order_customer]
GO
ALTER TABLE [dbo].[tbl_orderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_orderDetail_tbl_book] FOREIGN KEY([productID])
REFERENCES [dbo].[tbl_book] ([booktID])
GO
ALTER TABLE [dbo].[tbl_orderDetail] CHECK CONSTRAINT [FK_tbl_orderDetail_tbl_book]
GO
ALTER TABLE [dbo].[tbl_orderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_orderDetail_tbl_order] FOREIGN KEY([orderID])
REFERENCES [dbo].[tbl_order] ([orderID])
GO
ALTER TABLE [dbo].[tbl_orderDetail] CHECK CONSTRAINT [FK_tbl_orderDetail_tbl_order]
GO
USE [DeliveryManagement]
﻿INSERT INTO DeliveryManagement.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES (
'abc','abc','abc',NULL,NULL,NULL,NULL,0);
INSERT INTO DeliveryManagement.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES (
'abcd','abcd','abcd',NULL,NULL,NULL,NULL,0);
INSERT INTO DeliveryManagement.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES (
'duong','duong','Duong','Phan Tran','Hoang','285/4 A4/4 TCH 10','01674484419',0);
INSERT INTO DeliveryManagement.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES (
'efg','efg','efg','','','','',0);
INSERT INTO DeliveryManagement.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES (
'poh','poh','poh','','','','',0);
INSERT INTO DeliveryManagement.dbo.customer (custID,password,custName,lastName,middleName,address,phone,custLevel) VALUES (
'yhn','yhn','yhn','','','','',0);
﻿INSERT INTO DeliveryManagement.dbo.tbl_book (booktID,title,price,quantity) VALUES (
'B0001','EJB',45,10);
INSERT INTO DeliveryManagement.dbo.tbl_book (booktID,title,price,quantity) VALUES (
'B0002','Oracle HeadFirst',100,15);
INSERT INTO DeliveryManagement.dbo.tbl_book (booktID,title,price,quantity) VALUES (
'B0003','MSQL Server HeadFirst',85,20);
INSERT INTO DeliveryManagement.dbo.tbl_book (booktID,title,price,quantity) VALUES (
'B0004','Java HeadFirst',75,30);
﻿INSERT INTO DeliveryManagement.dbo.tbl_order (orderID,orderDate,custID,total,isDeliver,Reason) VALUES (
'OD001',{ts '2018-03-08 00:00:00.000'},'duong',90,0,'Not at home when delivered');
INSERT INTO DeliveryManagement.dbo.tbl_order (orderID,orderDate,custID,total,isDeliver,Reason) VALUES (
'OD002',{ts '2018-03-12 00:00:00.000'},'duong',300,1,'Success');
INSERT INTO DeliveryManagement.dbo.tbl_order (orderID,orderDate,custID,total,isDeliver,Reason) VALUES (
'OD003',{ts '2018-03-10 00:00:00.000'},'duong',425,0,'Not accepted');
INSERT INTO DeliveryManagement.dbo.tbl_order (orderID,orderDate,custID,total,isDeliver,Reason) VALUES (
'OD004',{ts '2018-03-04 00:00:00.000'},'duong',75,1,'Success');
﻿INSERT INTO DeliveryManagement.dbo.tbl_orderDetail (id,productID,quantity,unitPrice,total,orderID) VALUES (
3,'B0001',2,45,90,'OD001');
INSERT INTO DeliveryManagement.dbo.tbl_orderDetail (id,productID,quantity,unitPrice,total,orderID) VALUES (
5,'B0002',3,100,300,'OD002');
INSERT INTO DeliveryManagement.dbo.tbl_orderDetail (id,productID,quantity,unitPrice,total,orderID) VALUES (
6,'B0003',5,85,425,'OD003');
INSERT INTO DeliveryManagement.dbo.tbl_orderDetail (id,productID,quantity,unitPrice,total,orderID) VALUES (
7,'B0004',1,75,75,'OD004');
GO
USE [master]
GO
ALTER DATABASE [DeliveryManagement] SET  READ_WRITE 
GO
