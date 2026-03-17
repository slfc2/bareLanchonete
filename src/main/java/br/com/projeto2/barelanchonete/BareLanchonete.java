
package br.com.projeto2.barelanchonete;

import br.com.projeto2.barelanchonete.controller.Banco;
import br.com.projeto2.barelanchonete.model.Produto;
import java.sql.Connection;
import java.sql.SQLException;
 
/**
 *
 * @author SergioLuiz Ferreira
 */
public class BareLanchonete {

    public static void main(String[] args) {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
       Produto l = new Produto("carne de sol", 15.00);
       
       b.salvar(l, conexao);
                
    }
}
