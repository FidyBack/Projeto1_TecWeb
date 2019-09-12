# Projeto1_TecWeb
Página Inicial: http://localhost:8080/N_O_D_E/

Para a inicialização do Projeto, as seguntes linhas de código devem ser inseridas no terminal:

CREATE TABLE users( 
  id INT NOT NULL AUTO_INCREMENT,
  nome TINYTEXT,
  senha TINYTEXT,
  PRIMARY KEY (ID)
  );
  
  CREATE TABLE projects( 
  id INT NOT NULL AUTO_INCREMENT,
  nome TEXT NOT NULL,
  id_user INT NOT NULL REFERENCES users(id),
  username TEXT NOT NULL REFERENCES users(nome),
  PRIMARY KEY (ID)
  );
