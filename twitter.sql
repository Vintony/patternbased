CREATE TABLE `twitter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tweet_id` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `screen_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci