/*
Navicat MySQL Data Transfer

Source Server         : mysql_on_server
Source Server Version : 50730
Source Host           : 47.94.249.153:3306
Source Database       : SummerProject

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-07-10 22:12:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_20201172_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201172_content`;
CREATE TABLE `course_20201172_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201172__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201172_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201172_content
-- ----------------------------
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_announcement101', 'announcement', '大学英语课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201172_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201172_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_examination101', 'examination', '大学英语考试', '大学英语第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201172_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_homework101', 'homework', '大学英语第一次作业', '大学英语第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201172_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_homework102', 'homework', '大学英语第二次作业', '大学英语第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201172_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_homework103', 'homework', '大学英语第三次作业', '大学英语第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201172_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_homework104', 'homework', '大学英语第四次作业', '大学英语第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201172_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_content_homework105', 'homework', '大学英语第五次作业', '大学英语第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201172_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '大学英语月考', '大学英语月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201172_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '大学英语周考', '大学英语周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201172_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '大学英语小考', '大学英语小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201172_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201172_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '大学英语期末考试', '大学英语期末考试', null, null, '2020-09-05 00:00:00', '20201172_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201172_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201172_design`;
CREATE TABLE `course_20201172_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201172_design
-- ----------------------------
INSERT INTO `course_20201172_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201172_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201172_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201172_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201172_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201172_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201172_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201172_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201172_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201172_discussion`;
CREATE TABLE `course_20201172_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201172_discussion
-- ----------------------------
INSERT INTO `course_20201172_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201172_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201172_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201172_examination`;
CREATE TABLE `course_20201172_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201172_examination
-- ----------------------------
INSERT INTO `course_20201172_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201172_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201172_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201172_homework`;
CREATE TABLE `course_20201172_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201172_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201172_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201172_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201172_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201172_homework
-- ----------------------------
INSERT INTO `course_20201172_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '123', '11111', '22222', 'no', '2020-07-20 00:00:00');
INSERT INTO `course_20201172_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '123', 'bbbb', 'aaaaa', 'no', '2020-07-20 00:00:00');
INSERT INTO `course_20201172_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '123', 'bbbb', 'aaaaa', 'no', '2020-07-20 00:00:00');
INSERT INTO `course_20201172_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '123', 'bbbb', 'aaaaa', 'no', '2020-07-20 00:00:00');
INSERT INTO `course_20201172_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '123', 'bbbb', 'aaaaa', 'no', '2020-07-20 00:00:00');

-- ----------------------------
-- Table structure for course_20201172_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201172_resource`;
CREATE TABLE `course_20201172_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201172_resource
-- ----------------------------
INSERT INTO `course_20201172_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20201264_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201264_content`;
CREATE TABLE `course_20201264_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201264__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201264_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201264_content
-- ----------------------------
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_announcement101', 'announcement', '计算机科学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201264_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201264_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_examination101', 'examination', '计算机科学考试', '计算机科学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201264_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_homework101', 'homework', '计算机科学第一次作业', '计算机科学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201264_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_homework102', 'homework', '计算机科学第二次作业', '计算机科学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201264_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_homework103', 'homework', '计算机科学第三次作业', '计算机科学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201264_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_homework104', 'homework', '计算机科学第四次作业', '计算机科学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201264_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_content_homework105', 'homework', '计算机科学第五次作业', '计算机科学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201264_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '计算机科学月考', '计算机科学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201264_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '计算机科学周考', '计算机科学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201264_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '计算机科学小考', '计算机科学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201264_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201264_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '计算机科学期末考试', '计算机科学期末考试', null, null, '2020-09-05 00:00:00', '20201264_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201264_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201264_design`;
CREATE TABLE `course_20201264_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201264_design
-- ----------------------------
INSERT INTO `course_20201264_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201264_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201264_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201264_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201264_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201264_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201264_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201264_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201264_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201264_discussion`;
CREATE TABLE `course_20201264_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201264_discussion
-- ----------------------------
INSERT INTO `course_20201264_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201264_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201264_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201264_examination`;
CREATE TABLE `course_20201264_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201264_examination
-- ----------------------------
INSERT INTO `course_20201264_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201264_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201264_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201264_homework`;
CREATE TABLE `course_20201264_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201264_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201264_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201264_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201264_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201264_homework
-- ----------------------------
INSERT INTO `course_20201264_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20201264_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '计算机科学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20201264_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '计算机科学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20201264_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20201264_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20201264_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201264_resource`;
CREATE TABLE `course_20201264_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201264_resource
-- ----------------------------
INSERT INTO `course_20201264_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20201316_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201316_content`;
CREATE TABLE `course_20201316_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201316__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201316_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201316_content
-- ----------------------------
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_announcement101', 'announcement', '计算机科学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201316_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201316_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_examination101', 'examination', '计算机科学考试', '计算机科学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201316_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_homework101', 'homework', '计算机科学第一次作业', '计算机科学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201316_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_homework102', 'homework', '计算机科学第二次作业', '计算机科学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201316_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_homework103', 'homework', '计算机科学第三次作业', '计算机科学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201316_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_homework104', 'homework', '计算机科学第四次作业', '计算机科学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201316_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_content_homework105', 'homework', '计算机科学第五次作业', '计算机科学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201316_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '计算机科学月考', '计算机科学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201316_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '计算机科学周考', '计算机科学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201316_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '计算机科学小考', '计算机科学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201316_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201316_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '计算机科学期末考试', '计算机科学期末考试', null, null, '2020-09-05 00:00:00', '20201316_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201316_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201316_design`;
CREATE TABLE `course_20201316_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201316_design
-- ----------------------------
INSERT INTO `course_20201316_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201316_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201316_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201316_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201316_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201316_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201316_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201316_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201316_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201316_discussion`;
CREATE TABLE `course_20201316_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201316_discussion
-- ----------------------------
INSERT INTO `course_20201316_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201316_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201316_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201316_examination`;
CREATE TABLE `course_20201316_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201316_examination
-- ----------------------------
INSERT INTO `course_20201316_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201316_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201316_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201316_homework`;
CREATE TABLE `course_20201316_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201316_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201316_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201316_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201316_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201316_homework
-- ----------------------------
INSERT INTO `course_20201316_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20201316_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '计算机科学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20201316_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '计算机科学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20201316_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20201316_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20201316_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201316_resource`;
CREATE TABLE `course_20201316_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201316_resource
-- ----------------------------
INSERT INTO `course_20201316_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20201322_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201322_content`;
CREATE TABLE `course_20201322_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201322__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201322_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201322_content
-- ----------------------------
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_announcement101', 'announcement', '计算机科学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201322_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201322_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_examination101', 'examination', '计算机科学考试', '计算机科学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201322_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_homework101', 'homework', '计算机科学第一次作业', '计算机科学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201322_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_homework102', 'homework', '计算机科学第二次作业', '计算机科学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201322_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_homework103', 'homework', '计算机科学第三次作业', '计算机科学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201322_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_homework104', 'homework', '计算机科学第四次作业', '计算机科学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201322_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_content_homework105', 'homework', '计算机科学第五次作业', '计算机科学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201322_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '计算机科学月考', '计算机科学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201322_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '计算机科学周考', '计算机科学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201322_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '计算机科学小考', '计算机科学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201322_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201322_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '计算机科学期末考试', '计算机科学期末考试', null, null, '2020-09-05 00:00:00', '20201322_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201322_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201322_design`;
CREATE TABLE `course_20201322_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201322_design
-- ----------------------------
INSERT INTO `course_20201322_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201322_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201322_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201322_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201322_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201322_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201322_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201322_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201322_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201322_discussion`;
CREATE TABLE `course_20201322_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201322_discussion
-- ----------------------------
INSERT INTO `course_20201322_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201322_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201322_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201322_examination`;
CREATE TABLE `course_20201322_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201322_examination
-- ----------------------------
INSERT INTO `course_20201322_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201322_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201322_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201322_homework`;
CREATE TABLE `course_20201322_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201322_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201322_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201322_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201322_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201322_homework
-- ----------------------------
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '计算机科学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '计算机科学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework101', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework102', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework103', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework104', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_20201322_homework` VALUES ('tch20200101_content_homework105', 'stu20200306', null, null, null, 'yes', null);

-- ----------------------------
-- Table structure for course_20201322_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201322_resource`;
CREATE TABLE `course_20201322_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201322_resource
-- ----------------------------
INSERT INTO `course_20201322_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20201417_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201417_content`;
CREATE TABLE `course_20201417_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201417__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201417_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201417_content
-- ----------------------------
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_announcement101', 'announcement', '中外文学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201417_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201417_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_examination101', 'examination', '中外文学考试', '中外文学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201417_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_homework101', 'homework', '中外文学第一次作业', '中外文学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201417_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_homework102', 'homework', '中外文学第二次作业', '中外文学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201417_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_homework103', 'homework', '中外文学第三次作业', '中外文学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201417_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_homework104', 'homework', '中外文学第四次作业', '中外文学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201417_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_content_homework105', 'homework', '中外文学第五次作业', '中外文学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201417_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '中外文学月考', '中外文学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201417_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '中外文学周考', '中外文学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201417_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '中外文学小考', '中外文学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201417_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201417_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '中外文学期末考试', '中外文学期末考试', null, null, '2020-09-05 00:00:00', '20201417_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201417_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201417_design`;
CREATE TABLE `course_20201417_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201417_design
-- ----------------------------
INSERT INTO `course_20201417_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201417_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201417_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201417_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201417_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201417_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201417_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201417_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201417_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201417_discussion`;
CREATE TABLE `course_20201417_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201417_discussion
-- ----------------------------
INSERT INTO `course_20201417_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201417_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201417_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201417_examination`;
CREATE TABLE `course_20201417_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201417_examination
-- ----------------------------
INSERT INTO `course_20201417_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201417_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201417_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201417_homework`;
CREATE TABLE `course_20201417_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201417_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201417_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201417_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201417_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201417_homework
-- ----------------------------
INSERT INTO `course_20201417_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '中外文学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20201417_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '中外文学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20201417_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '中外文学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20201417_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '中外文学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20201417_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '中外文学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20201417_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201417_resource`;
CREATE TABLE `course_20201417_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201417_resource
-- ----------------------------
INSERT INTO `course_20201417_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20201506_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201506_content`;
CREATE TABLE `course_20201506_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201506__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201506_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201506_content
-- ----------------------------
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_announcement101', 'announcement', '中国诗词课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201506_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201506_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_examination101', 'examination', '中国诗词考试', '中国诗词第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201506_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_homework101', 'homework', '中国诗词第一次作业', '中国诗词第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201506_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_homework102', 'homework', '中国诗词第二次作业', '中国诗词第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201506_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_homework103', 'homework', '中国诗词第三次作业', '中国诗词第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201506_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_homework104', 'homework', '中国诗词第四次作业', '中国诗词第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201506_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_content_homework105', 'homework', '中国诗词第五次作业', '中国诗词第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201506_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '中国诗词月考', '中国诗词月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201506_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '中国诗词周考', '中国诗词周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201506_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '中国诗词小考', '中国诗词小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201506_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201506_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '中国诗词期末考试', '中国诗词期末考试', null, null, '2020-09-05 00:00:00', '20201506_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201506_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201506_design`;
CREATE TABLE `course_20201506_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201506_design
-- ----------------------------
INSERT INTO `course_20201506_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201506_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201506_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201506_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201506_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201506_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201506_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201506_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201506_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201506_discussion`;
CREATE TABLE `course_20201506_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201506_discussion
-- ----------------------------
INSERT INTO `course_20201506_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201506_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201506_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201506_examination`;
CREATE TABLE `course_20201506_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201506_examination
-- ----------------------------
INSERT INTO `course_20201506_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201506_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201506_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201506_homework`;
CREATE TABLE `course_20201506_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201506_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201506_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201506_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201506_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201506_homework
-- ----------------------------
INSERT INTO `course_20201506_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '中国诗词第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20201506_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '中国诗词第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20201506_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '中国诗词第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20201506_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '中国诗词第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20201506_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '中国诗词第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20201506_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201506_resource`;
CREATE TABLE `course_20201506_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201506_resource
-- ----------------------------
INSERT INTO `course_20201506_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20201508_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20201508_content`;
CREATE TABLE `course_20201508_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20201508__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20201508_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201508_content
-- ----------------------------
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_announcement101', 'announcement', '机器学习课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20201508_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20201508_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_examination101', 'examination', '机器学习考试', '机器学习第一周考试', null, 'Null', '2020-07-16 00:00:00', '20201508_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_homework101', 'homework', '机器学习第一次作业', '机器学习第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20201508_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_homework102', 'homework', '机器学习第二次作业', '机器学习第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20201508_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_homework103', 'homework', '机器学习第三次作业', '机器学习第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20201508_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_homework104', 'homework', '机器学习第四次作业', '机器学习第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20201508_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_content_homework105', 'homework', '机器学习第五次作业', '机器学习第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20201508_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '机器学习月考', '机器学习月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20201508_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '机器学习周考', '机器学习周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20201508_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '机器学习小考', '机器学习小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20201508_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20201508_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '机器学习期末考试', '机器学习期末考试', null, null, '2020-09-05 00:00:00', '20201508_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20201508_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20201508_design`;
CREATE TABLE `course_20201508_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201508_design
-- ----------------------------
INSERT INTO `course_20201508_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20201508_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20201508_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20201508_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20201508_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20201508_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20201508_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20201508_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20201508_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20201508_discussion`;
CREATE TABLE `course_20201508_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201508_discussion
-- ----------------------------
INSERT INTO `course_20201508_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20201508_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20201508_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20201508_examination`;
CREATE TABLE `course_20201508_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201508_examination
-- ----------------------------
INSERT INTO `course_20201508_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20201508_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20201508_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20201508_homework`;
CREATE TABLE `course_20201508_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20201508_homework_id_fk` (`homework_id`),
  CONSTRAINT `20201508_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20201508_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20201508_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201508_homework
-- ----------------------------
INSERT INTO `course_20201508_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '机器学习第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20201508_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '机器学习第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20201508_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '机器学习第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20201508_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '机器学习第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20201508_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '机器学习第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20201508_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20201508_resource`;
CREATE TABLE `course_20201508_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20201508_resource
-- ----------------------------
INSERT INTO `course_20201508_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202672_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202672_content`;
CREATE TABLE `course_20202672_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202672__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202672_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202672_content
-- ----------------------------
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_announcement101', 'announcement', '音乐艺术课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202672_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202672_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_examination101', 'examination', '音乐艺术考试', '音乐艺术第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202672_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_homework101', 'homework', '音乐艺术第一次作业', '音乐艺术第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202672_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_homework102', 'homework', '音乐艺术第二次作业', '音乐艺术第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202672_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_homework103', 'homework', '音乐艺术第三次作业', '音乐艺术第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202672_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_homework104', 'homework', '音乐艺术第四次作业', '音乐艺术第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202672_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_content_homework105', 'homework', '音乐艺术第五次作业', '音乐艺术第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202672_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '音乐艺术月考', '音乐艺术月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202672_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '音乐艺术周考', '音乐艺术周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202672_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '音乐艺术小考', '音乐艺术小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202672_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202672_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '音乐艺术期末考试', '音乐艺术期末考试', null, null, '2020-09-05 00:00:00', '20202672_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202672_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202672_design`;
CREATE TABLE `course_20202672_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202672_design
-- ----------------------------
INSERT INTO `course_20202672_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202672_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202672_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202672_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202672_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202672_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202672_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202672_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202672_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202672_discussion`;
CREATE TABLE `course_20202672_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202672_discussion
-- ----------------------------
INSERT INTO `course_20202672_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202672_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202672_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202672_examination`;
CREATE TABLE `course_20202672_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202672_examination
-- ----------------------------
INSERT INTO `course_20202672_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202672_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202672_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202672_homework`;
CREATE TABLE `course_20202672_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202672_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202672_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202672_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202672_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202672_homework
-- ----------------------------
INSERT INTO `course_20202672_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '音乐艺术第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202672_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '音乐艺术第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202672_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '音乐艺术第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202672_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '音乐艺术第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202672_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '音乐艺术第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202672_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202672_resource`;
CREATE TABLE `course_20202672_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202672_resource
-- ----------------------------
INSERT INTO `course_20202672_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202728_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202728_content`;
CREATE TABLE `course_20202728_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202728__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202728_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202728_content
-- ----------------------------
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_announcement101', 'announcement', '算法设计与分析课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202728_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202728_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_examination101', 'examination', '算法设计与分析考试', '算法设计与分析第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202728_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_homework101', 'homework', '算法设计与分析第一次作业', '算法设计与分析第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202728_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_homework102', 'homework', '算法设计与分析第二次作业', '算法设计与分析第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202728_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_homework103', 'homework', '算法设计与分析第三次作业', '算法设计与分析第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202728_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_homework104', 'homework', '算法设计与分析第四次作业', '算法设计与分析第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202728_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_content_homework105', 'homework', '算法设计与分析第五次作业', '算法设计与分析第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202728_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '算法设计与分析月考', '算法设计与分析月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202728_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '算法设计与分析周考', '算法设计与分析周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202728_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '算法设计与分析小考', '算法设计与分析小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202728_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202728_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '算法设计与分析期末考试', '算法设计与分析期末考试', null, null, '2020-09-05 00:00:00', '20202728_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202728_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202728_design`;
CREATE TABLE `course_20202728_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202728_design
-- ----------------------------
INSERT INTO `course_20202728_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202728_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202728_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202728_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202728_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202728_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202728_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202728_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202728_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202728_discussion`;
CREATE TABLE `course_20202728_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202728_discussion
-- ----------------------------
INSERT INTO `course_20202728_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202728_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202728_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202728_examination`;
CREATE TABLE `course_20202728_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202728_examination
-- ----------------------------
INSERT INTO `course_20202728_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202728_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202728_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202728_homework`;
CREATE TABLE `course_20202728_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202728_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202728_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202728_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202728_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202728_homework
-- ----------------------------
INSERT INTO `course_20202728_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '算法设计与分析第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202728_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '算法设计与分析第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202728_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '算法设计与分析第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202728_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '算法设计与分析第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202728_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '算法设计与分析第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202728_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202728_resource`;
CREATE TABLE `course_20202728_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202728_resource
-- ----------------------------
INSERT INTO `course_20202728_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202748_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202748_content`;
CREATE TABLE `course_20202748_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202748__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202748_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202748_content
-- ----------------------------
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_announcement101', 'announcement', '外国文学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202748_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202748_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_examination101', 'examination', '外国文学考试', '外国文学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202748_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_homework101', 'homework', '外国文学第一次作业', '外国文学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202748_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_homework102', 'homework', '外国文学第二次作业', '外国文学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202748_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_homework103', 'homework', '外国文学第三次作业', '外国文学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202748_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_homework104', 'homework', '外国文学第四次作业', '外国文学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202748_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_content_homework105', 'homework', '外国文学第五次作业', '外国文学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202748_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '外国文学月考', '外国文学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202748_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '外国文学周考', '外国文学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202748_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '外国文学小考', '外国文学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202748_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202748_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '外国文学期末考试', '外国文学期末考试', null, null, '2020-09-05 00:00:00', '20202748_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202748_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202748_design`;
CREATE TABLE `course_20202748_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202748_design
-- ----------------------------
INSERT INTO `course_20202748_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202748_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202748_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202748_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202748_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202748_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202748_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202748_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202748_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202748_discussion`;
CREATE TABLE `course_20202748_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202748_discussion
-- ----------------------------
INSERT INTO `course_20202748_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202748_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202748_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202748_examination`;
CREATE TABLE `course_20202748_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202748_examination
-- ----------------------------
INSERT INTO `course_20202748_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202748_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202748_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202748_homework`;
CREATE TABLE `course_20202748_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202748_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202748_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202748_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202748_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202748_homework
-- ----------------------------
INSERT INTO `course_20202748_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '外国文学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202748_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '外国文学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202748_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '外国文学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202748_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '外国文学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202748_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '外国文学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202748_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202748_resource`;
CREATE TABLE `course_20202748_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202748_resource
-- ----------------------------
INSERT INTO `course_20202748_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202832_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202832_content`;
CREATE TABLE `course_20202832_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202832__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202832_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202832_content
-- ----------------------------
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_announcement101', 'announcement', '计算机科学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202832_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202832_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_examination101', 'examination', '计算机科学考试', '计算机科学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202832_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_homework101', 'homework', '计算机科学第一次作业', '计算机科学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202832_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_homework102', 'homework', '计算机科学第二次作业', '计算机科学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202832_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_homework103', 'homework', '计算机科学第三次作业', '计算机科学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202832_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_homework104', 'homework', '计算机科学第四次作业', '计算机科学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202832_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_content_homework105', 'homework', '计算机科学第五次作业', '计算机科学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202832_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '计算机科学月考', '计算机科学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202832_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '计算机科学周考', '计算机科学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202832_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '计算机科学小考', '计算机科学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202832_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202832_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '计算机科学期末考试', '计算机科学期末考试', null, null, '2020-09-05 00:00:00', '20202832_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202832_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202832_design`;
CREATE TABLE `course_20202832_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202832_design
-- ----------------------------
INSERT INTO `course_20202832_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202832_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202832_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202832_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202832_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202832_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202832_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202832_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202832_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202832_discussion`;
CREATE TABLE `course_20202832_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202832_discussion
-- ----------------------------
INSERT INTO `course_20202832_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202832_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202832_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202832_examination`;
CREATE TABLE `course_20202832_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202832_examination
-- ----------------------------
INSERT INTO `course_20202832_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202832_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202832_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202832_homework`;
CREATE TABLE `course_20202832_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202832_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202832_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202832_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202832_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202832_homework
-- ----------------------------
INSERT INTO `course_20202832_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202832_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '计算机科学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202832_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '计算机科学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202832_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202832_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '计算机科学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202832_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202832_resource`;
CREATE TABLE `course_20202832_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202832_resource
-- ----------------------------
INSERT INTO `course_20202832_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202833_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202833_content`;
CREATE TABLE `course_20202833_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202833__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202833_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202833_content
-- ----------------------------
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_announcement101', 'announcement', '体育课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202833_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202833_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_examination101', 'examination', '体育考试', '体育第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202833_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_homework101', 'homework', '体育第一次作业', '体育第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202833_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_homework102', 'homework', '体育第二次作业', '体育第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202833_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_homework103', 'homework', '体育第三次作业', '体育第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202833_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_homework104', 'homework', '体育第四次作业', '体育第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202833_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_content_homework105', 'homework', '体育第五次作业', '体育第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202833_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '体育月考', '体育月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202833_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '体育周考', '体育周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202833_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '体育小考', '体育小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202833_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202833_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '体育期末考试', '体育期末考试', null, null, '2020-09-05 00:00:00', '20202833_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202833_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202833_design`;
CREATE TABLE `course_20202833_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202833_design
-- ----------------------------
INSERT INTO `course_20202833_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202833_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202833_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202833_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202833_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202833_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202833_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202833_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202833_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202833_discussion`;
CREATE TABLE `course_20202833_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202833_discussion
-- ----------------------------
INSERT INTO `course_20202833_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202833_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202833_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202833_examination`;
CREATE TABLE `course_20202833_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202833_examination
-- ----------------------------
INSERT INTO `course_20202833_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202833_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202833_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202833_homework`;
CREATE TABLE `course_20202833_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202833_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202833_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202833_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202833_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202833_homework
-- ----------------------------
INSERT INTO `course_20202833_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '体育第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202833_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '体育第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202833_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '体育第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202833_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '体育第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202833_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '体育第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202833_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202833_resource`;
CREATE TABLE `course_20202833_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202833_resource
-- ----------------------------
INSERT INTO `course_20202833_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202904_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202904_content`;
CREATE TABLE `course_20202904_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202904__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202904_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202904_content
-- ----------------------------
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_announcement101', 'announcement', '面向对象编程技术课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202904_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202904_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_examination101', 'examination', '面向对象编程技术考试', '面向对象编程技术第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202904_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_homework101', 'homework', '面向对象编程技术第一次作业', '面向对象编程技术第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202904_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_homework102', 'homework', '面向对象编程技术第二次作业', '面向对象编程技术第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202904_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_homework103', 'homework', '面向对象编程技术第三次作业', '面向对象编程技术第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202904_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_homework104', 'homework', '面向对象编程技术第四次作业', '面向对象编程技术第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202904_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_content_homework105', 'homework', '面向对象编程技术第五次作业', '面向对象编程技术第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202904_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '面向对象编程技术月考', '面向对象编程技术月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202904_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '面向对象编程技术周考', '面向对象编程技术周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202904_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '面向对象编程技术小考', '面向对象编程技术小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202904_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202904_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '面向对象编程技术期末考试', '面向对象编程技术期末考试', null, null, '2020-09-05 00:00:00', '20202904_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202904_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202904_design`;
CREATE TABLE `course_20202904_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202904_design
-- ----------------------------
INSERT INTO `course_20202904_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202904_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202904_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202904_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202904_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202904_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202904_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202904_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202904_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202904_discussion`;
CREATE TABLE `course_20202904_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202904_discussion
-- ----------------------------
INSERT INTO `course_20202904_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202904_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202904_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202904_examination`;
CREATE TABLE `course_20202904_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202904_examination
-- ----------------------------
INSERT INTO `course_20202904_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202904_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202904_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202904_homework`;
CREATE TABLE `course_20202904_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202904_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202904_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202904_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202904_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202904_homework
-- ----------------------------
INSERT INTO `course_20202904_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '面向对象编程技术第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202904_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '面向对象编程技术第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202904_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '面向对象编程技术第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202904_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '面向对象编程技术第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202904_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '面向对象编程技术第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202904_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202904_resource`;
CREATE TABLE `course_20202904_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202904_resource
-- ----------------------------
INSERT INTO `course_20202904_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_20202941_content
-- ----------------------------
DROP TABLE IF EXISTS `course_20202941_content`;
CREATE TABLE `course_20202941_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_20202941__to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_20202941_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202941_content
-- ----------------------------
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_announcement101', 'announcement', '离散数学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', '20202941_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_discussion101', 'discussion', 'testchat', 'fffffffdfdfsdf', null, 'null', '2020-07-15 00:00:00', '20202941_chat', 'discussion', '2020-07-01 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_examination101', 'examination', '离散数学考试', '离散数学第一周考试', null, 'Null', '2020-07-16 00:00:00', '20202941_examination', 'examination', '2020-07-02 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_homework101', 'homework', '离散数学第一次作业', '离散数学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-16 00:00:00', '20202941_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_homework102', 'homework', '离散数学第二次作业', '离散数学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-21 00:00:00', '20202941_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_homework103', 'homework', '离散数学第三次作业', '离散数学第三次作业，请同学们查收', null, null, '2020-07-30 00:00:00', '20202941_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_homework104', 'homework', '离散数学第四次作业', '离散数学第四次作业，请同学们按时完成', null, null, '2020-08-02 00:00:00', '20202941_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_content_homework105', 'homework', '离散数学第五次作业', '离散数学第五次作业，请同学们认真完成', null, null, '2020-08-21 00:00:00', '20202941_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '离散数学月考', '离散数学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', '20202941_dsg101', 'dsg101', '2020-07-14 04:07:25');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '离散数学周考', '离散数学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', '20202941_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '离散数学小考', '离散数学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', '20202941_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_20202941_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '离散数学期末考试', '离散数学期末考试', null, null, '2020-09-05 00:00:00', '20202941_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_20202941_design
-- ----------------------------
DROP TABLE IF EXISTS `course_20202941_design`;
CREATE TABLE `course_20202941_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202941_design
-- ----------------------------
INSERT INTO `course_20202941_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_20202941_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_20202941_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_20202941_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_20202941_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_20202941_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_20202941_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_20202941_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_20202941_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_20202941_discussion`;
CREATE TABLE `course_20202941_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202941_discussion
-- ----------------------------
INSERT INTO `course_20202941_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_20202941_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_20202941_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_20202941_examination`;
CREATE TABLE `course_20202941_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202941_examination
-- ----------------------------
INSERT INTO `course_20202941_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_20202941_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_20202941_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_20202941_homework`;
CREATE TABLE `course_20202941_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `20202941_homework_id_fk` (`homework_id`),
  CONSTRAINT `20202941_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_20202941_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `20202941_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202941_homework
-- ----------------------------
INSERT INTO `course_20202941_homework` VALUES ('tch20200101_content_homework101', 'stu20200101', '离散数学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:42:41');
INSERT INTO `course_20202941_homework` VALUES ('tch20200101_content_homework101', 'stu20200102', '离散数学第二次作业', 'null', 'null', 'yes', '2020-02-02 21:13:00');
INSERT INTO `course_20202941_homework` VALUES ('tch20200101_content_homework101', 'stu20200201', '离散数学第三次作业', 'null', 'null', 'yes', '2020-01-02 21:13:00');
INSERT INTO `course_20202941_homework` VALUES ('tch20200101_content_homework101', 'stu20200203', '离散数学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-07 16:43:16');
INSERT INTO `course_20202941_homework` VALUES ('tch20200101_content_homework101', 'stu20200204', '离散数学第一次作业', 'path1;path2;', 'name1;name2;', 'no', '2020-07-08 10:01:02');

-- ----------------------------
-- Table structure for course_20202941_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_20202941_resource`;
CREATE TABLE `course_20202941_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_20202941_resource
-- ----------------------------
INSERT INTO `course_20202941_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for course_demo001_content
-- ----------------------------
DROP TABLE IF EXISTS `course_demo001_content`;
CREATE TABLE `course_demo001_content` (
  `issue_id` char(40) NOT NULL,
  `issue_type` char(40) NOT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_content` text,
  `issue_attachment_name` text,
  `issue_attachment_path` text,
  `issue_deadline` datetime DEFAULT NULL,
  `issue_table` char(40) DEFAULT NULL,
  `issue_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `content_to_design` (`issue_belong`),
  CONSTRAINT `content_to_design` FOREIGN KEY (`issue_belong`) REFERENCES `course_demo001_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_demo001_content
-- ----------------------------
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_announcement101', 'announcement', '计算机科学课程第一周公告', '第一周我们将学习计算机发展历史', null, 'null', '2020-07-31 00:00:00', 'demo001_announcement', 'announcement', '2020-07-01 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_announcement102', 'announcement', '计算机科学课程第二周公告', '第二周的课堂ppt已经上传至思源课堂，请大家自行预习', null, null, '2020-07-31 00:00:00', 'demo001_announcement', 'announcement', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_announcement103', 'announcement', '计算机科学课程第三周公告', '第三周课程难度将会有明显提升，建议大家看ppt提前预习', null, null, '2020-07-31 00:00:00', 'demo001_announcement', 'announcement', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_announcement104', 'announcement', '计算机科学课程第四周公告', '第四周的课程是考试重点，我们将会安排两次答疑，时间为本周二下午两点在学院机房', null, null, '2020-07-31 00:00:00', 'demo001_announcement', 'announcement', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_announcement105', 'announcement', '计算机科学课程第五周公告', '第五周的ppt已上传至思源课堂，建议大家提前下载预习。', null, null, '2020-07-31 00:00:00', 'demo001_announcement', 'announcement', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_discussion101', 'discussion', '第一周讨论', '第一周讨论内容', null, 'null', '2020-07-01 00:00:00', 'demo001_chat', 'discussion', '2020-06-21 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_examination101', 'examination', '计算机科学考试', '计算机科学第一周考试', null, 'Null', '2020-07-08 00:00:00', 'demo001_examination', 'examination', '2020-06-22 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework101', 'homework', '计算机科学第一次作业', '计算机科学第一次作业', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-01 00:00:00', 'demo001_homework', 'homework', '2020-06-22 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework102', 'homework', '计算机科学第二次作业', '计算机科学第二次作业，请同学们查收', 'name_1;name_2;', 'file_id1;file_id2;', '2020-07-03 00:00:00', 'demo001_homework', 'homework', '2020-07-02 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework103', 'homework', '计算机科学第三次作业', '计算机科学第三次作业，请同学们查收', null, null, '2020-07-07 00:00:00', 'demo001_homework', 'homework', '2020-07-15 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework104', 'homework', '计算机科学第四次作业', '计算机科学第四次作业，请同学们按时完成', null, null, '2020-07-10 00:00:00', 'demo001_homework', 'homework', '2020-07-20 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework105', 'homework', '计算机科学第五次作业', '计算机科学第五次作业，请同学们认真完成', null, null, '2020-07-11 00:00:00', 'demo001_homework', 'homework', '2020-08-02 00:00:00');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework106', 'homework', '计算机科学第六次作业', '计算机科学第六次作业，请同学们认真完成', null, null, '2020-07-13 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework107', 'homework', '计算机科学第七次作业', '计算机科学第七次作业，请同学们按时完成', null, null, '2020-07-13 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework108', 'homework', '计算机科学第八次作业', '计算机科学第八次作业，请同学们查收', null, null, '2020-07-15 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework109', 'homework', '计算机科学第九次作业', '计算机科学第九次作业，请同学们查收', null, null, '2020-07-17 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework110', 'homework', '计算机科学第十次作业', '计算机科学第十次作业，请同学们查收', null, null, '2020-07-19 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework111', 'homework', '计算机科学第十一次作业', '计算机科学第十一次作业，请同学们查收', null, null, '2020-07-21 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework112', 'homework', '计算机科学第十二次作业', '计算机科学第十二次作业，请同学们查收', null, null, '2020-07-22 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework113', 'homework', '计算机科学第十三次作业', '计算机科学第十三次作业，请同学们查收', null, null, '2020-07-23 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework114', 'homework', '计算机科学第十四次作业', '计算机科学第十四次作业，请同学们查收', null, null, '2020-07-24 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_content_homework115', 'homework', '计算机科学第十五次作业', '计算机科学第十五次作业，请同学们查收', null, null, '2020-07-25 00:00:00', 'demo001_homework', 'homework', '2020-08-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_dsg001_examination101', 'examination', '计算机科学月考', '计算机科学月考', 'name_3;', 'file_id3;', '2020-07-22 04:07:04', 'demo001_dsg101', 'dsg101                                                                                                                                                                                                                                                         ', '2020-07-14 04:07:25');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_dsg001_examination102', 'examination', '计算机科学周考', '计算机科学周考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-05 00:00:00', 'demo001_examination', 'examination', '2020-07-08 10:59:31');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_dsg001_examination103', 'examination', '计算机科学小考', '计算机科学小考', 'name_1;name_2;', 'file_id1;file_id2;', '2020-08-25 00:00:00', 'demo001_examination', 'examination', '2020-07-08 11:03:14');
INSERT INTO `course_demo001_content` VALUES ('tch20200101_dsg001_examination104', 'examination', '计算机科学期末考试', '计算机科学期末考试', null, null, '2020-09-05 00:00:00', 'demo001_examination', 'examination', '2020-08-08 11:03:14');

-- ----------------------------
-- Table structure for course_demo001_design
-- ----------------------------
DROP TABLE IF EXISTS `course_demo001_design`;
CREATE TABLE `course_demo001_design` (
  `design_id` char(255) NOT NULL,
  `design_name` char(255) DEFAULT NULL,
  `design_table` char(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_demo001_design
-- ----------------------------
INSERT INTO `course_demo001_design` VALUES ('announcement', 'announcement', 'null', '2020-07-08 08:31:16');
INSERT INTO `course_demo001_design` VALUES ('discussion', 'discussion', 'course_demo_discusstion', '2020-07-08 08:28:37');
INSERT INTO `course_demo001_design` VALUES ('dsg101', '第一周内容', 'course_demo_dsn101', '2020-07-02 04:01:34');
INSERT INTO `course_demo001_design` VALUES ('dsg102', '第二周内容', 'course_demo_dsn102', '2020-07-14 11:47:54');
INSERT INTO `course_demo001_design` VALUES ('dsg103', '第三周内容', null, '2020-07-08 20:27:48');
INSERT INTO `course_demo001_design` VALUES ('examination', 'examination', 'course_demo_examination', '2020-07-08 08:28:34');
INSERT INTO `course_demo001_design` VALUES ('homework', 'homework', 'course_demo_homework', '2020-07-08 08:28:28');
INSERT INTO `course_demo001_design` VALUES ('resource', 'resource', 'course_demo_resource', '2020-07-08 08:28:31');

-- ----------------------------
-- Table structure for course_demo001_discussion
-- ----------------------------
DROP TABLE IF EXISTS `course_demo001_discussion`;
CREATE TABLE `course_demo001_discussion` (
  `discussion_id` char(255) NOT NULL,
  `response_id` char(255) NOT NULL,
  `student_id` char(40) NOT NULL,
  `theme` char(40) DEFAULT NULL,
  `parent_discussion_id` char(255) DEFAULT NULL,
  `content` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`discussion_id`,`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_demo001_discussion
-- ----------------------------
INSERT INTO `course_demo001_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp001', 'stu20200101', 'ddfasdf', 'null', 'dfsfaasfdsf', '2020-07-02 00:00:00');
INSERT INTO `course_demo001_discussion` VALUES ('tch20200101_content_chat001', 'stu20200101rsp002', 'stu20200101', 'dfsf', 'stu20200101rsp001', 'dfjksfjdk', '2020-07-02 00:00:00');

-- ----------------------------
-- Table structure for course_demo001_examination
-- ----------------------------
DROP TABLE IF EXISTS `course_demo001_examination`;
CREATE TABLE `course_demo001_examination` (
  `student_id` char(40) NOT NULL,
  `exam_id` char(40) NOT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `content_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_demo001_examination
-- ----------------------------
INSERT INTO `course_demo001_examination` VALUES ('stu20200101', 'tch20200101_content_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_content_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');
INSERT INTO `course_demo001_examination` VALUES ('stu20200101', 'tch20200101_dsg001_exam001', '2020-07-02 03:07:22', '/webfiles/courses/demo/tch20200101_dsg001_exam001/submitted/stu20200101/', '2020-07-02 03:08:26');

-- ----------------------------
-- Table structure for course_demo001_homework
-- ----------------------------
DROP TABLE IF EXISTS `course_demo001_homework`;
CREATE TABLE `course_demo001_homework` (
  `homework_id` char(40) NOT NULL,
  `student_id` char(40) NOT NULL,
  `content` text,
  `homework_file_path` text,
  `homework_file_name` text,
  `is_draft` char(40) DEFAULT 'yes',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`homework_id`),
  KEY `demo001_homework_id_fk` (`homework_id`),
  CONSTRAINT `demo001_homework_id_fk` FOREIGN KEY (`homework_id`) REFERENCES `course_demo001_content` (`issue_id`) ON UPDATE CASCADE,
  CONSTRAINT `demo001_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_demo001_homework
-- ----------------------------
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework101', 'stu20200306', '不会做', '/homework/ca3687a82e59416b9efb3acda64c959c_一寸免冠照.JPG', '一寸免冠照.JPG', 'no', '2020-07-10 00:00:00');
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework102', 'stu20200306', '我是傻逼', '/homework/7de2299e8b994931a6c544bc64b0d14a_一寸免冠照.JPG', '一寸免冠照.JPG', 'no', '2020-07-10 00:00:00');
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework103', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework104', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework105', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework106', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework107', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework108', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework109', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework110', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework111', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework112', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework113', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework114', 'stu20200306', null, null, null, 'yes', null);
INSERT INTO `course_demo001_homework` VALUES ('tch20200101_content_homework115', 'stu20200306', null, null, null, 'yes', null);

-- ----------------------------
-- Table structure for course_demo001_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_demo001_resource`;
CREATE TABLE `course_demo001_resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_belong` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_demo001_resource
-- ----------------------------
INSERT INTO `course_demo001_resource` VALUES ('resourse_101', 'pdf', 'file.pdf', '/resources/', 'resources', '2020-07-07 23:05:52');

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `course_id` char(40) NOT NULL,
  `course_name` char(40) DEFAULT NULL,
  `course_hierarchy` int(40) DEFAULT NULL,
  `course_semester` char(40) DEFAULT NULL,
  `course_design_table` text,
  `course_content_table` text,
  `course_homework_table` text,
  `course_examination_table` text,
  `course_resource_table` text,
  `course_college` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('20201172', 'English', '2020', 'spring', 'course_20201172_design', 'course_20201172_content', 'course_20201172_homework', null, null, '软件学院', '2020-08-11 19:07:14');
INSERT INTO `courses` VALUES ('20201264', 'Linear algebra', '2020', 'spring', 'course_20201264_design', 'course_20201264_content', 'course_20201264_homework', null, null, '电信学院', '2020-07-25 09:30:05');
INSERT INTO `courses` VALUES ('20201316', 'The data structure', '2018', 'spring', 'course_20201316_design', 'course_20201316_content', 'course_20201316_homework', null, null, '能动学院', '2020-07-22 00:00:00');
INSERT INTO `courses` VALUES ('20201322', 'University physics', '2017', 'spring', 'course_20201322_design', 'course_20201322_content', 'course_20201322_homework', 'course_20201322_examination', 'course_20201322_resource', '数学学院', '2020-07-29 03:02:56');
INSERT INTO `courses` VALUES ('20201417', 'Chinese and Foreign Literature', '2018', 'spring', 'course_20201417_design', 'course_20201417_content', 'course_20201417_homework', null, null, '数学学院', '2020-08-06 23:51:09');
INSERT INTO `courses` VALUES ('20201506', 'Chinese poetry', '2017', 'spring', 'course_20201506_design', 'course_20201506_content', 'course_20201506_homework', null, null, '数学学院', '2020-07-17 14:46:27');
INSERT INTO `courses` VALUES ('20201508', 'Machine learning', '2019', 'spring', 'course_20201508_design', 'course_20201508_content', 'course_20201508_homework', null, null, '数学学院', '2020-07-20 07:28:44');
INSERT INTO `courses` VALUES ('20202672', 'Music', '2020', 'fall', 'course_20202672_design', 'course_20202672_content', 'course_20202672_homework', null, null, '历史学院', '2020-08-11 19:07:14');
INSERT INTO `courses` VALUES ('20202728', 'Algorithm design and analysis', '2019', 'fall', 'course_20202728_design', 'course_20202728_content', 'course_20202728_homework', null, null, '文学院', '2020-07-19 17:23:41');
INSERT INTO `courses` VALUES ('20202748', 'Foreign literature', '2018', 'fall', 'course_20202748_design', 'course_20202748_content', 'course_20202748_homework', null, null, '理学院', '2020-08-11 19:07:14');
INSERT INTO `courses` VALUES ('20202832', 'Graph theory', '2020', 'fall', 'course_20202832_design', 'course_20202832_content', 'course_20202832_homework', null, null, '经济学院', '2020-07-17 21:14:55');
INSERT INTO `courses` VALUES ('20202833', 'sports', '2018', 'fall', 'course_20202833_design', 'course_20202833_content', 'course_20202833_homework', null, null, '外国语学院', '2020-07-25 09:30:05');
INSERT INTO `courses` VALUES ('20202904', 'Object oriented programming', '2020', 'fall', 'course_20202904_design', 'course_20202904_content', 'course_20202904_homework', null, null, '机械学院', '2020-07-23 05:33:27');
INSERT INTO `courses` VALUES ('20202941', 'Discrete mathematics', '2017', 'fall', 'course_20202941_design', 'course_20202941_content', 'course_20202941_homework', null, null, '航空航天学院', '2020-07-17 21:14:55');
INSERT INTO `courses` VALUES ('demo001', 'Computer Science', '2020', 'fall', 'course_demo001_design', 'course_demo001_content', 'course_demo001_homework', 'course_demo001_examination', 'course_demo001_resource', '数学学院', '2020-07-05 15:10:32');

-- ----------------------------
-- Table structure for demo_trigger
-- ----------------------------
DROP TABLE IF EXISTS `demo_trigger`;
CREATE TABLE `demo_trigger` (
  `issue_id` char(40) NOT NULL,
  `issue_content` char(40) DEFAULT NULL,
  `issue_title` char(40) DEFAULT NULL,
  `issue_deadline` datetime DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_trigger
-- ----------------------------

-- ----------------------------
-- Table structure for files_index
-- ----------------------------
DROP TABLE IF EXISTS `files_index`;
CREATE TABLE `files_index` (
  `file_id` char(40) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files_index
-- ----------------------------
INSERT INTO `files_index` VALUES ('file_id1;', 'file_name23', '/resources/', '2020-07-09 11:59:27');

-- ----------------------------
-- Table structure for password
-- ----------------------------
DROP TABLE IF EXISTS `password`;
CREATE TABLE `password` (
  `person_id` char(40) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of password
-- ----------------------------
INSERT INTO `password` VALUES ('stu20200101', 'yangtianshuo', '2020-06-09 02:27:51');
INSERT INTO `password` VALUES ('stu20200102', 'shihao', '2020-06-01 08:09:40');
INSERT INTO `password` VALUES ('stu20200201', 'linyan', '2020-06-13 13:38:53');
INSERT INTO `password` VALUES ('stu20200202', 'xuhouqing', '2020-06-20 17:57:20');
INSERT INTO `password` VALUES ('stu20200203', 'zhuhongyu', '2020-06-14 22:10:48');
INSERT INTO `password` VALUES ('stu20200204', 'peikai', '2020-06-15 05:33:07');
INSERT INTO `password` VALUES ('stu20200301', 'zhangxiaoyi', '2020-06-10 19:16:56');
INSERT INTO `password` VALUES ('stu20200302', 'wujiang', '2020-06-30 15:18:44');
INSERT INTO `password` VALUES ('stu20200303', 'ningqiqi', '2020-06-27 01:22:28');
INSERT INTO `password` VALUES ('stu20200304', 'handong', '2020-06-19 12:16:02');
INSERT INTO `password` VALUES ('tch20200101', 'lizhaolong', '2020-07-22 00:00:00');
INSERT INTO `password` VALUES ('tch20200102', 'tianfengrui', '2020-07-17 21:14:55');
INSERT INTO `password` VALUES ('tch20200103', 'caodahua', '2020-07-20 07:28:44');
INSERT INTO `password` VALUES ('tch20200104', 'gongyilin', '2020-07-25 09:30:05');
INSERT INTO `password` VALUES ('tch20200105', 'zhangyizhuo', '2020-07-19 17:23:41');
INSERT INTO `password` VALUES ('tch20200106', 'xiangyixiao', '2020-07-23 05:33:27');
INSERT INTO `password` VALUES ('tch20200107', 'fanghongjian', '2020-08-06 23:51:09');
INSERT INTO `password` VALUES ('tch20200108', 'suwenwan', '2020-07-17 14:46:27');
INSERT INTO `password` VALUES ('tch20200109', 'sunroujia', '2020-08-11 19:07:14');
INSERT INTO `password` VALUES ('tch20200110', 'zhaoxinmei', '2020-07-29 03:02:56');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `student_id` char(40) NOT NULL,
  `student_name` char(40) DEFAULT NULL,
  `student_age` char(40) DEFAULT NULL,
  `student_gender` char(40) DEFAULT NULL,
  `student_class` char(40) DEFAULT NULL,
  `student_email` char(40) DEFAULT NULL,
  `student_username` char(40) NOT NULL,
  `student_password` char(40) DEFAULT NULL,
  `student_avatar` char(255) DEFAULT '/img/profile-photos/1.png',
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`student_username`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('stu20000110', 'caod3ahua', null, null, null, '34334@223.com', 'ddd3d', 'ddd3d', '/img/profile-photos/1.png', '2020-07-06 16:55:18');
INSERT INTO `students` VALUES ('stu20200101', '杨天硕', '18', '男', '软件73', '747458467@qq.com', 'calmcat1', 'yangtianshuo', '/img/profile-photos/2.png', '2020-06-09 02:27:51');
INSERT INTO `students` VALUES ('stu20200102', '石昊', '21', '男', '计算机46', '846952176@qq.com', 'calmcat2', 'shihao', '/img/profile-photos/3.png', '2020-06-01 08:09:40');
INSERT INTO `students` VALUES ('stu20200201', '林嫣', '19', '女', '文试62', '648513694@qq.com', 'calmcat3', 'linyan', '/img/profile-photos/4.png', '2020-06-13 13:38:53');
INSERT INTO `students` VALUES ('stu20200202', '徐后青', '20', '男', '钱学森54', '648251476@qq.com', 'calmcat4', 'xuhouqing', '/img/profile-photos/1.png', '2020-06-20 17:57:20');
INSERT INTO `students` VALUES ('stu20200203', '朱红雨', '19', '女', 'ACCA68', '167954356@qq.com', 'calmcat5', 'zhuhongyu', '/img/profile-photos/1.png', '2020-06-14 22:10:48');
INSERT INTO `students` VALUES ('stu20200204', '裴凯', '20', '男', '物试57', '379521645@qq.com', 'calmcat6', 'peikai', '/img/profile-photos/1.png', '2020-06-15 05:33:07');
INSERT INTO `students` VALUES ('stu20200301', '张晓一', '16', '男', '少年班92', '135156131@qq.com', 'calmcat7', 'zhangxiaoyi', '/img/profile-photos/1.png', '2020-06-10 19:16:56');
INSERT INTO `students` VALUES ('stu20200302', '吴江', '23', '男', '能动27', '323115154@qq.com', 'calmcat8', 'wujiang', '/img/profile-photos/1.png', '2020-06-30 15:18:44');
INSERT INTO `students` VALUES ('stu20200303', '宁琪琪', '18', '女', '管工78', '763258493@qq.com', 'calmcat9', 'ningqiqi', '/img/profile-photos/1.png', '2020-06-27 01:22:28');
INSERT INTO `students` VALUES ('stu20200304', '韩冬', '20', '女', '数试59', '313215131@qq.com', 'calmcat10', 'handong', '/img/profile-photos/1.png', '2020-06-19 12:16:02');
INSERT INTO `students` VALUES ('stu20200305', '杨一铭', '21', '男', '能动71', '263888326@qq.com', 'calmcat11', 'yangyiming', '/img/profile-photos/1.png', '2020-07-03 05:32:02');
INSERT INTO `students` VALUES ('stu20200306', 'DaHua Cao', null, null, null, '940141567@qq.com', 'cdhhh', '123', '/img/profile-photos/1.png', '2020-07-06 00:00:00');
INSERT INTO `students` VALUES ('stu20200307', 'test123', null, null, null, '123456789@qq.com', 'test123', '123456', '/img/profile-photos/1.png', '2020-07-10 00:00:00');
INSERT INTO `students` VALUES ('stu20200308', 'test1234', null, null, null, '1234@163.com', 'usertest', '1234', '/img/profile-photos/1.png', '2020-07-10 00:00:00');

-- ----------------------------
-- Table structure for students_courses
-- ----------------------------
DROP TABLE IF EXISTS `students_courses`;
CREATE TABLE `students_courses` (
  `student_id` char(40) NOT NULL,
  `course_id` char(40) NOT NULL,
  `attend_type` char(40) DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `course_id_in_students_courses` (`course_id`),
  CONSTRAINT `course_id_in_students_courses` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON UPDATE CASCADE,
  CONSTRAINT `stu_id_in_students_courses` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students_courses
-- ----------------------------
INSERT INTO `students_courses` VALUES ('stu20000110', '20201264', 'secondattend', '2020-07-04 21:13:48');
INSERT INTO `students_courses` VALUES ('stu20200101', '20202941', 'secondattend', '2020-07-11 21:14:15');
INSERT INTO `students_courses` VALUES ('stu20200102', '20201417', 'selflearning', '2020-07-19 21:06:45');
INSERT INTO `students_courses` VALUES ('stu20200102', '20201508', 'firstattend', '2020-07-18 02:14:48');
INSERT INTO `students_courses` VALUES ('stu20200102', '20202941', 'selflearning', '2020-07-17 21:14:55');
INSERT INTO `students_courses` VALUES ('stu20200201', '20201264', 'secondattend', '2020-07-31 21:09:21');
INSERT INTO `students_courses` VALUES ('stu20200201', '20201316', 'secondattend', '2020-07-22 00:00:00');
INSERT INTO `students_courses` VALUES ('stu20200201', '20201322', 'firstattend', '2020-07-08 20:52:48');
INSERT INTO `students_courses` VALUES ('stu20200201', '20201417', 'firstattend', '2020-07-10 21:07:44');
INSERT INTO `students_courses` VALUES ('stu20200201', '20201508', 'secondattend', '2020-07-17 21:09:41');
INSERT INTO `students_courses` VALUES ('stu20200201', '20202672', 'selflearning', '2020-08-11 19:07:14');
INSERT INTO `students_courses` VALUES ('stu20200201', '20202748', 'secondattend', '2020-08-11 19:07:14');
INSERT INTO `students_courses` VALUES ('stu20200202', '20201172', 'firstattend', '2020-08-11 19:07:14');
INSERT INTO `students_courses` VALUES ('stu20200202', '20201264', 'firstattend', '2020-07-24 21:09:05');
INSERT INTO `students_courses` VALUES ('stu20200202', '20201316', 'firstattend', '2020-07-22 00:00:00');
INSERT INTO `students_courses` VALUES ('stu20200202', '20201506', 'firstattend', '2020-07-29 08:15:18');
INSERT INTO `students_courses` VALUES ('stu20200202', '20202832', 'firstattend', '2020-07-17 21:14:55');
INSERT INTO `students_courses` VALUES ('stu20200203', '20201264', 'firstattend', '2020-07-25 09:30:05');
INSERT INTO `students_courses` VALUES ('stu20200203', '20201316', 'firstattend', '2020-07-09 21:08:04');
INSERT INTO `students_courses` VALUES ('stu20200203', '20202832', 'firstattend', '2020-08-15 21:15:38');
INSERT INTO `students_courses` VALUES ('stu20200203', '20202833', 'firstattend', '2020-07-25 09:30:05');
INSERT INTO `students_courses` VALUES ('stu20200203', '20202904', 'secondattend', '2020-07-23 05:33:27');
INSERT INTO `students_courses` VALUES ('stu20200203', '20202941', 'firstattend', '2020-07-25 21:12:48');
INSERT INTO `students_courses` VALUES ('stu20200204', '20201506', 'firstattend', '2020-07-31 21:08:52');
INSERT INTO `students_courses` VALUES ('stu20200204', '20201508', 'firstattend', '2020-07-27 21:18:21');
INSERT INTO `students_courses` VALUES ('stu20200204', '20202728', 'firstattend', '2020-08-13 21:12:28');
INSERT INTO `students_courses` VALUES ('stu20200301', '20201417', 'firstattend', '2020-07-10 21:18:44');
INSERT INTO `students_courses` VALUES ('stu20200301', '20201506', 'firstattend', '2020-07-17 14:46:27');
INSERT INTO `students_courses` VALUES ('stu20200301', '20201508', 'firstattend', '2020-08-14 21:11:35');
INSERT INTO `students_courses` VALUES ('stu20200302', '20201322', 'selflearning', '2020-07-29 03:02:56');
INSERT INTO `students_courses` VALUES ('stu20200302', '20201417', 'firstattend', '2020-08-07 21:11:07');
INSERT INTO `students_courses` VALUES ('stu20200303', '20201172', 'firstattend', '2020-08-11 21:17:32');
INSERT INTO `students_courses` VALUES ('stu20200303', '20201508', 'selflearning', '2020-07-20 07:28:44');
INSERT INTO `students_courses` VALUES ('stu20200304', '20201417', 'secondattend', '2020-08-06 23:51:09');
INSERT INTO `students_courses` VALUES ('stu20200304', '20202832', 'firstattend', '2020-07-25 21:10:03');
INSERT INTO `students_courses` VALUES ('stu20200304', '20202941', 'firstattend', '2020-07-31 21:10:49');
INSERT INTO `students_courses` VALUES ('stu20200305', '20201506', 'firstattend', '2020-07-10 21:21:46');
INSERT INTO `students_courses` VALUES ('stu20200305', '20202728', 'firstattend', '2020-08-20 21:10:24');
INSERT INTO `students_courses` VALUES ('stu20200306', '20201322', 'firstattend', '2020-08-01 21:11:56');
INSERT INTO `students_courses` VALUES ('stu20200306', 'demo001', 'firstattend', '2020-07-07 11:12:52');

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `teacher_id` char(40) NOT NULL,
  `teacher_name` char(40) DEFAULT NULL,
  `teacher_age` char(40) DEFAULT NULL,
  `teacher_email` char(40) NOT NULL,
  `teacher_gender` char(40) DEFAULT NULL,
  `teacher_phone` char(40) DEFAULT NULL,
  `teacher_content` text,
  `teacher_username` varchar(255) NOT NULL,
  `teacher_password` varchar(255) DEFAULT NULL,
  `teacher_avatar` text,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`teacher_id`,`teacher_username`,`teacher_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('tch20000110', 'caodahua', null, '3434@223.com', null, null, null, 'dddd', 'dddd', 'img/profile-photos/3.png', '2020-07-06 16:36:47');
INSERT INTO `teachers` VALUES ('tch20200101', '李朝龙', '21', '7475383@dd.con', '男', '14425131456', 'The data structure', 'lizhaolong', 'lizhaolong', 'img/profile-photos/3.png', '2020-07-22 00:00:00');
INSERT INTO `teachers` VALUES ('tch20200102', '田丰瑞', '22', '3651248@dd.con', '男', '13652454669', 'Graph theory  & Discrete mathematics', 'tianfengrui', 'tianfengrui', 'img/profile-photos/3.png', '2020-07-17 21:14:55');
INSERT INTO `teachers` VALUES ('tch20200103', '曹大华', '21', '940141567@qq.com', '男', '15964854227', 'Machine learning', 'caodahua', '123', 'img/profile-photos/3.png', '2020-07-20 07:28:44');
INSERT INTO `teachers` VALUES ('tch20200104', '巩怡霖', '20', '6169774@dd.cn', '女', '16485632546', 'Linear algebra & sports', 'gongyilin', 'gongyilin', 'img/profile-photos/3.png', '2020-07-25 09:30:05');
INSERT INTO `teachers` VALUES ('tch20200105', '张一卓', '20', '5716498@dd.cn', '女', '15469325468', 'Algorithm design and analysis', 'zhangyizhuo', 'zhangyizhuo', 'img/profile-photos/3.png', '2020-07-19 17:23:41');
INSERT INTO `teachers` VALUES ('tch20200106', '向苡霄', '20', '5294658@dd.cn', '女', '13254875771', 'Object oriented programming', 'xiangyixiao', 'xiangyixiao', 'img/profile-photos/3.png', '2020-07-23 05:33:27');
INSERT INTO `teachers` VALUES ('tch20200107', '方鸿渐', '32', '9458621@dd.cn', '男', '17946582554', 'History of Chinese and Foreign Literature', 'fanghongjian', 'fanghongjian', 'img/profile-photos/3.png', '2020-08-06 23:51:09');
INSERT INTO `teachers` VALUES ('tch20200108', '苏文纨', '29', '3487921@dd.cn', '女', '15486952314', 'Chinese poetry', 'suwenwan', 'suwenwan', 'img/profile-photos/3.png', '2020-07-17 14:46:27');
INSERT INTO `teachers` VALUES ('tch20200109', '孙柔嘉', '27', '2496158@dd.cn', '女', '12864532948', 'English & Music & Foreign literature', 'sunroujia', 'sunroujia', 'img/profile-photos/3.png', '2020-08-11 19:07:14');
INSERT INTO `teachers` VALUES ('tch20200110', '赵辛楣', '33', '9124763@dd.cn', '男', '14936582469', 'University physics', 'zhaoxinmei', 'zhaoxinmei', 'img/profile-photos/3.png', '2020-07-29 03:02:56');
INSERT INTO `teachers` VALUES ('tch20200111', 'ddd', 'null', '328382@qq.com', 'null', 'null', 'null', 'testteacher', 'testteacher', 'img/profile-photos/3.png', '2020-07-02 16:36:38');
INSERT INTO `teachers` VALUES ('tch20200112', 'DaHua Cao', null, '940141567@qq.com', null, null, null, 'cdh', '123', 'img/profile-photos/3.png', null);
INSERT INTO `teachers` VALUES ('tch20200113', 'DaHua Cao', null, '940141567@qq.com', null, null, null, 'cdh1', '123', 'img/profile-photos/3.png', '2020-07-06 00:00:00');
INSERT INTO `teachers` VALUES ('tch20200114', 'test', null, 'test@test', null, null, null, 'test', 'test', null, '2020-07-10 00:00:00');
INSERT INTO `teachers` VALUES ('tch20200115', 'test', null, 'test@test', null, null, null, '1234567', 'test', null, '2020-07-10 00:00:00');
INSERT INTO `teachers` VALUES ('tch20200116', 'tfr111', null, 'tfr@163.com', null, null, null, 'tfr123', '123456', null, '2020-07-10 00:00:00');

-- ----------------------------
-- Table structure for teachers_courses
-- ----------------------------
DROP TABLE IF EXISTS `teachers_courses`;
CREATE TABLE `teachers_courses` (
  `teacher_id` char(40) NOT NULL,
  `course_id` char(40) NOT NULL,
  `insert_date` datetime DEFAULT NULL,
  PRIMARY KEY (`teacher_id`,`course_id`),
  KEY `course_id_in_teachers_courses` (`course_id`),
  CONSTRAINT `course_id_in_teachers_courses` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON UPDATE CASCADE,
  CONSTRAINT `teacher_id_in_teachers_courses` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers_courses
-- ----------------------------
INSERT INTO `teachers_courses` VALUES ('tch20000110', '20201506', '2020-07-23 21:24:40');
INSERT INTO `teachers_courses` VALUES ('tch20200101', '20201316', '2020-07-22 00:00:00');
INSERT INTO `teachers_courses` VALUES ('tch20200101', '20201506', '2020-07-05 15:24:08');
INSERT INTO `teachers_courses` VALUES ('tch20200101', 'demo001', '2020-07-09 16:41:44');
INSERT INTO `teachers_courses` VALUES ('tch20200102', '20202832', '2020-07-17 21:14:55');
INSERT INTO `teachers_courses` VALUES ('tch20200102', '20202941', '2020-07-17 21:14:55');
INSERT INTO `teachers_courses` VALUES ('tch20200103', '20201264', '2020-08-21 09:23:33');
INSERT INTO `teachers_courses` VALUES ('tch20200103', '20201508', '2020-07-20 07:28:44');
INSERT INTO `teachers_courses` VALUES ('tch20200104', '20201264', '2020-07-25 09:30:05');
INSERT INTO `teachers_courses` VALUES ('tch20200104', '20201316', '2020-07-04 12:23:55');
INSERT INTO `teachers_courses` VALUES ('tch20200104', '20201508', '2020-07-01 21:23:16');
INSERT INTO `teachers_courses` VALUES ('tch20200104', '20202748', '2020-07-13 21:25:41');
INSERT INTO `teachers_courses` VALUES ('tch20200104', '20202833', '2020-07-25 09:30:05');
INSERT INTO `teachers_courses` VALUES ('tch20200105', '20202728', '2020-07-19 17:23:41');
INSERT INTO `teachers_courses` VALUES ('tch20200106', '20201508', '2020-07-19 21:25:06');
INSERT INTO `teachers_courses` VALUES ('tch20200106', '20202904', '2020-07-23 05:33:27');
INSERT INTO `teachers_courses` VALUES ('tch20200107', '20201417', '2020-08-06 23:51:09');
INSERT INTO `teachers_courses` VALUES ('tch20200108', '20201506', '2020-07-17 14:46:27');
INSERT INTO `teachers_courses` VALUES ('tch20200109', '20201172', '2020-08-11 19:07:14');
INSERT INTO `teachers_courses` VALUES ('tch20200109', '20201417', '2020-07-11 21:26:21');
INSERT INTO `teachers_courses` VALUES ('tch20200109', '20202672', '2020-08-11 19:07:14');
INSERT INTO `teachers_courses` VALUES ('tch20200109', '20202748', '2020-08-11 19:07:14');
INSERT INTO `teachers_courses` VALUES ('tch20200110', '20201322', '2020-07-29 03:02:56');
INSERT INTO `teachers_courses` VALUES ('tch20200112', '20202832', '2020-07-17 21:25:20');
INSERT INTO `teachers_courses` VALUES ('tch20200112', '20202904', '2020-07-04 21:26:55');
INSERT INTO `teachers_courses` VALUES ('tch20200113', '20201264', '2020-07-23 21:25:30');
INSERT INTO `teachers_courses` VALUES ('tch20200113', '20201322', '2020-07-25 21:27:10');

-- ----------------------------
-- Procedure structure for test_mytest
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_mytest`;
DELIMITER ;;
CREATE DEFINER=`javaee`@`%` PROCEDURE `test_mytest`(in in_course_id varchar(99), in_announcement_id VARCHAR(99))
BEGIN
SET @course_id = in_course_id;
SET @announcement_id = in_announcement_id;
SET @search_tables = (
	SELECT
		courses.course_content_table
	FROM
		courses
	WHERE
		courses.course_id = @course_id
);


SET @STSQL = CONCAT(
	'SELECT issue_title, issue_id,  issue_content, insert_date FROM ',
	@search_tables,
	' WHERE issue_id = \'',
	@announcement_id,
	'\''
);

PREPARE stmt
FROM
	@STSQL;

EXECUTE stmt;

END
;;
DELIMITER ;
