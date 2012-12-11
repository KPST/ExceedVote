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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=73 ;

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

-- 
-- dump ตาราง `choice`
-- 

INSERT INTO `choice` VALUES (14, 'Google', 'Brabrabra1', 'http://www.google.co.th/images/srpr/logo3w.png');
INSERT INTO `choice` VALUES (15, 'Panda', 'Never say no to panda', 'https://programming.cpe.ku.ac.th/jet/service/authen/images/leftphoto.jpg');

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

-- 
-- dump ตาราง `statement`
-- 

INSERT INTO `statement` VALUES (15, 'Best of Bug', 1);
INSERT INTO `statement` VALUES (16, 'Bug is the Best', 2);

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- dump ตาราง `user`
-- 

INSERT INTO `user` VALUES (1, 'admin', 'admin');
INSERT INTO `user` VALUES (2, 'user', 'pass');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `user_type`
-- 

CREATE TABLE `user_type` (
  `id` int(255) NOT NULL auto_increment,
  `role` int(255) NOT NULL,
  `user` int(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- dump ตาราง `user_type`
-- 

INSERT INTO `user_type` VALUES (1, 16, 1);
INSERT INTO `user_type` VALUES (2, 21, 2);
