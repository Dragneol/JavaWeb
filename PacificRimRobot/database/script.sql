USE [master]
GO
/****** Object:  Database [PacificRimRobot]    Script Date: 5/1/2018 6:08:25 PM ******/
CREATE DATABASE [PacificRimRobot]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PacificRimRobot', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\PacificRimRobot.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PacificRimRobot_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\PacificRimRobot_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PacificRimRobot] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PacificRimRobot].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PacificRimRobot] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PacificRimRobot] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PacificRimRobot] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PacificRimRobot] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PacificRimRobot] SET ARITHABORT OFF 
GO
ALTER DATABASE [PacificRimRobot] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PacificRimRobot] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PacificRimRobot] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PacificRimRobot] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PacificRimRobot] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PacificRimRobot] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PacificRimRobot] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PacificRimRobot] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PacificRimRobot] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PacificRimRobot] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PacificRimRobot] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PacificRimRobot] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PacificRimRobot] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PacificRimRobot] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PacificRimRobot] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PacificRimRobot] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PacificRimRobot] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PacificRimRobot] SET RECOVERY FULL 
GO
ALTER DATABASE [PacificRimRobot] SET  MULTI_USER 
GO
ALTER DATABASE [PacificRimRobot] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PacificRimRobot] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PacificRimRobot] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PacificRimRobot] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PacificRimRobot] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'PacificRimRobot', N'ON'
GO
ALTER DATABASE [PacificRimRobot] SET QUERY_STORE = OFF
GO
USE [PacificRimRobot]
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
USE [PacificRimRobot]
GO
/****** Object:  Table [dbo].[Ability]    Script Date: 5/1/2018 6:08:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ability](
	[Pilot] [nvarchar](50) NOT NULL,
	[BattleTypeId] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Ability] PRIMARY KEY CLUSTERED 
(
	[Pilot] ASC,
	[BattleTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BattleSkill]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BattleSkill](
	[Robot] [nvarchar](50) NOT NULL,
	[BattleTypeId] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Robot] ASC,
	[BattleTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Equiment]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Equiment](
	[WeaponId] [nvarchar](10) NOT NULL,
	[Robot] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[WeaponId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[General]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[General](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Available] [bit] NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[MiddleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_General] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pilot]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pilot](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NULL,
	[Weight] [float] NULL,
	[Height] [float] NULL,
	[Available] [bit] NOT NULL,
	[GroupCode] [nvarchar](10) NOT NULL,
	[Citizenship] [nvarchar](50) NULL,
	[Ranker] [nvarchar](20) NULL,
	[ImgLink] [nvarchar](100) NULL,
 CONSTRAINT [PK_Pilot] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rider]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rider](
	[GroupCode] [nvarchar](10) NOT NULL,
	[Robot] [nvarchar](50) NULL,
	[Pilot] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Robot]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Robot](
	[Robot] [nvarchar](50) NOT NULL,
	[Available] [bit] NOT NULL,
	[DateLauched] [date] NULL,
	[Classified] [nvarchar](10) NULL,
	[Origin] [nvarchar](50) NULL,
	[KaijuKilled] [int] NULL,
	[ImgLink] [nvarchar](100) NULL,
 CONSTRAINT [PK_Robot] PRIMARY KEY CLUSTERED 
(
	[Robot] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Skill]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skill](
	[BattleTypeId] [nvarchar](10) NOT NULL,
	[BattleSkill] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[BattleTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Weapon]    Script Date: 5/1/2018 6:08:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Weapon](
	[WeaponCode] [nvarchar](10) NOT NULL,
	[Available] [bit] NOT NULL,
	[BattleTypeId] [nvarchar](10) NULL,
	[Carriable] [bit] NULL,
	[WeaponName] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[WeaponCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ability] ([Pilot], [BattleTypeId]) VALUES (N'amara', N'type1')
INSERT [dbo].[Ability] ([Pilot], [BattleTypeId]) VALUES (N'jake', N'type1')
INSERT [dbo].[Ability] ([Pilot], [BattleTypeId]) VALUES (N'nate', N'type5')
INSERT [dbo].[BattleSkill] ([Robot], [BattleTypeId]) VALUES (N'Gipsy Avenger', N'type1')
INSERT [dbo].[BattleSkill] ([Robot], [BattleTypeId]) VALUES (N'Gipsy Avenger', N'type2')
INSERT [dbo].[BattleSkill] ([Robot], [BattleTypeId]) VALUES (N'Gipsy Avenger', N'type3')
INSERT [dbo].[BattleSkill] ([Robot], [BattleTypeId]) VALUES (N'Gipsy Avenger', N'type5')
INSERT [dbo].[Equiment] ([WeaponId], [Robot]) VALUES (N'weapon3', N'Gipsy Avenger')
INSERT [dbo].[Equiment] ([WeaponId], [Robot]) VALUES (N'weapon7', N'Gipsy Avenger')
INSERT [dbo].[Equiment] ([WeaponId], [Robot]) VALUES (N'weapon9', N'Saber Athena')
INSERT [dbo].[General] ([Username], [Password], [Available], [FirstName], [LastName], [MiddleName]) VALUES (N'duongpth', N'duongpth', 1, N'Duong', N'PT', N'Hoang')
INSERT [dbo].[General] ([Username], [Password], [Available], [FirstName], [LastName], [MiddleName]) VALUES (N'thanhpc', N'thanhpc', 1, N'Thanh', N'Pham', N'Cong')
INSERT [dbo].[Pilot] ([Username], [Password], [FirstName], [LastName], [Weight], [Height], [Available], [GroupCode], [Citizenship], [Ranker], [ImgLink]) VALUES (N'amara', N'amara', N'Amara', N'Namani', 40, 160, 1, N'team2', N'America', N'Cadet', N'Amara.jpg')
INSERT [dbo].[Pilot] ([Username], [Password], [FirstName], [LastName], [Weight], [Height], [Available], [GroupCode], [Citizenship], [Ranker], [ImgLink]) VALUES (N'jake', N'jake', N'Jacob', N'Pentecost', 80, 190, 1, N'team1', N'British', N'Ranger', N'Jake.jpg')
INSERT [dbo].[Pilot] ([Username], [Password], [FirstName], [LastName], [Weight], [Height], [Available], [GroupCode], [Citizenship], [Ranker], [ImgLink]) VALUES (N'nate', N'nate', N'Nathan', N'Lambert', 80, 190, 1, N'team1', N'British', N'PPDC Ranger', N'Nate.jpg')
INSERT [dbo].[Rider] ([GroupCode], [Robot], [Pilot]) VALUES (N'team1', N'Gipsy Avenger', N'jake')
INSERT [dbo].[Rider] ([GroupCode], [Robot], [Pilot]) VALUES (N'team1', N'Gipsy Avenger', N'nate')
INSERT [dbo].[Rider] ([GroupCode], [Robot], [Pilot]) VALUES (N'team2', N'Bracer Phoenix', N'amara')
INSERT [dbo].[Robot] ([Robot], [Available], [DateLauched], [Classified], [Origin], [KaijuKilled], [ImgLink]) VALUES (N'Bracer Phoenix', 1, CAST(N'2025-11-01' AS Date), N'Mark-V', N'China', 5, N'BracerPhoenix.jpg')
INSERT [dbo].[Robot] ([Robot], [Available], [DateLauched], [Classified], [Origin], [KaijuKilled], [ImgLink]) VALUES (N'Brawler Yukon', 0, CAST(N'2015-01-31' AS Date), N'Mark-II', N'United States of America', 2, N'404.png')
INSERT [dbo].[Robot] ([Robot], [Available], [DateLauched], [Classified], [Origin], [KaijuKilled], [ImgLink]) VALUES (N'Gipsy Avenger', 1, CAST(N'2034-01-12' AS Date), N'Mark-VI', N'Australia', 5, N'GipsyAvenger.jpg')
INSERT [dbo].[Robot] ([Robot], [Available], [DateLauched], [Classified], [Origin], [KaijuKilled], [ImgLink]) VALUES (N'Hydra Corinthian', 0, CAST(N'2018-02-16' AS Date), N'Mark-IV', N'United States of America', 1, N'404.png')
INSERT [dbo].[Robot] ([Robot], [Available], [DateLauched], [Classified], [Origin], [KaijuKilled], [ImgLink]) VALUES (N'Saber Athena', 1, CAST(N'2033-12-20' AS Date), N'Mark-VI', N'Japan', 1, N'SaberAthena.jpg')
INSERT [dbo].[Skill] ([BattleTypeId], [BattleSkill]) VALUES (N'type1', N'Combat')
INSERT [dbo].[Skill] ([BattleTypeId], [BattleSkill]) VALUES (N'type2', N'Ranged')
INSERT [dbo].[Skill] ([BattleTypeId], [BattleSkill]) VALUES (N'type3', N'Supported')
INSERT [dbo].[Skill] ([BattleTypeId], [BattleSkill]) VALUES (N'type4', N'Throwable')
INSERT [dbo].[Skill] ([BattleTypeId], [BattleSkill]) VALUES (N'type5', N'Sniper')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon1', 1, N'type4', 1, N'Boom')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon10', 1, N'type3', 1, N'Shield')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon2', 1, N'type5', 1, N'Canon')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon3', 1, N'type1', 0, N'ChainSword')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon4', 1, N'type4', 1, N'Garena')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon5', 1, N'type2', 1, N'HookChain')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon6', 1, N'type1', 1, N'LongSword')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon7', 1, N'type5', 0, N'PlasmaGun')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon8', 1, N'type3', 1, N'RepairKit')
INSERT [dbo].[Weapon] ([WeaponCode], [Available], [BattleTypeId], [Carriable], [WeaponName]) VALUES (N'weapon9', 1, N'type1', 0, N'SaberSword')
ALTER TABLE [dbo].[Pilot] ADD  CONSTRAINT [DF_Pilot_Available]  DEFAULT ((0)) FOR [Available]
GO
ALTER TABLE [dbo].[Robot] ADD  DEFAULT ('0') FOR [Available]
GO
ALTER TABLE [dbo].[Weapon] ADD  DEFAULT ((0)) FOR [Carriable]
GO
ALTER TABLE [dbo].[Weapon] ADD  DEFAULT ('Weapon') FOR [WeaponName]
GO
ALTER TABLE [dbo].[Ability]  WITH CHECK ADD  CONSTRAINT [FK_Ability_Pilot] FOREIGN KEY([Pilot])
REFERENCES [dbo].[Pilot] ([Username])
GO
ALTER TABLE [dbo].[Ability] CHECK CONSTRAINT [FK_Ability_Pilot]
GO
ALTER TABLE [dbo].[Ability]  WITH CHECK ADD  CONSTRAINT [FK_Ability_Skill] FOREIGN KEY([BattleTypeId])
REFERENCES [dbo].[Skill] ([BattleTypeId])
GO
ALTER TABLE [dbo].[Ability] CHECK CONSTRAINT [FK_Ability_Skill]
GO
ALTER TABLE [dbo].[BattleSkill]  WITH CHECK ADD  CONSTRAINT [FK_BattleSkill_Robot] FOREIGN KEY([Robot])
REFERENCES [dbo].[Robot] ([Robot])
GO
ALTER TABLE [dbo].[BattleSkill] CHECK CONSTRAINT [FK_BattleSkill_Robot]
GO
ALTER TABLE [dbo].[BattleSkill]  WITH CHECK ADD  CONSTRAINT [FK_BattleSkill_Skill] FOREIGN KEY([BattleTypeId])
REFERENCES [dbo].[Skill] ([BattleTypeId])
GO
ALTER TABLE [dbo].[BattleSkill] CHECK CONSTRAINT [FK_BattleSkill_Skill]
GO
ALTER TABLE [dbo].[Equiment]  WITH CHECK ADD  CONSTRAINT [FK_Equiment_Robot] FOREIGN KEY([Robot])
REFERENCES [dbo].[Robot] ([Robot])
GO
ALTER TABLE [dbo].[Equiment] CHECK CONSTRAINT [FK_Equiment_Robot]
GO
ALTER TABLE [dbo].[Rider]  WITH CHECK ADD  CONSTRAINT [FK_Rider_Pilot] FOREIGN KEY([Pilot])
REFERENCES [dbo].[Pilot] ([Username])
GO
ALTER TABLE [dbo].[Rider] CHECK CONSTRAINT [FK_Rider_Pilot]
GO
ALTER TABLE [dbo].[Rider]  WITH CHECK ADD  CONSTRAINT [FK_Rider_Robot] FOREIGN KEY([Robot])
REFERENCES [dbo].[Robot] ([Robot])
GO
ALTER TABLE [dbo].[Rider] CHECK CONSTRAINT [FK_Rider_Robot]
GO
ALTER TABLE [dbo].[Weapon]  WITH CHECK ADD  CONSTRAINT [FK_Weapon_Skill] FOREIGN KEY([BattleTypeId])
REFERENCES [dbo].[Skill] ([BattleTypeId])
GO
ALTER TABLE [dbo].[Weapon] CHECK CONSTRAINT [FK_Weapon_Skill]
GO
USE [master]
GO
ALTER DATABASE [PacificRimRobot] SET  READ_WRITE 
GO
