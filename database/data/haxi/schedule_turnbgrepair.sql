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

-- 正在导出表  haxi.schedule_turnbgrepair 的数据：~5 rows (大约)
DELETE FROM `schedule_turnbgrepair`;
/*!40000 ALTER TABLE `schedule_turnbgrepair` DISABLE KEYS */;
INSERT INTO `schedule_turnbgrepair` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`) VALUES
	(1, '2018-07-19 22:17:59', '5566', '2018-07-19', '3090043', '3260043', '3290043'),
	(2, '2018-07-19 22:18:07', '5717', '2018-07-19', '1996898', '2166898', '2196898'),
	(3, '2018-07-19 22:18:13', '5727', '2018-07-19', '2023917', '2193917', '2223917'),
	(4, '2018-07-19 22:19:11', '5727', '2018-07-19', '2023917', '2193917', '2223917'),
	(5, '2018-07-25 16:15:00', '5566', '2018-07-25', '3380043', '3550043', '3580043');
/*!40000 ALTER TABLE `schedule_turnbgrepair` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
