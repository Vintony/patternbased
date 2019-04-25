CREATE TABLE `donaldtrump` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tweet_id` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3193 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `tweeterabstract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tweeter` varchar(45) DEFAULT NULL,
  `totalcount` int(11) DEFAULT NULL,
  `earliest` timestamp NULL DEFAULT NULL,
  `latest` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tweeterlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tweeter` varchar(45) DEFAULT NULL,
  `intro` varchar(45) DEFAULT NULL,
  `detailname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;