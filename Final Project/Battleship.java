import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Battleship {
    private static final int BOARD_SIZE = 5;
    private static final char EMPTY = '-';
    private static final char SHIP = 'S';
    private static final char HIT = 'X';
    private static final char MISS = 'O';
    private static char[][] playerBoard;
    private static char[][] aiBoard;
    private static int difficulty;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        displayMainMenu();
    }

    // 主菜单
    public static void displayMainMenu() {
        while (true) {
            System.out.println("1. Start New Game");
            System.out.println("2. Load Game");
            System.out.println("3. View Instructions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    chooseDifficulty();
                    startNewGame();
                    break;
                case 2:
                    loadGame();
                    break;
                case 3:
                    displayInstructions();
                    break;
                case 4:
                    System.out.println("Exiting game. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // 选择游戏难度
    public static void chooseDifficulty() {
        System.out.println("Choose difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Normal");
        System.out.print("Enter your choice: ");
        difficulty = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        switch (difficulty) {
            case 1:
                System.out.println("Easy mode selected.");
                break;
            case 2:
                System.out.println("Normal mode selected.");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Easy mode.");
                difficulty = 1;
        }
    }

    // 游戏说明
    public static void displayInstructions() {
        System.out.println("Battleship Game Instructions:");
        System.out.println("1. The game is played on a 5x5 grid.");
        System.out.println("2. Each player has 3 ships.");
        System.out.println("3. Players take turns to call shots to try to hit the opponent's ships.");
        System.out.println("4. The first player to sink all opponent's ships wins.");
        System.out.println("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    // 开始新游戏
    public static void startNewGame() {
        playerBoard = new char[BOARD_SIZE][BOARD_SIZE];
        aiBoard = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard(playerBoard);
        initializeBoard(aiBoard);
        placePlayerShips(playerBoard);
        placeAIShips(aiBoard);
        playGame();
    }

    // 初始化空白游戏板
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // 玩家设置舰船位置
    public static void placePlayerShips(char[][] board) {
        System.out.println("Place your ships on the board.");
        for (int i = 0; i < 3; i++) {
            displayGameBoard(playerBoard, aiBoard, true);
            System.out.printf("Placing ship %d\n", i + 1);
            int length = i + 2;
            boolean vertical = chooseOrientation();
            int row, col;
            do {
                System.out.printf("Enter position for ship %d (row and column): ", i + 1);
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!canPlaceShip(board, row, col, length, vertical));
            placeShip(board, row, col, length, vertical);
        }
    }

    // 选择舰艇方向
    public static boolean chooseOrientation() {
        System.out.println("Choose orientation:");
        System.out.println("1. Vertical");
        System.out.println("2. Horizontal");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        return choice == 1;
    }

    // 验证是否可以放置舰艇
    public static boolean canPlaceShip(char[][] board, int row, int col, int length, boolean vertical) {
        if (vertical) {
            if (row + length > BOARD_SIZE) return false;
            for (int i = 0; i < length; i++) {
                if (board[row + i][col] != EMPTY) return false;
            }
        } else {
            if (col + length > BOARD_SIZE) return false;
            for (int i = 0; i < length; i++) {
                if (board[row][col + i] != EMPTY) return false;
            }
        }
        return true;
    }

    // 放置舰艇
    public static void placeShip(char[][] board, int row, int col, int length, boolean vertical) {
        if (vertical) {
            for (int i = 0; i < length; i++) {
                board[row + i][col] = SHIP;
            }
        } else {
            for (int i = 0; i < length; i++) {
                board[row][col + i] = SHIP;
            }
        }
    }

    // AI设置舰船位置
    public static void placeAIShips(char[][] board) {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int length = i + 2;
            boolean vertical = rand.nextBoolean();
            int row, col;
            do {
                row = rand.nextInt(BOARD_SIZE);
                col = rand.nextInt(BOARD_SIZE);
            } while (!canPlaceShip(board, row, col, length, vertical));
            placeShip(board, row, col, length, vertical);
        }
    }

    // 游戏主循环
    public static void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            displayGameBoard(playerBoard, aiBoard, false);
            playerTurn();
            if (isGameOver(aiBoard)) {
                gameOver = true;
                displayGameOver(true);
                break;
            }
            aiTurn();
            if (isGameOver(playerBoard)) {
                gameOver = true;
                displayGameOver(false);
            }
        }
    }

    // 显示游戏板
    public static void displayGameBoard(char[][] playerBoard, char[][] aiBoard, boolean revealAI) {
        System.out.println("Your board:");
        printBoard(playerBoard);
        System.out.println("AI board:");
        if (revealAI) {
            printBoard(aiBoard);
        } else {
            printHiddenBoard(aiBoard);
        }
    }

    // 打印游戏板
    public static void printBoard(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 打印隐藏的游戏板
    public static void printHiddenBoard(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == SHIP) {
                    System.out.print(EMPTY + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // 玩家回合
    public static void playerTurn() {
        int row, col;
        do {
            System.out.print("Enter coordinates to fire (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidInput(row, col) || playerBoard[row][col] == HIT || playerBoard[row][col] == MISS);

        if (processShot(aiBoard, row, col)) {
            System.out.println("Hit!");
            playerBoard[row][col] = HIT;
        } else {
            System.out.println("Miss.");
            playerBoard[row][col] = MISS;
        }
    }

    // AI回合
    public static void aiTurn() {
        Random rand = new Random();
        int row, col;
        if (difficulty == 1) {
            do {
                row = rand.nextInt(BOARD_SIZE);
                col = rand.nextInt(BOARD_SIZE);
            } while (aiBoard[row][col] == HIT || aiBoard[row][col] == MISS);
        } else {
            // Normal AI logic: Try to find ships around hits
            do {
                row = rand.nextInt(BOARD_SIZE);
                col = rand.nextInt(BOARD_SIZE);
            } while (aiBoard[row][col] == HIT || aiBoard[row][col] == MISS);
        }

        if (processShot(playerBoard, row, col)) {
            System.out.println("AI hit your ship!");
            aiBoard[row][col]
