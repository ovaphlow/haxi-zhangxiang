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

-- 导出  表 haxi.schedule_source 结构
CREATE TABLE IF NOT EXISTS `schedule_source` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `counter` bigint(20) unsigned NOT NULL DEFAULT 0,
  `upload_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `file_name` varchar(50) NOT NULL DEFAULT '',
  `p_xh` varchar(10) NOT NULL DEFAULT '' COMMENT '序号',
  `p_psj` varchar(10) NOT NULL DEFAULT '' COMMENT '配属局',
  `p_yys` varchar(10) NOT NULL DEFAULT '' COMMENT '运用所',
  `model` varchar(10) NOT NULL DEFAULT '' COMMENT '车型',
  `train` varchar(10) NOT NULL DEFAULT '' COMMENT '车组号',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `total_mileage` varchar(10) NOT NULL DEFAULT '' COMMENT '总累计走行公里',
  `last_p_gjx` varchar(10) NOT NULL DEFAULT '' COMMENT '上次高级修程',
  `last_date_p_gjx` date NOT NULL DEFAULT '0000-00-00' COMMENT '上次高级修修竣日期',
  `last_total_mileage_p_gjx` varchar(10) NOT NULL DEFAULT '0' COMMENT '上次高级修修竣时走行公里',
  `mileage_after_last_p_gjx` varchar(10) NOT NULL DEFAULT '0' COMMENT '上次高级修程后走行公里',
  `next_p_gjx` varchar(10) NOT NULL DEFAULT '' COMMENT '下次高级修程',
  `next_mileage_p_gjx` varchar(10) NOT NULL DEFAULT '' COMMENT '下次高级修到期走行公里',
  `next_date` date NOT NULL DEFAULT '0000-00-00' COMMENT '到期日期',
  `date_p_sx` date NOT NULL DEFAULT '0000-00-00' COMMENT '失修日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
