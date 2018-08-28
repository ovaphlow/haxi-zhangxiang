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

-- 正在导出表  haxi.schedule_detectionflaw 的数据：~5 rows (大约)
DELETE FROM `schedule_detectionflaw`;
/*!40000 ALTER TABLE `schedule_detectionflaw` DISABLE KEYS */;
INSERT INTO `schedule_detectionflaw` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`) VALUES
	(1, '2018-07-18 20:20:39', '5143', '2018-07-18', '1807138', '1975138', '2005138'),
	(2, '2018-07-24 08:32:08', '5143', '2018-07-18', '1807138', '1975138', '2005138'),
	(3, '2018-07-18 20:20:47', '5019', '2018-07-18', '4931809', '5099809', '5129809'),
	(4, '2018-07-24 08:37:16', '5020', '2018-07-18', '5322055', '5320055', '5350055'),
	(5, '2018-07-25 16:00:52', '5019', '2018-07-25', '5451809', '5619809', '5649809');
/*!40000 ALTER TABLE `schedule_detectionflaw` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
