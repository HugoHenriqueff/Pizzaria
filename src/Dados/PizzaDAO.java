package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    private Connection conn;

    public PizzaDAO() {
        Conexao conexao = new Conexao();
        if (conexao.conectar()) {
            this.conn = conexao.getConnection();
        } else {
            System.out.println("Não foi possivel conectar");
        }

    }

    public int cadastrarFuncionarios(Funcionarios funcionario) {
        int status;
        String sql = "INSERT INTO funcionarios (nome,senha,cargo,email) VALUES(?,?,?,?)";
        try ( PreparedStatement st = conn.prepareStatement(sql)) {
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
        String sql = "INSERT INTO clientes (nome,datadenascimento,email) VALUES(?,?,?)";
        try ( PreparedStatement st = conn.prepareStatement(sql)) {
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
            {
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
            {
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
