public class Matrix_Snail {
        public static void spiralMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
            int count = 0;

            while (top <= bottom && left <= right) {
                // Mover da esquerda para a direita no limite superior
                for (int i = left; i <= right; i++) {
                    System.out.print(matrix[top][i] + " ");
                    count++;
                }
                top++;

                // Mover de cima para baixo no limite direito
                for (int i = top; i <= bottom; i++) {
                    System.out.print(matrix[i][right] + " ");
                    count++;
                }
                right--;

                // Mover da direita para a esquerda no limite inferior
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        System.out.print(matrix[bottom][i] + " ");
                        count++;
                    }
                    bottom--;
                }

                // Mover de baixo para cima no limite esquerdo
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        System.out.print(matrix[i][left] + " ");
                        count++;
                    }
                    left++;
                }
            }
        }
}
