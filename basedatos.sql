

DROP DATABASE IF EXISTS botsociety;


CREATE Database botsociety;

use botsociety;


CREATE TABLE categoria_oferta (
    id_categoria       INT NOT NULL,
    nombre_categoria   VARCHAR(39)
);

ALTER TABLE categoria_oferta ADD CONSTRAINT categoria_oferta_pk PRIMARY KEY ( id_categoria );

CREATE TABLE comuna (
    id_comuna       INT NOT NULL,
    nombre_comina   VARCHAR(60) NOT NULL,
    id_provincia    INT NOT NULL
);

ALTER TABLE comuna ADD CONSTRAINT comuna_pk PRIMARY KEY ( id_comuna );

CREATE TABLE control_empresa (
    id_control_e   INT NOT NULL AUTO_INCREMENT,
    usuario        VARCHAR(40) NOT NULL,
    clave          VARCHAR(30) NOT NULL,
    rut_empresa    VARCHAR(1),
    id_empresa     INT NOT NULL,
    PRIMARY KEY(id_control_e)
);


CREATE TABLE control_usuario (
    id_control_u   INT NOT NULL AUTO_INCREMENT,
    usuario        VARCHAR(40) NOT NULL,
    clave          VARCHAR(40) NOT NULL,
    rut_persona    VARCHAR(13),
    id_persona     INT NOT NULL,
    PRIMARY KEY(id_control_u)
);


CREATE TABLE detalle_categoria (
    id_detalle_categoria   INT NOT NULL AUTO_INCREMENT,,
    id_categoria           INT NOT NULL,
    id_oferta              INT NOT NULL,
    PRIMARY KEY(id_detalle_categoria)
);


CREATE TABLE empresa (
    id_empresa       INT NOT NULL AUTO_INCREMENT,
    nombre_empresa   VARCHAR(50),
    rut_empresa      VARCHAR(30),
    imagen_empresa   VARCHAR(300) NOT NULL,
    PRIMARY KEY(id_empresa)
);


CREATE TABLE estado_civil (
    id_estadoc       INT NOT NULL,
    nombre_estadoc   VARCHAR(20) NOT NULL
);

ALTER TABLE estado_civil ADD CONSTRAINT estado_civil_pk PRIMARY KEY ( id_estadoc );

CREATE TABLE experiencia_laboral (
    id_experiencia_laboral   INT NOT NULL AUTO_INCREMENT,
    id_persona               INT NOT NULL,
    periodo                  VARCHAR(50) NOT NULL,
    empresa                  VARCHAR(30) NOT NULL,
    cargo                    VARCHAR(30) NOT NULL,
    glosa                    VARCHAR(40) NOT NULL,
    PRIMARY KEY (id_experiencia_laboral)
);

CREATE TABLE genero (
    id_genero       INT NOT NULL,
    nombre_genero   VARCHAR(20)
);

ALTER TABLE genero ADD CONSTRAINT genero_pk PRIMARY KEY ( id_genero );

CREATE TABLE `like` (
    id_like      INT NOT NULL AUTO_INCREMENT,
    id_persona   INT NOT NULL,
    id_oferta    INT NOT NULL,
    PRIMARY KEY(id_like)
);

CREATE TABLE like_general (
    id_like_g    INT NOT NULL AUTO_INCREMENT,
    id_persona   INT NOT NULL,
    positivo     INT,
    negativo     INT,
    PRIMARY KEY(id_like_g)
);


CREATE TABLE nacionalidad (
    id_nacionalidad       INT NOT NULL,
    nombre_nacionalidad   VARCHAR(50) NOT NULL
);

ALTER TABLE nacionalidad ADD CONSTRAINT nacionalidad_pk PRIMARY KEY ( id_nacionalidad );

CREATE TABLE nivel_estudio (
    id_nivel_e       INT NOT NULL,
    nombre_nivel_e   VARCHAR(30)
);

ALTER TABLE nivel_estudio ADD CONSTRAINT nivel_estudio_pk PRIMARY KEY ( id_nivel_e );

CREATE TABLE oferta_laboral (
    id_oferta       INT NOT NULL AUTO_INCREMENT,
    nombre_oferta   VARCHAR(50),
    vacantes        INT NOT NULL,
    id_empresa      INT NOT NULL,
    glosa           VARCHAR(300) NOT NULL,
    id_comuna       INT NOT NULL,
    PRIMARY KEY(id_oferta)
);


CREATE TABLE persona (
    id_persona         INT NOT NULL AUTO_INCREMENT,
    rut_persona        VARCHAR(13) NOT NULL,
    id_tipo_d          INT NOT NULL,
    nombres            VARCHAR(50) NOT NULL,
    apellidos          VARCHAR(50) NOT NULL,
    fecha_nacimiento   DATETIME NOT NULL,
    id_nacionalidad    INT NOT NULL,
    id_comuna          INT NOT NULL,
    direccion          VARCHAR(300) NOT NULL,
    id_estadoc         INT NOT NULL,
    id_sexo            INT NOT NULL,
    id_genero          INT NOT NULL,
    id_nivel_e         INT NOT NULL,
    profesion          VARCHAR(40),
    correo             VARCHAR(60),
    telefono           VARCHAR(12),
    celular            VARCHAR(12),
    presentacion       VARCHAR(300),
    PRIMARY KEY(id_persona)
);

CREATE TABLE postulacion (
    id_postulacion   INT NOT NULL AUTO_INCREMENT,
    fecha            DATETIME NOT NULL,
    id_persona       INT NOT NULL,
    id_oferta        INT NOT NULL,
    PRIMARY KEY(id_postulacion)
);


CREATE TABLE pregunta (
    id_pregunta       INT NOT NULL AUTO_INCREMENT,
    nombre_pregunta   VARCHAR(300) NOT NULL,
    id_oferta         INT NOT NULL,
    PRIMARY KEY(id_pregunta)
);


CREATE TABLE provincia (
    id_provincia       INT NOT NULL,
    nombre_provincia   VARCHAR(30)
);

ALTER TABLE provincia ADD CONSTRAINT provincia_pk PRIMARY KEY ( id_provincia );

CREATE TABLE respuestas (
    id_respuesta     INT NOT NULL AUTO_INCREMENT,
    respuesta        VARCHAR(300) NOT NULL,
    id_postulacion   INT NOT NULL,
    id_pregunta      INT NOT NULL,
    PRIMARY KEY(id_respuesta)
);


CREATE TABLE sexo (
    id_sexo       INT NOT NULL,
    nombre_sexo   VARCHAR(10) NOT NULL
);

ALTER TABLE sexo ADD CONSTRAINT sexo_pk PRIMARY KEY ( id_sexo );

CREATE TABLE tipo_documento (
    id_tipo_d       INT NOT NULL,
    nombre_tipo_d   VARCHAR(100)
);

ALTER TABLE tipo_documento ADD CONSTRAINT tipo_documento_pk PRIMARY KEY ( id_tipo_d );

ALTER TABLE comuna
    ADD CONSTRAINT comuna_provincia_fk FOREIGN KEY ( id_provincia )
        REFERENCES provincia ( id_provincia );

ALTER TABLE control_empresa
    ADD CONSTRAINT cont_empr_fk FOREIGN KEY ( id_empresa )
        REFERENCES empresa ( id_empresa );

ALTER TABLE control_usuario
    ADD CONSTRAINT control_persona_fk FOREIGN KEY ( id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE detalle_categoria
    ADD CONSTRAINT deca_caof_fk FOREIGN KEY ( id_categoria )
        REFERENCES categoria_oferta ( id_categoria );

ALTER TABLE detalle_categoria
    ADD CONSTRAINT deca_oflal_fk FOREIGN KEY ( id_oferta )
        REFERENCES oferta_laboral ( id_oferta );

ALTER TABLE experiencia_laboral
    ADD CONSTRAINT expe_labo_fk FOREIGN KEY ( id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE like_general
    ADD CONSTRAINT like_gepe_fk FOREIGN KEY ( id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE `like`
    ADD CONSTRAINT like_oferta_laboral_fk FOREIGN KEY ( id_oferta )
        REFERENCES oferta_laboral ( id_oferta );

ALTER TABLE `like`
    ADD CONSTRAINT like_persona_fk FOREIGN KEY ( id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE oferta_laboral
    ADD CONSTRAINT ofla_comu_fk FOREIGN KEY ( id_comuna )
        REFERENCES comuna ( id_comuna );

ALTER TABLE oferta_laboral
    ADD CONSTRAINT oflabo_empre_fk FOREIGN KEY ( id_empresa )
        REFERENCES empresa ( id_empresa );

ALTER TABLE persona
    ADD CONSTRAINT pers_naci_fk FOREIGN KEY ( id_nacionalidad )
        REFERENCES nacionalidad ( id_nacionalidad );

ALTER TABLE persona
    ADD CONSTRAINT perso_nivel_fk FOREIGN KEY ( id_nivel_e )
        REFERENCES nivel_estudio ( id_nivel_e );

ALTER TABLE persona
    ADD CONSTRAINT persona_comuna_fk FOREIGN KEY ( id_comuna )
        REFERENCES comuna ( id_comuna );

ALTER TABLE persona
    ADD CONSTRAINT persona_estado_civil_fk FOREIGN KEY ( id_estadoc )
        REFERENCES estado_civil ( id_estadoc );

ALTER TABLE persona
    ADD CONSTRAINT persona_genero_fk FOREIGN KEY ( id_genero )
        REFERENCES genero ( id_genero );

ALTER TABLE persona
    ADD CONSTRAINT persona_sexo_fk FOREIGN KEY ( id_sexo )
        REFERENCES sexo ( id_sexo );

ALTER TABLE persona
    ADD CONSTRAINT persona_tipo_documento_fk FOREIGN KEY ( id_tipo_d )
        REFERENCES tipo_documento ( id_tipo_d );

ALTER TABLE postulacion
    ADD CONSTRAINT post_labo_fk FOREIGN KEY ( id_oferta )
        REFERENCES oferta_laboral ( id_oferta );

ALTER TABLE postulacion
    ADD CONSTRAINT post_pers_fk FOREIGN KEY ( id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE pregunta
    ADD CONSTRAINT preg_laboral_fk FOREIGN KEY ( id_oferta )
        REFERENCES oferta_laboral ( id_oferta );

ALTER TABLE respuestas
    ADD CONSTRAINT resp_preg_fk FOREIGN KEY ( id_pregunta )
        REFERENCES pregunta ( id_pregunta );

ALTER TABLE respuestas
    ADD CONSTRAINT respuestas_postulacion_fk FOREIGN KEY ( id_postulacion )
        REFERENCES postulacion ( id_postulacion );




INSERT INTO provincia VALUES (1,'Santiago');
INSERT INTO provincia VALUES (2,'Chacabuco');
INSERT INTO provincia VALUES (3,'Cordillera');
INSERT INTO provincia VALUES (4,'Maipo');
INSERT INTO provincia VALUES (5,'Melipilla');
INSERT INTO provincia VALUES (6,'Talagante');

INSERT INTO comuna VALUES (1,'Santiago',1);
INSERT INTO comuna VALUES (2,'Independecia',1);
INSERT INTO comuna VALUES (3,'Conchalí',1);
INSERT INTO comuna VALUES (4,'Huachuraba',1);
INSERT INTO comuna VALUES (5,'Recoleta',1);
INSERT INTO comuna VALUES (6,'Providencia',1);
INSERT INTO comuna VALUES (7,'Vitacura',1);
INSERT INTO comuna VALUES (8,'Lo Barnechea',1);
INSERT INTO comuna VALUES (9,'Las Condes',1);
INSERT INTO comuna VALUES (10,'Ñuñoa',1);
INSERT INTO comuna VALUES (11,'La Reina',1);
INSERT INTO comuna VALUES (12,'Macul',1);
INSERT INTO comuna VALUES (13,'Peñalolén',1);
INSERT INTO comuna VALUES (14,'La Florida',1);
INSERT INTO comuna VALUES (15,'San Joaquín',1);
INSERT INTO comuna VALUES (16,'La Granja',1);
INSERT INTO comuna VALUES (17,'La Pintana',1);
INSERT INTO comuna VALUES (18,'San Ramón',1);
INSERT INTO comuna VALUES (19,'San Miguel',1);
INSERT INTO comuna VALUES (20,'La Cisterna',1);
INSERT INTO comuna VALUES (21,'El Bosque',1);
INSERT INTO comuna VALUES (22,'Pedro Aguirre Cerda',1);
INSERT INTO comuna VALUES (23,'Lo Espejo',1);
INSERT INTO comuna VALUES (24,'Estacion Central',1);
INSERT INTO comuna VALUES (25,'Cerrillos',1);
INSERT INTO comuna VALUES (26,'Maipú',1);
INSERT INTO comuna VALUES (27,'Quinta Normal',1);
INSERT INTO comuna VALUES (28,'Lo Prado',1);
INSERT INTO comuna VALUES (29,'Pudahuel',1);
INSERT INTO comuna VALUES (30,'Cerro Navía',1);
INSERT INTO comuna VALUES (31,'Renca',1);
INSERT INTO comuna VALUES (32,'Quilicura',1);
INSERT INTO comuna VALUES (33,'Colina',2);
INSERT INTO comuna VALUES (34,'Lampa',2);
INSERT INTO comuna VALUES (35,'Tiltil',2);
INSERT INTO comuna VALUES (36,'Puente Alto',3);
INSERT INTO comuna VALUES (37,'San Jose de Maipo',3);
INSERT INTO comuna VALUES (38,'Pirque',3);
INSERT INTO comuna VALUES (39,'San Bernardo',4);
INSERT INTO comuna VALUES (40,'Buin',4);
INSERT INTO comuna VALUES (41,'Paine',4);
INSERT INTO comuna VALUES (42,'Calera de Tango',4);
INSERT INTO comuna VALUES (43,'Melipilla',5);
INSERT INTO comuna VALUES (44,'María Pinto',5);
INSERT INTO comuna VALUES (45,'Curacaví',5);
INSERT INTO comuna VALUES (46,'Alhué',5);
INSERT INTO comuna VALUES (47,'San Pedro',5);
INSERT INTO comuna VALUES (48,'Talagante',6);
INSERT INTO comuna VALUES (49,'Peñaflor',6);
INSERT INTO comuna VALUES (50,'Isla de Maipo',6);
INSERT INTO comuna VALUES (51,'El Monte',4);
INSERT INTO comuna VALUES (52,'Padre Hurtado',4);