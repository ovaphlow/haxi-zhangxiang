-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.3.8-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 正在导出表  haxi.schedule_bgsecond 的数据：~4 rows (大约)
DELETE FROM `schedule_bgsecond`;
/*!40000 ALTER TABLE `schedule_bgsecond` DISABLE KEYS */;
INSERT INTO `schedule_bgsecond` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`, `next_date`) VALUES
	(1, '2018-07-19 21:53:43', '5566', '2018-07-19', '3090043', '3175043', '3200043', '2018-10-26'),
	(2, '2018-07-19 21:54:12', '5591', '2018-07-19', '2523392', '2608392', '2633392', '2018-10-26'),
	(3, '2018-07-19 21:54:20', '5591', '2018-07-19', '2523392', '2608392', '2633392', '2018-10-26'),
	(4, '2018-07-25 16:12:33', '5566', '2018-07-25', '3380043', '3465043', '3490043', '2018-11-01');
/*!40000 ALTER TABLE `schedule_bgsecond` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
