
package br.com.projeto2.barelanchonete.model;

import java.util.ArrayList;

/**
 *
 * @author sluiz
 */
public class Carrinho {
    private ArrayList<Produto> produtos;
    
    public Carrinho(){
        produtos = new ArrayList<>();
    }
 
    public void adicionarCarrinho(Produto produto){
    
        produtos.add(produto);
    }
    
    public void removerProdutoCarrinho(int id){
        for(int i=0; i<produtos.size(); i++){
            if (produtos.get(i).getId() == id){
                produtos.remove(produtos.get(i));
                i=produtos.size();
            }
            
        }
    }
    
    public double calcularPreco(){
        double total = 0;
        for (Produto produto: produtos){
            total += produto.getPreco();
        }
      return total;
    }
    
    public ArrayList<Produto> getProdutos(){
         return produtos;
    }
 }
    

