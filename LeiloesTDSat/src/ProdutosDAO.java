
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;

    // Método para cadastrar um produto
    public void cadastrarProduto(ProdutosDTO produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try (Connection conn = new conectaDAO().connectDB(); PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, produto.getNome());
            prep.setDouble(2, produto.getValor());  // Usando valor, que parece ser o campo correto
            prep.setString(3, produto.getStatus());

            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso no banco de dados!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
            e.printStackTrace();  // Logando a exceção
        }
    }

    // Método para salvar um produto no banco de dados
    public boolean salvarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        boolean sucesso = false;

        try (Connection conn = new conectaDAO().connectDB(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());  // Usando valor aqui também
            stmt.setString(3, produto.getStatus());

            int linhasAfetadas = stmt.executeUpdate();
            sucesso = linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();  // Logando a exceção
        }

        return sucesso;
    }

    // Método para listar todos os produtos
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException {
        String sql = "SELECT * FROM produtos";
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        try (Connection conn = new conectaDAO().connectDB(); PreparedStatement prep = conn.prepareStatement(sql); ResultSet resultset = prep.executeQuery()) {

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setDescricao(resultset.getString("descricao"));
                produto.setValor(resultset.getDouble("valor"));  // Ajuste para refletir o campo correto

                listagem.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
            e.printStackTrace();  // Logando a exceção
        }

        return listagem;
    }

    // Método para listar produtos vendidos
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>();

        try (Connection conn = new conectaDAO().connectDB(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));  // Usando valor correto
                produto.setStatus(rs.getString("status"));
                produtosVendidos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Logando a exceção
        }
        return produtosVendidos;
    }

    // Método para vender um produto
    public void venderProduto(int id) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

        try (Connection conn = new conectaDAO().connectDB(); PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setInt(1, id);

            int rowsUpdated = prep.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado com ID: " + id);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
            e.printStackTrace();  // Logando a exceção
        }
    }

}
