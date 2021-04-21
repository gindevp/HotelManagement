USE [QLKS]
GO
/****** Object:  Table [dbo].[BOPHAN]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BOPHAN](
	[MABP] [varchar](10) NOT NULL,
	[TENBP] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MABP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DICHVU]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DICHVU](
	[MADV] [int] IDENTITY(1,1) NOT NULL,
	[TENDV] [nvarchar](50) NOT NULL,
	[DONGIA] [money] NOT NULL,
	[MOTA] [nvarchar](500) NULL,
	[TRANGTHAI] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MADV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDDICHVU]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDDICHVU](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MAHD] [int] NOT NULL,
	[MADV] [int] NOT NULL,
	[SOLUONG] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDPHONG]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDPHONG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MAHD] [int] NOT NULL,
	[SOPHONG] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MAHD] [int] IDENTITY(1,1) NOT NULL,
	[NGAYTHUE] [datetime] NOT NULL,
	[NGAYTT] [datetime] NULL,
	[TONGTIEN] [money] NOT NULL,
	[TRANGTHAI] [bit] NOT NULL,
	[MALG] [int] NOT NULL,
	[MAKH] [int] NOT NULL,
	[MANV] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MAHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[MAKH] [int] IDENTITY(1,1) NOT NULL,
	[TENKH] [nvarchar](50) NOT NULL,
	[CMND] [varchar](20) NOT NULL,
	[SDT] [varchar](20) NOT NULL,
	[GIOITINH] [bit] NOT NULL,
	[DIACHI] [nvarchar](50) NOT NULL,
	[QUOCTICH] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MAKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAIGIA]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAIGIA](
	[MALG] [int] IDENTITY(1,1) NOT NULL,
	[TENLG] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MALG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAIPHONG]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAIPHONG](
	[MALP] [varchar](10) NOT NULL,
	[TENLP] [nvarchar](50) NOT NULL,
	[MOTA] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[MALP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAIPHONG_LOAIGIA]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAIPHONG_LOAIGIA](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MALP] [varchar](10) NOT NULL,
	[MALG] [int] NOT NULL,
	[DONGIA] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAXACNHAN]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAXACNHAN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CODE] [varchar](20) NOT NULL,
	[MANV] [varchar](10) NOT NULL,
	[CREATEAT] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MANV] [varchar](10) NOT NULL,
	[TENNV] [nvarchar](50) NOT NULL,
	[PASSWORD] [varchar](50) NOT NULL,
	[NGAYSINH] [date] NOT NULL,
	[GIOITINH] [bit] NOT NULL,
	[DIACHI] [nvarchar](50) NOT NULL,
	[SDT] [varchar](20) NOT NULL,
	[EMAIL] [varchar](50) NOT NULL,
	[ANH] [varchar](50) NULL,
	[MABP] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MANV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHONG]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONG](
	[SOPHONG] [varchar](10) NOT NULL,
	[SUCCHUA] [int] NOT NULL,
	[TRANGTHAI] [bit] NOT NULL,
	[MALP] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SOPHONG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHONG_TIENNGHI]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONG_TIENNGHI](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SOPHONG] [varchar](10) NOT NULL,
	[MATN] [int] NOT NULL,
	[SOLUONG] [int] NOT NULL,
	[TINHTRANG] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TIENNGHI]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIENNGHI](
	[MATN] [int] IDENTITY(1,1) NOT NULL,
	[TENTN] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MATN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BOPHAN] ([MABP], [TENBP]) VALUES (N'KT', N'Kế Toán')
INSERT [dbo].[BOPHAN] ([MABP], [TENBP]) VALUES (N'LT', N'Lễ Tân')
INSERT [dbo].[BOPHAN] ([MABP], [TENBP]) VALUES (N'PB', N'Phòng Ban')
INSERT [dbo].[BOPHAN] ([MABP], [TENBP]) VALUES (N'QL', N'Quản Lý')
GO
SET IDENTITY_INSERT [dbo].[DICHVU] ON 

INSERT [dbo].[DICHVU] ([MADV], [TENDV], [DONGIA], [MOTA], [TRANGTHAI]) VALUES (1, N'Make-up room service', 20000.0000, N'Make-up room service là dịch vụ làm phòng. Trong dịch vụ này, người làm phòng sẽ thay drap giường, khăn tắm và các đồ dùng trong phòng ngủ.', 1)
INSERT [dbo].[DICHVU] ([MADV], [TENDV], [DONGIA], [MOTA], [TRANGTHAI]) VALUES (2, N'Turndown service', 40000.0000, N'Là dịch vụ chỉnh trang phòng buổi tối. Người làm phòng sẽ trải thẳng lại drap giường, gấp nếp giường, đặt cành hoa hoặc thiệp chúc ngủ ngon lên giường..', 1)
INSERT [dbo].[DICHVU] ([MADV], [TENDV], [DONGIA], [MOTA], [TRANGTHAI]) VALUES (3, N'Laundry service', 50000.0000, N'Laundry service là dịch vụ giặt ủi trong khách sạn.', 1)
INSERT [dbo].[DICHVU] ([MADV], [TENDV], [DONGIA], [MOTA], [TRANGTHAI]) VALUES (4, N'Dảk wah', 12000.0000, N'bủh', 0)
SET IDENTITY_INSERT [dbo].[DICHVU] OFF
GO
SET IDENTITY_INSERT [dbo].[HDDICHVU] ON 

INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (21, 22, 1, 3)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (22, 22, 2, 3)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (23, 23, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (24, 23, 3, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (25, 24, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (26, 24, 2, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (27, 24, 3, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (28, 25, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (29, 25, 2, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (30, 25, 3, 3)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (31, 26, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (32, 27, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (42, 28, 2, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (43, 28, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (44, 29, 1, 1)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (45, 30, 1, 2)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (46, 31, 1, 2)
INSERT [dbo].[HDDICHVU] ([ID], [MAHD], [MADV], [SOLUONG]) VALUES (47, 32, 1, 2)
SET IDENTITY_INSERT [dbo].[HDDICHVU] OFF
GO
SET IDENTITY_INSERT [dbo].[HDPHONG] ON 

INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (28, 20, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (30, 21, N'101')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (29, 21, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (31, 22, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (32, 23, N'403')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (33, 24, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (34, 25, N'303')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (35, 26, N'201')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (36, 27, N'102')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (44, 28, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (45, 28, N'303')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (46, 29, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (47, 30, N'301')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (48, 31, N'303')
INSERT [dbo].[HDPHONG] ([ID], [MAHD], [SOPHONG]) VALUES (49, 32, N'303')
SET IDENTITY_INSERT [dbo].[HDPHONG] OFF
GO
SET IDENTITY_INSERT [dbo].[HOADON] ON 

INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (20, CAST(N'2021-04-16T20:23:27.140' AS DateTime), CAST(N'2021-04-17T01:23:37.273' AS DateTime), 300000.0000, 1, 1, 1, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (21, CAST(N'2021-03-12T01:24:28.480' AS DateTime), CAST(N'2021-03-17T01:25:00.480' AS DateTime), 1100000.0000, 1, 3, 1, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (22, CAST(N'2021-04-17T09:38:54.977' AS DateTime), CAST(N'2021-04-17T09:39:02.283' AS DateTime), 420000.0000, 1, 1, 8, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (23, CAST(N'2021-04-17T09:39:34.887' AS DateTime), CAST(N'2021-04-17T09:39:40.053' AS DateTime), 270000.0000, 1, 2, 6, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (24, CAST(N'2021-03-17T09:45:40.083' AS DateTime), CAST(N'2021-03-17T09:47:13.663' AS DateTime), 15190000.0000, 1, 1, 3, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (25, CAST(N'2021-03-17T09:46:54.020' AS DateTime), CAST(N'2021-03-17T09:47:17.147' AS DateTime), 15290000.0000, 1, 1, 4, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (26, CAST(N'2021-04-17T10:44:03.213' AS DateTime), CAST(N'2021-04-17T10:44:07.910' AS DateTime), 180000.0000, 1, 1, 1, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (27, CAST(N'2021-04-17T10:54:54.943' AS DateTime), CAST(N'2021-04-17T10:55:01.670' AS DateTime), 100000.0000, 1, 3, 1, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (28, CAST(N'2021-04-17T11:00:22.517' AS DateTime), CAST(N'2021-04-19T22:35:51.403' AS DateTime), 620000.0000, 1, 2, 1, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (29, CAST(N'2021-04-19T22:42:36.747' AS DateTime), CAST(N'2021-04-19T22:43:48.410' AS DateTime), 260000.0000, 1, 1, 1, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (30, CAST(N'2021-04-19T22:49:12.327' AS DateTime), CAST(N'2021-04-19T22:49:32.190' AS DateTime), 280000.0000, 1, 1, 6, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (31, CAST(N'2021-04-19T22:59:05.403' AS DateTime), CAST(N'2021-04-19T23:02:32.360' AS DateTime), 280000.0000, 1, 1, 7, N'PH01')
INSERT [dbo].[HOADON] ([MAHD], [NGAYTHUE], [NGAYTT], [TONGTIEN], [TRANGTHAI], [MALG], [MAKH], [MANV]) VALUES (32, CAST(N'2021-04-19T23:27:24.057' AS DateTime), NULL, 0.0000, 0, 1, 2, N'PH01')
SET IDENTITY_INSERT [dbo].[HOADON] OFF
GO
SET IDENTITY_INSERT [dbo].[KHACHHANG] ON 

INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (1, N'Trần Thị Quỳnh', N'122122121', N'0987654001', 0, N'Hà Nội', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (2, N'Trần Ngọc Hải', N'122122122', N'0987654002', 0, N'Hồ Chí Minh', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (3, N'Đỗ Trà My', N'122122123', N'0987654003', 1, N'Đà Nẵng', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (4, N'Nguyễn Bá Quang', N'122122124', N'0987654004', 1, N'Hải Phòng', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (5, N'Nguyễn Bảo Linh', N'122122125', N'0987654005', 0, N'Hải Dương', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (6, N'Vũ Thị Thu', N'122122126', N'0987654006', 0, N'Bắc Nih', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (7, N'Trần Thị Ngọc Diệp', N'122122127', N'0987654007', 0, N'Hà Nam', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (8, N'Nguyễn Việt Anh', N'122122128', N'0987654008', 1, N'Quảng Ninh', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (9, N'Nông Thị Ngoan', N'122122129', N'0987654009', 0, N'Bắc Giang', N'Việt Nam')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [CMND], [SDT], [GIOITINH], [DIACHI], [QUOCTICH]) VALUES (10, N'Ngô Hà Vy', N'122122130', N'0987654010', 0, N'Hà Nội', N'Việt Nam')
SET IDENTITY_INSERT [dbo].[KHACHHANG] OFF
GO
SET IDENTITY_INSERT [dbo].[LOAIGIA] ON 

INSERT [dbo].[LOAIGIA] ([MALG], [TENLG]) VALUES (1, N'Theo giờ')
INSERT [dbo].[LOAIGIA] ([MALG], [TENLG]) VALUES (2, N'Qua đêm')
INSERT [dbo].[LOAIGIA] ([MALG], [TENLG]) VALUES (3, N'Theo ngày')
SET IDENTITY_INSERT [dbo].[LOAIGIA] OFF
GO
INSERT [dbo].[LOAIPHONG] ([MALP], [TENLP], [MOTA]) VALUES (N'DLX', N'Deluxe', N'Phòng deluxe thường ở tầng trên cao với view đẹp (hướng ra núi, biển… ). Diện tích của loại phòng này rộng rãi hơn superior và được đầu tư trang thiết bị cao cấp như tivi, tủ lạnh, bồn rửa mặt cao cấp… Đương nhiên, mức giá niêm yết dành cho phòng deluxe sẽ cao hơn superior.')
INSERT [dbo].[LOAIPHONG] ([MALP], [TENLP], [MOTA]) VALUES (N'STD', N'Standard', N'Phòng standard (viết tắt là STD) là loại phòng tiêu chuẩn, đơn giản nhất trong các khách sạn hiện nay. Đây là loại phòng có diện tích nhỏ, thường được đặt ở tầng thấp nhất và không có view hoặc view không được đẹp. Trang thiết bị của phòng standard cũng được khách sạn giảm tối thiểu. Chính vì vậy, giá phòng standard nằm ở mức thấp nhất trong các loại phòng khách sạn.')
INSERT [dbo].[LOAIPHONG] ([MALP], [TENLP], [MOTA]) VALUES (N'SUP', N'Superior', N'Phòng superior cao cấp hơn phòng standard với diện tích lớn hơn (từ 20m2 trở lên) bao gồm 1-2 giường, tầm nhìn view cũng đẹp hơn. Trang thiết bị của phòng được khách sạn đầu tư hiện đại. Vì chất lượng tốt hơn nên mức giá cho phòng superior cũng sẽ cao hơn phòng standard.')
INSERT [dbo].[LOAIPHONG] ([MALP], [TENLP], [MOTA]) VALUES (N'SUT', N'Suite', N'Phòng suite là loại phòng cao cấp nhất khách sạn, được đặt ở tầng cao nhất, nơi có không gian thoáng đãng và không khí trong lành. Với diện tích từ 60 – 120m2, phòng suite thường bao gồm 1 phòng khách, 1 phòng ngủ riêng biệt, cửa sổ và ban công để khách ngắm phong cảnh.')
GO
SET IDENTITY_INSERT [dbo].[LOAIPHONG_LOAIGIA] ON 

INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (1, N'STD', 1, 50000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (2, N'STD', 2, 100000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (3, N'STD', 3, 80000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (4, N'SUP', 1, 80000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (5, N'SUP', 2, 120000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (6, N'SUP', 3, 100000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (7, N'DLX', 1, 120000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (8, N'DLX', 2, 160000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (9, N'DLX', 3, 140000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (10, N'SUT', 1, 160000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (11, N'SUT', 2, 200000.0000)
INSERT [dbo].[LOAIPHONG_LOAIGIA] ([ID], [MALP], [MALG], [DONGIA]) VALUES (12, N'SUT', 3, 180000.0000)
SET IDENTITY_INSERT [dbo].[LOAIPHONG_LOAIGIA] OFF
GO
SET IDENTITY_INSERT [dbo].[MAXACNHAN] ON 

INSERT [dbo].[MAXACNHAN] ([ID], [CODE], [MANV], [CREATEAT]) VALUES (0, N'12080441', N'PH01', CAST(N'2021-04-17T10:32:41.483' AS DateTime))
INSERT [dbo].[MAXACNHAN] ([ID], [CODE], [MANV], [CREATEAT]) VALUES (1, N'95850673', N'PH01', CAST(N'2021-04-17T10:34:28.147' AS DateTime))
INSERT [dbo].[MAXACNHAN] ([ID], [CODE], [MANV], [CREATEAT]) VALUES (2, N'35688307', N'PH01', CAST(N'2021-04-17T10:51:41.667' AS DateTime))
SET IDENTITY_INSERT [dbo].[MAXACNHAN] OFF
GO
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [PASSWORD], [NGAYSINH], [GIOITINH], [DIACHI], [SDT], [EMAIL], [ANH], [MABP]) VALUES (N'PH01', N'Nguyễn Nhật Hùng', N'hungnn', CAST(N'1998-03-05' AS Date), 1, N'Hà Nội', N'0984111111', N'hungnnph09719@fpt.edu.vn', N'', N'QL')
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [PASSWORD], [NGAYSINH], [GIOITINH], [DIACHI], [SDT], [EMAIL], [ANH], [MABP]) VALUES (N'PH02', N'Hứa Mạnh Hùng', N'hunghm', CAST(N'2000-03-05' AS Date), 1, N'Hà Nội', N'0984111112', N'hunghmph09808@fpt.edu.vn', N'', N'QL')
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [PASSWORD], [NGAYSINH], [GIOITINH], [DIACHI], [SDT], [EMAIL], [ANH], [MABP]) VALUES (N'PH03', N'Nguyễn Hữu Quyết', N'quyetnh', CAST(N'2001-03-05' AS Date), 1, N'Hà Nội', N'0984111113', N'quyetnhph12037@fpt.edu.vn', NULL, N'LT')
GO
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'101', 4, 0, N'STD')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'102', 4, 0, N'STD')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'103', 2, 0, N'STD')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'201', 4, 0, N'SUP')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'202', 4, 0, N'SUP')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'203', 4, 0, N'SUP')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'301', 4, 0, N'DLX')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'302', 4, 1, N'DLX')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'303', 4, 1, N'DLX')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'401', 4, 0, N'SUT')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'402', 4, 0, N'SUT')
INSERT [dbo].[PHONG] ([SOPHONG], [SUCCHUA], [TRANGTHAI], [MALP]) VALUES (N'403', 4, 0, N'SUT')
GO
SET IDENTITY_INSERT [dbo].[PHONG_TIENNGHI] ON 

INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (1, N'101', 1, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (2, N'101', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (3, N'101', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (4, N'102', 1, 2, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (5, N'102', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (6, N'102', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (7, N'103', 1, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (8, N'103', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (9, N'103', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (10, N'201', 1, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (11, N'201', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (12, N'201', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (13, N'202', 1, 2, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (14, N'202', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (15, N'202', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (16, N'203', 1, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (17, N'203', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (18, N'203', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (19, N'301', 2, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (20, N'301', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (21, N'301', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (22, N'302', 2, 2, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (23, N'302', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (24, N'302', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (25, N'303', 2, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (26, N'303', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (27, N'303', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (28, N'401', 2, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (29, N'401', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (30, N'401', 4, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (31, N'401', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (32, N'402', 1, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (33, N'402', 2, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (34, N'402', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (35, N'402', 4, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (36, N'402', 5, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (37, N'403', 1, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (38, N'403', 2, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (39, N'403', 3, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (40, N'403', 4, 1, N'Normal')
INSERT [dbo].[PHONG_TIENNGHI] ([ID], [SOPHONG], [MATN], [SOLUONG], [TINHTRANG]) VALUES (41, N'403', 5, 1, N'Normal')
SET IDENTITY_INSERT [dbo].[PHONG_TIENNGHI] OFF
GO
SET IDENTITY_INSERT [dbo].[TIENNGHI] ON 

INSERT [dbo].[TIENNGHI] ([MATN], [TENTN]) VALUES (1, N'Giường đơn')
INSERT [dbo].[TIENNGHI] ([MATN], [TENTN]) VALUES (2, N'Giường đôi')
INSERT [dbo].[TIENNGHI] ([MATN], [TENTN]) VALUES (3, N'Tivi')
INSERT [dbo].[TIENNGHI] ([MATN], [TENTN]) VALUES (4, N'Tủ lạnh')
INSERT [dbo].[TIENNGHI] ([MATN], [TENTN]) VALUES (5, N'Điều hòa')
SET IDENTITY_INSERT [dbo].[TIENNGHI] OFF
GO
/****** Object:  Index [UQ__HDDICHVU__263CD0CA6365BD00]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[HDDICHVU] ADD UNIQUE NONCLUSTERED 
(
	[MAHD] ASC,
	[MADV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HDPHONG__84EDA86241908534]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[HDPHONG] ADD UNIQUE NONCLUSTERED 
(
	[MAHD] ASC,
	[SOPHONG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KHACHHAN__CA1930A52A4E4B59]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[KHACHHANG] ADD UNIQUE NONCLUSTERED 
(
	[SDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KHACHHAN__F67C8D0B2E9F5B4A]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[KHACHHANG] ADD UNIQUE NONCLUSTERED 
(
	[CMND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__LOAIPHON__B63CB54034D49C28]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[LOAIPHONG_LOAIGIA] ADD UNIQUE NONCLUSTERED 
(
	[MALP] ASC,
	[MALG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NHANVIEN__161CF724B706CB55]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[NHANVIEN] ADD UNIQUE NONCLUSTERED 
(
	[EMAIL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NHANVIEN__CA1930A513C3A342]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[NHANVIEN] ADD UNIQUE NONCLUSTERED 
(
	[SDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__PHONG_TI__4B2ABDFF6488B51F]    Script Date: 4/19/2021 11:34:47 PM ******/
ALTER TABLE [dbo].[PHONG_TIENNGHI] ADD UNIQUE NONCLUSTERED 
(
	[SOPHONG] ASC,
	[MATN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DICHVU] ADD  DEFAULT ((1)) FOR [TRANGTHAI]
GO
ALTER TABLE [dbo].[HOADON] ADD  DEFAULT (getdate()) FOR [NGAYTHUE]
GO
ALTER TABLE [dbo].[HOADON] ADD  DEFAULT ((0)) FOR [TRANGTHAI]
GO
ALTER TABLE [dbo].[MAXACNHAN] ADD  DEFAULT (getdate()) FOR [CREATEAT]
GO
ALTER TABLE [dbo].[PHONG] ADD  DEFAULT ((0)) FOR [TRANGTHAI]
GO
ALTER TABLE [dbo].[PHONG_TIENNGHI] ADD  DEFAULT ('Normal') FOR [TINHTRANG]
GO
ALTER TABLE [dbo].[HDDICHVU]  WITH CHECK ADD FOREIGN KEY([MADV])
REFERENCES [dbo].[DICHVU] ([MADV])
GO
ALTER TABLE [dbo].[HDDICHVU]  WITH CHECK ADD FOREIGN KEY([MAHD])
REFERENCES [dbo].[HOADON] ([MAHD])
GO
ALTER TABLE [dbo].[HDPHONG]  WITH CHECK ADD FOREIGN KEY([MAHD])
REFERENCES [dbo].[HOADON] ([MAHD])
GO
ALTER TABLE [dbo].[HDPHONG]  WITH CHECK ADD FOREIGN KEY([SOPHONG])
REFERENCES [dbo].[PHONG] ([SOPHONG])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([MAKH])
REFERENCES [dbo].[KHACHHANG] ([MAKH])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([MALG])
REFERENCES [dbo].[LOAIGIA] ([MALG])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([MANV])
REFERENCES [dbo].[NHANVIEN] ([MANV])
GO
ALTER TABLE [dbo].[LOAIPHONG_LOAIGIA]  WITH CHECK ADD FOREIGN KEY([MALG])
REFERENCES [dbo].[LOAIGIA] ([MALG])
GO
ALTER TABLE [dbo].[LOAIPHONG_LOAIGIA]  WITH CHECK ADD FOREIGN KEY([MALP])
REFERENCES [dbo].[LOAIPHONG] ([MALP])
GO
ALTER TABLE [dbo].[MAXACNHAN]  WITH CHECK ADD FOREIGN KEY([MANV])
REFERENCES [dbo].[NHANVIEN] ([MANV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD FOREIGN KEY([MABP])
REFERENCES [dbo].[BOPHAN] ([MABP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PHONG]  WITH CHECK ADD FOREIGN KEY([MALP])
REFERENCES [dbo].[LOAIPHONG] ([MALP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PHONG_TIENNGHI]  WITH CHECK ADD FOREIGN KEY([SOPHONG])
REFERENCES [dbo].[PHONG] ([SOPHONG])
GO
ALTER TABLE [dbo].[PHONG_TIENNGHI]  WITH CHECK ADD FOREIGN KEY([MATN])
REFERENCES [dbo].[TIENNGHI] ([MATN])
GO
ALTER TABLE [dbo].[DICHVU]  WITH CHECK ADD CHECK  (([DONGIA]>=(0)))
GO
ALTER TABLE [dbo].[HDDICHVU]  WITH CHECK ADD CHECK  (([SOLUONG]>(0)))
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD CHECK  (([TONGTIEN]>=(0)))
GO
ALTER TABLE [dbo].[LOAIPHONG_LOAIGIA]  WITH CHECK ADD CHECK  (([DONGIA]>(0)))
GO
ALTER TABLE [dbo].[PHONG]  WITH CHECK ADD CHECK  (([SUCCHUA]>(0)))
GO
/****** Object:  StoredProcedure [dbo].[sp_demo]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_demo] @mahd int, @malg int
as
begin
begin try
begin tran
	declare @gia money, @tienphong money, @tiendv money, @tongNgayThue int, @tongGioThue int

	select @gia =  sum(dongia) from hoadon a
						join HDPHONG b on a.MAHD = b.MAHD
						join PHONG c on b.SOPHONG = c.SOPHONG
						join LOAIPHONG d on c.MALP = d.MALP
						join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
						where a.MAHD = @mahd and e.MALG = @malg
	select @tongNgayThue = DATEDIFF(day, ngaythue, getdate()) from hoadon where MAHD = @mahd
	select @tongGioThue = DATEDIFF(HOUR, ngaythue, GETDATE()) from hoadon where MAHD = @mahd
	if @malg = 1
	begin
		if @tongGioThue <= 2
		begin
			select @tienphong = @gia
		end
		else
		begin
			select @tienphong = @gia + (@tongGioThue - 2) * 20000
		end
	end
	else
	begin
		if @malg = 2
		begin
			declare @giotre_quadem int
			select @giotre_quadem = DATEPART(hour, ngaytt) from hoadon where MAHD = @mahd
			if @giotre_quadem >= 10 and @tongNgayThue > 0
			begin
				select @tienphong = @gia + (@giotre_quadem - 10) * 20000
			end
			else
			begin
				select @tienphong = @gia
			end
		end
		else
		begin 
			if @malg = 3
			begin
				if @tongNgayThue < 2
				begin
					select @tienphong = @gia
				end
				else
				begin
					select @tienphong = @tongNgayThue * @gia
				end
			end
		end
	end
	if (select count(*) from HDDICHVU where MAHD = @mahd) > 0
	begin
		select @tiendv = sum(a.SOLUONG * b.DONGIA) from HDDICHVU a
					join DICHVU b on a.MADV = b.MADV
					where MAHD = @mahd
					group by MAHD
	end
	else
	begin
		select @tiendv = 0
	end
	declare @tongtien money

	
	select @tongtien = (@tienphong + @tiendv)
		
	select @tongtien as tongtien
commit tran
end try
begin catch
	rollback tran
end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_motaphong]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_motaphong] @sophong varchar(10)
as
begin
	begin tran
	begin try
		select cast(a.SOLUONG as varchar(10)) + ' ' + b.TENTN from PHONG_TIENNGHI a
		join TIENNGHI b on a.MATN = b.MATN
		where SOPHONG = @sophong and (a.MATN = 1 or a.MATN = 2)
		commit tran
	end try
	begin catch
		rollback tran
	end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_thanhtoanhd]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_thanhtoanhd] @mahd int, @malg int
as
begin
begin try
begin tran
	update HOADON set NGAYTT = getdate() where MAHD = @mahd
	declare @gia money, @tienphong money, @tiendv money, @tongNgayThue int, @tongGioThue int

	select @gia =  sum(dongia) from hoadon a
						join HDPHONG b on a.MAHD = b.MAHD
						join PHONG c on b.SOPHONG = c.SOPHONG
						join LOAIPHONG d on c.MALP = d.MALP
						join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
						where a.MAHD = @mahd and e.MALG = @malg
	select @tongNgayThue = DATEDIFF(day, ngaythue, ngaytt) from hoadon where MAHD = @mahd
	select @tongGioThue = DATEDIFF(HOUR, ngaythue, ngaytt) from hoadon where MAHD = @mahd
	if @malg = 1
	begin
		if @tongGioThue <= 2
		begin
			select @tienphong = @gia
		end
		else
		begin
			select @tienphong = @gia + (@tongGioThue - 2) * 20000
		end
	end
	else
	begin
		if @malg = 2
		begin
			declare @giotre_quadem int
			select @giotre_quadem = DATEPART(hour, ngaytt) from hoadon where MAHD = @mahd
			if @giotre_quadem >= 10 and @tongNgayThue > 0
			begin
				select @tienphong = @gia + (@giotre_quadem - 10) * 20000
			end
			else
			begin
				select @tienphong = @gia
			end
		end
		else
		begin 
			if @malg = 3
			begin
				if @tongNgayThue < 2
				begin
					select @tienphong = @gia
				end
				else
				begin
					select @tienphong = @tongNgayThue * @gia
				end
			end
		end
	end
	if (select count(*) from HDDICHVU where MAHD = @mahd) > 0
	begin
		select @tiendv = sum(a.SOLUONG * b.DONGIA) from HDDICHVU a
					join DICHVU b on a.MADV = b.MADV
					where MAHD = @mahd
					group by MAHD
	end
	else
	begin
		select @tiendv = 0
	end

	select @tienphong, @tiendv
	declare @tongtien money

	update HOADON
	set TONGTIEN = (@tienphong + @tiendv), TRANGTHAI = 1 where MAHD = @mahd
		
	update phong
	set TRANGTHAI = 0
	where phong.SOPHONG in (select sophong from HDPHONG 
								where phong.SOPHONG = HDPHONG.SOPHONG and MAHD = @mahd)
commit tran
end try
begin catch
	rollback tran
end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_tongtiennow]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_tongtiennow] @mahd int, @malg int
as
begin
begin try
begin tran
	declare @gia money, @tienphong money, @tiendv money, @tongNgayThue int, @tongGioThue int

	select @gia =  sum(dongia) from hoadon a
						join HDPHONG b on a.MAHD = b.MAHD
						join PHONG c on b.SOPHONG = c.SOPHONG
						join LOAIPHONG d on c.MALP = d.MALP
						join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
						where a.MAHD = @mahd and e.MALG = @malg
	select @tongNgayThue = DATEDIFF(day, ngaythue, getdate()) from hoadon where MAHD = @mahd
	select @tongGioThue = DATEDIFF(HOUR, ngaythue, GETDATE()) from hoadon where MAHD = @mahd
	if @malg = 1
	begin
		if @tongGioThue <= 2
		begin
			select @tienphong = @gia
		end
		else
		begin
			select @tienphong = @gia + (@tongGioThue - 2) * 20000
		end
	end
	else
	begin
		if @malg = 2
		begin
			declare @giotre_quadem int
			select @giotre_quadem = DATEPART(hour, ngaytt) from hoadon where MAHD = @mahd
			if @giotre_quadem >= 10 and @tongNgayThue > 0
			begin
				select @tienphong = @gia + (@giotre_quadem - 10) * 20000
			end
			else
			begin
				select @tienphong = @gia
			end
		end
		else
		begin 
			if @malg = 3
			begin
				if @tongNgayThue < 2
				begin
					select @tienphong = @gia
				end
				else
				begin
					select @tienphong = @tongNgayThue * @gia
				end
			end
		end
	end
	if (select count(*) from HDDICHVU where MAHD = @mahd) > 0
	begin
		select @tiendv = sum(a.SOLUONG * b.DONGIA) from HDDICHVU a
					join DICHVU b on a.MADV = b.MADV
					where MAHD = @mahd
					group by MAHD
	end
	else
	begin
		select @tiendv = 0
	end
	declare @tongtien money

	
	select @tongtien = (@tienphong + @tiendv)
		
	select @tongtien as tongtien
commit tran
end try
begin catch
	rollback tran
end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_topdv]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_topdv] @year int, @month int
as
begin
begin tran
begin try
	select TENDV, sum(soluong * dongia) as doanhthu from HOADON a
	join HDDICHVU b on a.MAHD = b.MAHD
	join DICHVU c on b.MADV = c.MADV
	where YEAR(ngaytt) = @year and MONTH(ngaytt) = @month
	group by TENDV
	order by doanhthu desc
	commit tran
end try
begin catch
	rollback tran
end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_topphong]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_topphong] @year int, @month int
as
begin
begin tran
begin try
	select a.SOPHONG, 
		sum(case b.MALG
		when 1 then case 
			when DATEDIFF(HOUR, ngaythue, ngaytt) <= 2 then 2 * DONGIA
			else 2 * DONGIA + (DATEDIFF(HOUR, ngaythue, ngaytt) - 2) * 20000
			end
		when 2 then case 
			when DATEPART(hour, ngaytt) <= 10 and DATEDIFF(day, ngaythue, ngaytt) > 0 then DONGIA + (DATEPART(hour, ngaytt) - 10) * 20000
			else DONGIA
			end
		when 3 then case
			when DATEDIFF(day, ngaythue, ngaytt) < 2 then DONGIA
			else DATEDIFF(day, ngaythue, ngaytt) * DONGIA
			end
		end)
	as DOANHTHU
	from HDPHONG a
	join HOADON b on a.MAHD = b.MAHD
	join phong c on a.SOPHONG = c.SOPHONG
	join LOAIPHONG d on c.MALP = d.MALP
	join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
	where b.MALG = e.MALG and MONTH(ngaytt) = @month and year(ngaytt) = @year
	group by a.SOPHONG
	order by DOANHTHU desc
	commit tran
end try
begin catch
	rollback tran
end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_xoahddv]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_xoahddv] @mahd int
as
begin
begin tran
begin try
	delete from HDDICHVU where MAHD = @mahd
	commit tran
end try
begin catch
	rollback tran
end catch
end
GO
/****** Object:  StoredProcedure [dbo].[sp_xoahdp]    Script Date: 4/19/2021 11:34:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_xoahdp] @mahd int
as
begin
begin tran
begin try
	delete from HDPHONG where MAHD = @mahd
	update phong
	set TRANGTHAI = 0
	where phong.SOPHONG in (select SOPHONG from HDPHONG where MAHD = @mahd)
	commit tran
end try
begin catch
	rollback tran
end catch
end
GO
