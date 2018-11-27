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

-- 正在导出表  haxi.schedule_m3bgrepair 的数据：~4 rows (大约)
DELETE FROM `schedule_m3bgrepair`;
/*!40000 ALTER TABLE `schedule_m3bgrepair` DISABLE KEYS */;
INSERT INTO `schedule_m3bgrepair` (`id`, `update_time`, `train`, `last_date`, `last_mileage`, `alarm_mileage`, `next_mileage`) VALUES
	(1, '2018-07-19 22:19:38', '5727', '2018-07-19', '2023917', '2303917', '2903917'),
	(2, '2018-07-19 22:20:04', '5717', '2018-07-19', '1996898', '2276898', '2876898'),
	(3, '2018-07-19 22:20:11', '5566', '2018-07-19', '3090043', '3370043', '3970043'),
	(4, '2018-07-25 16:19:18', '5566', '2018-07-25', '3380043', '3660043', '4260043');
/*!40000 ALTER TABLE `schedule_m3bgrepair` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
