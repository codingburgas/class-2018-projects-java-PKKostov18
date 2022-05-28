USE [master]
GO
/****** Object:  Database [JavaProject]    Script Date: 5/28/2022 9:20:48 PM ******/
CREATE DATABASE [JavaProject]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JavaProject', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\JavaProject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'JavaProject_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\JavaProject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [JavaProject] SET COMPATIBILITY_LEVEL = 150
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
ALTER DATABASE [JavaProject] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'JavaProject', N'ON'
GO
ALTER DATABASE [JavaProject] SET QUERY_STORE = OFF
GO
USE [JavaProject]
GO
/****** Object:  Table [dbo].[actors]    Script Date: 5/28/2022 9:20:49 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[actorsmovies]    Script Date: 5/28/2022 9:20:49 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[favourites]    Script Date: 5/28/2022 9:20:49 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[genres]    Script Date: 5/28/2022 9:20:49 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[genresmovies]    Script Date: 5/28/2022 9:20:49 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movies]    Script Date: 5/28/2022 9:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movies](
	[MovieId] [int] IDENTITY(1,1) NOT NULL,
	[MovieName] [varchar](100) NOT NULL,
	[MovieOrSeries] [varchar](45) NOT NULL,
	[YearOfPublishing] [int] NOT NULL,
	[Description] [varchar](1000) NULL,
	[Company] [varchar](45) NOT NULL,
	[Duration] [tinyint] NOT NULL,
	[IMDB_Score] [float] NOT NULL,
	[NumberOfSeasons] [int] NULL,
 CONSTRAINT [PK__movies__4BD2941A2CA63AD1] PRIMARY KEY CLUSTERED 
(
	[MovieId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 5/28/2022 9:20:49 PM ******/
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
	[Salt] [nvarchar](50) NULL,
	[Admin] [bit] NOT NULL,
 CONSTRAINT [PK__users__1788CC4C59D87B01] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[genres] ON 

INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (1, N'Action')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (2, N'Biography')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (3, N'Crime')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (4, N'Family')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (5, N'History')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (6, N'Music')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (7, N'Romance')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (8, N'Thriller')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (9, N'Western')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (10, N'Adventure')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (11, N'Costume')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (12, N'Documentary')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (13, N'Fantasy')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (14, N'Horror')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (15, N'Mystery')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (16, N'Sci-Fi')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (17, N'TV Show')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (18, N'Animation')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (19, N'Comedy')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (20, N'Drama')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (21, N'Game-Show')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (22, N'Kungfu')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (23, N'Reality-Show')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (24, N'Sport')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (25, N'War')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (26, N'Superhero')
INSERT [dbo].[genres] ([GenreId], [Genre]) VALUES (27, N'Dark Comedy')
SET IDENTITY_INSERT [dbo].[genres] OFF
GO
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 3)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 5)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 6)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 8)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 11)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 12)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 15)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 16)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 17)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 18)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 19)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 20)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (1, 21)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (3, 1)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (3, 2)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (3, 15)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (3, 21)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (5, 7)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (7, 3)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (7, 5)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (7, 13)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (8, 15)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (8, 16)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (9, 12)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 4)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 5)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 6)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 8)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 11)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 12)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 16)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 17)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 18)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 19)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (10, 20)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (11, 7)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (13, 8)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (13, 11)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (13, 17)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (13, 18)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (13, 19)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (13, 20)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (15, 6)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (15, 17)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 4)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 5)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 16)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 18)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 19)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 20)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (16, 21)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (19, 5)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (19, 13)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 1)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 2)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 3)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 4)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 6)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 7)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 8)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 11)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 13)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 15)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (20, 16)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (24, 3)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (25, 7)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (26, 6)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (26, 18)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (26, 19)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (26, 20)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (26, 21)
INSERT [dbo].[genresmovies] ([GenreId], [MovieId]) VALUES (27, 15)
GO
SET IDENTITY_INSERT [dbo].[movies] ON 

INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (1, N'The Shawshank Redemption
', N'Movie', 1994, N'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', N'Castle Rock Entertainment', 142, 9.2, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (2, N'The Godfather
', N'Movie', 1972, N'Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.', N'Paramount Pictures Studios', 175, 8.7, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (3, N'Rocky', N'Movie', 1976, N'When world heavyweight boxing champion, Apollo Creed wants to give an unknown fighter a shot at the title as a publicity stunt, his handlers choose palooka Rocky Balboa, an uneducated collector for a Philadelphia loan shark. Rocky teams up with trainer Mickey Goldmill to make the most of this once in a lifetime break.', N'Chartoff-Winkler Productions', 120, 8.1, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (4, N'Avengers: Infinity War', N'Movie', 2018, N'As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.', N'Marvel Studios', 149, 8.4, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (5, N'Deadpool', N'Movie', 2016, N'The origin story of former Special Forces operative turned mercenary Wade Wilson, who, after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.', N'Marvel Studios', 108, 8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (6, N'The Dark Knight
', N'Movie', 2008, N'Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.', N'Warner Bros', 152, 9, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (7, N'Schindler''s List
', N'Movie', 1993, N'The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.', N'Universal Studios', 195, 9, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (8, N'The Lord of the Rings: The Return of the King', N'Movie', 2003, N'Aragorn is revealed as the heir to the ancient kings as he, Gandalf and the other members of the broken fellowship struggle to save Gondor from Sauron''s forces. Meanwhile, Frodo and Sam take the ring closer to the heart of Mordor, the dark lord''s realm.', N'New Line Cinema', 201, 9, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (11, N'The Lord of the Rings: The Fellowship of the Ring
', N'Movie', 2001, N'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.', N'New Line Cinema', 178, 8.8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (12, N'The Good, the Bad and the Ugly
', N'Movie', 1996, N'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.', N'Produzioni Europee Associati', 178, 8.8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (13, N'Forrest Gump
', N'Movie', 1994, N'The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.', N'Paramount Pictures Studios', 144, 8.8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (15, N'Fight Club', N'Movie', 1999, N'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.', N'20th Century Studios', 139, 8.8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (16, N'Inception
', N'Movie', 2010, N'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.', N'Warner Bros', 148, 8.8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (17, N'Star Wars: Episode V - The Empire Strikes Back
', N'Movie', 1980, N'After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued across the galaxy by Darth Vader and bounty hunter Boba Fett.', N'Lucasfilm', 124, 8.7, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (18, N'The Avengers
', N'Movie', 2012, N'Earth''s mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.

', N'Marvel Studios', 143, 8, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (19, N'Avengers: Age of Ultron
', N'Movie', 2015, N'When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it''s up to Earth''s mightiest heroes to stop the villainous Ultron from enacting his terrible plan.

', N'Marvel Studios', 141, 7.3, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (20, N'Avengers: Endgame
', N'Movie', 2019, N'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos'' actions and restore balance to the universe.', N'Marvel Studios', 181, 8.4, NULL)
INSERT [dbo].[movies] ([MovieId], [MovieName], [MovieOrSeries], [YearOfPublishing], [Description], [Company], [Duration], [IMDB_Score], [NumberOfSeasons]) VALUES (21, N'Daredevil', N'Series', 2015, N'A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.

', N'Netfix', 54, 8.6, 3)
SET IDENTITY_INSERT [dbo].[movies] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (1, N'Plamen', N'Kostov', N'PKKostov18@codingburgas.bg', N'pacata69', N'plamen123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (3, N'Ilian', N'Yanev', N'IMYanev18@codingburgas.bg', N'iyanev66', N'ilko123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (4, N'Radoslav', N'Stoychev18@codingburgas.bg', N'RAStoychev18@codingburgas.bg', N'radofifa1', N'rado123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (5, N'Ivan', N'Ivanov', N'ITIvanov18@codingburgas.bg', N'tsarivan', N'vanko123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (6, N'Kaloyan', N'Andrikov', N'KNAndrikov18@codingburgas.bg', N'neotrax', N'kalata123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (7, N'Jelqzko', N'Ivanov', N'ZAIivanov18@codingburgas.bg', N'jelqzko', N'jelqzko123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (8, N'Plamen', N'Petkov', N'PCPetkov18@codingburgas.bg', N'paleca', N'paleca123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (9, N'Stanislav', N'Todorov', N'SATodorov18@codingburgas.bg', N'ST', N'trunio123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (10, N'Kristian', N'Lalev', N'KALalev18@codingburgas.bg', N'kavalkata', N'kavalkata123', NULL, 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (11, N'Ben', N'Dover', N'BenYEEEES@gmail.com', N'Ben', N'2q/w1IN/JYyX8jWyf1Rf+8nBFG/SztBXH4+/Ou/w1tg=', N'Xd8SpZZrR+sYMTFKLgCY2A==', 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (13, N'asd', N'asd', N'asd@gmail.com', N'sewuyyy', N'67qJAbrL5wLXI5OksEaEbwh3yT6rbolPY/IHPW+aCTU=', N'WQ6QlfPgQE7orNu6C+iXeg==', 0)
INSERT [dbo].[users] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Salt], [Admin]) VALUES (14, N'ilian', N'Yanev', N'unufri333@gmail.com', N'ilkoba', N'Br8pHCLsmvRDUDL/tyaxpIgK3bsbX+jLfrKThapSyPc=', N'iff3lXdXCS1cmXpbObyT4A==', 0)
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[movies] ADD  CONSTRAINT [DF__movies__Descript__300424B4]  DEFAULT (NULL) FOR [Description]
GO
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [DF_users_Admin]  DEFAULT ((0)) FOR [Admin]
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
