package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

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

    public int cadastrarCaixa(Pedido pedido) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO caixa (descricao,Funcao,data,valor) VALUES(?,?,?)");
            st.setString(1, pedido.getDescricao());
            st.setString(2, pedido.getFuncao());
            st.setString(3, pedido.getData());
            st.setString(4, pedido.getValor());
            status = st.executeUpdate();
            System.out.println("Conexão realizada com sucesso");
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar : " + ex.getMessage());
            return ex.getErrorCode();
        }

    }

    public int cadastrarFuncionarios(Funcionarios funcionario) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO funcionarios (nome,senha,cargo,email) VALUES(?,?,?,?)");
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getSenha());
            st.setString(3, funcionario.getCargo());
            st.setString(4, funcionario.getEmail());
            status = st.executeUpdate();
            System.out.println("Conexão realizada com sucesso");
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar : " + ex.getMessage());
            return ex.getErrorCode();
        }

    }

    public int cadastrarClientes(Cliente cliente) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO clientes (nome,datadenascimento,email) VALUES(?,?,?)");
            st.setString(1, cliente.getNome());
            st.setString(3, cliente.getDatadenascimento());
            st.setString(2, cliente.getEmail());
            status = st.executeUpdate();
            System.out.println("Conexão realizada com sucesso");
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar : " + ex.getMessage());
            return ex.getErrorCode();
        }

    }

    public List<Funcionarios> getFuncionario() {
        if (this.conn == null) {
            if (!conectar()) {
                System.out.println("Não foi possível estabelecer a conexão.");
                return null;
            }
        }
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Funcionarios> lista = new ArrayList<>();
            while (rs.next()) {
                Funcionarios FUN = new Funcionarios();
                FUN.setId(rs.getInt("id"));
                FUN.setNome(rs.getString("Nome"));
                FUN.setCargo(rs.getString("Cargo"));
                FUN.setEmail(rs.getString("Email"));

                lista.add(FUN);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> getCliente() {
        if (this.conn == null) {
            if (!conectar()) {
                System.out.println("Não foi possível estabelecer a conexão.");
                return null;
            }
        }
        String sql = "SELECT * FROM clientes";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setDatadenascimento(rs.getString("datadenascimento"));
                cliente.setEmail(rs.getString("Email"));

                lista.add(cliente);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
