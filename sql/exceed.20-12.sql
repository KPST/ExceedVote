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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=88 ;

-- 
-- dump ตาราง `ballot`
-- 


-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `choice`
-- 

CREATE TABLE `choice` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `img` varchar(1024) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

-- 
-- dump ตาราง `choice`
-- 

INSERT INTO `choice` VALUES (14, 'Google', 'Google is the seach engine.', 'http://www.google.co.th/images/srpr/logo3w.png');
INSERT INTO `choice` VALUES (18, 'Facebook', 'Facebook is the social network.', 'http://link.highedweb.org/files/Facebook-logo.png');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `role`
-- 

CREATE TABLE `role` (
  `id` int(255) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `ballot_multiply` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

-- 
-- dump ตาราง `role`
-- 

INSERT INTO `role` VALUES (21, 'Student', 1);
INSERT INTO `role` VALUES (16, 'Admin', 0);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `statement`
-- 

CREATE TABLE `statement` (
  `id` int(10) NOT NULL auto_increment,
  `description` varchar(50) NOT NULL,
  `ballot_multiply` int(255) NOT NULL default '1',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

-- 
-- dump ตาราง `statement`
-- 

INSERT INTO `statement` VALUES (20, 'What is your favorite website?', 1);
INSERT INTO `statement` VALUES (21, 'What is the most user friendly?', 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `time`
-- 

CREATE TABLE `time` (
  `id` int(100) NOT NULL auto_increment,
  `year` int(100) NOT NULL,
  `month` int(100) NOT NULL,
  `day` int(100) NOT NULL,
  `hour` int(100) NOT NULL,
  `min` int(100) NOT NULL,
  `timezone` int(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

-- 
-- dump ตาราง `time`
-- 

INSERT INTO `time` VALUES (9, 2012, 12, 20, 10, 30, 7);

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- 
-- dump ตาราง `user`
-- 

INSERT INTO `user` VALUES (1, 'admin', 'admin');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `user_type`
-- 

CREATE TABLE `user_type` (
  `id` int(255) NOT NULL auto_increment,
  `role` int(255) NOT NULL,
  `user` int(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- 
-- dump ตาราง `user_type`
-- 

INSERT INTO `user_type` VALUES (1, 16, 1);
