
package Controles;

import Classes.Usuario;
import conectar.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Adilson Hernany
 */
public class ControleTabela {

    public void cadastrarUsuario(Usuario usuario) {

        String cmdS = "INSERT INTO estudante VALUES (?, ?, ?, ? , ?)";

        PreparedStatement pdec = null;

        try {
            pdec = Conexao.getConnection().prepareStatement(cmdS);

            // Definir os valores dos parâmetros na instrução SQL
            pdec.setString(1, null); // nome do estudante
            pdec.setString(2, usuario.getNome()); // nome do estudante
            pdec.setString(3, usuario.getEmail()); // email do estudante
            pdec.setString(4, usuario.getSenha()); // senha do estudante
            pdec.setString(5, usuario.getSenha()); // endereco do estudante
            
            pdec.execute();
            pdec.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
