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

-- 正在导出表  haxi.schedule_m4 的数据：~4 rows (大约)
DELETE FROM `schedule_m4`;
/*!40000 ALTER TABLE `schedule_m4` DISABLE KEYS */;
INSERT INTO `schedule_m4` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`) VALUES
	(1, '2018-07-18 20:24:28', '5019', '2018-07-18', '4931809', '5441809', '5591809'),
	(2, '2018-07-18 20:24:32', '5020', '2018-07-18', '5152055', '5662055', '5812055'),
	(3, '2018-07-24 09:33:01', '5145', '2018-07-18', '0', '510000', '660000'),
	(4, '2018-07-25 16:09:51', '5019', '2018-07-25', '5451809', '5961809', '6111809');
/*!40000 ALTER TABLE `schedule_m4` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
