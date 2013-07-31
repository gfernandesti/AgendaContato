/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gabriel.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author gabriel
 */
//Uma variavel ou um Metodo deve receber o tipo classe "Connection"
//A classe DriverManager é a responsável por se comunicar com todos os drivers
//que você deixou disponível. Para isso, invocamos o método estático getConnection
//com uma String que indica a qual banco desejamos nos conectar(passamos o endereço
//junto com dados de login.
             //Classe
public class CriaConexao {
                  //Tipo   //NomedoMetodo  //Lança uma excessão de erro SQl
    public static Connection getConexao()throws SQLException{
        try{
            //Class.forName Passa o endereço do Driver após
            //a versão 3 do JDBC não é obrigatório referenciar..
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Conecatado ao Banco!");
            //Retorna os valores passados p/ o metodo "getConexao"
            return DriverManager.getConnection("jdbc:mysql://localhost/agendabd","root","cancer");
        }
        //Joga excessao caso não encontre as classes JDBC
        catch(ClassNotFoundException e){
            throw  new SQLException(e.getMessage());
        }
    }
    
}
