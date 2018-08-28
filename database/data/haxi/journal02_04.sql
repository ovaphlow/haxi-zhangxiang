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

-- 正在导出表  haxi.journal02_04 的数据：~0 rows (大约)
DELETE FROM `journal02_04`;
/*!40000 ALTER TABLE `journal02_04` DISABLE KEYS */;
INSERT INTO `journal02_04` (`id`, `uuid`, `master_id`, `subject`, `software_version_new`, `software_version_old`, `approval_sn`, `train`, `date`, `carriage`, `time_begin`, `time_end`, `dept`, `operator`, `watcher`, `watcher_group`, `qc`, `remark`) VALUES
	(1, '9de815ac-aa9e-11e8-90a9-2cfda16e4afb', 8, '动车加装火箭推进四级长征运载系统', '1.10023', '1.33654', '152556', '5019', '2018-08-28', '01', '12:12:12', '12:12:13', '长客', '长客', '地勤一修', '地勤一修组', '', '很快');
/*!40000 ALTER TABLE `journal02_04` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
