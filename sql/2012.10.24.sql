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
-- โครงสร้างตาราง `auth`
-- 

CREATE TABLE `auth` (
  `id` int(10) NOT NULL auto_increment,
  `user` varchar(12) NOT NULL,
  `pass` varchar(12) NOT NULL,
  `priority` int(11) NOT NULL,
  `no_ballot` tinyint(4) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- dump ตาราง `auth`
-- 

INSERT INTO `auth` VALUES (1, 'admin', 'admin', 0, 5);
INSERT INTO `auth` VALUES (2, 'user', 'pass', 1, 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=46 ;

-- 
-- dump ตาราง `ballot`
-- 

INSERT INTO `ballot` VALUES (27, 1, 3, 2);
INSERT INTO `ballot` VALUES (24, 1, 3, 1);
INSERT INTO `ballot` VALUES (45, 1, 2, 2);
INSERT INTO `ballot` VALUES (21, 1, 3, 2);
INSERT INTO `ballot` VALUES (17, 1, 2, 2);
INSERT INTO `ballot` VALUES (18, 1, 2, 2);
INSERT INTO `ballot` VALUES (44, 1, 1, 2);
INSERT INTO `ballot` VALUES (29, 1, 3, 2);
INSERT INTO `ballot` VALUES (32, 1, 2, 2);
INSERT INTO `ballot` VALUES (42, 1, 1, 2);
INSERT INTO `ballot` VALUES (41, 1, 1, 2);
INSERT INTO `ballot` VALUES (37, 1, 1, 1);
INSERT INTO `ballot` VALUES (38, 1, 1, 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `choice`
-- 

CREATE TABLE `choice` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- dump ตาราง `choice`
-- 

INSERT INTO `choice` VALUES (1, 'ExceedVote G1', 'G1 Des');
INSERT INTO `choice` VALUES (2, 'ExceedVote G2', 'G2 Des');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `statement`
-- 

CREATE TABLE `statement` (
  `id` int(10) NOT NULL auto_increment,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- dump ตาราง `statement`
-- 

INSERT INTO `statement` VALUES (1, 'Question1');
INSERT INTO `statement` VALUES (2, 'Question2');
INSERT INTO `statement` VALUES (3, 'Question3');
