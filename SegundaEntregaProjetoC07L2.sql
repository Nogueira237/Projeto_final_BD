-- ======== Cria o bd ========
DROP DATABASE IF EXISTS academia;
CREATE DATABASE academia;
USE academia;


-- ======== Criando as tabelas ========
CREATE TABLE Plano(
	id_plano INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    valor DOUBLE,
    duracao INT
);

CREATE TABLE Treino(
	id_treino INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(100),
    nivel VARCHAR(10)
);

CREATE TABLE Instrutor(
	id_instrutor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    especialidade VARCHAR(45),
    salario DOUBLE
);

CREATE TABLE Aluno(
	id_aluno INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    cpf VARCHAR(14) UNIQUE,		-- nao podem existir cpfs iguais
    data_nascimento DATE,
    telefone VARCHAR(20),
    Treino_id_treino INT,
    Plano_id_plano INT,
    
    FOREIGN KEY (Treino_id_treino)
    REFERENCES Treino(id_treino)
    ON DELETE CASCADE,
    
    FOREIGN KEY (Plano_id_plano)
    REFERENCES Plano(id_plano)
    ON DELETE CASCADE
    
);

CREATE TABLE Pagamento(
	id_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    valor DOUBLE,
    data_pagamento DATE,
    pago VARCHAR(3),			-- SIM ou NAO
    Aluno_id_aluno INT,
    
    FOREIGN KEY (Aluno_id_aluno)
    REFERENCES  Aluno(id_aluno)
    ON DELETE CASCADE
);

CREATE TABLE Aula(
	id_aula INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    horario TIME,
    capacidade INT,
    Instrutor_id_instrutor INT,
    
    FOREIGN KEY (Instrutor_id_instrutor)
    REFERENCES Instrutor(id_instrutor)
    ON DELETE CASCADE
);

-- ======== Tabela de relacionamento muitos pra muitos de Aluno e Aula ========
CREATE TABLE Aluno_has_Aula(
	Aluno_id_aluno INT,
    Aula_id_aula INT,
    
    PRIMARY KEY(Aluno_id_aluno, Aula_id_aula),
    
    FOREIGN KEY (Aluno_id_aluno)
    REFERENCES Aluno(id_aluno)
    ON DELETE CASCADE,
    
    FOREIGN KEY (Aula_id_aula)
    REFERENCES Aula(id_aula)
    ON DELETE CASCADE

);


-- ======== Inserindo nas tabelas ========

-- ======== Inserindo planos ========
INSERT INTO Plano(nome, valor, duracao) VALUES
('Mensal', 99.9, 1),
('Bimestral', 184.9, 2),
('Trimestral', 269.9, 3),
('Semestral', 499.9, 6),
('Anual', 899.9, 12);

-- ======== Inserindo treinos ========
INSERT INTO Treino(descricao, nivel) VALUES
('Treino iniciante', 'Fácil'),
('Treino hipertrofia', 'Difícil'),
('Treino funcional', 'Médio'),
('Treino cardio', 'Médio'),
('Treino resistência', 'Difícil');

-- ======== Inserindo instrutores ========
INSERT INTO Instrutor(nome, especialidade, salario) VALUES
('Alex lima', 'Musculação', 3500),
('Nayara Silva', 'Funcional', 4200),
('Rafael Souza', 'Crossfit', 5000),
('Juliana Alves', 'Yoga', 3200),
('Marcos Pereira', 'Cardio', 3800);

-- ======== Inserindo alunos ========
INSERT INTO Aluno(nome, cpf, data_nascimento, telefone, Treino_id_treino, Plano_id_plano) VALUES
('Carlos Eduardo', '123.456.789-01', '2003-05-14', '(32)93687-2510', 1, 4),
('Ana Clara', '987.654.321-02', '2001-09-22', '(34)93171-0412', 2, 5),
('Lucas Martins', '741.852.963-03', '1999-12-10', '(32)93168-7295', 3, 2),
('Mariana Costa', '159.357.258-04', '2004-03-18', '(35)92182-2024', 4, 1),
('Pedro Henrique', '951.753.456-05', '2000-07-30', '(38)93076-7481', 5, 3);

-- ======== Inserindo pagamentos ========
INSERT INTO Pagamento(valor, data_pagamento, pago, Aluno_id_aluno) VALUES
(99.9, '2026-05-02', 'SIM', 1),
(1299.9, '2026-05-05', 'SIM', 2),
(269.9, '2026-05-10', 'NAO', 3),
(99.9, '2026-05-16', 'SIM', 4),
(499.9, '2026-05-22', 'SIM', 5);

-- ======== Inserindo aulas ========
INSERT INTO Aula(nome, horario, capacidade, Instrutor_id_instrutor) VALUES
('Musculação', '08:00:00', 20, 1),
('Funcional', '10:00:00', 15, 2),
('Crossfit', '18:00:00', 25, 3),
('Yoga', '07:30:00', 10, 4),
('Cardio', '19:30:00', 30, 5);

-- ======== Inserindo relacionamento Aluno <-> Aula ========
INSERT INTO Aluno_has_Aula(Aluno_id_aluno, Aula_id_aula) VALUES
(1, 1),	-- 'Carlos Eduardo' vinculado ao 'Treino iniciante'
(1, 3),
(2, 2),
(3, 3),
(4, 4);


-- ======== Criando usuários ========
-- Administrador 
CREATE USER IF NOT EXISTS 'admin_academia'@'localhost' IDENTIFIED BY 'admin2026';
GRANT ALL PRIVILEGES ON academia.* TO 'admin_academia'@'localhost';

-- Funcionário
CREATE USER IF NOT EXISTS 'funcionario_academia'@'localhost' IDENTIFIED BY 'func2026';
GRANT SELECT, INSERT, UPDATE ON academia.* TO 'funcionario_academia'@'localhost';


-- ======== Criando role ========
CREATE ROLE IF NOT EXISTS 'role_funcionario';													-- Cria a role
GRANT SELECT, INSERT ON academia.* TO 'role_funcionario';						-- Privilégios da role
GRANT 'role_funcionario' TO 'funcionario_academia'@'localhost';					-- Associa funcionario_academia a role
SET DEFAULT ROLE 'role_funcionario' TO 'funcionario_academia'@'localhost';		-- Define a role como padrão para funcionario_academia


-- ======== Criando objetos programáveis ========

-- ======== 1. View que lista nome e plano dos alunos ========
CREATE VIEW vw_alunos_planos AS SELECT Aluno.nome AS aluno, Plano.nome AS plano
FROM Aluno INNER JOIN Plano 
ON Aluno.Plano_id_plano = Plano.id_plano;

-- ======== 2. Procedure que mostra todos os alunos ========
DROP PROCEDURE IF EXISTS listarAlunos;

DELIMITER $$

CREATE PROCEDURE listarAlunos()

BEGIN
    SELECT * FROM Aluno;
END $$

DELIMITER ;

-- ======== 3. Procedure para cadastrar um novo aluno ========
DROP PROCEDURE IF EXISTS cadastrarAluno;

DELIMITER $$

CREATE PROCEDURE cadastrarAluno(IN p_nome VARCHAR(45), IN p_cpf VARCHAR(14), IN p_data DATE,
 IN p_telefone VARCHAR(20), IN p_treino INT, IN p_plano INT)
 
BEGIN
    INSERT INTO Aluno(nome, cpf, data_nascimento, telefone, Treino_id_treino, Plano_id_plano)
    VALUES(p_nome, p_cpf, p_data, p_telefone, p_treino, p_plano);
END $$

DELIMITER ;

-- ======== Testes dos objetos programáveis ========
SELECT * FROM vw_alunos_planos;
CALL listarAlunos();
CALL cadastrarAluno('Teste', '111.111.111-11', '2000-01-01', '(35)11111-1111', 1, 1);
SELECT * FROM Aluno;