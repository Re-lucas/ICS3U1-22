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

    // 游戏说明
    public static void displayInstructions() {
        System.out.println("Battleship Game Instructions:");
        System.out.println("1. The game is played on a 5x5 grid.");
        System.out.println("2. Each player has 3 ships.");
        System.out.println("3. Players take turns to call shots to try to hit the opponent's ships.");
        System.out.println("4. The first player to sink all opponent's ships wins.");
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
            int row, col;
            do {
                System.out.printf("Enter position for ship %d (row and column): ", i + 1);
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!isValidInput(row, col) || board[row][col] == SHIP);
            board[row][col] = SHIP;
        }
    }

    // AI设置舰船位置
    public static void placeAIShips(char[][] board) {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int row, col;
            do {
                row = rand.nextInt(BOARD_SIZE);
                col = rand.nextInt(BOARD_SIZE);
            } while (board[row][col] == SHIP);
            board[row][col] = SHIP;
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
        do {
            row = rand.nextInt(BOARD_SIZE);
            col = rand.nextInt(BOARD_SIZE);
        } while (aiBoard[row][col] == HIT || aiBoard[row][col] == MISS);

        if (processShot(playerBoard, row, col)) {
            System.out.println("AI hit your ship!");
            aiBoard[row][col] = HIT;
        } else {
            System.out.println("AI missed.");
            aiBoard[row][col] = MISS;
        }
    }

    // 验证输入
    public static boolean isValidInput(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    // 处理射击结果
    public static boolean processShot(char[][] board, int row, int col) {
        return board[row][col] == SHIP;
    }

    // 检查游戏是否结束
    public static boolean isGameOver(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    // 显示游戏结束信息
    public static void displayGameOver(boolean playerWon) {
        if (playerWon) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("You lost. Better luck next time!");
        }
        System.out.println("Game over.");
    }

    // 保存游戏
    public static void saveGame(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(playerBoard);
            oos.writeObject(aiBoard);
            System.out.println("Game saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 加载游戏
    public static void loadGame() {
        System.out.print("Enter the filename to load: ");
        String filename = scanner.nextLine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            playerBoard = (char[][]) ois.readObject();
            aiBoard = (char[][]) ois.readObject();
            System.out.println("Game loaded.");
            playGame();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
