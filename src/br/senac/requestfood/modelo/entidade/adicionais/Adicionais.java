package br.senac.requestfood.modelo.entidade.adicionais;

public class Adicionais {
    private int quantidadeCopos;
    private int quantidadeTalheres;

    public Adicionais (int quantidadeCopos, int quantidadeTalheres) {
        setQuantidadeCopos(quantidadeCopos);
        setQuantidadeTalheres(quantidadeTalheres);
    }

    public void setQuantidadeCopos(int quantidadeCopos) {
        this.quantidadeCopos = quantidadeCopos;
    }

    public int getQuantidadeCopos() {
        return quantidadeCopos;
    }

    public void setQuantidadeTalheres(int quantidadeTalheres) {
        this.quantidadeTalheres = quantidadeTalheres;
    }

    public int getQuantidadeTalheres() {
        return quantidadeTalheres;
    }
}
