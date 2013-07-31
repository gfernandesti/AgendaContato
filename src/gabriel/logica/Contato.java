/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gabriel.logica;

/**
 *
 * @author gabriel
 */
//Classe Contato
public class Contato {
    //Atributos da Classe do tipo private
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String sexo;
//Acesso à Atributos do tipo private ocorre por Getters e Setters
//Para gerar de forma automatica ->Codigo-Fonte->Inserir Código->Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String email;
    
}
