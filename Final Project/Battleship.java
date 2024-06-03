import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Battleship {
    private static final int BOARD_SIZE = 10;
    private static final char EMPTY_CELL = '-';
    private static final char SHIP_CELL = 'S';
    private static final char HIT_CELL = 'X';
    private static final char MISS_CELL = 'O';
    private static final int EASY = 1;
    private static final int NORMAL = 2;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎来到战舰游戏！");
            System.out.println("1. 开始新游戏");
            System.out.println("2. 加载已保存的游戏");
            System.out.println("3. 查看游戏说明");
            System.out.println("4. 退出");

            System.out.print("请选择一个选项: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    loadGame();
                    break;
                case 3:
                    showInstructions();
                    break;
                case 4:
                    System.out.println("退出游戏。");
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重试。");
            }
        }
    }

    private static void startNewGame() {
        System.out.println("选择难度: 1. 简单 2. 普通");
        int difficulty = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        char[][] playerBoard = initializeBoard();
        char[][] aiBoard = initializeBoard();

        placeShips(playerBoard, false);
        placeShips(aiBoard, true);

        boolean playerTurn = true;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("玩家的游戏板:");
            printBoard(playerBoard, false);
            System.out.println("AI的游戏板:");
            printBoard(aiBoard, true);

            if (playerTurn) {
                System.out.println("玩家回合。");
                playerTurn = !playerMove(aiBoard);
            } else {
                System.out.println("AI回合。");
                playerTurn = aiMove(playerBoard, difficulty);
            }

            if (isGameOver(playerBoard)) {
                displayGameOver(false);
                gameOver = true;
            } else if (isGameOver(aiBoard)) {
                displayGameOver(true);
                gameOver = true;
            }
        }
    }

    private static void loadGame() {
        System.out.println("选择存档: 1. 存档一 2. 存档二 3. 存档三");
        int slot = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        String fileName = "save" + slot + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // 读取并初始化游戏状态
            System.out.println("游戏已加载。");
        } catch (IOException e) {
            System.out.println("无法加载存档：" + e.getMessage());
        }
    }

    private static void showInstructions() {
        System.out.println("战舰游戏说明...");
        // 在这里添加游戏说明内容
        System.out.println("按回车键返回主菜单...");
        scanner.nextLine();
    }

    private static char[][] initializeBoard() {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
        return board;
    }

    private static void placeShips(char[][] board, boolean isAI) {
        // 实现放置舰船的逻辑
    }

    private static void printBoard(char[][] board, boolean hideShips) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (hideShips && board[i][j] == SHIP_CELL) {
                    System.out.print(EMPTY_CELL + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean playerMove(char[][] aiBoard) {
        System.out.print("输入射击坐标 (行 列): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        if (!isValidInput(row, col)) {
            System.out.println("无效的坐标，请重试。");
            return true; // 继续玩家回合
        }

        return processShot(aiBoard, row, col);
    }

    private static boolean aiMove(char[][] playerBoard, int difficulty) {
        Random rand = new Random();
        int row, col;

        if (difficulty == EASY) {
            do {
                row = rand.nextInt(BOARD_SIZE);
                col = rand.nextInt(BOARD_SIZE);
            } while (!isValidInput(row, col));
        } else {
            // 实现普通难度AI逻辑
        }

        return processShot(playerBoard, row, col);
    }

    private static boolean isValidInput(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    private static boolean processShot(char[][] board, int row, int col) {
        if (board[row][col] == SHIP_CELL) {
            board[row][col] = HIT_CELL;
            System.out.println("命中！");
            return true;
        } else if (board[row][col] == EMPTY_CELL) {
            board[row][col] = MISS_CELL;
            System.out.println("未命中！");
        } else {
            System.out.println("重复射击，请重试。");
        }
        return false;
    }

    private static boolean isGameOver(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == SHIP_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayGameOver(boolean playerWon) {
        if (playerWon) {
            System.out.println("恭喜你！你赢了！");
        } else {
            System.out.println("很遗憾，你输了。");
        }
        System.out.println("按回车键返回主菜单...");
        scanner.nextLine();
    }
}
