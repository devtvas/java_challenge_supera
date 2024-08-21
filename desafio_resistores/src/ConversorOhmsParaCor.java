import java.math.BigDecimal;
import java.math.RoundingMode;

class ConversorOhmsParaCor {
    private static final String[] COLORS = {"preto", "marrom", "vermelho", "laranja", "amarelo", "verde", "azul", "violeta", "cinza", "branco"};
    private static final String[] MULTIPLIERS = {"preto", "marrom", "vermelho", "laranja", "amarelo", "verde", "azul", "violeta", "cinza", "branco"};
    private static final String TOLERANCE = "dourado"; // Representa 5% de tolerância

    public static String converter(String resistorValue) {
        try {
            BigDecimal ohms = parseOhms(resistorValue);

            if (ohms.compareTo(BigDecimal.ZERO) < 0) {
                return "Valor inválido";
            }

            int[] digits = getDigits(ohms);
            int multiplier = getMultiplier(ohms);

            StringBuilder sb = new StringBuilder();

            if (multiplier < MULTIPLIERS.length) {
                sb.append(COLORS[digits[0]]).append(" ")
                        .append(COLORS[digits[1]]).append(" ")
                        .append(MULTIPLIERS[multiplier]).append(" ")
                        .append(TOLERANCE);
            } else {
                sb.append("Valor fora do intervalo suportado");
            }

            return sb.toString().trim();
        } catch (NumberFormatException e) {
            return "Erro: Formato de número inválido";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Erro: Valor fora do intervalo";
        } catch (Exception e) {
            return "Erro: Entrada inválida";
        }
    }

    private static BigDecimal parseOhms(String resistorValue) {
        if (resistorValue.endsWith("ohms")) {
            resistorValue = resistorValue.replace(" ohms", "");
        }

        try {
            BigDecimal value = new BigDecimal(resistorValue.replaceAll("[^0-9.]", ""));
            if (resistorValue.contains("k")) {
                value = value.multiply(BigDecimal.valueOf(1000));
            } else if (resistorValue.contains("M")) {
                value = value.multiply(BigDecimal.valueOf(1000000));
            } else if (resistorValue.contains("G")) {
                value = value.multiply(BigDecimal.valueOf(1000000000));
            } else if (resistorValue.contains("T")) {
                value = value.multiply(BigDecimal.valueOf(1000000000000L));
            } else if (resistorValue.contains("P")) {
                value = value.multiply(BigDecimal.valueOf(1000000000000000L));
            } else if (resistorValue.contains("E")) {
                value = value.multiply(BigDecimal.valueOf(1000000000000000000L));
            } else if (resistorValue.contains("Z")) {
                value = value.multiply(new BigDecimal("1000000000000000000000"));
            } else if (resistorValue.contains("Y")) {
                value = value.multiply(new BigDecimal("1000000000000000000000000"));
            }
            return value;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Formato de número inválido");
        }
    }

    private static int[] getDigits(BigDecimal ohms) {
        try {
            BigDecimal scaledOhms = ohms.setScale(0, RoundingMode.DOWN);
            String ohmsStr = scaledOhms.toPlainString();
            int hundreds = Character.getNumericValue(ohmsStr.charAt(0));
            int tens = Character.getNumericValue(ohmsStr.charAt(1));
            return new int[]{hundreds, tens};
        } catch (IndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Valor fora do intervalo para extração de dígitos");
        }
    }

    private static int getMultiplier(BigDecimal ohms) {
        int magnitude = ohms.precision() - 1;
        return magnitude - 1; // -1 para ajustar o índice na tabela de cores
    }

}
