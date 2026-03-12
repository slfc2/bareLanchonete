package br.com.projeto2.barelanchonete.controller;

import br.com.projeto2.barelanchonete.model.Produto;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Banco {

    private String url;
    private String usuario;
    private String senha;

    public Banco() {
        url = "jdbc:mysql://localhost:3306/bareLanchonete";
        usuario = "root";
        senha = "slfc7532";

    }

    public Connection conectar() {
        try {

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conectado ao banco de dados");

            return conexao;
        } catch (SQLException e) {

            System.out.println("Não foi possivel conectar ao banco de dados");

            return null;
        }
    }

    public void salvar(Produto produto, Connection conexao) {

        String sql = "INSERT INTO produto(nome, preco) VALUES(?, ?)";
        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            
            int  linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0){
               System.out.println("Produto adicionado com sucesso!");
            }
        } catch(SQLException e) {
            System.out.println("Produto não foi adicionado no banco de dados !");
        }
    }

}
