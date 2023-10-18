
# 👋 JDBC

Esse é um pequeno projeto para estudo da faculdade que conect o banco de dados com um simples interface usando JDBC e MYSQL
## 👁️‍🗨️ Demonstração
![](https://cdn.discordapp.com/attachments/806191502686027796/1163995311635697764/image.png?ex=65419a1c&is=652f251c&hm=1577fdd5dd27374675f691131216a41aa9a421591412d6f4aa513a6a44a0b62b&)
## 📚 Aprendizados
Com esse projeto aprendi a implementar o banco de dados com a interface
## ✈️ Como rodar

## Pré-Requisitos
Certifique-se de ter o seguinte configurado em seu sistema:

**Java Development Kit (JDK):** Verifique se você tem o Java Development Kit (JDK) instalado em seu sistema. Você pode baixar e instalar a versão mais recente do JDK no [site oficial da Oracle.](https://www.oracle.com/java/technologies/downloads/)

**MySQL Database Server:** Esta aplicação requer um servidor MySQL em execução. Se você ainda não tem o MySQL instalado, você pode baixá-lo do [site oficial do MySQL](https://dev.mysql.com/downloads/). Após a instalação, crie um banco de dados chamado livros e configure um usuário com permissões adequadas para acessar esse banco de dados.

**Driver JDBC MySQL**: Baixe o driver JDBC do MySQL do [site oficial do MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/). Certifique-se de adicionar o arquivo JAR do driver ao seu projeto.

## Instalação do Driver JDBC no NetBeans
### Baixe o Driver JDBC do MySQL:
Primeiro, baixe o arquivo JAR do driver JDBC do MySQL.

### Abra o NetBeans:
Inicie o NetBeans e abra seu projeto Java existente ou crie um novo projeto, se ainda não tiver um.

### Adicione o Driver JDBC ao seu Projeto:

- No explorador de projetos (Projects), clique com o botão direito do mouse na pasta "Bibliotecas".
- Selecione "Adicionar JAR/Folder...".
- Navegue até o local onde você salvou o arquivo JAR do driver JDBC e selecione-o.
- Clique em "Abrir" para adicionar o arquivo JAR ao seu projeto.
- Verifique se o Driver foi Adicionado com Sucesso:
- Após adicionar o arquivo JAR, você deve ver o driver JDBC do MySQL listado sob a pasta "Bibliotecas" no seu projeto.

## Configuração do Banco de Dados
- O arquivo livros.sql contém o banco de dados para importar no MySQL.
- O arquivo livros.txt possui os comandos relevantes para criação do banco de dados caso prefira.

**Observação:** Neste projeto, foi utilizado o [WampServer](https://www.wampserver.com/en/), portanto, o usuário do banco de dados é "root" e a senha está vazia.

## Passos para Execução
### Clone o Repositório:

```git clone https://github.com/seu-usuario/seu-projeto.git```

### Abra o NetBeans:

- Inicie o NetBeans IDE no seu computador.

### Abra o Projeto:

- No NetBeans, clique em File (Arquivo) -> Open Project (Abrir Projeto).
- Navegue até o diretório onde você clonou o repositório e selecione o arquivo do projeto (normalmente, tem a extensão .nbproject).

### Configure o Banco de Dados:

- Certifique-se de que o seu servidor MySQL está em execução.
- Importe o arquivo livros.sql no seu servidor MySQL para criar o banco de dados necessário para o projeto.

### Execute o Projeto:

- Clique com o botão direito do mouse no projeto no NetBeans.
- Escolha Run (Executar) para iniciar o projeto.
- A interface do usuário será exibida, permitindo que você consulte livros, empréstimos e insira novos livros no banco de dados.