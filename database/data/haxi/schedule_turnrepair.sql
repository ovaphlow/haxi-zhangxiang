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

-- 正在导出表  haxi.schedule_turnrepair 的数据：~4 rows (大约)
DELETE FROM `schedule_turnrepair`;
/*!40000 ALTER TABLE `schedule_turnrepair` DISABLE KEYS */;
INSERT INTO `schedule_turnrepair` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`) VALUES
	(1, '2018-07-18 20:22:27', '5020', '2018-07-18', '5152055', '5382055', '5402055'),
	(2, '2018-07-18 20:22:33', '5019', '2018-07-18', '4931809', '5161809', '5181809'),
	(3, '2018-07-18 20:22:38', '5143', '2018-07-18', '1807138', '2037138', '2057138'),
	(4, '2018-07-25 16:03:37', '5019', '2018-07-25', '5451809', '5681809', '5701809');
/*!40000 ALTER TABLE `schedule_turnrepair` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
