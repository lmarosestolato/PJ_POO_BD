DROP DATABASE IF EXISTS projetoGaleria;
CREATE DATABASE projetoGaleria;
USE projetoGaleria;

CREATE TABLE IF NOT EXISTS `projetoGaleria`.`info_contato` (
  `telefone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`email`));

CREATE TABLE IF NOT EXISTS `projetoGaleria`.`galeria` (
  `idGaleria` INT NOT NULL AUTO_INCREMENT,
  `nome_galeria` VARCHAR(45) NOT NULL,
  `nome_gerente` VARCHAR(45) NOT NULL,
  `num_func` INT NOT NULL,
  `info_contato_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGaleria`, `info_contato_email`),
  INDEX `fk_galeria_info_contato1_idx` (`info_contato_email` ASC) VISIBLE,
  CONSTRAINT `fk_galeria_info_contato1`
    FOREIGN KEY (`info_contato_email`)
    REFERENCES `projetoGaleria`.`info_contato` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `projetoGaleria`.`exposicao` (
  `idExposicao` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(15) NOT NULL,
  `galeria_idGaleria` INT NOT NULL,
  PRIMARY KEY (`idExposicao`, `galeria_idGaleria`),
  INDEX `fk_exposicao_galeria1_idx` (`galeria_idGaleria` ASC) VISIBLE,
  CONSTRAINT `fk_exposicao_galeria1`
    FOREIGN KEY (`galeria_idGaleria`)
    REFERENCES `projetoGaleria`.`galeria` (`idGaleria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `projetoGaleria`.`artista` (
  `idArtista` INT NOT NULL AUTO_INCREMENT,
  `nome_artista` VARCHAR(45) NOT NULL,
  `data_nasc` VARCHAR(15),
  `data_morte` VARCHAR(15),
  `naturalidade` VARCHAR(45),
  `estilo` VARCHAR(45),
  PRIMARY KEY (`idArtista`));

CREATE TABLE IF NOT EXISTS `projetoGaleria`.`exposicao_has_artista` (
  `exposicao_idExposicao` INT NOT NULL,
  `artista_idArtista` INT NOT NULL,
  PRIMARY KEY (`exposicao_idExposicao`, `artista_idArtista`),
  INDEX `fk_Exposicao_has_artista_artista1_idx` (`artista_idArtista` ASC) VISIBLE,
  INDEX `fk_Exposicao_has_artista_Exposicao1_idx` (`exposicao_idExposicao` ASC) VISIBLE,
  CONSTRAINT `fk_Exposicao_has_artista_Exposicao1`
    FOREIGN KEY (`exposicao_idExposicao`)
    REFERENCES `projetoGaleria`.`exposicao` (`idExposicao`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Exposicao_has_artista_artista1`
    FOREIGN KEY (`artista_idArtista`)
    REFERENCES `projetoGaleria`.`artista` (`idArtista`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `projetoGaleria`.`obra` (
  `idObra` INT NOT NULL AUTO_INCREMENT,
  `nome_obra` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `local_origem` VARCHAR(45) NOT NULL,
  `ano_criacao` INT NOT NULL,
  `material` VARCHAR(45) NOT NULL,
  `tecnica` VARCHAR(45) NOT NULL,
  `movimento` VARCHAR(45) NOT NULL,
  `artista_idArtista` INT NOT NULL,
  PRIMARY KEY (`idObra`, `artista_idArtista`),
  INDEX `fk_obra_artista1_idx` (`artista_idArtista` ASC) VISIBLE,
  CONSTRAINT `fk_obra_artista1`
    FOREIGN KEY (`artista_idArtista`)
    REFERENCES `projetoGaleria`.`artista` (`idArtista`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
	INSERT INTO info_contato (email, telefone, endereco) VALUES('arte@gmail.com', '(41) 3471-7345', 'Alameda Rosada, 103B, Monte Grande');
    INSERT INTO info_contato (email, telefone, endereco) VALUES('galeria@gmail.com', '(35) 99910-5013', 'Rua Bacharel Franco, 79, Ribeira');
    INSERT INTO info_contato (email, telefone, endereco) VALUES('louvre@org.com', '(17) 33325088', 'Rua 1 de Abril, 65, BH');
    
    INSERT INTO galeria (idGaleria, nome_galeria, nome_gerente, num_func, info_contato_email) VALUES ('1','Artes','Gabriel',10,'arte@gmail.com');
	INSERT INTO galeria (idGaleria, nome_galeria, nome_gerente, num_func, info_contato_email) VALUES ('2','Galeria de Artes','Lucas',5,'galeria@gmail.com');
	INSERT INTO galeria (idGaleria, nome_galeria, nome_gerente, num_func, info_contato_email) VALUES ('3','Louvre','Pierre',100,'louvre@org.com');
    
    INSERT INTO exposicao (idExposicao, data, galeria_idGaleria) VALUE ('1','09/11/2021','1');
    INSERT INTO exposicao (idExposicao, data, galeria_idGaleria) VALUE ('2','20/11/2021','1');
    INSERT INTO exposicao (idExposicao, data, galeria_idGaleria) VALUE ('3','30/12/2021','2');
    
    INSERT INTO artista() VALUES ('1','Leonardo da Vinci','11/05/1857','11/05/1887','Frances','Surrealista');
    INSERT INTO artista() VALUES ('2','Michelangelo','10/06/1859','20/08/1889','Italiano','Dadaismo');
    INSERT INTO artista() VALUES ('3','Donatello','04/09/1853','11/06/1883','Suico','Surrealista');
    
    INSERT INTO obra(idObra, nome_obra, tipo, local_origem, ano_criacao, material, tecnica, movimento, artista_idArtista) VALUES (1,'Monalisa','Quadro','Italia' ,1854,'Tinta' ,'Oleo sobre tela','Surrealismo','1');
	INSERT INTO obra(idObra, nome_obra, tipo, local_origem, ano_criacao, material, tecnica, movimento, artista_idArtista) VALUES (2,'Ultima Ceia','Quadro','Italia' ,1866,'Tinta' ,'Oleo sobre tela','Dadaismo','2');
	INSERT INTO obra(idObra, nome_obra, tipo, local_origem, ano_criacao, material, tecnica, movimento, artista_idArtista) VALUES (3,'Davi','Escultura','Italia' ,1834,'Marmore' ,'Escultura','Impressionismo','1');
 
    
    SELECT * FROM info_contato;
    SELECT * FROM galeria;
    SELECT * FROM exposicao;
    SELECT * FROM artista;
    SELECT * FROM obra;