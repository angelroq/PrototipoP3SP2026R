
CREATE TABLE peliculas (
  idPeliculas int(11) NOT NULL,
  Nombre varchar(45) NOT NULL,
  Clasificacion varchar(45) NOT NULL,
  Genero varchar(45) NOT NULL,
  Subtitulado varchar(45) NOT NULL,
  Idioma varchar(45) NOT NULL,
  Precio double NOT NULL,
  PRIMARY KEY (idPeliculas)
)ENGINE=InnoDB CHARACTER SET=LATIN1;

INSERT INTO aplicaciones (Aplcodigo, Aplnombre, Aplestado) VALUES (777, "Peliculas", 1)
