package ru.robotbot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixCalculatorTest {

    // 1 Блок
    // 1. Тест для сложения двух матриц
    @Test
    void testAddMatrices() {
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        int[][] matrix2 = {
                {5, 6},
                {7, 8}
        };
        int[][] expected = {
                {6, 8},
                {10, 12}
        };
        assertArrayEquals(expected, MatrixCalculator.addMatrices(matrix1, matrix2));
    }

    // 2. Тест для нахождения детерминанта 2x2 матрицы
    @Test
    void testFindDeterminant() {
        int[][] matrix = {
                {4, 6},
                {3, 8}
        };
        int expected = 14; // 4*8 - 6*3 = 32 - 18 = 14
        assertEquals(expected, MatrixCalculator.findDeterminant(matrix));
    }

    @Test
    void testFindDeterminantThrowsExceptionForNon2x2() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertThrows(IllegalArgumentException.class, () -> MatrixCalculator.findDeterminant(matrix), "Матрица должна быть 2х2");
    }

    // 3. Тест для проверки, является ли матрица единичной
    @Test
    void testIsIdentityMatrix() {
        int[][] identityMatrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int[][] nonIdentityMatrix1 = {
                {1, 0, 0},
                {0, 2, 0},
                {0, 0, 1}
        };
        int[][] nonIdentityMatrix2 = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };
        assertTrue(MatrixCalculator.isIdentityMatrix(identityMatrix));
        assertFalse(MatrixCalculator.isIdentityMatrix(nonIdentityMatrix1));
        assertFalse(MatrixCalculator.isIdentityMatrix(nonIdentityMatrix2));
    }

    // 4. Тест для вычитания одной матрицы из другой
    @Test
    void testSubtractMatrices() {
        int[][] matrix1 = {
                {5, 6},
                {7, 8}
        };
        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {4, 4},
                {4, 4}
        };
        assertArrayEquals(expected, MatrixCalculator.subtractMatrices(matrix1, matrix2));
    }

    // 5. Тест для нахождения обратной матрицы (для 2x2 матрицы)
    @Test
    void testInvertMatrix() {
        int[][] matrix = {
                {4, 7},
                {2, 6}
        };
        double[][] expected = {
                {0.6, -0.7},
                {-0.2, 0.4}
        };
        assertArrayEquals(expected, MatrixCalculator.invertMatrix(matrix));
    }

    @Test
    void testInvertMatrixThrowsExceptionForNonInvertibleMatrix() {
        int[][] matrix = {
                {1, 2},
                {2, 4}
        }; // Детерминант = 0, матрица необратима
        assertThrows(ArithmeticException.class, () -> MatrixCalculator.invertMatrix(matrix), "Матрица необратима");
    }

    @Test
    void testInvertMatrixThrowsExceptionForNon2x2() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertThrows(IllegalArgumentException.class, () -> MatrixCalculator.invertMatrix(matrix), "Матрица должна быть 2х2");
    }

    // 2 Блок

    // 6. Тест для умножения двух матриц
    @Test
    void testMultiplyMatrices() {
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        int[][] matrix2 = {
                {5, 6},
                {7, 8}
        };
        int[][] expected = {
                {19, 22},
                {43, 50}
        };
        assertArrayEquals(expected, MatrixCalculator.multiplyMatrices(matrix1, matrix2));
    }

    // 7. Тест для умножения матрицы на скаляр
    @Test
    void testScalarMultiplyMatrix() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int scalar = 2;
        int[][] expected = {
                {2, 4},
                {6, 8}
        };
        assertArrayEquals(expected, MatrixCalculator.scalarMultiplyMatrix(matrix, scalar));
    }

    // 8. Тест для проверки, является ли матрица симметричной
    @Test
    void testIsSymmetric() {
        int[][] symmetricMatrix = {
                {1, 2, 3},
                {2, 5, 6},
                {3, 6, 9}
        };
        int[][] nonSymmetricMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertTrue(MatrixCalculator.isSymmetric(symmetricMatrix));
        assertFalse(MatrixCalculator.isSymmetric(nonSymmetricMatrix));
    }

    // 9. Тест для нахождения следа матрицы (сумма элементов на главной диагонали)
    @Test
    void testTraceMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected = 15; // 1 + 5 + 9 = 15
        assertEquals(expected, MatrixCalculator.traceMatrix(matrix));
    }

    @Test
    void testTraceMatrixNonSquare() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> MatrixCalculator.traceMatrix(matrix));
    }

    // 10. Тест для нахождения суммы всех элементов матрицы
    @Test
    void testSumOfElements() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int expected = 10; // 1 + 2 + 3 + 4 = 10
        assertEquals(expected, MatrixCalculator.sumOfElements(matrix));
    }

    @Test
    void testSumOfElementsEmptyMatrix() {
        int[][] matrix = new int[0][0]; // Пустая матрица
        int expected = 0;
        assertEquals(expected, MatrixCalculator.sumOfElements(matrix));
    }

    // 3 Блок

    // 11. Тест для транспонирования матрицы
    @Test
    void testTransposeMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] expected = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        assertArrayEquals(expected, MatrixCalculator.transposeMatrix(matrix));
    }

    // 12. Тест для проверки, является ли матрица диагональной
    @Test
    void testIsDiagonalMatrix() {
        int[][] diagonalMatrix = {
                {5, 0, 0},
                {0, 8, 0},
                {0, 0, 12}
        };
        int[][] nonDiagonalMatrix = {
                {1, 0, 0},
                {0, 5, 6},
                {0, 0, 3}
        };
        assertTrue(MatrixCalculator.isDiagonalMatrix(diagonalMatrix));
        assertFalse(MatrixCalculator.isDiagonalMatrix(nonDiagonalMatrix));
    }

    // 13. Тест для установки значения элемента по индексу
    @Test
    void testSetElement() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixCalculator.setElement(matrix, 1, 1, 99);
        assertEquals(99, MatrixCalculator.getElement(matrix, 1, 1)); // Проверяем, что элемент изменен на 99
    }

    @Test
    void testSetElementOutOfBounds() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThrows(IndexOutOfBoundsException.class, () -> MatrixCalculator.setElement(matrix, 3, 3, 99));
    }

    // 14. Тест для нахождения максимального элемента в матрице
    @Test
    void testFindMaxElement() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected = 9; // Максимальный элемент — 9
        assertEquals(expected, MatrixCalculator.findMaxElement(matrix));
    }

    @Test
    void testFindMaxElementSingleElementMatrix() {
        int[][] matrix = {
                {42}
        };
        assertEquals(42, MatrixCalculator.findMaxElement(matrix)); // Проверка для матрицы с одним элементом
    }

    // 15. Тест для поворота матрицы на 90 градусов по часовой стрелке
    @Test
    void testRotateMatrixClockwise() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        assertArrayEquals(expected, MatrixCalculator.rotateMatrixClockwise(matrix));
    }

    @Test
    void testRotateMatrixClockwiseNonSquare() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int[][] expected = {
                {5, 3, 1},
                {6, 4, 2}
        };
        assertArrayEquals(expected, MatrixCalculator.rotateMatrixClockwise(matrix));
    }

    // 4 Блок
    // 16. Тест для нахождения минимального элемента в матрице
    @Test
    void testFindMinElement() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected = 1; // Минимальный элемент — 1
        assertEquals(expected, MatrixCalculator.findMinElement(matrix));
    }

    @Test
    void testFindMinElementNegativeValues() {
        int[][] matrix = {
                {-1, -2, -3},
                {4, -5, 6},
                {7, 8, 9}
        };
        int expected = -5; // Минимальный элемент — -5
        assertEquals(expected, MatrixCalculator.findMinElement(matrix));
    }

    // 17. Тест для проверки, является ли матрица квадратной
    @Test
    void testIsSquareMatrix() {
        int[][] squareMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertTrue(MatrixCalculator.isSquareMatrix(squareMatrix));

        int[][] nonSquareMatrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertFalse(MatrixCalculator.isSquareMatrix(nonSquareMatrix));
    }

    @Test
    void testIsSquareMatrixEmpty() {
        int[][] emptyMatrix = new int[0][0];
        assertTrue(MatrixCalculator.isSquareMatrix(emptyMatrix)); // Пустая матрица считается квадратной
    }

    // 18. Тест для проверки, является ли матрица верхней треугольной
    @Test
    void testIsUpperTriangular() {
        int[][] upperTriangularMatrix = {
                {1, 2, 3},
                {0, 5, 6},
                {0, 0, 9}
        };
        assertTrue(MatrixCalculator.isUpperTriangular(upperTriangularMatrix));

        int[][] nonUpperTriangularMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertFalse(MatrixCalculator.isUpperTriangular(nonUpperTriangularMatrix));
    }

    @Test
    void testIsUpperTriangularNonSquare() {
        int[][] nonSquareMatrix = {
                {1, 2, 3},
                {0, 5, 6}
        };
        assertFalse(MatrixCalculator.isUpperTriangular(nonSquareMatrix)); // Не квадратная матрица не может быть треугольной
    }

    // 19. Тест для получения элемента матрицы по индексу
    @Test
    void testGetElement() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(5, MatrixCalculator.getElement(matrix, 1, 1)); // Элемент на позиции (1,1) — 5
        assertEquals(9, MatrixCalculator.getElement(matrix, 2, 2)); // Элемент на позиции (2,2) — 9
    }

    @Test
    void testGetElementOutOfBounds() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThrows(IndexOutOfBoundsException.class, () -> MatrixCalculator.getElement(matrix, 3, 3));
    }

    // 20. Тест для зеркального отражения матрицы по горизонтали
    @Test
    void testFlipMatrixHorizontally() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };
        assertArrayEquals(expected, MatrixCalculator.flipMatrixHorizontally(matrix));
    }

    @Test
    void testFlipMatrixHorizontallyNonSquare() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int[][] expected = {
                {2, 1},
                {4, 3},
                {6, 5}
        };
        assertArrayEquals(expected, MatrixCalculator.flipMatrixHorizontally(matrix));
    }
}
