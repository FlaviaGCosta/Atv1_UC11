
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class conectaDAO {
    
    private static final String URL = "jdbc:mysql://localhost:3306/uc11?useSSL=false";
    private static final String USER = "root";
    //colocar sua senha
    private static final String PASS = "SUA-SENHA";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                // Aqui você poderia logar o erro usando um Logger ou rethrow a exceção
                throw new RuntimeException("Erro ao fechar conexão com o banco de dados", e);
            }
        }
    }
}