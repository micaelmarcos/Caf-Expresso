package com.mycompany.cafeexpresso;

public class Produto {
    String nome;
    double precoUnitario;
    
    
    // Construtor
    public Produto(String nome, double precoUnitario) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
    public int somar(int a, int b) {
        return a+b;
    }
        
    
}
