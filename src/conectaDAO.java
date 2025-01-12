
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    public Connection connectDB() throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/casa_leiloes"; // Substitua "seu_banco" pelo nome do banco
            String user = "root"; // Usuário do banco
            String password = "skyline_r34"; // Senha do banco

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados", e);
        }
        return conn;
    }
}
