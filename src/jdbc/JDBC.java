package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;

public class JDBC {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel para conter os componentes 
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Botão para consultar livros
        JButton consultarLivrosButton = new JButton("Consultar Livros");
        consultarLivrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarLivros();
            }
        });

        // Campo de entrada para o ID do usuário
        JTextField userIdField = new JTextField(5);
        userIdField.setText("1");

        // Botão para consultar empréstimos
        JButton consultarEmprestimosButton = new JButton("Consultar Empréstimos");
        consultarEmprestimosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userId = Integer.parseInt(userIdField.getText());
                consultarEmprestimos(userId);
            }
        });

        // Botão para inserir livro
        JButton inserirLivroButton = new JButton("Inserir Livro");
        inserirLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirLivro();
            }
        });

        // Adiciona os componentes ao painel
        panel.add(consultarLivrosButton);
        panel.add(new JLabel("ID do Usuário:"));
        panel.add(userIdField);
        panel.add(consultarEmprestimosButton);
        panel.add(inserirLivroButton);

        // Adiciona o painel ao frame
        frame.getContentPane().add(panel);
        frame.setSize(200, 300); 
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
    }

    private static void consultarLivros() {
        // Lógica para consultar o banco de dados
        String url = "jdbc:mysql://localhost:3306/livros";
        String usuario = "root";
        String senha = "";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String consultaLivros = "SELECT * FROM Livro";
            PreparedStatement preparedStatement = connection.prepareStatement(consultaLivros);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder resultado = new StringBuilder();
            while (resultSet.next()) {
                int idLivro = resultSet.getInt("ID");
                String titulo = resultSet.getString("Titulo");
                String autor = resultSet.getString("Autor");
                int anoPublicacao = resultSet.getInt("Ano_Publicacao");
                String genero = resultSet.getString("Genero");
                int numeroPaginas = resultSet.getInt("Numero_Paginas");

                resultado.append("ID: ").append(idLivro).append("\n");
                resultado.append("Título: ").append(titulo).append("\n");
                resultado.append("Autor: ").append(autor).append("\n");
                resultado.append("Ano de Publicação: ").append(anoPublicacao).append("\n");
                resultado.append("Gênero: ").append(genero).append("\n");
                resultado.append("Número de Páginas: ").append(numeroPaginas).append("\n");
                resultado.append("----------------------\n");
            }

            JOptionPane.showMessageDialog(null, resultado.toString(), "Livros", JOptionPane.INFORMATION_MESSAGE);

            // Fechar os recursos
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        private static void inserirLivro() {
        // Lógica para inserir um novo livro no banco de dados
        String url = "jdbc:mysql://localhost:3306/livros";
        String usuario = "root";
        String senha = "";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Consulta de inserção 
            String inserirLivro = "INSERT INTO Livro (Titulo, Autor, Ano_Publicacao, Genero, Numero_Paginas) VALUES (?, ?, ?, ?, ?)";

            // Captura dos dados do novo livro 
            String titulo = JOptionPane.showInputDialog("Título do Livro:");
            String autor = JOptionPane.showInputDialog("Autor do Livro:");
            int anoPublicacao = Integer.parseInt(JOptionPane.showInputDialog("Ano de Publicação:"));
            String genero = JOptionPane.showInputDialog("Gênero do Livro:");
            int numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog("Número de Páginas:"));

            // Preparar a declaração de inserção
            PreparedStatement preparedStatement = connection.prepareStatement(inserirLivro);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setInt(3, anoPublicacao);
            preparedStatement.setString(4, genero);
            preparedStatement.setInt(5, numeroPaginas);

            // Executar a inserção
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Fechar os recursos
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
        private static void consultarEmprestimos(int userId) {
        // Lógica para consultar os empréstimos do usuário específico
        String url = "jdbc:mysql://localhost:3306/livros"; 
        String usuario = "root";
        String senha = "";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String consultaEmprestimos = "SELECT L.Titulo, L.Autor, E.Data_Emprestimo, E.Data_Devolucao_Prevista "
                    + "FROM Emprestimo E "
                    + "JOIN Livro L ON E.ID_Livro = L.ID "
                    + "WHERE E.ID_Usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(consultaEmprestimos);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder resultado = new StringBuilder();
            while (resultSet.next()) {
                String tituloLivro = resultSet.getString("Titulo");
                String autorLivro = resultSet.getString("Autor");
                String dataEmprestimo = resultSet.getString("Data_Emprestimo");
                String dataDevolucaoPrevista = resultSet.getString("Data_Devolucao_Prevista");

                resultado.append("Título: ").append(tituloLivro).append("\n");
                resultado.append("Autor: ").append(autorLivro).append("\n");
                resultado.append("Data de Empréstimo: ").append(dataEmprestimo).append("\n");
                resultado.append("Data de Devolução Prevista: ").append(dataDevolucaoPrevista).append("\n");
                resultado.append("----------------------\n");
            }

            JOptionPane.showMessageDialog(null, resultado.toString(), "Empréstimos (Usuário " + userId + ")", JOptionPane.INFORMATION_MESSAGE);

            // Fechar os recursos
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}