-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mangadb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `manga_cover`
--

DROP TABLE IF EXISTS `manga_cover`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manga_cover` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imageUrl` varchar(255) DEFAULT NULL,
  `relId` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manga_cover`
--

LOCK TABLES `manga_cover` WRITE;
/*!40000 ALTER TABLE `manga_cover` DISABLE KEYS */;
INSERT INTO `manga_cover` VALUES (1,'http://h.mfcdn.net/store/manga/11362/cover.jpg?token=5c55250382c4de196e2d10153e6026ce&ttl=1498424400&v=1498117442','11362','Onepunch-Man','http://mangafox.me/manga/onepunch_man/'),(2,'http://h.mfcdn.net/store/manga/16627/cover.jpg?token=d06672ab18340477dd992069f6b97338&ttl=1498424400&v=1498118013','16627','Tales of Demons and Gods','http://mangafox.me/manga/tales_of_demons_and_gods/'),(3,'http://h.mfcdn.net/store/manga/246/cover.jpg?token=e394293c1b30929f4a555f7f726fce82&ttl=1498424400&v=1497746526','246','Fairy Tail','http://mangafox.me/manga/fairy_tail/'),(4,'http://h.mfcdn.net/store/manga/106/cover.jpg?token=b6b59eb4cf758d47dea45365adb91545&ttl=1498424400&v=1497514025','106','One Piece','http://mangafox.me/manga/one_piece/'),(5,'http://h.mfcdn.net/store/manga/14356/cover.jpg?token=87aa3bb2c2e889281da2763df9be76aa&ttl=1498424400&v=1498180682','14356','Boku no Hero Academia','http://mangafox.me/manga/boku_no_hero_academia/'),(6,'http://h.mfcdn.net/store/manga/13088/cover.jpg?token=8296c1d7e743c34da40b2e4a28a1fd18&ttl=1498424400&v=1498192263','13088','The Gamer','http://mangafox.me/manga/the_gamer/'),(7,'http://h.mfcdn.net/store/manga/11529/cover.jpg?token=e93090f57321f852d2ca0076e6b746f2&ttl=1498424400&v=1498181766','11529','Shokugeki no Soma','http://mangafox.me/manga/shokugeki_no_soma/'),(8,'http://h.mfcdn.net/store/manga/14036/cover.jpg?token=693ad758dc3947db4e9c745375f0b0ee&ttl=1498424400&v=1495520826','14036','Tate no Yuusha no Nariagari','http://mangafox.me/manga/tate_no_yuusha_no_nariagari/'),(9,'http://h.mfcdn.net/store/manga/9011/cover.jpg?token=d420b4a47930590cef190e1bda25bf9c&ttl=1498424400&v=1497605588','9011','Shingeki no Kyojin','http://mangafox.me/manga/shingeki_no_kyojin/'),(10,'http://h.mfcdn.net/store/manga/16159/cover.jpg?token=16bcbaa5f278444e326a59bf25b7c0e3&ttl=1498424400&v=1498281061','16159','Tomo-chan wa Onnanoko!','http://mangafox.me/manga/tomo_chan_wa_onnanoko/'),(11,'http://h.mfcdn.net/store/manga/15177/cover.jpg?token=a8496ce3f03379363a3fc1225de150d7&ttl=1498424400&v=1498144622','15177','The Legendary Moonlight Sculptor','http://mangafox.me/manga/the_legendary_moonlight_sculptor/'),(12,'http://h.mfcdn.net/store/manga/15291/cover.jpg?token=1027d4bfc2161b6f0aba4830da85511e&ttl=1498424400&v=1498118522','15291','Black Clover','http://mangafox.me/manga/black_clover/'),(13,'http://h.mfcdn.net/store/manga/8207/cover.jpg?token=ef382566b6a4d8c5902126411d9f6b53&ttl=1498424400&v=1498117397','8207','Tower of God','http://mangafox.me/manga/tower_of_god/'),(14,'http://h.mfcdn.net/store/manga/11147/cover.jpg?token=eb30341a144ac07c592e61e8d833cdc2&ttl=1498424400&v=1496677202','11147','Horimiya','http://mangafox.me/manga/horimiya/'),(15,'http://h.mfcdn.net/store/manga/6770/cover.jpg?token=ba7ef9ef1a0ae49da3455c93d61494cf&ttl=1498424400&v=1498118013','6770','Noblesse','http://mangafox.me/manga/noblesse/'),(16,'http://h.mfcdn.net/store/manga/14588/cover.jpg?token=22bbd01335cbe01fd213be9267cdf5a3&ttl=1498424400&v=1497431521','14588','The New Gate','http://mangafox.me/manga/the_new_gate/'),(17,'http://h.mfcdn.net/store/manga/22443/cover.jpg?token=3ece4ac271c891cdefe1f5a7a0d4297d&ttl=1498424400&v=1498155002','22443','Star Martial God Technique','http://mangafox.me/manga/star_martial_god_technique/'),(18,'http://h.mfcdn.net/store/manga/12978/cover.jpg?token=37a207dd0fb5900f4f3810d09ccc1078&ttl=1498424400&v=1495651262','12978','Dungeon ni Deai o Motomeru no wa Machigatte Iru Darou ka','http://mangafox.me/manga/dungeon_ni_deai_o_motomeru_no_wa_machigatte_iru_darou_ka/'),(19,'http://h.mfcdn.net/store/manga/14765/cover.jpg?token=653acc9fbcaa2ea156af7d552072fe3d&ttl=1498424400&v=1497314402','14765','Overlord','http://mangafox.me/manga/overlord/'),(20,'http://h.mfcdn.net/store/manga/11374/cover.jpg?token=e381d5f9aff89d39e01d91a2ab8c222f&ttl=1498424400&v=1497857704','11374','Nanatsu no Taizai','http://mangafox.me/manga/nanatsu_no_taizai/'),(21,'http://h.mfcdn.net/store/manga/10348/cover.jpg?token=9ee34debb19a7d28ece82af142f3a971&ttl=1498424400&v=1498120066','10348','Monster Musume no Iru Nichijou','http://mangafox.me/manga/monster_musume_no_iru_nichijou/'),(22,'http://h.mfcdn.net/store/manga/14225/cover.jpg?token=cb4b2a0e556b1f29986f0d86a3fa7a88&ttl=1498424400&v=1498095189','14225','Doupo Cangqiong','http://mangafox.me/manga/doupo_cangqiong/'),(23,'http://h.mfcdn.net/store/manga/14425/cover.jpg?token=d4138db541c9da7324c1b84c8fd73722&ttl=1498424400&v=1498336682','14425','Tokyo Ghoul:re','http://mangafox.me/manga/tokyo_ghoul_re/'),(24,'http://h.mfcdn.net/store/manga/176/cover.jpg?token=334153302d490ebe099cd70091bac69c&ttl=1498424400&v=1498204683','176','Berserk','http://mangafox.me/manga/berserk/'),(25,'http://h.mfcdn.net/store/manga/16457/cover.jpg?token=adf60ee30fb515862dd7a8680dac7cc3&ttl=1498424400&v=1496761981','16457','Death March kara Hajimaru Isekai Kyousoukyoku','http://mangafox.me/manga/death_march_kara_hajimaru_isekai_kyousoukyoku/'),(26,'http://h.mfcdn.net/store/manga/15216/cover.jpg?token=2228c3a72dba2e1b5e650542ae5cd5cf&ttl=1498424400&v=1497510542','15216','Panlong','http://mangafox.me/manga/panlong/'),(27,'http://h.mfcdn.net/store/manga/14948/cover.jpg?token=86b0bbdef79b7eede66e9aa56e54e473&ttl=1498424400&v=1497827403','14948','ReLIFE','http://mangafox.me/manga/relife/'),(28,'http://h.mfcdn.net/store/manga/6151/cover.jpg?token=9699ed1486262def089344fd42b2baa6&ttl=1498424400&v=1498116569','6151','Magi - Labyrinth of Magic','http://mangafox.me/manga/magi_labyrinth_of_magic/'),(29,'http://h.mfcdn.net/store/manga/8198/cover.jpg?token=637c52b0b6046c7741e1a5165b6a598a&ttl=1498424400&v=1497769563','8198','Kingdom','http://mangafox.me/manga/kingdom/'),(30,'http://h.mfcdn.net/store/manga/13841/cover.jpg?token=ffc12f06d613c9da339c4052c0e8bad5&ttl=1498424400&v=1495872269','13841','Doulou Dalu','http://mangafox.me/manga/doulou_dalu/'),(31,'http://h.mfcdn.net/store/manga/9126/cover.jpg?token=ac19c2ad147d7d54c596e5464e857395&ttl=1498424400&v=1497023162','9126','Akatsuki no Yona','http://mangafox.me/manga/akatsuki_no_yona/'),(32,'http://h.mfcdn.net/store/manga/13895/cover.jpg?token=3e3a621ad0f5c11dbceea119499b7ca4&ttl=1498424400&v=1498119039','13895','Re:Monster','http://mangafox.me/manga/re_monster/'),(33,'http://h.mfcdn.net/store/manga/9013/cover.jpg?token=17b30e4e2a3ff16e8f94ee336cf65955&ttl=1498424400&v=1498274282','9013','Kangoku Gakuen','http://mangafox.me/manga/kangoku_gakuen/'),(34,'http://h.mfcdn.net/store/manga/44/cover.jpg?token=6b69d33cf51235aea5e1e3d62e491816&ttl=1498424400&v=1498181823','44','Hunter X Hunter','http://mangafox.me/manga/hunter_x_hunter/'),(35,'http://h.mfcdn.net/store/manga/18289/cover.jpg?token=b8fdd78f7739162974e629b8ffac84bc&ttl=1498424400&v=1498095185','18289','Spirit Blade Mountain','http://mangafox.me/manga/spirit_blade_mountain/'),(36,'http://h.mfcdn.net/store/manga/2212/cover.jpg?token=a14b9b3cbf6c653bfa32fb14dc841143&ttl=1498424400&v=1488787923','2212','Freezing','http://mangafox.me/manga/freezing/'),(37,'http://h.mfcdn.net/store/manga/9/cover.jpg?token=f5145e30388c1d1460ea05112cc90ed7&ttl=1498424400&v=1480571428','9','Bleach','http://mangafox.me/manga/bleach/'),(38,'http://h.mfcdn.net/store/manga/8957/cover.jpg?token=053940a918c563089c9944149d57f603&ttl=1498424400&v=1488786305','8957','Noragami','http://mangafox.me/manga/noragami/'),(39,'http://h.mfcdn.net/store/manga/9017/cover.jpg?token=5e756f50914278d0dd62934e343c1324&ttl=1498424400&v=1498196944','9017','The God of High School','http://mangafox.me/manga/the_god_of_high_school/'),(40,'http://h.mfcdn.net/store/manga/10416/cover.jpg?token=ec3c35bba9774a31900841945418d891&ttl=1498424400&v=1489544519','10416','Akame ga Kill!','http://mangafox.me/manga/akame_ga_kill/'),(41,'http://h.mfcdn.net/store/manga/14038/cover.jpg?token=b38ff94bbf06e42753e873557bffc1b8&ttl=1498424400&v=1497854289','14038','Douluo Dalu II - Jueshui Tangmen','http://mangafox.me/manga/douluo_dalu_ii_jueshui_tangmen/'),(42,'http://h.mfcdn.net/store/manga/2605/cover.jpg?token=cde5c26d1c2603e93791ebaf558cf325&ttl=1498424400&v=1483581875','2605','Nana to Kaoru','http://mangafox.me/manga/nana_to_kaoru/'),(43,'http://h.mfcdn.net/store/manga/15975/cover.jpg?token=dd55ec77d29a1c89eff1ca228a7979c7&ttl=1498424400&v=1496905921','15975','Tensei Shitara Slime Datta Ken','http://mangafox.me/manga/tensei_shitara_slime_datta_ken/'),(44,'http://h.mfcdn.net/store/manga/9518/cover.jpg?token=e4028c598ad9b0efb319aff05f8ee348&ttl=1498424400&v=1498023315','9518','Minamoto-kun Monogatari','http://mangafox.me/manga/minamoto_kun_monogatari/');
/*!40000 ALTER TABLE `manga_cover` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-25 21:40:34
