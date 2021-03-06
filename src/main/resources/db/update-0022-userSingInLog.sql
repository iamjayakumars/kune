DROP TABLE IF EXISTS `user_signin_log`;
CREATE TABLE `user_signin_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hash` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ipAddress` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `signInDate` bigint(20) NOT NULL,
  `userAgent` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1C924E1BE8AF66E5` (`user_id`),
  CONSTRAINT `FK1C924E1BE8AF66E5` FOREIGN KEY (`user_id`) REFERENCES `kusers` (`id`)
);
