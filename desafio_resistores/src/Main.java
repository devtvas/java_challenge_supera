//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /* DOC:

    Entrada inválida: Se a entrada for algo como "4.7k" (sem "ohms"),
    ou um formato numérico inválido, o programa retornará uma mensagem de erro apropriada.

    Valores fora do intervalo: Para valores que não podem ser mapeados
    corretamente para a tabela de cores, uma mensagem de "Valor fora do
    intervalo suportado" ou "Erro: Valor fora do intervalo" será retornada.

    */

    public static void main(String[] args) {
        String resistor = "4.7k ohms";
        String codigoCor  = ConversorOhmsParaCor.converter(resistor);
        System.out.println("Código de cores: " + codigoCor);
    }
}