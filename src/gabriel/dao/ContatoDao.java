/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gabriel.dao;

import gabriel.bancodados.CriaConexao;
import gabriel.logica.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gabriel
 */
//O objeto da  classe PreparedStatement  leva o meu comando Sql p/o Banco
public class ContatoDao {
    //Argumento conexao do Tipo Connection
    private Connection conexao;
    //Passa a instancia de conexão do Banco p/ o construtor da classe ContatoDao
    public ContatoDao() throws SQLException{
        this.conexao= CriaConexao.getConexao();
    }
    public void adiciona(Contato c1) throws SQLException{
           //prepara Sql para envio pro Banco
        String sql = "insert into contato(nome,endereco,sexo,telefone,email)"+
                "values(?,?,?,?,?)";
        // Cria o statement - Objeto de interação de dados(Faz as execuçoes no banco)
        
                                              //Instrução Sql vai para o objeto "smtm" Statement        
        PreparedStatement smtm = conexao.prepareStatement(sql);
          //seta os valores
        
//O objeto "smtm" executa  o comando sql escolhido no Banco,
//passando o valor do argumento atual referenciado pela posição
        smtm.setString(1, c1.getNome());
        smtm.setString(2, c1.getEndereco());
        smtm.setString(3, c1.getSexo());
        smtm.setString(4, c1.getTelefone());
        smtm.setString(5, c1.getEmail());
        //executa o codigo sql
        smtm.execute();
        //fecha coneção
        smtm.close();
        
    }
    public List<Contato > getLista(String nome) throws SQLException{
        String sql = "select * from contato where nome like ?";
        PreparedStatement smtm = this.conexao.prepareStatement(sql);
        smtm.setString(1, nome);
        //ResultSet Repositorio com os Dados da pesquisa do Banco
        ResultSet pesquisa = smtm.executeQuery();
        //Variavel do tipo List para guardar os dados temporários do ResultSet
        List<Contato> minhalista = new ArrayList<Contato>();
        
        while(pesquisa.next()){
            Contato c1 = new Contato();
            c1.setId(Integer.valueOf(pesquisa.getString("id")));
            c1.setNome(pesquisa.getString("nome"));
            c1.setEndereco(pesquisa.getString("endereco"));
            c1.setSexo(pesquisa.getString("sexo"));
            c1.setTelefone(pesquisa.getString("telefone"));
            c1.setEmail(pesquisa.getString("email")); 
            minhalista.add(c1);
        }
        pesquisa.close();//Fecha ResultSet
        smtm.close();
        return minhalista;//Retorna o List
        
    }
    public void Altera(Contato c1) throws SQLException{
        String sql="update contato set nome=?,endereco=?,sexo=?,telefone=?,"
                + "email=? where id=?";
        PreparedStatement smtm = conexao.prepareStatement(sql);
        //seta os valores
        smtm.setString(1, c1.getNome());
        smtm.setString(2, c1.getEndereco());
        smtm.setString(3, c1.getSexo());
        smtm.setString(4, c1.getTelefone());
        smtm.setString(5, c1.getEmail());
        smtm.setInt(6,c1.getId());
          //executa o codigo sql
        smtm.execute();
        //fecha coneção
        smtm.close();
        
    }
    public void Remove(Contato c1) throws SQLException{
        String sql="delete from contato where id=?";
        PreparedStatement smtm = conexao.prepareStatement(sql);
        smtm.setInt(1, c1.getId());
        //executa o codigo sql
        smtm.execute();
        //fecha coneção
        smtm.close();
        
    }
   
    
}
