
package Classes;

import java.util.Date;

/**
 *
 * @author Adilson Hernany
 */
public class Usuario {
    private int id_usuario;
    private String nome;
    private String email;
    private String senha;
    private String morada;
    private Date dataCadastro;
    private Date dataActualizacao;
    
    private int id_historico;
    private Date data_accaoTrigger;
    private String status_accao;

    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataActualizacao() {
        return dataActualizacao;
    }

    public void setDataActualizacao(Date dataActualizacao) {
        this.dataActualizacao = dataActualizacao;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    
    
    public Date getData_accaoTrigger() {
        return data_accaoTrigger;
    }

    public void setData_accaoTrigger(Date data_accaoTrigger) {
        this.data_accaoTrigger = data_accaoTrigger;
    }

    public String getStatus_accao() {
        return status_accao;
    }

    public void setStatus_accao(String status_accao) {
        this.status_accao = status_accao;
    }

    
    
    
    
}
