package domain;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor completo
    public Data(int dia, int mes, int ano) {
        if (ano < 0 || Double.isNaN(ano) || ano == 0 || String.valueOf(ano).length() > 4) {
            throw new IllegalArgumentException("Ano inválido. Deve ser um valor positivo no formato de 4 dígitos.");
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido. Deve estar entre 1 e 12.");
        }
        if (dia < 1 || dia > diasNoMes(mes, ano)) {
            throw new IllegalArgumentException("Dia inválido para o mês e ano fornecidos.");
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Getters
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAno() {
        return ano;
    }

    // Setters com validação
    public void setDia(int dia) {
        if (dia < 1 || dia > diasNoMes(this.mes, this.ano)) {
            throw new IllegalArgumentException("Dia inválido para o mês e ano atuais.");
        }
        this.dia = dia;
    }
    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido. Deve estar entre 1 e 12.");
        }
        // Ajusta o dia se o novo mês tiver menos dias que o dia atual
        if (this.dia > diasNoMes(mes, this.ano)) {
            this.dia = diasNoMes(mes, this.ano);
        }
        this.mes = mes;
    }
    public void setAno(int ano) {
        if (ano < 0) {
            throw new IllegalArgumentException("Ano inválido. Deve ser um valor positivo.");
        }
        // Ajusta o dia se fevereiro for afetado por mudança de ano bissexto
        if (this.mes == 2 && this.dia == 29 && !verificaAnoBissexto(ano)) {
            this.dia = 28;
        }
        this.ano = ano;
    }

    // Método para verificar se um ano é bissexto
    public boolean verificaAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método para obter o número de dias em um mês
    private int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return verificaAnoBissexto(ano) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Mês inválido.");
        }
    }

    // Representação em String do objeto Data
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}