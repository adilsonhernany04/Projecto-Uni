package Controles;

import Classes.Usuario;
import conectar.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Adilson Hernany
 */
public class ControleUsuario {

    PreparedStatement pdec = null;
    ResultSet rs = null;
    
    ArrayList<Usuario> verLista = new ArrayList<>();

    @SuppressWarnings("ConvertToTryWithResources")

    // METPODO PARA CADASTRAR
    public boolean cadastrarUsuario(Usuario usuario) {

        String cmdS = "INSERT INTO estudante ( nome, email, senha, endereco) VALUES (?, ?, ? , ? )";

        try {
            pdec = Conexao.pegarConexao().prepareStatement(cmdS);

            // Definir os valores dos parâmetros na instrução SQL
            pdec.setString(1, usuario.getNome()); // nome do estudante
            pdec.setString(2, usuario.getEmail()); // email do estudante
            pdec.setString(3, usuario.getSenha()); // endereco do estudante
            pdec.setString(4, usuario.getMorada()); // senha do estudante
            
            pdec.execute();
            pdec.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    //
    // METODO PARA LISTAR/MOSTRAR OS CADASTRADOS MODIFICADOS
    public ArrayList<Usuario> verRelatorioUsuarios() {
        String cmdS = "SELECT id_historico, data_accao, accao FROM escola.historico_estudantes";

        try {
            pdec = (PreparedStatement) Conexao.pegarConexao().prepareStatement(cmdS);
            rs = pdec.executeQuery();

            while (rs.next()) {

                Usuario us = new Usuario();
                us.setId_historico(rs.getInt(("id_historico")));
                us.setData_accaoTrigger(rs.getTimestamp(("data_accao")));
                us.setStatus_accao(rs.getString(("accao")));

                verLista.add(us);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verLista;
    } 
    
    // METODO PARA LISTAR/MOSTRARs OS CADASTRADOS
    public ArrayList<Usuario> VerUsuarios() {

        String cmdS = "SELECT id, nome, email, endereco, senha, dataCadastro FROM estudante";

        try {
            pdec = (PreparedStatement) Conexao.pegarConexao().prepareStatement(cmdS);
            rs = pdec.executeQuery();

            while (rs.next()) {

                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt("id"));
                us.setNome(rs.getString("nome"));
                us.setEmail(rs.getString("email"));
                us.setMorada(rs.getString("endereco"));
                us.setSenha(rs.getString("senha"));
                us.setDataCadastro(rs.getTimestamp(("dataCadastro")));

                verLista.add(us);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verLista;
    }

    //
    //
    // METODO PARA ACTUALIZAR OS DADOS DE USUARIOS CADASTRADOS
    public boolean actualizarDados(Usuario usuario) {

        String cmdS = "UPDATE escola.estudante SET nome = ?, email = ?,senha = ?, endereco = ?, dataActualizacao = ? "
                + "WHERE id = ?";
        
        try {
            pdec = Conexao.pegarConexao().prepareStatement(cmdS);
                        
            // Definir os valores dos parâmetros na instrução SQL
            pdec.setString(1, usuario.getNome()); // nome do estudante
            pdec.setString(2, usuario.getEmail()); // email do estudante
            pdec.setString(3, usuario.getSenha()); // endereco do estudante
            pdec.setString(4, usuario.getMorada()); // senha do estudante
            pdec.setTimestamp(5, new java.sql.Timestamp(new Date().getTime())); // data-actualizada apos registro ser actualizado
            
            // o id para seleccionar 
            pdec.setInt(6, usuario.getId_usuario()); // id do estudante
            
            pdec.executeUpdate();
            pdec.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    //
    // METODO PARA DELETAR USUARIO
    public boolean apagarUsuarioPeloId(int id) {
        String cmdS = "DELETE FROM estudante WHERE id = ? ";

        try {
            pdec = Conexao.pegarConexao().prepareStatement(cmdS);

            // Definir o valore do parâmetro na instrução SQL
            // o id para seleccionar 
            pdec.setInt(1, id); // id do estudante

            pdec.execute();
            pdec.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    //
    // METODO PARA PESQUISAR/BUSCAR USUARIO/s
    public ArrayList<Usuario> buscarUsuarioPeloNome(String nome) {
        
        String cmdS = "SELECT * FROM estudante WHERE nome LIKE ?"; // Consulta com LIKE para busca parcial
        
        try {
            pdec = Conexao.pegarConexao().prepareStatement(cmdS);

            // Definir o parâmetro com "%" para buscar por nomes semelhantes
            // 
            // pdec.setString(1, nome + "%"); // pega usuario pela inicial
            
            // pegar pelo nome semelhante 
            pdec.setString(1, "%" + nome + "%");

            ResultSet rs = pdec.executeQuery();

            // Processar os resultados da consulta
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id")); // Alterar o nome da coluna se necessário
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setMorada(rs.getString("endereco"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setDataCadastro(rs.getTimestamp("dataCadastro"));

                verLista.add(usuario);
            }

            rs.close();
            pdec.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verLista;
    }

}
