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

-- 正在导出表  haxi.journal02_03 的数据：~0 rows (大约)
DELETE FROM `journal02_03`;
/*!40000 ALTER TABLE `journal02_03` DISABLE KEYS */;
INSERT INTO `journal02_03` (`id`, `master_id`, `name`, `train`, `carriage`, `position`, `date`, `time`, `production_date`, `reason`, `p_gywj`, `p_ljbs`, `component_sn_old`, `component_sn_new`, `p_bjaz`, `operator`, `leader`, `p_bjgnsy`, `qc`, `duty_officer`) VALUES
	(1, 7, '大撒大撒', '5019', '01', ' 达到', '2018-08-28', '12:12:12', '121212', '二五七五', '是', '是', '15246', '15246', '是', '长客', '地勤一修', '是', '质检1', '');
/*!40000 ALTER TABLE `journal02_03` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
