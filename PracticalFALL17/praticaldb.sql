USE [master]
GO
/****** Object:  Database [PraticalDB]    Script Date: 3/18/2018 9:10:22 PM ******/
CREATE DATABASE [PraticalDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PraticalDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\PraticalDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PraticalDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\PraticalDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PraticalDB] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PraticalDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PraticalDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PraticalDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PraticalDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PraticalDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PraticalDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [PraticalDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PraticalDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PraticalDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PraticalDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PraticalDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PraticalDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PraticalDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PraticalDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PraticalDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PraticalDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PraticalDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PraticalDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PraticalDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PraticalDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PraticalDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PraticalDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PraticalDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PraticalDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PraticalDB] SET  MULTI_USER 
GO
ALTER DATABASE [PraticalDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PraticalDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PraticalDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PraticalDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PraticalDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PraticalDB] SET QUERY_STORE = OFF
GO
USE [PraticalDB]
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [PraticalDB]
GO
/****** Object:  Table [dbo].[tbl_Pet]    Script Date: 3/18/2018 9:10:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Pet](
	[petId] [varchar](5) NOT NULL,
	[petName] [varchar](50) NOT NULL,
	[description] [varchar](250) NOT NULL,
	[dob] [datetime] NOT NULL,
	[vaccineDesp] [varchar](250) NULL,
	[price] [float] NULL,
	[registerDate] [datetime] NOT NULL,
	[approveReg] [int] NULL,
	[userId] [varchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_Pet] PRIMARY KEY CLUSTERED 
(
	[petId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 3/18/2018 9:10:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_User](
	[userId] [varchar](20) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [varchar](50) NOT NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tbl_Pet] ([petId], [petName], [description], [dob], [vaccineDesp], [price], [registerDate], [approveReg], [userId]) VALUES (N'423', N'vit dien', N'123', CAST(N'2015-10-03T00:00:00.000' AS DateTime), N'456', 345, CAST(N'2017-10-30T10:53:20.723' AS DateTime), 0, N'khanhkt')
INSERT [dbo].[tbl_Pet] ([petId], [petName], [description], [dob], [vaccineDesp], [price], [registerDate], [approveReg], [userId]) VALUES (N'523', N'meo khung', N'abc', CAST(N'2000-01-01T00:00:00.000' AS DateTime), N'567', 200, CAST(N'2017-10-30T10:52:38.207' AS DateTime), 0, N'khanhkt')
INSERT [dbo].[tbl_Pet] ([petId], [petName], [description], [dob], [vaccineDesp], [price], [registerDate], [approveReg], [userId]) VALUES (N'p01', N'cat', N'small, ', CAST(N'2017-10-01T00:00:00.000' AS DateTime), N'twicea', 2, CAST(N'2017-10-27T11:57:03.730' AS DateTime), 0, N'ngoc')
INSERT [dbo].[tbl_Pet] ([petId], [petName], [description], [dob], [vaccineDesp], [price], [registerDate], [approveReg], [userId]) VALUES (N'p02', N'dog', N'small', CAST(N'2017-10-02T00:00:00.000' AS DateTime), N'once', 22, CAST(N'2017-10-27T00:00:00.000' AS DateTime), 0, N'ngoc')
INSERT [dbo].[tbl_Pet] ([petId], [petName], [description], [dob], [vaccineDesp], [price], [registerDate], [approveReg], [userId]) VALUES (N'p03', N'bird', N'none', CAST(N'2017-09-25T00:00:00.000' AS DateTime), N'once', 30, CAST(N'2017-10-27T00:00:00.000' AS DateTime), 1, N'vy')
INSERT [dbo].[tbl_Pet] ([petId], [petName], [description], [dob], [vaccineDesp], [price], [registerDate], [approveReg], [userId]) VALUES (N'p04', N'fish', N'yellow', CAST(N'2017-10-25T00:00:00.000' AS DateTime), N'none', 10, CAST(N'2017-10-27T00:00:00.000' AS DateTime), 2, N'vy')
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'khanhcaca', 1234, N'12345', 1)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'khanhkt', 5562, N'Khanh Ðai Ca', 0)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'ngoc', 123, N'Thuy Ngoc', 0)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'vy', 123, N'Vy', 1)
USE [master]
GO
ALTER DATABASE [PraticalDB] SET  READ_WRITE 
GO
