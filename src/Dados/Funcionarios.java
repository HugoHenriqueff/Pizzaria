package Dados;

public class Funcionarios {

   private String nome;
   private String senha;
   private int id ;
   private String cargo;
   private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   private UsuarioTipo tipo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public UsuarioTipo getTipo() {
        return tipo;
    }

    public void setTipo(UsuarioTipo tipo) {
        this.tipo = tipo;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
