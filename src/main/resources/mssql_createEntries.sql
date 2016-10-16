USE [prostolife]
GO

/****** Object:  Table [dbo].[Entries]    Script Date: 12-Oct-16 10:44:45 ******/
DROP TABLE [dbo].[Entries]
GO

/****** Object:  Table [dbo].[Entries]    Script Date: 12-Oct-16 10:44:45 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Entries](
	[Topic] [varchar](30) NULL,
	[Text] [varchar](max) NULL,
	[Img] [varchar](50) NULL,
	[CreateDate] [integer] NULL,
	[Author] [varchar](30) NULL,
	[Id] [varchar](64) NOT NULL,
 CONSTRAINT [PK_Entries] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


