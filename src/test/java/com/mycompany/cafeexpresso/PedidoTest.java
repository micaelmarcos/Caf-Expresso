package com.mycompany.cafeexpresso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PedidoTest {
    // testar se o método calcularTotal() retorna o valor correto para um pedido com vários itens.
    @Test
    public void deveCalcularTotalCorretamente() {
        System.out.println("Teste Calcular Total do Pedido");
        Pedido instance = new Pedido(); // Instancia um objeto da classe Pedido

        // Criar produtos e itens de pedido
        Produto produto1 = new Produto("Café com Leite", 5.50);
        Produto produto2 = new Produto("Café Preto", 4.00);
        ItemPedido item1 = new ItemPedido(2, produto1); // 2 unidades de Café com Leite
        ItemPedido item2 = new ItemPedido(3, produto2); // 3 unidades de Café Preto

        // Adicionar itens ao pedido
        instance.adicionarItem(item1);
        instance.adicionarItem(item2);

        // Calcular o total esperado
        double totalEsperado = (2 * 5.50) + (3 * 4.00); // Total esperado: 11.00 + 12.00 = 23.00

        // Verificar se o total calculado é igual ao total esperado
        assertEquals(totalEsperado, instance.calcularTotal(), "O total calculado deve ser igual ao total esperado");
    }
}
