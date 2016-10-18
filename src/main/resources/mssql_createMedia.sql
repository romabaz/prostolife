USE [prostolife]
GO

/****** Object:  Table [dbo].[Media]    Script Date: 10/18/2016 15:38:36 ******/
DROP TABLE [dbo].[Media]
GO

/****** Object:  Table [dbo].[Media]    Script Date: 10/18/2016 15:38:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Media](
	[Id] [varchar](64) NOT NULL,
	[Link] [varchar](max) NOT NULL,
	[LinkTypeId] [varchar](64) NOT NULL,
	[EntryId] [varchar](64) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


