package com.mycompany.cafeexpresso;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ItemPedidoTest {
    
    @beforeEach
    void setUp() {

    }


    // Primeiro teste: Criar um ItemPedido com dados corretos e verificar se os atributos estão sendo atribuídos corretamente.

    @Test
    void deveCriarItemPedidoComDadosCorretos() {
        System.out.println("Teste Criar ItemPedido com Dados Corretos");
        Produto produtoEsperado = new Produto("Café com Leite", 5.50); // cria um produto esperado para o teste
        ItemPedido instance = new ItemPedido(2, produtoEsperado); // Instancia um objeto da classe ItemPedido

        // Verificação
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
    
}