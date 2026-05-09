package com.mycompany.cafeexpresso;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ItemPedidoTest {

    // Primeiro teste: Criar um ItemPedido com dados corretos e verificar se os atributos estão sendo atribuídos corretamente.

    @Test
    void deveCriarItemPedidoComDadosCorretos() {
        System.out.println("Teste Criar ItemPedido com Dados Corretos");
        Produto produtoEsperado = new Produto("Café com Leite", 5.50); // cria um produto esperado para o teste
        ItemPedido instance = new ItemPedido(2, produtoEsperado); // Instancia um objeto da classe ItemPedido

        assertAll("Verificação de atributos do item pedido",
            () -> assertEquals(2, instance.getQuantidade(), "A quantidade deve ser igual ao fornecido"),
            () -> assertEquals(produtoEsperado, instance.getProduto(), "O produto deve ser igual ao fornecido")
        );
    }

    @Test
    void devePermitirAlterarQuantidadedoProduto() {
        System.out.println("Teste Alterar Quantidade do ItemPedido");
        Produto produto = new Produto("Café com Leite", 5.50);
        ItemPedido instance = new ItemPedido(2, produto); // Instancia um objeto da classe ItemPedido

        instance.setQuantidade(3); // Altera a quantidade para 3

        // Verificação
        assertEquals(3, instance.getQuantidade(), "A quantidade deve ser atualizada para o novo valor");
    }
    
    @Test
    void devePermitirAlterarProdutoDoItemPedido() {
        System.out.println("Teste Alterar Produto do ItemPedido");
        Produto produtoInicial = new Produto("Café com Leite", 5.50);
        Produto produtoNovo = new Produto("Café Preto", 4.00);
        ItemPedido instance = new ItemPedido(2, produtoInicial); // Instancia um objeto da classe ItemPedido

        instance.setProduto(produtoNovo); // Altera o produto para o novo produto

        assertEquals(produtoNovo, instance.getProduto(), "O produto deve ser atualizado para o novo");
    }

    @Test
    void deveCalcularPrecoTotalDoItemPedido() {
        Produto produto = new Produto("Café com Leite", 5.50);
        ItemPedido instance = new ItemPedido(2, produto); // Instancia um objeto da classe ItemPedido

        double precoTotalEsperado = 2 * 5.50; // Calcula o preço total esperado (quantidade * preço unitário)

        assertEquals(precoTotalEsperado, instance.getPreco(), "O preço total do item pedido deve ser calculado corretamente");
    }
}