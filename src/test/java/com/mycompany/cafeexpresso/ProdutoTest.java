
package com.mycompany.cafeexpresso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProdutoTest {
    
    @Test
    public void deveCriarProdutoComDadosCorretos() {
        System.out.println("Teste Criar Produto com Dados Corretos");
        String nomeEsperado = "Café com Leite";
        double precoEsperado = 5.50;
        
        Produto instance = new Produto(nomeEsperado, precoEsperado); // Instancia um objeto da classe Produto
        
        // Verificação
        assertAll("Verificação de atributos do produto",
            () -> assertEquals(nomeEsperado, instance.getNome(), "O nome deve ser igual ao fornecido"),
            () -> assertEquals(precoEsperado, instance.getPrecoUnitario(), "O preço deve ser igual ao fornecido")
        );
    }
    
}
