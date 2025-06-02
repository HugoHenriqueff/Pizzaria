package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private Connection conn;

  public Connection getConnection() {
        return conn;
    }


    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "Hugo22gh");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    public void closeConn(){
        try{
            if(conn!= null && !conn.isClosed()){
                conn.close();
            }
        }catch(SQLException ex){
            System.out.println("Erro ao fechar conexao");
        }
    }
    

    public static Funcionarios validarUsuarioSeguro(Funcionarios funcionario) {
        String sql = "SELECT * FROM funcionarios WHERE nome = ? AND senha = ?";
        Funcionarios usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "Hugo22gh");
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSenha());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Funcionarios();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                UsuarioTipo usuariotipo = UsuarioTipo.valueOf(rs.getString("cargo").toUpperCase());
                usuarioEncontrado.setTipo(usuariotipo);

            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }
}
