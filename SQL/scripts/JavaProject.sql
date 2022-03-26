USE [master]
GO
/****** Object:  Database [JavaProject]    Script Date: 26.3.2022 г. 23:23:27 ******/
CREATE DATABASE [JavaProject]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JavaProject', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\JavaProject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'JavaProject_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\JavaProject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JavaProject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JavaProject] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JavaProject] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JavaProject] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JavaProject] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JavaProject] SET ARITHABORT OFF 
GO
ALTER DATABASE [JavaProject] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JavaProject] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JavaProject] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JavaProject] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JavaProject] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JavaProject] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JavaProject] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JavaProject] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JavaProject] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JavaProject] SET  DISABLE_BROKER 
GO
ALTER DATABASE [JavaProject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JavaProject] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JavaProject] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JavaProject] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JavaProject] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JavaProject] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JavaProject] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JavaProject] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [JavaProject] SET  MULTI_USER 
GO
ALTER DATABASE [JavaProject] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JavaProject] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JavaProject] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JavaProject] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [JavaProject] SET DELAYED_DURABILITY = DISABLED 
GO
USE [JavaProject]
GO
/****** Object:  Table [dbo].[actors]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[actors](
	[ActorId] [int] IDENTITY(1,1) NOT NULL,
	[ActorName] [varchar](45) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ActorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[actorsmovies]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[actorsmovies](
	[ActorId] [int] NOT NULL,
	[MovieId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ActorId] ASC,
	[MovieId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[favourites]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[favourites](
	[MovieId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC,
	[MovieId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[genres]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[genres](
	[GenreId] [int] IDENTITY(1,1) NOT NULL,
	[Genre] [varchar](45) NOT NULL,
 CONSTRAINT [PK__genres__0385057ED9393D7F] PRIMARY KEY CLUSTERED 
(
	[GenreId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[genresmovies]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[genresmovies](
	[GenreId] [int] NOT NULL,
	[MovieId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[GenreId] ASC,
	[MovieId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movies]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movies](
	[MovieId] [int] IDENTITY(1,1) NOT NULL,
	[MovieName] [varchar](100) NOT NULL,
	[MovieOrSeries] [varchar](45) NOT NULL,
	[YearOfPublishing] [tinyint] NOT NULL,
	[Description] [varchar](1000) NULL,
	[Company] [varchar](45) NOT NULL,
	[Duration] [tinyint] NOT NULL,
	[IMDB_Score] [decimal](18, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MovieId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 26.3.2022 г. 23:23:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [varchar](45) NOT NULL,
	[LastName] [varchar](45) NOT NULL,
	[Email] [varchar](45) NOT NULL,
	[Username] [varchar](45) NOT NULL,
	[Password] [varchar](45) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[genres] ON 
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (1, N'Action')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (2, N'Biography')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (3, N'Crime')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (4, N'Family')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (5, N'History')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (6, N'Music')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (7, N'Romance')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (8, N'Thriller')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (9, N'Western')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (10, N'Adventure')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (11, N'Costume')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (12, N'Documentary')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (13, N'Fantasy')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (14, N'Horror')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (15, N'Mystery')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (16, N'Sci-Fi')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (17, N'TV Show')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (18, N'Animation')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (19, N'Comedy')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (20, N'Drama')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (21, N'Game-Show')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (22, N'Kungfu')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (23, N'Reality-Show')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (24, N'Sport')
GO
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (25, N'War')
GO
SET IDENTITY_INSERT [dbo].[genres] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (1, N'Plamen', N'Kostov', N'PKKostov18@codingburgas.bg', N'pacata69', N'plamen123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (3, N'Ilian', N'Yanev', N'IMYanev18@codingburgas.bg', N'iyanev66', N'ilko123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (4, N'Radoslav', N'Stoychev18@codingburgas.bg', N'RAStoychev18@codingburgas.bg', N'radofifa1', N'rado123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (5, N'Ivan', N'Ivanov', N'ITIvanov18@codingburgas.bg', N'tsarivan', N'vanko123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (6, N'Kaloyan', N'Andrikov', N'KNAndrikov18@codingburgas.bg', N'neotrax', N'kalata123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (7, N'Jelqzko', N'Ivanov', N'ZAIivanov18@codingburgas.bg', N'jelqzko', N'jelqzko123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (8, N'Plamen', N'Petkov', N'PCPetkov18@codingburgas.bg', N'paleca', N'paleca123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (9, N'Stanislav', N'Todorov', N'SATodorov18@codingburgas.bg', N'ST', N'trunio123')
GO
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password]) VALUES (10, N'Kristian', N'Lalev', N'KALalev18@codingburgas.bg', N'kavalkata', N'kavalkata123')
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[movies] ADD  DEFAULT (NULL) FOR [Description]
GO
ALTER TABLE [dbo].[actorsmovies]  WITH CHECK ADD  CONSTRAINT [FK_ActorsActorsMovies] FOREIGN KEY([ActorId])
REFERENCES [dbo].[actors] ([ActorId])
GO
ALTER TABLE [dbo].[actorsmovies] CHECK CONSTRAINT [FK_ActorsActorsMovies]
GO
ALTER TABLE [dbo].[actorsmovies]  WITH CHECK ADD  CONSTRAINT [FK_MoviesActorsMovies] FOREIGN KEY([MovieId])
REFERENCES [dbo].[movies] ([MovieId])
GO
ALTER TABLE [dbo].[actorsmovies] CHECK CONSTRAINT [FK_MoviesActorsMovies]
GO
ALTER TABLE [dbo].[favourites]  WITH CHECK ADD  CONSTRAINT [FK_FavouritesMovies] FOREIGN KEY([MovieId])
REFERENCES [dbo].[movies] ([MovieId])
GO
ALTER TABLE [dbo].[favourites] CHECK CONSTRAINT [FK_FavouritesMovies]
GO
ALTER TABLE [dbo].[favourites]  WITH CHECK ADD  CONSTRAINT [FK_FavouritesUsers] FOREIGN KEY([UserId])
REFERENCES [dbo].[users] ([UserId])
GO
ALTER TABLE [dbo].[favourites] CHECK CONSTRAINT [FK_FavouritesUsers]
GO
ALTER TABLE [dbo].[genresmovies]  WITH CHECK ADD  CONSTRAINT [FK_GenresGenresMovies] FOREIGN KEY([GenreId])
REFERENCES [dbo].[genres] ([GenreId])
GO
ALTER TABLE [dbo].[genresmovies] CHECK CONSTRAINT [FK_GenresGenresMovies]
GO
ALTER TABLE [dbo].[genresmovies]  WITH CHECK ADD  CONSTRAINT [FK_MoviesGenresMovies] FOREIGN KEY([MovieId])
REFERENCES [dbo].[movies] ([MovieId])
GO
ALTER TABLE [dbo].[genresmovies] CHECK CONSTRAINT [FK_MoviesGenresMovies]
GO
USE [master]
GO
ALTER DATABASE [JavaProject] SET  READ_WRITE 
GO
