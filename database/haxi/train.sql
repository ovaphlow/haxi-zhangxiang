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

-- 导出  表 haxi.train 结构
CREATE TABLE IF NOT EXISTS `train` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `model` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `uuid` (`uuid`),
  KEY `model` (`model`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='车组';

-- 正在导出表  haxi.train 的数据：~72 rows (大约)
DELETE FROM `train`;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` (`id`, `uuid`, `model`, `name`) VALUES
	(1, 'd66a276c-79db-11e8-85eb-2cfda16e4afb', '测试车型', '测试车组123'),
	(2, 'a73ce54a-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5020'),
	(3, 'a73ce7a2-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5019'),
	(4, 'a73ce86a-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5022'),
	(5, 'a73ce8f6-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5030'),
	(6, 'a73ce98c-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5033'),
	(7, 'a73cea18-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5023'),
	(8, 'a73ceaa4-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5041'),
	(9, 'a73ceb30-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5043'),
	(10, 'a73cebbc-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5056'),
	(11, 'a73cecca-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5064'),
	(12, 'a73ced56-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5065'),
	(13, 'a73cede2-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5067'),
	(14, 'a73cee78-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5128'),
	(15, 'a73cf242-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5129'),
	(16, 'a73cf2d8-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5131'),
	(17, 'a73cf382-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5130'),
	(18, 'a73cf40e-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5132'),
	(19, 'a73cf4ae-9562-11e8-a067-2cfda16e4afb', 'CRH5A', '5140'),
	(20, 'a73cf53a-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5143'),
	(21, 'a73cf6f2-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5144'),
	(22, 'a73cf77e-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5145'),
	(23, 'a73cf80a-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5146'),
	(24, 'a73cf896-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5155'),
	(25, 'a73cf99a-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5154'),
	(26, 'a73cfa30-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5158'),
	(27, 'a73cfabc-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5156'),
	(28, 'a73cfb52-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5153'),
	(29, 'a73d01e2-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5159'),
	(30, 'a73d0278-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5186'),
	(31, 'a73d0304-9562-11e8-a067-2cfda16e4afb', 'CRH5G', '5187'),
	(32, 'a73d0390-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5546'),
	(33, 'a73d041c-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5556'),
	(34, 'a73d04a8-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5557'),
	(35, 'a73d0534-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5565'),
	(36, 'a73d05b6-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5566'),
	(37, 'a73d0638-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5571'),
	(38, 'a73d06ba-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5578'),
	(39, 'a73d0764-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5582'),
	(40, 'a73d07f0-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5590'),
	(41, 'a73d087c-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5591'),
	(42, 'a73d0908-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5592'),
	(43, 'a73d099e-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5593'),
	(44, 'a73d0a20-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5594'),
	(45, 'a73d0ab6-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5600'),
	(46, 'a73d0b42-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5626'),
	(47, 'a73d0bf6-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5628'),
	(48, 'a73d0c82-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5632'),
	(49, 'a73d0d04-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5691'),
	(50, 'a73d0d86-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5692'),
	(51, 'a73d0e12-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5693'),
	(52, 'a73d0e94-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5694'),
	(53, 'a73d0f16-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5695'),
	(54, 'a73d0fa2-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5696'),
	(55, 'a73d1024-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5711'),
	(56, 'a73d10b0-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5714'),
	(57, 'a73d1128-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5717'),
	(58, 'a73d11b4-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5718'),
	(59, 'a73d1236-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5722'),
	(60, 'a73d12c2-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5726'),
	(61, 'a73d1344-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5721'),
	(62, 'a73d13da-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5778'),
	(63, 'a73d1466-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5779'),
	(64, 'a73d14f2-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5727'),
	(65, 'a73d1574-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5780'),
	(66, 'a73d1600-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5781'),
	(67, 'a73d1682-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5782'),
	(68, 'a73d170e-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5785'),
	(69, 'a73d1790-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5786'),
	(70, 'a73d181c-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5820'),
	(71, 'a73d18b2-9562-11e8-a067-2cfda16e4afb', 'CRH380BG', '5821'),
	(72, '7bebb560-a5ad-11e8-90a9-2cfda16e4afb', '测试车型', '测试');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
