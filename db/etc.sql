select * from phong

update phong set TRANGTHAI = 0

select * from HOADON

select * from LOAIGIA
delete from hoadon
delete from HDPHONG
delete from HDDICHVU


select * from HOADON
select * from HDPHONG
select * from HDDICHVU


select * from KHACHHANG a
where not exists (select * from hoadon b where a.MAKH = b.MAKH) and CMND = '122122121'

select a.* from hoadon a
join KHACHHANG b on a.MAKH = b.MAKH
where TRANGTHAI = 0 and (TENKH like '%1%' or cmnd like '%122%')

select a.* from hoadon a join khachhang b on a.makh = b.makh where trangthai = 0 and (b.tenkh like '%Cus%' or b.sdt like '%Cus%' or b.cmnd like '%Cus%')


select * from phong
select * from LOAIPHONG
select * from LOAIPHONG_LOAIGIA

select d.DONGIA from HDPHONG a join PHONG b on a.SOPHONG = b.SOPHONG join loaiphong c on b.MALP = c.MALP join LOAIPHONG_LOAIGIA d on c.MALP = d.MALP where d.MALG = 1


select c.DONGIA from phong a
join loaiphong b on a.MALP = b.MALP
join LOAIPHONG_LOAIGIA c on b.MALP = c.MALP
where c.MALG = 1 


select * from HOADON
select * from HDPHONG
select * from HDDICHVU

insert HDPHONG values (10, '302')


select c.SOPHONG, e.DONGIA from hoadon a
join HDPHONG b on a.MAHD = b.MAHD
join phong c on b.SOPHONG = c.SOPHONG
join LOAIPHONG d on c.MALP = d.MALP
join LOAIPHONG_LOAIGIA e on a.MALG = e.MALG
where e.MALG = 2 and a.MAHD = 10

select DONGIA from hoadon a
join HDPHONG b on a.MAHD = b.MAHD
join phong c on b.SOPHONG = c.SOPHONG
join LOAIPHONG d on c.MALP = d.MALP
join LOAIPHONG_LOAIGIA e on d.MALP = e.MALP
where a.MAHD = 10 and e.MALG = 2

select * from hoadon
select * from HDDICHVU
select * from DICHVU

select DONGIA from hoadon a
join HDDICHVU b on a.MAHD = b.MAHD
join DICHVU c on b.MADV = c.MADV
where a.MAHD = 10




