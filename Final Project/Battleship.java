import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Battleship {
    private static final int SIZE = 10;
    private boolean isGameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Battleship game = new Battleship();
        game.run(scanner);
    }

    private void run(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("主菜单");
            System.out.println("1. 开始新游戏");
            System.out.println("2. 加载已保存的游戏");
            System.out.println("3. 查看游戏说明");
            System.out.println("4. 退出程序");
            System.out.print("请选择：");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startNewGame(scanner);
                    break;
                case 2:
                    loadGame(scanner);
                    break;
                case 3:
                    showInstructions(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("无效选择，请重试。");
                    break;
            }
        }
    }

    private void showInstructions(Scanner scanner) {
        System.out.println("战舰游戏说明：");
        System.out.println("这里是游戏说明...");
        System.out.println("按任意键返回主菜单。");
        scanner.next();
    }

    private void startNewGame(Scanner scanner) {
        System.out.println("选择难度：1. 简单 2. 普通");
        int difficulty = scanner.nextInt();
        AI ai = new AI(difficulty);
        Board playerBoard = new Board();
        Board aiBoard = new Board();

        playerBoard.initializeBoard();
        aiBoard.initializeBoard();
        
        playerBoard.placeShips(scanner);
        ai.placeShips(aiBoard);

        playGame(scanner, playerBoard, aiBoard, ai);
    }

    private void loadGame(Scanner scanner) {
        System.out.println("选择存档：1. 存档一 2. 存档二 3. 存档三");
        int slot = scanner.nextInt();
        String fileName = "save" + slot + ".txt";

        if (!new File(fileName).exists()) {
            System.out.println("该存档无内容");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // 加载游戏状态
            reader.close();
        } catch (IOException e) {
            System.out.println("加载游戏时出错。");
        }
    }

    private void playGame(Scanner scanner, Board playerBoard, Board aiBoard, AI ai) {
        while (!isGameOver) {
            playerTurn(scanner, playerBoard, aiBoard);
            if (isGameOver) break;
            aiTurn(playerBoard, ai);
        }
    }

    private void playerTurn(Scanner scanner, Board playerBoard, Board aiBoard) {
        System.out.println("玩家的回合");
        playerBoard.displayBoard();
        System.out.print("输入射击坐标 (格式: x y): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (aiBoard.shoot(x, y)) {
            System.out.println("命中！");
        } else {
            System.out.println("未命中。");
        }

        if (aiBoard.allShipsSunk()) {
            System.out.println("玩家获胜！");
            isGameOver = true;
        }
    }

    private void aiTurn(Board playerBoard, AI ai) {
        System.out.println("AI的回合");
        int[] shot = ai.shoot(playerBoard);
        int x = shot[0];
        int y = shot[1];

        if (playerBoard.shoot(x, y)) {
            System.out.println("AI命中！");
        } else {
            System.out.println("AI未命中。");
        }

        if (playerBoard.allShipsSunk()) {
            System.out.println("AI获胜！");
            isGameOver = true;
        }
    }

    private void saveGame(Scanner scanner, Board playerBoard, Board aiBoard, AI ai) {
        System.out.println("选择存档位置：1. 存档一 2. 存档二 3. 存档三");
        int slot = scanner.nextInt();
        String fileName = "save" + slot + ".txt";

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            // 保存游戏状态
            writer.close();
        } catch (IOException e) {
            System.out.println("保存游戏时出错。");
        }
    }

    private void gameOver(String winner) {
        System.out.println(winner + "获胜！");
        System.out.println("按任意键返回主菜单。");
        new Scanner(System.in).next();
    }
}

class Board {
    private char[][] board;
    private static final int SIZE = 10;
    private Ship[] ships;

    public Board() {
        board = new char[SIZE][SIZE];
        ships = new Ship[]{
            new Ship("航空母舰", 5),
            new Ship("战舰", 4),
            new Ship("驱逐舰", 3),
            new Ship("潜艇", 3),
            new Ship("巡逻船", 2)
        };
    }

    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void placeShips(Scanner scanner) {
        for (Ship ship : ships) {
            boolean placed = false;
            while (!placed) {
                displayBoard();
                System.out.println("放置舰船: " + ship.getName() + " (长度: " + ship.getSize() + ")");
                System.out.print("输入起始坐标 (格式: x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.print("选择方向 (h: 水平, v: 垂直): ");
                char direction = scanner.next().charAt(0);

                placed = placeShip(x, y, ship.getSize(), direction);
                if (!placed) {
                    System.out.println("无效位置，请重试。");
                }
            }
        }
    }

    private boolean placeShip(int x, int y, int size, char direction) {
        if (direction == 'h') {
            if (y + size > SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (board[x][y + i] != '-') return false;
            }
            for (int i = 0; i < size; i++) {
                board[x][y + i] = 'S';
            }
        } else if (direction == 'v') {
            if (x + size > SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (board[x + i][y] != '-') return false;
            }
            for (int i = 0; i < size; i++) {
                board[x + i][y] = 'S';
            }
        } else {
            return false;
        }
        return true;
    }

    public void displayBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean shoot(int x, int y) {
        if (board[x][y] == 'S') {
            board[x][y] = 'X';
            return true;
        } else if (board[x][y] == '-') {
            board[x][y] = 'O';
            return false;
        }
        return false;
    }

    public boolean allShipsSunk() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 'S') return false;
            }
        }
        return true;
    }
}

class AI {
    private int difficulty;
    private boolean[][] shotBoard;
    private static final int SIZE = 10;
    private Random random;

    public AI(int difficulty) {
        this.difficulty = difficulty;
        shotBoard = new boolean[SIZE][SIZE];
        random = new Random();
    }

    public void placeShips(Board board) {
        int[] shipSizes = {5, 4, 3, 3, 2};
        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(SIZE);
                int y = random.nextInt(SIZE);
                char direction = random.nextBoolean() ? 'h' : 'v';
                placed = board.placeShip(x, y, size, direction);
            }
        }
    }

    public int[] shoot(Board board) {
        if (difficulty == 1) {
            return randomShoot();
        } else {
            return smartShoot(board);
        }
    }

    private int[] randomShoot() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (shotBoard[x][y]);
        shotBoard[x][y] = true;
        return new int[]{x, y};
    }

    private int[] smartShoot(Board board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.shoot(i, j)) {
                    return checkSurroundings(i, j);
                }
            }
        }
        return randomShoot();
    }

    private int[] checkSurroundings(int x, int y) {
        if (x > 0 && !shotBoard[x - 1][y]) return new int[]{x - 1, y};
        if (x < SIZE - 1 && !shotBoard[x + 1][y]) return new int[]{x + 1, y};
        if (y > 0 && !shotBoard[x][y - 1]) return new int[]{x, y - 1};
        if (y < SIZE - 1 && !shotBoard[x][y + 1]) return new int[]{x, y + 1};
        return null;
    }
}

class Ship {
    private String name;
    private int size;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
