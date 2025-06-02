package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CaixaDAO {

    private Connection conn;

    public CaixaDAO() {
        Conexao conexao = new Conexao();
        if (conexao.conectar()) {
            this.conn = conexao.getConnection();
        } else {
            System.out.println("Não foi possivel conectar");
        }

    }

    public int cadastrarCaixa(Pedido pedido) {
        int status;
        String sql = "INSERT INTO caixa (descricao,Funcao,data,valor) VALUES(?,?,?,?)";
        try ( PreparedStatement st = conn.prepareStatement(sql)) {
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
}
