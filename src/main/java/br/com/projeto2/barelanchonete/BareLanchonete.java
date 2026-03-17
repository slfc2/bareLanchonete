
package br.com.projeto2.barelanchonete;

import br.com.projeto2.barelanchonete.controller.Banco;
import br.com.projeto2.barelanchonete.model.Produto;
import br.com.projeto2.barelanchonete.view.GUIMenu;
import java.sql.Connection;
import java.sql.SQLException;
 
/**
 *
 * @author SergioLuiz Ferreira
 */
public class BareLanchonete {
    /*
    public static void main(String[] args) {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
       Produto l = new Produto("carne de sol", 15.00);
       
       b.salvar(l, conexao);
                
    }*/
    public static void main(String args[]) {
       GUIMenu janelaPrincipal = new GUIMenu();
       Banco b = new Banco();
       b.iniciarBanco();
       b = null;
       //Connection conexao = b.conectar();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> janelaPrincipal.setVisible(true));
        janelaPrincipal.getjInternalFrameCadastroProduto().setVisible(false);
        
    }
}
