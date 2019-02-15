package entity;

public class PratoModel {

    private String nome;

    private String tipo;

    private CategoriaModel categoriaModel;

    public PratoModel(String nome, String tipo, CategoriaModel categoriaModel) {
        this.nome = nome;
        this.tipo = tipo;
        this.categoriaModel = categoriaModel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaModel getCategoriaModel() {
        return categoriaModel;
    }

    public void setCategoriaModel(CategoriaModel categoriaModel) {
        this.categoriaModel = categoriaModel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
