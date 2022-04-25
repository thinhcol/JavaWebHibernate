Create database ASMJAVA4;
Use ASMJAVA4;

Create table Users(
	userid varchar(20) primary key,
	pass varchar(24),
	fullname nvarchar(50),
	email varchar(50),
	roler bit,
	hinh varchar(Max)
);

Create table Videos(
	idvs varchar(11) primary key,
	tittle nvarchar(50),
	poster varchar(50),
	cmt nvarchar(Max),
	active bit,
	viewer int,
	video varchar(MAX),
	theloai nvarchar(50)
);
Create table Favorite(
	idfv bigint identity(1,1) primary key,
	idvs  varchar(11),
	userid varchar(20),
	likedate date
	foreign key (idvs) references Videos (idvs),
	foreign key (userid) references Users (userid)
);
Create table Share(
	idsr bigint identity(1,1) primary key,
	idvs varchar(11),
	userid varchar(20),
	email varchar(50),
	sahredate date
	foreign key (idvs) references Videos (idvs),
	foreign key (userid) references Users (userid)
);
Create table Comment(
	idcmt bigint identity(1,1) primary key,
	idvs varchar(11),
	userid varchar(20),
	comment nvarchar(Max),
	cmtdate date
	foreign key (idvs) references Videos (idvs),
	foreign key (userid) references Users (userid)
);

select * from Users
insert into Users values (N'thinh','123456',N'Đặng Phú Thịnh','thinhdp2002@gmail.com',1,'sdasdsd'),
(N'phu','123456',N'Nguyễn Ngọc Thiên Phú','thinhdp2002@gmail.com',0,'sdasdsd'),
(N'binh','123456',N'Trương Thị Thanh Bình','thinhdp2002@gmail.com',1,'sdasdsd'),
(N'man','123456',N'Lương Minh Mẫn','thinhdp2002@gmail.com',0,'sdasdsd'),
(N'thien','123456',N'Vũ Đức Thiện','thinhdp2002@gmail.com',0,'sdasdsd'),
(N'hung','123456',N'Nguyễn Huỳnh Khuyết Hùng','thinhdp2002@gmail.com',1,'sdasdsd'),
(N'anh','123456',N'Lê Ngọc Anh','thinhdp2002@gmail.com',1,'sdasdsd'),
(N'an','123456',N'Nguyễn Thành An','thinhdp2002@gmail.com',1,'sdasdsd'),
(N'doanh','123456',N'Nguyễn Ngọc Doanh','thinhdp2002@gmail.com',0,'sdasdsd'),
(N'dang','123456',N'Phạm Hải Đăng','thinhdp2002@gmail.com',1,'sdasdsd')
update videos set viewer=10 where idvs='video' and idvs='video4'and idvs='video5'and idvs='video6'
select * from videos
update users set hinh='BN2.jpg' where userid='thinh'
insert into Videos values ('video1',N'Supergirl','supergirl.jpg',N'sieeu ddirnh',0,1000000,'',N'Hành động'),
 ('video2',N'Captain Marvel','captain-marvel.png',N'sieeu ddirnh',0,1000000,'shdsdhs',N'Hành động'),
  ('video3',N'Infinity Train','demon-slayer.jpg',N'sieeu ddirnh',0,1000000,'shdsdhs',N'Hoạt Hình'),
  ('video4',N'Bloodshot','blood-shot.jpg',N'sieeu ddirnh',0,1000000,'shdsdhs',N'Kinh dị'),
  ('video5',N'Wanda Vision','wanda.png',N'sieeu ddirnh',0,1000000,'shdsdhs',N'Hành động'),
  ('video6',N'The Dark Knight','bat-man.jpg',N'sieeu ddirnh',0,1000000,'shdsdhs',N'Hành động'),
  ('video7',N'The Call','call.jpg',N'sieeu ddirnh',0,1,'shdsdhs',N'Kinh dị'),
  ('video8',N'Coco','coco.jpg',N'sieeu ddirnh',0,2,'shdsdhs',N'Hoạt hình'),
  ('video9',N'Cuộc Phiêu Lưu Của Nhà Croods','croods.jpg',N'sieeu ddirnh',0,3,'shdsdhs',N'Hoạt hình'),
  ('video10',N'7 viên ngọc rồng','dragon.jpg',N'sieeu ddirnh',0,10,'shdsdhs',N'Hoạt hình'),
  ('video11',N'Avengers: Hồi kết','end-game.jpg',N'sieeu ddirnh',0,5,'shdsdhs',N'Hành động'),
  ('video12',N'Mật vụ giải cứu','hunter-killer.jpg',N'sieeu ddirnh',0,10,'shdsdhs',N'Kinh dị'),
  ('video13',N'Quỷ quyệt','insidious.jpg',N'sieeu ddirnh',0,18,'shdsdhs',N'Kinh dị'),
  ('video14',N'Bồng bột tuổi dậy thì','love-roise.jpg',N'sieeu ddirnh',0,100,'shdsdhs',N'Lãng mạn'),
  ('video15',N'The Mandalorian','mandalorian.jpg',N'sieeu ddirnh',0,900,'shdsdhs',N'Khoa học viễn tưởng'),
  ('video16',N'Vươn tới cung trăng','over-the-moon.jpg',N'sieeu ddirnh',0,300,'shdsdhs',N'Hoạt hình'),
  ('video17',N'Cuộc chiến thượng lưu','penthouses.jpg',N'sieeu ddirnh',0,700,'shdsdhs',N'Drama'),
  ('video18',N'Resident Evil: Quỷ dữ trỗi dậy','resident-evil.jpg',N'sieeu ddirnh',0,811,'shdsdhs',N'Kinh dị'),
  ('video19',N'Du hành các vì sao','star-trek.jpg',N'sieeu ddirnh',0,1796,'shdsdhs',N'Khoa học viễn tưởng'),
  ('video20',N'Supergirl','start-trek.jpeg',N'sieeu ddirnh',0,3614,'shdsdhs',N'Hành động'),
  ('video21',N'Cậu bé mất tích','stranger-thing.jpg',N'sieeu ddirnh',0,2347,'shdsdhs',N'Khoa học viễn tưởng'),
  ('video22',N'Nhà hát của người chết','theatre-dead.jpg',N'sieeu ddirnh',0,7412,'shdsdhs',N'Kinh dị'),
  ('video23',N'The Falcon and the Winter Soldier','the-falcon.webp',N'sieeu ddirnh',0,1023,'shdsdhs',N'Hành động'),
  ('video24',N'Robot Trànormers','transformer.jpg',N'sieeu ddirnh',0,2356,'shdsdhs',N'Khoa học viễn tưởng'),
  ('video25',N'Weathering with you','weathering.jpg',N'sieeu ddirnh',0,3641,'shdsdhs',N'Hoạt hình'),
  ('video26',N'Your name','your-name.jpg',N'sieeu ddirnh',0,7496,'shdsdhs',N'Hoạt hình');
insert into Favorite values ('video1',N'thinh','2022-1-15'),
('video2',N'thinh','2022-1-15'),
('video3',N'thinh','2022-1-15'),
('video4',N'thinh','2022-1-15'),
('video5',N'thinh','2022-1-15'),
('video6',N'thinh','2022-1-15'),
('video7',N'thinh','2022-1-15'),
('video8',N'thinh','2022-1-15')
insert into Share values ('vs1',N'thinh','2022-1-15');

DROP PROCEDURE sp_FavoriteByYear
CREATE PROC sp_FavoriteByYear(@Year INT)
AS
	BEGIN
		SELECT
			v.tittle AS 'Group',
			count(f.idvs) AS 'Likes',
			max(f.likedate) AS 'Newest',
			min(f.likedate) AS 'Oldest'
		FROM favorite f JOIN Videos v ON v.idvs = f.idvs
		WHERE year(f.likedate) = @Year
		GROUP BY v.tittle
	END
exec sp_FavoriteByYear 2022
select * from Users
Select top 10 * from Videos Order By viewer DESC
Select top 1 * from Videos Order by NEWID()
select * from Videos where theloai=N'Hành động'
select * from Videos where theloai=N'Kinh dị'
select * from Videos where theloai=N'Hoạt hình'
select * from Videos where theloai=N'Drama'
select * from Videos where theloai=N'Khoa học viễn tưởng'
select * from Favorite where userid=N'thinh'
select * from Comment
select * from Share
select * from Users

