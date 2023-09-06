package org.exa.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final int WIN_COUNT = 4; // Выигрышная комбинация
    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        field = new char[3][];

        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize(){
        String messageX ="Введите размер игрового поля по вертикали: ";
        String messageY ="Введите размер игрового поля по горизонтали: ";
        fieldSizeX = scannInt(messageX) + 1;
        fieldSizeY = scannInt(messageY) + 1;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     *
     *     +-1-2-3-
     *     1|*|X|0|
     *     2|*|*|0|
     *     3|*|*|0|
     *     --------
     */
    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++){
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Получения числа от игрока
     * @param message Сообщение для уточнения вода
     * @return
     */
    private static int scannInt(String message){
        int x;
        while (true){
            System.out.print(message);
            if (scanner.hasNextInt()){
                x = scanner.nextInt() - 1;
                scanner.nextLine();
                break;
            }
            else {
                System.out.println("Некорректное число, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
        return x;
    }
    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn(){
        int x, y;
        String messageX = String.format("Введите координату хода X (от 1 до %d): ",fieldSizeX);
        String messageY = String.format("Введите координату хода Y (от 1 до %d): ",fieldSizeY);

        do {
            x = scannInt(messageX);
            y = scannInt(messageY);
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }
    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn(){
        int x, y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     * @param c фишка игрока
     * @param s победный слоган
     * @return
     */
    private static boolean checkGameState(char c, String s){
        if (checkWinV2(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка победы на 3 поля
     * @param c
     * @return
     */
    private static boolean checkWin(char c){

        // Проверка по трем горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // Проверка по трем вертикалям
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // Проверка по диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    /**
     * Проверка победы универсальная
     * @param c знак игрока
     * @return
     */

    private static boolean checkWinV2(char c){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (checkHorizontal(x,y,c) ||
                        checkVertical(x,y,c) ||
                        checkDiagonalRight(x,y,c) ||
                        checkDiagonalLeft(x,y,c))
                    return true;
            }
        }
        return false;
    }

    /**
     * Проверка одиночная по горизонтали
     * @param x координата
     * @param y координата
     * @param c знак игрока
     * @return
     */

    private static boolean checkHorizontal(int x, int y, char c){
        int count = 0;
        if (y > fieldSizeY - WIN_COUNT)
            return false;

        while (y < fieldSizeY && field[x][y++] == c){
            count++;
        }
        if (count >= WIN_COUNT)
            return true;
        return false;
    }
    /**
     * Проверка одиночная по вертикали
     * @param x координата
     * @param y координата
     * @param c знак игрока
     * @return
     */
    private static boolean checkVertical(int x, int y, char c){
        int count = 0;
        if (x > fieldSizeX - WIN_COUNT)
            return false;

        while (x < fieldSizeX && field[x++][y]== c){
            count++;
        }
        if (count >= WIN_COUNT)
            return true;
        return false;
    }
    /**
     * Проверка одиночная по диагонали вправо
     * @param x координата
     * @param y координата
     * @param c знак игрока
     * @return
     */
    private static boolean checkDiagonalRight(int x, int y, char c){
        int count=0;
        if (x > fieldSizeX - WIN_COUNT || y > fieldSizeY - WIN_COUNT)
            return false;

        while (x <fieldSizeX && y < fieldSizeY && field[x++][y++]== c){
            count++;
        }
        if (count>=WIN_COUNT)
            return true;
        return false;
    }
    /**
     * Проверка одиночная по диагонали влево
     * @param x координата
     * @param y координата
     * @param c знак игрока
     * @return
     */
    private static boolean checkDiagonalLeft(int x, int y, char c){
        int count=0;
        if (x > fieldSizeX-WIN_COUNT || y - WIN_COUNT + 1 < 0)
            return false;

        while (x < fieldSizeX && y >= 0 && field[x++][y--]== c){
            count++;
        }
        if (count>=WIN_COUNT)
            return true;
        return false;
    }

    /**
     * Проверка на ничью
     * @return
     */
    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

}
