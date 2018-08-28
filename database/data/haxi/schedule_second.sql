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

-- 正在导出表  haxi.schedule_second 的数据：~6 rows (大约)
DELETE FROM `schedule_second`;
/*!40000 ALTER TABLE `schedule_second` DISABLE KEYS */;
INSERT INTO `schedule_second` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`, `next_date`) VALUES
	(1, '2018-07-18 20:18:48', '5019', '2018-07-18', '4931809', '4971809', '4986809', '2018-09-22'),
	(2, '2018-07-18 20:18:52', '5019', '2018-07-18', '4931809', '4971809', '4986809', '2018-09-22'),
	(3, '2018-07-18 20:32:55', '5019', '2018-02-18', '4921809', '4961809', '4976809', '2018-05-01'),
	(4, '2018-07-18 20:19:24', '5020', '2018-07-18', '5152055', '5192055', '5207055', '2018-09-22'),
	(5, '2018-07-20 09:23:59', '5143', '2018-07-18', '1807138', '1847138', '1862138', '2018-09-22'),
	(6, '2018-07-25 15:55:52', '5019', '2018-07-25', '5451809', '5491809', '5506809', '2018-09-29');
/*!40000 ALTER TABLE `schedule_second` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
