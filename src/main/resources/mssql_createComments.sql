USE [prostolife]
GO

/****** Object:  Table [dbo].[Comments]    Script Date: 17-Oct-16 22:22:11 ******/
DROP TABLE [dbo].[Comments]
GO

/****** Object:  Table [dbo].[Comments]    Script Date: 17-Oct-16 22:22:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Comments](
	[Id] [varchar](64) NOT NULL,
	[Author] [varchar](30) NOT NULL,
	[CreateDate] [int] NOT NULL,
	[Text] [varchar](max) NOT NULL,
 CONSTRAINT [PK_Comments] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO
