USE MASTER
GO

IF OBJECT_ID('QLKS') IS NOT NULL
	DROP DATABASE QLKS
GO
CREATE DATABASE QLKS
GO

USE QLKS
GO

----------------------------BO PHAN
IF OBJECT_ID('BOPHAN') IS NOT NULL
	DROP TABLE BOPHAN
GO
CREATE TABLE BOPHAN
(
	MABP	VARCHAR(10) NOT NULL PRIMARY KEY,
	TENBP	NVARCHAR(50) NOT NULL
)
GO

DELETE FROM BOPHAN
INSERT BOPHAN VALUES ('QL', N'Quản Lý')
INSERT BOPHAN VALUES ('KT', N'Kế Toán')
INSERT BOPHAN VALUES ('PB', N'Phòng Ban')
INSERT BOPHAN VALUES ('LT', N'Lễ Tân')
SELECT * FROM BOPHAN
GO

---------------------------------------------------
IF OBJECT_ID('NHANVIEN') IS NOT NULL
	DROP TABLE NHANVIEN
GO
CREATE TABLE NHANVIEN
(
	MANV			VARCHAR(10) NOT NULL PRIMARY KEY,
	TENNV			NVARCHAR(50) NOT NULL,
	PASSWORD		VARCHAR(50) NOT NULL,
	NGAYSINH		DATE NOT NULL,
	GIOITINH		BIT NOT NULL,
	DIACHI			NVARCHAR(50) NOT NULL,
	SDT				VARCHAR(20) NOT NULL,
	EMAIL			VARCHAR(50) NOT NULL,
	ANH				VARCHAR(50),
	MABP			VARCHAR(10) NOT NULL,
	UNIQUE(SDT),
	UNIQUE(EMAIL),
	FOREIGN KEY (MABP) REFERENCES BOPHAN(MABP) ON UPDATE CASCADE 
)
GO
DELETE FROM NHANVIEN
INSERT NHANVIEN VALUES ('PH01', N'Nguyễn Nhật Hùng', 'hungnn', '1998-03-05', 1, N'Hà Nội', '0984111111', 'hungnnph09719@fpt.edu.vn', DEFAULT, 'QL')
INSERT NHANVIEN VALUES ('PH02', N'Hứa Mạnh Hùng', 'hunghm', '2000-03-05', 1, N'Hà Nội', '0984111112', 'hunghmph09808@fpt.edu.vn', DEFAULT, 'QL')
INSERT NHANVIEN VALUES ('PH03', N'Nguyễn Hữu Quyết', 'quyetnh', '2001-03-05', 1, N'Hà Nội', '0984111113', 'quyetnhph12037@fpt.edu.vn', DEFAULT, 'LT')

INSERT NHANVIEN VALUES ('PH04', N'Nguyễn Quốc Lập', 'lapnq', '2002-11-12', 1, N'Hà Nội', '0984111114', 'lapnqph14889@fpt.edu.vn', DEFAULT, 'LT')
INSERT NHANVIEN VALUES ('PH05', N'Hoàng Tấn Lộc', 'locht', '2001-08-13', 1, N'Hà Nội', '0984111115', 'lochtph15557@fpt.edu.vn', DEFAULT, 'LT')
INSERT NHANVIEN VALUES ('PH06', N'Trương Tấn Thành', 'thanhtt', '2000-05-09', 1, N'Hà Nội', '0984111116', 'thanhttph15752@fpt.edu.vn', DEFAULT, 'PB')
INSERT NHANVIEN VALUES ('PH07', N'Ngô Duy Nam ', 'namnd', '1999-06-05', 1, N'Hà Nội', '0984111117', 'namndph15819 @fpt.edu.vn', DEFAULT, 'PB')
INSERT NHANVIEN VALUES ('PH08', N'Bùi Minh Hiển ', 'hienbm', '2001-12-05', 1, N'Hà Nội', '0984111118', 'hienbmph15983@fpt.edu.vn', DEFAULT, 'KT')
INSERT NHANVIEN VALUES ('PH09', N'Đỗ Thị Huế ', 'huedt', '2001-03-23', 0, N'Hà Nội', '0984111119', 'huedtph16848@fpt.edu.vn', DEFAULT, 'KT')
INSERT NHANVIEN VALUES ('PH10', N'Phạm Anh Tú ', 'tupa', '2001-10-05', 1, N'Hà Nội', '0984111120', 'tupaph17044@fpt.edu.vn', DEFAULT, 'LT')

delete from NHANVIEN where MANV = 'ph10'

SELECT * FROM NHANVIEN
GO

---------------------------------------------------------MAXACNHAN
IF OBJECT_ID('MAXACNHAN') IS NOT NULL
	DROP TABLE MAXACNHAN
GO
CREATE TABLE MAXACNHAN
(
	ID			INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	CODE		VARCHAR(20) NOT NULL,
	MANV		VARCHAR(10) NOT NULL,
	CREATEAT	DATETIME NOT NULL DEFAULT GETDATE()
	FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV) ON UPDATE CASCADE
)
GO
DELETE FROM MAXACNHAN
DBCC CHECKIDENT ('MAXACNHAN', RESEED, 0)

--------------------------------------------DICHVU
IF OBJECT_ID('DICHVU') IS NOT NULL
	DROP TABLE DICHVU
GO
CREATE TABLE DICHVU
( 
	MADV		INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TENDV		NVARCHAR(50) NOT NULL,
	DONGIA		MONEY NOT NULL CHECK(DONGIA >= 0),
	MOTA		NVARCHAR(500),
	TRANGTHAI	BIT NOT NULL DEFAULT 1
)
GO

DELETE FROM DICHVU
DBCC CHECKIDENT ('DICHVU', RESEED, 0)
INSERT DICHVU VALUES ('Make-up room service', 20000, N'Make-up room service là dịch vụ làm phòng. Trong dịch vụ này, người làm phòng sẽ thay drap giường, khăn tắm và các đồ dùng trong phòng ngủ.', 1)
INSERT DICHVU VALUES ('Turndown service', 40000, N'Là dịch vụ chỉnh trang phòng buổi tối. Người làm phòng sẽ trải thẳng lại drap giường, gấp nếp giường, đặt cành hoa hoặc thiệp chúc ngủ ngon lên giường..', 1)
INSERT DICHVU VALUES ('Laundry service', 50000, N'Laundry service là dịch vụ giặt ủi trong khách sạn.', 1)
SELECT * FROM DICHVU
GO

-----------------------------------------------------TIENNGHI
IF OBJECT_ID('TIENNGHI') IS NOT NULL
	DROP TABLE TIENNGHI
GO
CREATE TABLE TIENNGHI
( 
	MATN	INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TENTN	NVARCHAR(50) NOT NULL
)
GO
DELETE FROM TIENNGHI
DBCC CHECKIDENT ('TIENNGHI', RESEED, 0)
INSERT TIENNGHI VALUES (N'Tivi')
INSERT TIENNGHI VALUES (N'Tủ lạnh')
INSERT TIENNGHI VALUES (N'Điều hòa')
INSERT TIENNGHI VALUES (N'Ghế massage')
GO
SELECT * FROM TIENNGHI

------------------------------------------------LOAIGIA
IF OBJECT_ID('LOAIGIA') IS NOT NULL
	DROP TABLE LOAIGIA
GO
CREATE TABLE LOAIGIA
( 
	MALG	INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TENLG	NVARCHAR(50) NOT NULL
)
GO
DELETE FROM LOAIGIA
DBCC CHECKIDENT ('LOAIGIA', RESEED, 0)
INSERT LOAIGIA VALUES (N'Theo giờ')
INSERT LOAIGIA VALUES (N'Qua đêm')
INSERT LOAIGIA VALUES (N'Theo ngày')
SELECT * FROM LOAIGIA
GO

--------------------------------------------LOAIPHONG
IF OBJECT_ID ('LOAIPHONG') IS NOT NULL
DROP TABLE LOAIPHONG
GO
CREATE TABLE LOAIPHONG
(
	MALP		VARCHAR(10) NOT NULL PRIMARY KEY,
	TENLP		NVARCHAR(50) NOT NULL,
	MOTA		NVARCHAR(500) 
)
GO

DELETE FROM LOAIPHONG
INSERT LOAIPHONG VALUES ('STD', 'Standard', N'Phòng standard (viết tắt là STD) là loại phòng tiêu chuẩn, đơn giản nhất trong các khách sạn hiện nay. Đây là loại phòng có diện tích nhỏ, thường được đặt ở tầng thấp nhất và không có view hoặc view không được đẹp. Trang thiết bị của phòng standard cũng được khách sạn giảm tối thiểu. Chính vì vậy, giá phòng standard nằm ở mức thấp nhất trong các loại phòng khách sạn.')
INSERT LOAIPHONG VALUES ('SUP', 'Superior', N'Phòng superior cao cấp hơn phòng standard với diện tích lớn hơn (từ 20m2 trở lên) bao gồm 1-2 giường, tầm nhìn view cũng đẹp hơn. Trang thiết bị của phòng được khách sạn đầu tư hiện đại. Vì chất lượng tốt hơn nên mức giá cho phòng superior cũng sẽ cao hơn phòng standard.')
INSERT LOAIPHONG VALUES ('DLX', 'Deluxe', N'Phòng deluxe thường ở tầng trên cao với view đẹp (hướng ra núi, biển… ). Diện tích của loại phòng này rộng rãi hơn superior và được đầu tư trang thiết bị cao cấp như tivi, tủ lạnh, bồn rửa mặt cao cấp… Đương nhiên, mức giá niêm yết dành cho phòng deluxe sẽ cao hơn superior.')
INSERT LOAIPHONG VALUES ('SUT', 'Suite', N'Phòng suite là loại phòng cao cấp nhất khách sạn, được đặt ở tầng cao nhất, nơi có không gian thoáng đãng và không khí trong lành. Với diện tích từ 60 – 120m2, phòng suite thường bao gồm 1 phòng khách, 1 phòng ngủ riêng biệt, cửa sổ và ban công để khách ngắm phong cảnh.')
GO
SELECT * FROM LOAIPHONG

---------------------------------------LOAIPHONG_GIA
IF OBJECT_ID ('LOAIPHONG_LOAIGIA') IS NOT NULL
DROP TABLE LOAIPHONG_LOAIGIA
GO
CREATE TABLE LOAIPHONG_LOAIGIA
(
	ID		INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	MALP	VARCHAR(10) NOT NULL,
	MALG	INT NOT NULL,
	DONGIA	MONEY NOT NULL CHECK(DONGIA > 0),
	UNIQUE(MALP, MALG),
	FOREIGN KEY (MALP) REFERENCES LOAIPHONG(MALP),
	FOREIGN KEY (MALG) REFERENCES LOAIGIA(MALG)
)
GO
DELETE FROM LOAIPHONG_LOAIGIA
DBCC CHECKIDENT ('LOAIPHONG_LOAIGIA', RESEED, 0)
INSERT LOAIPHONG_LOAIGIA VALUES ('STD', 1, 50)
INSERT LOAIPHONG_LOAIGIA VALUES ('STD', 2, 100)
INSERT LOAIPHONG_LOAIGIA VALUES ('STD', 3, 80)

INSERT LOAIPHONG_LOAIGIA VALUES ('SUP', 1, 80)
INSERT LOAIPHONG_LOAIGIA VALUES ('SUP', 2, 120)
INSERT LOAIPHONG_LOAIGIA VALUES ('SUP', 3, 100)

INSERT LOAIPHONG_LOAIGIA VALUES ('DLX', 1, 120)
INSERT LOAIPHONG_LOAIGIA VALUES ('DLX', 2, 160)
INSERT LOAIPHONG_LOAIGIA VALUES ('DLX', 3, 140)

INSERT LOAIPHONG_LOAIGIA VALUES ('SUT', 1, 160)
INSERT LOAIPHONG_LOAIGIA VALUES ('SUT', 2, 200)
INSERT LOAIPHONG_LOAIGIA VALUES ('SUT', 3, 180)

SELECT * FROM LOAIPHONG_LOAIGIA
GO

---------------------------------------------PHONG
IF OBJECT_ID ('PHONG') IS NOT NULL
	DROP TABLE PHONG
GO
CREATE TABLE PHONG
(
	SOPHONG		VARCHAR(10) NOT NULL PRIMARY KEY,
	SUCCHUA		INT NOT NULL CHECK(SUCCHUA > 0),
	TRANGTHAI	BIT NOT NULL DEFAULT 0,
	MALP		VARCHAR(10) NOT NULL
	FOREIGN KEY (MALP) REFERENCES LOAIPHONG(MALP) ON UPDATE CASCADE
)
GO

DELETE FROM PHONG
INSERT PHONG VALUES ('101', 4, DEFAULT, 'STD')
INSERT PHONG VALUES ('102', 4, DEFAULT, 'STD')
INSERT PHONG VALUES ('103', 2, DEFAULT, 'STD')

INSERT PHONG VALUES ('201', 4, DEFAULT, 'SUP')
INSERT PHONG VALUES ('202', 4, DEFAULT, 'SUP')
INSERT PHONG VALUES ('203', 4, DEFAULT, 'SUP')

INSERT PHONG VALUES ('301', 4, DEFAULT, 'DLX')
INSERT PHONG VALUES ('302', 4, DEFAULT, 'DLX')
INSERT PHONG VALUES ('303', 4, DEFAULT, 'DLX')

INSERT PHONG VALUES ('401', 4, DEFAULT, 'SUT')
INSERT PHONG VALUES ('402', 4, DEFAULT, 'SUT')
INSERT PHONG VALUES ('403', 4, DEFAULT, 'SUT')
GO
SELECT * FROM PHONG

--------------------------------------------PHONG_TIENNGHI
IF OBJECT_ID('PHONG_TIENNGHI') IS NOT NULL
	DROP TABLE PHONG_TIENNGHI
GO
CREATE TABLE PHONG_TIENNGHI
(
	ID			INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	SOPHONG		VARCHAR(10) NOT NULL,
	MATN		INT NOT NULL,
	SOLUONG		INT NOT NULL,
	TINHTRANG	NVARCHAR(50) NOT NULL DEFAULT 'Normal'
	UNIQUE (SOPHONG, MATN),
	FOREIGN KEY (SOPHONG) REFERENCES PHONG(SOPHONG),
	FOREIGN KEY (MATN) REFERENCES TIENNGHI(MATN),
)
GO
DELETE FROM PHONG_TIENNGHI
DBCC CHECKIDENT ('PHONG_TIENNGHI', RESEED, 0)
INSERT PHONG_TIENNGHI VALUES ('101', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('101', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('102', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('102', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('103', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('103', 3, 1, DEFAULT)


INSERT PHONG_TIENNGHI VALUES ('201', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('201', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('201', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('202', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('202', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('202', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('203', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('203', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('203', 3, 1, DEFAULT)

INSERT PHONG_TIENNGHI VALUES ('301', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('301', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('301', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('302', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('302', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('302', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('303', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('303', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('303', 3, 1, DEFAULT)

INSERT PHONG_TIENNGHI VALUES ('401', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('401', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('401', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('401', 4, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('402', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('402', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('402', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('402', 4, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('403', 1, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('403', 2, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('403', 3, 1, DEFAULT)
INSERT PHONG_TIENNGHI VALUES ('403', 4, 1, DEFAULT)
GO
SELECT * FROM PHONG_TIENNGHI

---------------------------------------------KHACHHANG
IF OBJECT_ID('KHACHHANG') IS NOT NULL
	DROP TABLE KHACHHANG
GO
CREATE TABLE KHACHHANG
(
	MAKH		INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TENKH		NVARCHAR(50) NOT NULL,
	CMND		VARCHAR(20) NOT NULL,
	SDT			VARCHAR(20) NOT NULL,
	GIOITINH	BIT NOT NULL,
	DIACHI		NVARCHAR(50) NOT NULL,
	QUOCTICH	NVARCHAR(50) NOT NULL
	UNIQUE(CMND),
	UNIQUE(SDT)
)
GO

DELETE FROM KHACHHANG
DBCC CHECKIDENT ('KHACHHANG', RESEED, 0)
INSERT KHACHHANG VALUES (N'Trần Thị Quỳnh', '122122121', '0987654001', 0, N'Hà Nội', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Trần Ngọc Hải', '122122122', '0987654002', 0, N'Hồ Chí Minh', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Đỗ Trà My', '122122123', '0987654003', 1, N'Đà Nẵng', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Nguyễn Bá Quang', '122122124', '0987654004', 1, N'Hải Phòng', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Nguyễn Bảo Linh', '122122125', '0987654005', 0, N'Hải Dương', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Vũ Thị Thu', '122122126', '0987654006', 0, N'Bắc Nih', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Trần Thị Ngọc Diệp', '122122127', '0987654007', 0, N'Hà Nam', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Nguyễn Việt Anh', '122122128', '0987654008', 1, N'Quảng Ninh', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Nông Thị Ngoan', '122122129', '0987654009', 0, N'Bắc Giang', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Ngô Hà Vy', '122122130', '0987654010', 0, N'Hà Nội', N'Việt Nam')

INSERT KHACHHANG VALUES (N'Vũ Trọng Huy', '122122131', '0987654011', 1, N'Bắc Kạn', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Vũ Hoàng Phong', '122122132', '0987654012', 1, N'Bến Tre', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Đinh Văn Kiên', '122122133', '0987654013', 1, N'Thái Bình', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Phạm Anh Hùng', '122122134', '0987654014', 1, N'Cần Thơ', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Lê Thuỷ Tiên', '122122135', '0987654015', 0, N'Khánh Hòa', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Phan Văn Ký', '122122136', '0987654016', 1, N'Lâm Đồng', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Lê Thu Trà ', '122122137', '0987654017', 0, N'Nam Định', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Chu Văn An', '122122138', '0987654018', 1, N'Ninh Thuận', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Lê Thị Dung', '122122139', '0987654019', 0, N'Phú Thọ', N'Việt Nam')
INSERT KHACHHANG VALUES (N'Lê Anh Quân', '122122140', '0987654020', 1, N'Hà Tĩnh', N'Việt Nam')

GO
SELECT * FROM KHACHHANG

-------------------------------------HOADON
IF OBJECT_ID('HOADON') IS NOT NULL
	DROP TABLE HOADON
GO
CREATE TABLE HOADON
(
	MAHD		INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	NGAYTHUE	DATETIME NOT NULL DEFAULT GETDATE(),
	NGAYTT		DATETIME,
	TONGTIEN	MONEY NOT NULL CHECK (TONGTIEN >= 0),
	TRANGTHAI	BIT NOT NULL DEFAULT 0,
	MALG		INT NOT NULL,
	MAKH		INT NOT NULL,
	MANV		VARCHAR(10) NOT NULL
	FOREIGN KEY (MALG) REFERENCES LOAIGIA(MALG),
	FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH),
	FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)
GO

DELETE FROM HOADON
DBCC CHECKIDENT ('HOADON', RESEED, 0)

----------------------------------------HDDICHVU
IF OBJECT_ID('HDDICHVU') IS NOT NULL
	DROP TABLE HDDICHVU
GO
CREATE TABLE HDDICHVU
(
	ID			INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	MAHD		INT NOT NULL,
	MADV		INT NOT NULL,
	SOLUONG		INT NOT NULL CHECK(SOLUONG > 0)
	UNIQUE(MAHD, MADV),
	FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD),
	FOREIGN KEY (MADV) REFERENCES DICHVU(MADV)	
)
GO
DELETE FROM HDDICHVU
DBCC CHECKIDENT ('HDDICHVU', RESEED, 0)

--------------------------------------------HDPHONG
IF OBJECT_ID('HDPHONG') IS NOT NULL
	DROP TABLE HDPHONG
GO
CREATE TABLE HDPHONG
(
	ID			INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	MAHD		INT NOT NULL,
	SOPHONG		VARCHAR(10) NOT NULL
	UNIQUE(MAHD, SOPHONG),
	FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD),
	FOREIGN KEY (SOPHONG) REFERENCES PHONG(SOPHONG)
)
GO
DELETE FROM HDPHONG
DBCC CHECKIDENT ('HDPHONG', RESEED, 0)

-----------------------------------------sp_thanhtoan
if OBJECT_ID('sp_thanhtoanhd') is not null
drop proc sp_thanhtoanhd
go
create proc sp_thanhtoanhd @mahd int, @malg int
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
			select @tienphong = 2 * @gia
		end
		else
		begin
			select @tienphong = 2 * @gia + (@tongGioThue - 2) * 20000
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

----------------------------sp_xoahdp
if OBJECT_ID('sp_xoahdp') is not null
	drop proc sp_xoahdp
go
create proc sp_xoahdp @mahd int
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
go

----------------------------------sp_xoahddv

if OBJECT_ID('sp_xoahddv') is not null
	drop proc sp_xoahddv
go
create proc sp_xoahddv @mahd int
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
go

---------------------------------------sp_topphong
if OBJECT_ID('sp_topphong') is not null
	drop proc sp_topphong
go
create proc sp_topphong @year int, @month int
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
go

exec sp_topphong 2021, 3

--------------------------------sp_topdv
if OBJECT_ID('sp_topdv') is not null
	drop proc sp_topdv
go
create proc sp_topdv @year int, @month int
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

exec sp_topdv 2021, 3
------------------------------sp_sosanhdt
if OBJECT_ID ('sp_sosanhdoanhthu') is not null
	drop proc sp_sosanhdoanhthu
go
create proc sp_sosanhdoanhthu @year int
as
begin
	select MONTH(ngaytt) as thang, sum(tongtien) as tong from HOADON
	where YEAR(ngaytt) = @year
	group by MONTH(ngaytt)
end



