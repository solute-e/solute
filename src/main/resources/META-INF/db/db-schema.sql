CREATE TABLE `code` (
  `name` varchar(20) NOT NULL DEFAULT '',
  `group` varchar(20) NOT NULL DEFAULT '',
  `code` int(11) NOT NULL DEFAULT '0',
  `message` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`name`,`group`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `image_group` (
  `gid` varchar(36) NOT NULL,
  `image_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `images` (
  `id` varchar(36) NOT NULL,
  `path` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `solutions` (
  `id` varchar(36) NOT NULL,
  `problem` varchar(4000) DEFAULT NULL,
  `solution` varchar(4000) DEFAULT NULL,
  `source` varchar(256) DEFAULT NULL,
  `answer` varchar(256) DEFAULT NULL,
  `problem_img_gid` varchar(36) DEFAULT NULL,
  `solution_img_gid` varchar(36) DEFAULT NULL,
  `tag_gid` varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`,`tag_gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tag_group` (
  `gid` varchar(36) NOT NULL,
  `tag_id` varchar(36) NOT NULL,
  PRIMARY KEY (`gid`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tags` (
  `id` varchar(36) NOT NULL,
  `tag` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `email` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

