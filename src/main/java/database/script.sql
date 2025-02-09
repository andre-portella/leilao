-- Criação do banco de dados
CREATE DATABASE leilao;
USE leilao;

-- Tabela de usuários (US04)
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabela de produtos (US01)
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    min_bid DECIMAL(10, 2) NOT NULL,
    description TEXT
);

-- Tabela de lances (US02 e US03)
CREATE TABLE bids (
    bid_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    user_id INT NOT NULL,
    bid_value DECIMAL(10, 2) NOT NULL,
    bid_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) 
        REFERENCES products(product_id) 
        ON DELETE CASCADE,
    FOREIGN KEY (user_id) 
        REFERENCES users(user_id) 
        ON DELETE CASCADE
);



-- script para popular a tabela produto:

INSERT INTO products (name, min_bid, description) VALUES
('Figura de Ação Batman 1989', 500.00, 'Figura rara do Batman do filme de 1989, em excelente estado de conservação.'),
('Quadrinho X-Men #1', 300.00, 'Primeira edição do famoso quadrinho X-Men, em ótimo estado.'),
('Moeda Comemorativa 50 anos da NASA', 200.00, 'Moeda rara comemorando os 50 anos da NASA, com detalhes gravados em alta qualidade.'),
('Estatueta Star Wars Darth Vader', 600.00, 'Estatueta premium do Darth Vader, com detalhes incríveis, edição limitada.'),
('Cartão Pokémon Charizard', 1000.00, 'Cartão raro de Charizard, em condição de "mint", ideal para colecionadores.'),
('Action Figure Iron Man 1ª Edição', 450.00, 'Action figure do Homem de Ferro, edição limitada de 1ª linha.'),
('Moeda de Ouro do Império Romano', 1200.00, 'Moeda de ouro do período do Império Romano, raridade histórica.'),
('Pôster Original de Star Wars', 350.00, 'Pôster original de Star Wars de 1977, em excelente estado para o seu tempo.'),
('Figurinha Rara Michael Jordan', 700.00, 'Figurinha rara de Michael Jordan, considerada um ícone no mercado de colecionáveis esportivos.'),
('Boneco Funko Pop! de Harry Potter', 80.00, 'Boneco Funko Pop! de edição limitada do Harry Potter, item indispensável para fãs.'),
('Action Figure Godzilla', 350.00, 'Action figure de alta qualidade do Godzilla, edição limitada e extremamente detalhada.'),
('Quadrinho Superman #75', 400.00, 'Edição comemorativa do quadrinho Superman #75, com a famosa morte do Superman.'),
('Monumento Miniatura da Estátua da Liberdade', 150.00, 'Miniatura detalhada da Estátua da Liberdade, feita de metal fundido e pintada à mão.'),
('Caixa de Edição Limitada de Star Wars', 500.00, 'Caixa colecionável com itens exclusivos de Star Wars, incluindo cartas e acessórios.'),
('Réplica de Espada de Conan', 600.00, 'Réplica fiel da espada de Conan, feita de aço inoxidável e com base para exibição.'),
('Figurinha Rara de Pelé', 900.00, 'Figura rara do Pelé em sua primeira Copa do Mundo, colecionável extremamente raro.'),
('Cópia Assinada de "O Senhor dos Anéis"', 200.00, 'Edição de luxo e assinada do livro "O Senhor dos Anéis", com capa de couro e ilustrações exclusivas.'),
('Relógio Antigo de Ouro da Rolex', 2500.00, 'Relógio Rolex vintage de ouro, um verdadeiro tesouro para colecionadores de relógios.'),
('Escultura de Ferro de Iron Man', 700.00, 'Escultura de ferro do Iron Man, feita à mão e pintada em alto relevo.'),
('Moeda de Ouro do Brasil Império', 1500.00, 'Moeda de ouro rara do Brasil Império, uma peça preciosa para numismatas.');


INSERT INTO users (username, password) VALUES
('admin', 'admin'),
('lzaina', 'web2024'),
('bob', '1234'),
('alice', '4321');