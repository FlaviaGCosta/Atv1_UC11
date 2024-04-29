/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;





public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    private conectaDAO conexaoBD;
    
    public ProdutosDAO() {
        conexaoBD = new conectaDAO();
    }
    
     public boolean cadastrarProduto(ProdutosDTO produto) throws SQLException {
        boolean sucesso = false;
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)"; 

        try (Connection conn = conexaoBD.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());

            int affectedRows = stmt.executeUpdate();
            sucesso = affectedRows > 0;
        }
        return sucesso;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

