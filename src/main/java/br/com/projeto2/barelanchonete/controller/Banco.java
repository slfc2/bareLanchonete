package br.com.projeto2.barelanchonete.controller;

import br.com.projeto2.barelanchonete.model.Produto;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {

    private String url;
    private String usuario;
    private String senha;
    

    public Banco() {
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "slfc7532";
        
       iniciarBanco(url,usuario,senha);

    }

    public Connection conectar() {
        try {
            
            url ="jdbc:mysql://localhost:3306/bareLanchonete";
            usuario = "root";
            senha = "slfc7532";
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
    public  void iniciarBanco(String url, String usuario, String senha){
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "slfc7532";
        
        try{
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement stmt = conexao.createStatement();
        
        try {
            InputStream is = new FileInputStream("banco.sql");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            String linha;
            StringBuilder sql = new StringBuilder();
            
            linha = br.readLine();
            
            while(linha != null) {
                System.out.println(linha);
                sql.append(linha).append("\n");
                
                if(linha.trim().endsWith(";")){
                   stmt.execute(sql.toString());
                   sql.setLength(0);
                }
                
                linha = br.readLine();
            }
            
            stmt.close();
            conexao.close();
            
        } catch(Exception e) {
            System.out.println("Não foi possivel ler o arquivo banco.sql");
        }
        
        } catch(SQLException e){
            System.out.println("Erro ao conectar no banco de dados no metodo iniciarbanco");
    }
    }
}

