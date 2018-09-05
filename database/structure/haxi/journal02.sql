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

-- 导出  表 haxi.journal02 结构
CREATE TABLE IF NOT EXISTS `journal02` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `applicant` varchar(20) NOT NULL DEFAULT '' COMMENT '申请人',
  `applicant_phone` varchar(20) NOT NULL DEFAULT '',
  `leader` varchar(20) NOT NULL DEFAULT '' COMMENT '作业负责人',
  `leader_id` int(10) unsigned NOT NULL DEFAULT 0,
  `leader_phone` varchar(20) NOT NULL DEFAULT '',
  `dept` varchar(20) NOT NULL DEFAULT '' COMMENT '部门',
  `group_sn` varchar(20) NOT NULL DEFAULT '',
  `date_begin` date NOT NULL DEFAULT '0001-01-01' COMMENT '日期',
  `time_begin` time NOT NULL DEFAULT '00:00:00' COMMENT '时间',
  `date_end` date NOT NULL DEFAULT '0001-01-01',
  `time_end` time NOT NULL DEFAULT '00:00:00',
  `content` varchar(20) NOT NULL DEFAULT '',
  `content_detail` varchar(50) NOT NULL DEFAULT '',
  `p_yq_xdc` varchar(20) NOT NULL DEFAULT '' COMMENT '蓄电池',
  `p_yq_jcw` varchar(20) NOT NULL DEFAULT '' COMMENT '接触网',
  `p_yq_zydd` varchar(20) NOT NULL DEFAULT '' COMMENT '作业地点',
  `p_yq_qt` varchar(20) NOT NULL DEFAULT '' COMMENT '其它',
  `p_jsy` varchar(20) NOT NULL DEFAULT '' COMMENT '技术员',
  `p_jsy_id` int(11) NOT NULL DEFAULT 0,
  `p_jsy_date` date NOT NULL DEFAULT '1970-01-01',
  `p_jsy_time` time NOT NULL DEFAULT '00:00:00',
  `p_jsy_content` varchar(20) NOT NULL DEFAULT '' COMMENT '技术员选择跟踪形式',
  `p_jsy_bz` varchar(20) NOT NULL DEFAULT '' COMMENT '技术员指定班组',
  `p_jsy_qc` varchar(20) NOT NULL DEFAULT '' COMMENT '技术员指定质检',
  `p_zbsz` varchar(20) NOT NULL DEFAULT '' COMMENT '值班所长',
  `p_zbsz_id` int(11) NOT NULL DEFAULT 0,
  `p_zbsz_date` date NOT NULL DEFAULT '1970-01-01',
  `p_zbsz_time` time NOT NULL DEFAULT '00:00:00',
  `p_dd` varchar(20) NOT NULL DEFAULT '' COMMENT '调度',
  `p_dd_id` int(11) NOT NULL DEFAULT 0,
  `p_dd_date` date NOT NULL DEFAULT '1970-01-01',
  `p_dd_time` time NOT NULL DEFAULT '00:00:00',
  `tag` varchar(50) NOT NULL DEFAULT '' COMMENT '内容',
  `verify_report` varchar(100) NOT NULL DEFAULT '' COMMENT '作业完成情况',
  `verify_leader` varchar(20) NOT NULL DEFAULT '',
  `verify_leader_id` int(10) unsigned NOT NULL DEFAULT 0,
  `verify_leader_date` date DEFAULT NULL,
  `verify_leader_time` time DEFAULT NULL,
  `verify` varchar(20) NOT NULL DEFAULT '' COMMENT '调度员',
  `verify_id` int(10) unsigned NOT NULL DEFAULT 0,
  `verify_date` date DEFAULT NULL,
  `verify_time` time DEFAULT NULL,
  `reject` varchar(50) NOT NULL DEFAULT '' COMMENT '退回',
  `reject_by` varchar(50) NOT NULL DEFAULT '' COMMENT '被__驳回',
  `reject_by_id` int(11) NOT NULL DEFAULT 0,
  `remark` text DEFAULT NULL COMMENT '备注',
  `sign_p_jsy` text DEFAULT NULL,
  `sign_p_jsy_bz` text DEFAULT NULL,
  `sign_p_jsy_qc` text DEFAULT NULL,
  `sign_p_dd` text DEFAULT NULL,
  `sign_p_zbsz` text DEFAULT NULL,
  `sign_verify_leader` text DEFAULT NULL,
  `sign_verify_leader_bz` text DEFAULT NULL,
  `sign_verify_leader_qc` text DEFAULT NULL,
  `sign_verify` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `p_jsy_id` (`p_jsy_id`),
  KEY `p_zbsz_id` (`p_zbsz_id`),
  KEY `p_dd_id` (`p_dd_id`),
  KEY `journal02_verify_leader_id_IDX` (`verify_leader_id`) USING BTREE,
  KEY `journal02_verify_id_IDX` (`verify_id`) USING BTREE,
  KEY `journal02_dept_IDX` (`dept`) USING BTREE,
  KEY `journal02_group_sn_IDX` (`group_sn`) USING BTREE,
  KEY `journal02_date_begin_IDX` (`date_begin`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
