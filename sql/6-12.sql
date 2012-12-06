-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- โฮสต์: localhost
-- เวลาในการสร้าง: 
-- รุ่นของเซิร์ฟเวอร์: 5.0.51
-- รุ่นของ PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- ฐานข้อมูล: `exceedvote`
-- 

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `ballot`
-- 

CREATE TABLE `ballot` (
  `id` int(10) NOT NULL auto_increment,
  `user` int(10) NOT NULL,
  `questionid` int(10) NOT NULL,
  `choice` int(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

-- 
-- dump ตาราง `ballot`
-- 

INSERT INTO `ballot` VALUES (16, 13, 1, 1);
INSERT INTO `ballot` VALUES (2, 12, 1, 1);
INSERT INTO `ballot` VALUES (3, 12, 1, 1);
INSERT INTO `ballot` VALUES (5, 12, 1, 1);
INSERT INTO `ballot` VALUES (14, 12, 1, 2);
INSERT INTO `ballot` VALUES (7, 12, 1, 1);
INSERT INTO `ballot` VALUES (8, 12, 1, 1);
INSERT INTO `ballot` VALUES (9, 12, 1, 1);
INSERT INTO `ballot` VALUES (10, 12, 10, 1);
INSERT INTO `ballot` VALUES (11, 12, 10, 1);
INSERT INTO `ballot` VALUES (12, 12, 10, 1);
INSERT INTO `ballot` VALUES (13, 12, 10, 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `choice`
-- 

CREATE TABLE `choice` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `img` varchar(40) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

-- 
-- dump ตาราง `choice`
-- 

INSERT INTO `choice` VALUES (2, 'ExceedVote G2', 'G2 Des', '');
INSERT INTO `choice` VALUES (11, 'sdfsdfsd', 'asdasd', '');
INSERT INTO `choice` VALUES (9, 'ExccedVote G3', 'H3', 'demo/7.jpg');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `role`
-- 

CREATE TABLE `role` (
  `id` int(255) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `ballot_multiply` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

-- 
-- dump ตาราง `role`
-- 

INSERT INTO `role` VALUES (10, 'Student', 3);
INSERT INTO `role` VALUES (9, 'Admin', 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `statement`
-- 

CREATE TABLE `statement` (
  `id` int(10) NOT NULL auto_increment,
  `description` varchar(50) NOT NULL,
  `ballot_multiply` int(255) NOT NULL default '1',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

-- 
-- dump ตาราง `statement`
-- 

INSERT INTO `statement` VALUES (1, 'Question1', 2);
INSERT INTO `statement` VALUES (10, 'Q2', 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `user`
-- 

CREATE TABLE `user` (
  `id` int(255) NOT NULL auto_increment,
  `user` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `user` (`user`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

-- 
-- dump ตาราง `user`
-- 

INSERT INTO `user` VALUES (12, 'admin', 'admin');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `user_type`
-- 

CREATE TABLE `user_type` (
  `id` int(255) NOT NULL auto_increment,
  `role` int(255) NOT NULL,
  `user` int(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

-- 
-- dump ตาราง `user_type`
-- 

INSERT INTO `user_type` VALUES (12, 9, 12);
INSERT INTO `user_type` VALUES (11, 10, 11);
INSERT INTO `user_type` VALUES (10, 9, 11);
INSERT INTO `user_type` VALUES (9, 9, 10);
INSERT INTO `user_type` VALUES (8, 10, 9);
INSERT INTO `user_type` VALUES (7, 9, 9);
INSERT INTO `user_type` VALUES (13, 10, 12);
