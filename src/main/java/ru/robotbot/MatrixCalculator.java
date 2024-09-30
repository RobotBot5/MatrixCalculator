package ru.robotbot;

public class MatrixCalculator {

    // 1 Блок
    // 1. Сложение двух матриц
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // 2. Нахождение детерминанта (для 2x2 матрицы)
    public static int findDeterminant(int[][] matrix) {
        if (matrix.length == 2 && matrix[0].length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            throw new IllegalArgumentException("Матрица должна быть 2х2");
        }
    }

    // 3. Проверка, является ли матрица единичной
    public static boolean isIdentityMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 4. Вычитание одной матрицы из другой
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // 5. Нахождение обратной матрицы (для 2x2 матрицы)
    public static double[][] invertMatrix(int[][] matrix) {
        if (matrix.length == 2 && matrix[0].length == 2) {
            int det = findDeterminant(matrix);
            if (det == 0) throw new ArithmeticException("Матрица необратима");
            double[][] result = new double[2][2];
            result[0][0] = matrix[1][1] / (double) det;
            result[0][1] = -matrix[0][1] / (double) det;
            result[1][0] = -matrix[1][0] / (double) det;
            result[1][1] = matrix[0][0] / (double) det;
            return result;
        } else {
            throw new IllegalArgumentException("Матрица должна быть 2х2");
        }
    }

    // 2 Блок
    // 6. Умножение двух матриц
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // 7. Умножение матрицы на скаляр
    public static int[][] scalarMultiplyMatrix(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    // 8. Проверка, является ли матрица симметричной
    public static boolean isSymmetric(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 9. Нахождение следа матрицы (сумма элементов на главной диагонали)
    public static int traceMatrix(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    // 10. Нахождение суммы всех элементов матрицы
    public static int sumOfElements(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    // 3 Блок
    // 11. Транспонирование матрицы
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // 12. Проверка, является ли матрица диагональной
    public static boolean isDiagonalMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // 13. Установка значения элемента по индексу
    public static void setElement(int[][] matrix, int row, int col, int value) {
        matrix[row][col] = value;
    }

    // 14. Нахождение максимального элемента в матрице
    public static int findMaxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    // 15. Поворот матрицы на 90 градусов по часовой стрелке
    public static int[][] rotateMatrixClockwise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = matrix[i][j];
            }
        }
        return result;
    }

    // 4 Блок
    // 16. Нахождение минимального элемента в матрице
    public static int findMinElement(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    // 17. Проверка, является ли матрица квадратной
    public static boolean isSquareMatrix(int[][] matrix) {
        if (matrix.length == 0) return true;
        return matrix.length == matrix[0].length;
    }

    // 18. Проверка, является ли матрица верхней треугольной
    public static boolean isUpperTriangular(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) return false;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // 19. Получение элемента матрицы по индексу
    public static int getElement(int[][] matrix, int row, int col) {
        return matrix[row][col];
    }

    // 20. Отражение матрицы по горизонтали
    public static int[][] flipMatrixHorizontally(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][cols - 1 - j];
            }
        }
        return result;
    }
}

