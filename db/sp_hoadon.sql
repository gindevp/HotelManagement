select * from HOADON
select * from HDPHONG
select * from HDDICHVU
select * from DICHVU
select * from PHONG
select * from LOAIPHONG
select * from LOAIPHONG_LOAIGIA

select * from HDDICHVU



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
			select @tienphong = 2 * @gia + (@tongGioThue - 2) * 20
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
				select @tienphong = @gia + (@giotre_quadem - 10) * 20
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



exec sp_thanhtoanhd 18, 2
select * from HOADON
select * from HDPHONG
select * from PHONG

select ngaythue, ngaytt, datediff(hour, ngaythue, NGAYTT) from hoadon where MAHD = 10

select DATEDIFF(hour, ngaythue, ngaytt), ngaythue, NGAYTT from hoadon where MAHD = 10

select * from LOAIPHONG_LOAIGIA
update LOAIPHONG_LOAIGIA
set DONGIA /= 1000


select DATEPART(hour, ngaytt) from HOADON

select sum(dongia) from hoadon a
						join HDPHONG b on a.MAHD = b.MAHD
						join PHONG c on b.SOPHONG = c.SOPHONG
						join LOAIPHONG d on c.MALP = d.MALP
						join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
						where a.MAHD = 10 and e.MALG = 2

select DATEPART(hour, ngaytt) from hoadon where MAHD = 10

exec sp_thanhtoanhd 10, 2

select * from HOADON
select * from HDDICHVU
select * from DICHVU

select sum(c.DONGIA * b.soluong) from HOADON a
join HDDICHVU b on a.MAHD = b.MADV
join DICHVU c on b.MADV = c.MADV
where b.MADV = 10

select * from HDDICHVU
select * from DICHVU

update phong set TRANGTHAI = 0



select a.SOLUONG, b.DONGIA, a.SOLUONG * b.DONGIA from HDDICHVU a
join DICHVU b on a.MADV = b.MADV
where MAHD = 10

select * from HOADON
select * from HDPHONG
select * from PHONG

update phong
set TRANGTHAI = 1
where phong.SOPHONG in (select sophong from HDPHONG where phong.SOPHONG = HDPHONG.SOPHONG and MAHD = 10)
select * from PHONG

update HOADON
set NGAYTHUE = DATEADD(Day, -1, NGAYTHUE)
where MAHD = 10

select * from KHACHHANG


select * from khachhang a 
where sdt = '122122121' or cmnd = '122122121'
	and a.MAKH not in (select makh from hoadon b where a.MAKH = b.MAKH and TRANGTHAI = 0)

select * from khachhang a 
where a.MAKH not in (select makh from hoadon b where a.MAKH = b.MAKH)

select * from HOADON 

select datediff(hour, NGAYTHUE, NGAYTT) from HOADON where MAHD = 15

update hoadon 
set NGAYTHUE = DATEADD(hour, -1, ngaythue) 
where mahd = 15


	select sum(dongia) from hoadon a
						join HDPHONG b on a.MAHD = b.MAHD
						join PHONG c on b.SOPHONG = c.SOPHONG
						join LOAIPHONG d on c.MALP = d.MALP
						join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
						where a.MAHD = 16 and e.MALG = 1
						select * from PHONG
						select * from HDPHONG
						select * from LOAIPHONG_LOAIGIA

delete from HDPHONG where MAHD = 17
delete from HOADON where MAHD = 17

select * from HOADON
select * from HDPHONG
select * from HDDICHVU
select count(*) from HDDICHVU
where MAHD = 18

select * from DICHVU

update DICHVU
set DONGIA /= 10




