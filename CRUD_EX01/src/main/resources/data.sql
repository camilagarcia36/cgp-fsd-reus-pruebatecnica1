DROP TABLE IF EXISTS `messages`;
DROP TABLE IF EXISTS `games`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `parties`;


CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `steam_user` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
);

CREATE TABLE `parties` (

  `id_party` int(11) NOT NULL AUTO_INCREMENT,
  `party_title` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_party`),
  CONSTRAINT `user_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`) 
);
CREATE TABLE `games` (
  `id_game` int(11) NOT NULL AUTO_INCREMENT,
  `game_title` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL, 
  `party_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_game`),
  CONSTRAINT `party_FK` FOREIGN KEY (`party_id`) REFERENCES `parties` (`id_party`) 
);

CREATE TABLE `messages` (
  `id_message` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(250) DEFAULT NULL,
    `date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `party_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_message`),
  CONSTRAINT `user_message_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`),
 CONSTRAINT `party_message_FK` FOREIGN KEY (`party_id`) REFERENCES `parties` (`id_party`) 
 );



INSERT INTO `users` (`username`, `password`, `email`, `steam_user`) VALUES
('plaweh', 'mellamorauh', 'rauh@hotmail.com', 'u3454_2');
INSERT INTO `users` (`username`, `password`, `email`, `steam_user`) VALUES
('camy', 'mellamocami', 'camila@gmail.com', 'k1000a');
INSERT INTO `users` (`username`, `password`, `email`, `steam_user`) VALUES
('carlos', 'gimenez1', 'gcarlos@gg.com', 'carlitos');

INSERT INTO `parties` (`party_title`, `user_id`) VALUES
('Otakus game', 3);
INSERT INTO `parties` (`party_title`, `user_id`) VALUES
('Shooter time', 1);
INSERT INTO `parties` (`party_title`, `user_id`) VALUES
('HouseTime', 2);

INSERT INTO `games` (`game_title`, `description`, `party_id`) VALUES
('Valorant', 'Juego de disparar sin sentido y esconderse', 1);

INSERT INTO `games` (`game_title`, `description`, `party_id`) VALUES
('Naruto', 'Juego de correr con surikens', 3);
INSERT INTO `games` (`game_title`, `description`, `party_id`) VALUES
('House Flipper', 'Juego de diseñar y redecorar casas', 2);

INSERT INTO `messages` (`content`, `date`, `user_id`, `party_id`) VALUES
('Hola a todos, alguien quiere jugar a naruto', '2010-01-19', 3, 2);

INSERT INTO `messages` (`content`, `date`, `user_id`, `party_id`) VALUES
('hola grupo feliz jaguelin soi Vanessa!', '2023-02-25', 1, 1);
INSERT INTO `messages` (`content`, `date`, `user_id`, `party_id`) VALUES
('Vamo a pinta', '2023-04-19', 2, 3);