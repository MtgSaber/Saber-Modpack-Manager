CREATE TABLE `Modpack_Access_Permission` (
  `user_id` int NOT NULL,
  `modpack_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `modpack_id`)
);

CREATE TABLE `User` (
  `id` int PRIMARY KEY,
  `person_id` int UNIQUE,
  `username` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Person` (
  `id` int PRIMARY KEY
);

CREATE TABLE `Minecraft_Version` (
  `id` int PRIMARY KEY,
  `version` char(10) UNIQUE,
  `title` varchar(255)
);

CREATE TABLE `Modpack` (
  `id` int PRIMARY KEY,
  `owner_id` int NOT NULL,
  `minecraft_version_id` int NOT NULL,
  `title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Modpack_Contribution` (
  `modpack_id` int NOT NULL,
  `contributor_id` int NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`modpack_id`, `contributor_id`)
);

CREATE TABLE `Contributor` (
  `id` int PRIMARY KEY,
  `person_id` int UNIQUE,
  `name` varchar(255) NOT NULL
);

CREATE TABLE `Pack_File` (
  `id` int PRIMARY KEY,
  `local_path` varchar(255) NOT NULL,
  `remote_uri` varchar(255) NOT NULL
);

CREATE TABLE `Misc_Pack_File` (
  `pack_file_id` int NOT NULL,
  `modpack_version_id` int NOT NULL,
  PRIMARY KEY (`pack_file_id`, `modpack_version_id`)
);

CREATE TABLE `Modpack_Version` (
  `id` int PRIMARY KEY,
  `modpack_id` int NOT NULL,
  `version` char(10) NOT NULL
);

CREATE TABLE `Mod_Contribution` (
  `contributor_id` int NOT NULL,
  `mod_id` int NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`contributor_id`, `mod_id`)
);

CREATE TABLE `Mod_Config` (
  `pack_file_id` int NOT NULL,
  `modpack_version_id` int NOT NULL,
  `mod_id` int NOT NULL,
  PRIMARY KEY (`pack_file_id`, `modpack_version_id`)
);

CREATE TABLE `Mod_Listing` (
  `modpack_version_id` int NOT NULL,
  `mod_id` int NOT NULL,
  `modfile_id` int NOT NULL,
  PRIMARY KEY (`modpack_version_id`, `mod_id`)
);

CREATE TABLE `Mod` (
  `id` int PRIMARY KEY,
  `owner_id` int NOT NULL,
  `name` varchar(255) UNIQUE NOT NULL,
  `website` varchar(255) NOT NULL
);

CREATE TABLE `Modfile` (
  `pack_file_id` int UNIQUE NOT NULL,
  `mod_id` int NOT NULL,
  `minecraft_version_id` int NOT NULL,
  `version` varchar(255) NOT NULL,
  `artifact_uri` varchar(255) UNIQUE NOT NULL,
  PRIMARY KEY (`pack_file_id`)
);

ALTER TABLE `User` ADD FOREIGN KEY (`person_id`) REFERENCES `Person` (`id`);

ALTER TABLE `Contributor` ADD FOREIGN KEY (`person_id`) REFERENCES `Person` (`id`);

ALTER TABLE `Modfile` ADD FOREIGN KEY (`pack_file_id`) REFERENCES `Pack_File` (`id`);

ALTER TABLE `Mod_Config` ADD FOREIGN KEY (`pack_file_id`) REFERENCES `Pack_File` (`id`);

ALTER TABLE `Mod_Config` ADD FOREIGN KEY (`modpack_version_id`, `mod_id`) REFERENCES `Mod_Listing` (`modpack_version_id`, `mod_id`);

ALTER TABLE `Misc_Pack_File` ADD FOREIGN KEY (`pack_file_id`) REFERENCES `Pack_File` (`id`);

ALTER TABLE `Misc_Pack_File` ADD FOREIGN KEY (`modpack_version_id`) REFERENCES `Modpack_Version` (`id`);

ALTER TABLE `Modpack` ADD FOREIGN KEY (`owner_id`) REFERENCES `User` (`id`);

ALTER TABLE `Modpack` ADD FOREIGN KEY (`minecraft_version_id`) REFERENCES `Minecraft_Version` (`id`);

ALTER TABLE `Modpack_Access_Permission` ADD FOREIGN KEY (`modpack_id`) REFERENCES `Modpack` (`id`);

ALTER TABLE `Modpack_Access_Permission` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);

ALTER TABLE `Modpack_Contribution` ADD FOREIGN KEY (`contributor_id`) REFERENCES `Contributor` (`id`);

ALTER TABLE `Modpack_Contribution` ADD FOREIGN KEY (`modpack_id`) REFERENCES `Modpack` (`id`);

ALTER TABLE `Mod_Contribution` ADD FOREIGN KEY (`contributor_id`) REFERENCES `Contributor` (`id`);

ALTER TABLE `Mod_Contribution` ADD FOREIGN KEY (`mod_id`) REFERENCES `Mod` (`id`);

ALTER TABLE `Modpack_Version` ADD FOREIGN KEY (`modpack_id`) REFERENCES `Modpack` (`id`);

ALTER TABLE `Mod` ADD FOREIGN KEY (`owner_id`) REFERENCES `Contributor` (`id`);

ALTER TABLE `Modfile` ADD FOREIGN KEY (`mod_id`) REFERENCES `Mod` (`id`);

ALTER TABLE `Modfile` ADD FOREIGN KEY (`minecraft_version_id`) REFERENCES `Minecraft_Version` (`id`);

ALTER TABLE `Mod_Listing` ADD FOREIGN KEY (`modpack_version_id`) REFERENCES `Modpack_Version` (`id`);

ALTER TABLE `Mod_Listing` ADD FOREIGN KEY (`mod_id`) REFERENCES `Mod` (`id`);

ALTER TABLE `Mod_Listing` ADD FOREIGN KEY (`modfile_id`) REFERENCES `Modfile` (`pack_file_id`);
