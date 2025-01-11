
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/casa_leiloes"; // Substitua "seu_banco" pelo nome do banco
            String user = "root"; // Usuário do banco
            String password = "skyline_r34"; // Senha do banco

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conn;
    }
}
