package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao = null;
    private static final String url = "jdbc:mysql://localhost:3306/escola";
    private static final String user = "root";
    private static final String password = "root";

    // Método para obter a conexão com o banco de dados
    public static Connection pegarConexao() {
        // Configurações do banco de dados

        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(url, user, password);

                return conexao;
            } else {
                return conexao;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para fechar a conexão
    public static void fechaConexao() {
        if (conexao != null) {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão fechada com sucesso!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
