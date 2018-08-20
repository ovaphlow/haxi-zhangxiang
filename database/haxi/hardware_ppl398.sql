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

-- 导出  表 haxi.hardware_ppl398 结构
CREATE TABLE IF NOT EXISTS `hardware_ppl398` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `identify_pad` varchar(20) NOT NULL DEFAULT '',
  `identify_pen` varchar(20) NOT NULL DEFAULT '',
  `version` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.hardware_ppl398 的数据：~2 rows (大约)
DELETE FROM `hardware_ppl398`;
/*!40000 ALTER TABLE `hardware_ppl398` DISABLE KEYS */;
INSERT INTO `hardware_ppl398` (`id`, `uuid`, `identify_pad`, `identify_pen`, `version`) VALUES
	(1, '44957294-74ed-11e8-afd3-2cfda16e4afb', '1710004551', '17110928', 'PPL398S1'),
	(2, 'e1d806fc-74ed-11e8-afd3-2cfda16e4afb', '1710004520', '17110937', 'PPL398S1');
/*!40000 ALTER TABLE `hardware_ppl398` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
