
package Controles;

import Classes.Usuario;
import conectar.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import View.UsuarioView;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Adilson Hernany
 */
public class ControleUsuario {

    public void cadastrarUsuario(Usuario usuario) throws SQLException {

        String cmdS = "INSERT INTO estudante VALUES (?, ?, ?, ? , ?)";

        PreparedStatement pdec = null;

        try {
            pdec = Conexao.pegarConexao().prepareStatement(cmdS);

            // Definir os valores dos parâmetros na instrução SQL
            pdec.setString(1, null); // id do estudante
            pdec.setString(2, usuario.getNome()); // nome do estudante
            pdec.setString(3, usuario.getEmail()); // email do estudante
            pdec.setString(4, usuario.getSenha()); // endereco do estudante
            pdec.setString(5, usuario.getEndereco()); // senha do estudante
            
            pdec.execute();
            pdec.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pdec != null) pdec.close();
            if (Conexao.pegarConexao() != null) Conexao.close();
        }

    }
    //
    //

    //
    public List<Usuario> Ver() {

        String cmdS = "SELECT id, nome, email, endereco FROM estudante";

        List<Usuario> ver = new ArrayList<>();
        
        PreparedStatement pdec = null;
        ResultSet rs = null;
                
        try {
            pdec = (PreparedStatement) Conexao.pegarConexao().prepareStatement(cmdS);
            rs = pdec.executeQuery();
            
            while(rs.next()) {
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt("id"));
                us.setNome(rs.getString("nome"));
                us.setNome(rs.getString("email"));
                us.setNome(rs.getString("endereco"));
                
                ver.add(us);            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+ e.getMessage());
            e.printStackTrace();
        } 
        return ver;
    }
        

}
