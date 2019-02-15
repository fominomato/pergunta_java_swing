package service;

import entity.CategoriaModel;
import entity.PratoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe para gerir servicos da lista de pratos
 */
public class GeraResposta {

    /**
     * Lista do modelo de dados para pratos
     */
    public static List<PratoModel> listPratoModels = new ArrayList<PratoModel>();

    /**
     * Inicializa a lista
     * @return void
     */
    public void init() {
        listPratoModels.add(new PratoModel("Lasanha", "massa",  new CategoriaModel("Principal")));
        listPratoModels.add(new PratoModel("Bolo de Chocolate","", new CategoriaModel("Alternativo")));
    }

    /**
     * Funcionalidade para adicionar novo item a lista de pratos
     * @param nomePrato String nome do prato
     * @param tipo String Tipo do Prato
     * @param categoria String Nome da categoria
     */
    public void add(String nomePrato, String tipo, String categoria) {
        listPratoModels.add(new PratoModel(nomePrato, tipo, new CategoriaModel(categoria)));
    }

    /**
     * Pesquisar item na lista
     * @param pos int Posicao na lista
     * @param tipo String Nome do tipo do prato
     * @param categoria Nome da categoria (Principal e Alternativo)
     * @return PratoModel
     */
    public PratoModel get(int pos, String tipo, String categoria) {
        List<PratoModel> filtrado = listPratoModels.stream()
                .filter((r) -> categoria.equals(r.getCategoriaModel().getNome()))
                .collect(Collectors.toList());

        if (tipo != null && !tipo.isEmpty()) {
            filtrado = filtrado.stream()
                    .filter((r) -> tipo.equals(r.getTipo()))
                    .collect(Collectors.toList());
        }
        try {
            return filtrado.get(pos);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
