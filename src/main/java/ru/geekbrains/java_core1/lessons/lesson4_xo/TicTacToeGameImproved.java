package ru.geekbrains.java_core1.lessons.lesson4_xo;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGameImproved {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static char dotHuman;
    private static char dotAi;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int winLength;

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        while (true) {
            playRound();
            System.out.printf("SCORE:  HUMAN     AI\n" +
                    "          %d       %d\n", scoreHuman, scoreAi);
            System.out.print("Wanna play again? Y or N >>> ");
            if (!scanner.next().toLowerCase().equals("y")) {
                System.out.println("Good bye!");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("ROUND %d START\n", ++roundCounter);
        setGameProperties();
        printField();
        if (dotHuman == DOT_X) {
            humanFirstTurn();
        } else {
            aiFirstTurn();
        }
    }

    private static void setGameProperties() {
        System.out.println("Please enter 'x' if you want to play with X, and something else for O >>> ");
        String x = scanner.next();
        if (x.toLowerCase().equals("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }
        System.out.println("Please enter the wanted field size for width and height split by whitespace >>> ");
        int sizeX = scanner.nextInt();
        int sizeY = scanner.nextInt();
        if (sizeX < 3) {
            sizeX = 3;
        }
        if (sizeY < 3) {
            sizeY = 3;
        }
        initField(sizeX, sizeY);
        System.out.println("Please enter the wanted win length >>> ");
        winLength = scanner.nextInt();
        if (winLength < 3) {
            winLength = 3;
        }
        if (winLength > fieldSizeX || winLength > fieldSizeY) {
            winLength = Math.min(fieldSizeX, fieldSizeY);
        }
    }

    private static void aiFirstTurn() {
        while (true) {
            aiTurn();
            printField();
            if (checkGame(dotAi)) break;
            humanTurn();
            printField();
            if (checkGame(dotHuman)) break;
        }
    }

    private static void humanFirstTurn() {
        while (true) {
            humanTurn();
            printField();
            if (checkGame(dotHuman)) break;
            aiTurn();
            printField();
            if (checkGame(dotAi)) break;
        }
    }

    private static boolean checkGame(char dot) {
        if (checkWin(dot, winLength)) {
            if (dot == dotHuman) {
                System.out.println("Human win!!!");
                scoreHuman++;
            } else {
                System.out.println("AI win!!!");
                scoreAi++;
            }
            return true;
        }
        if (checkDraw()) return true;
        return false;
    }

    private static void aiTurn() {
        for (int i = 0; winLength - i > 2; i++) {
            if (scanField(dotAi, winLength - i)) return;        // ???????????????? ???????????????? ??????????
            if (scanField(dotHuman, winLength - i)) return;    // ???????????????? ???????????????? ???????????? ???? ???????? ????????
        }
        aiTurnEasy();
    }

    private static void aiTurnEasy() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(y, x));
        field[y][x] = dotAi;
    }

    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Please enter coordinates of your turn x and y split by whitespace >>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));
        field[y][x] = dotHuman;
    }

    private static boolean scanField(char dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {                // ???????????????? ?????????? ?? ???????????? ???????????? ???????? ???? ??????????????
                    field[y][x] = dot;
                    if (checkWin(dot, length)) {
                        if (dot == dotAi) return true;    // ???????? ???????? ????????????????????, ???? ??????????????????
                        if (dot == dotHuman) {
                            field[y][x] = dotAi;            // ???????? ???????????????????? ?????????? ???????????? ???????? 0
                            return true;
                        }
                    }
                    field[y][x] = DOT_EMPTY;            // ???????? ?????????? ????????????, ???? ???????????????????? ?????? ????????
                }
            }
        }
        return false;
    }

    private static boolean checkWin(char dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {            // ?????????????????? ?????? ????????
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, length, dot)) return true;    // ????????????????  ???? +??
                if (checkLine(x, y, 1, 1, length, dot)) return true;    // ???????????????? ???? ?????????????????? +?? +??
                if (checkLine(x, y, 0, 1, length, dot)) return true;    // ???????????????? ?????????? ???? +??
                if (checkLine(x, y, 1, -1, length, dot)) return true;    // ???????????????? ???? ?????????????????? +?? -??
//                if (checkLine(i, j, -1, 0, length, dot)) return true;	// ????????????????  ???? +??
//                if (checkLine(i, j, -1, 1, length, dot)) return true;	// ???????????????? ???? ?????????????????? +?? +??
//                if (checkLine(i, j, 0, -1, length, dot)) return true;	// ???????????????? ?????????? ???? +??
//                if (checkLine(i, j, -1, -1, length, dot)) return true;	// ???????????????? ???? ?????????????????? +?? -??
            }
        }
        return false;
    }

    // ???????????????? ??????????
    private static boolean checkLine(int x, int y, int incrementX, int incrementY, int len, char dot) {
        int endXLine = x + (len - 1) * incrementX;            // ?????????? ?????????? ???? ??
        int endYLine = y + (len - 1) * incrementY;            // ?????????? ???? ??
        if (!isCellValid(endYLine, endXLine)) return false;    // ?????????? ?????????? ???? ??????????????
        for (int i = 0; i < len; i++) {                    // ???????? ???? ??????????
            if (field[y + i * incrementY][x + i * incrementX] != dot) return false;    // ?????????????? ?????????????????????
        }
        return true;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        System.out.println("It's DRAW!!!");
        return true;
    }

    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static void initField(int sizeX, int sizeY) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
//            if (i % 2 == 0) {
//                System.out.print("-");
//            } else {
//                System.out.print(i / 2 + 1);
//            }
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print("_");
        }
        System.out.println();
//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                System.out.print(field[y][x] + " ");
//            }
//            System.out.println();
//        }
    }
}
