import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Battleship game = new Battleship();
        game.run(scanner);
    }

    public Board playerBoard;
    public Board aiBoard;
    public AI ai;
    public boolean isGameOver;

    public void run(Scanner scanner) {
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
                    showInstructions();
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

    public void startNewGame(Scanner scanner) {
        System.out.println("选择难度：1. 简单 2. 普通");
        int difficulty = scanner.nextInt();
        ai = new AI(difficulty);
        playerBoard = new Board();
        aiBoard = new Board();

        playerBoard.initializeBoard();
        aiBoard.initializeBoard();
        
        playerBoard.placeShips(scanner);
        ai.placeShips(aiBoard);

        playGame(scanner);
    }

    public void loadGame(Scanner scanner) {
        System.out.println("选择存档：1. 存档一 2. 存档二 3. 存档三");
        int slot = scanner.nextInt();
        String fileName = "save" + slot + ".txt";

        if (!new File(fileName).exists()) {
            System.out.println("该存档无内容");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            playerBoard = new Board();
            aiBoard = new Board();
            ai = new AI(reader.readLine().equals("easy") ? 1 : 2);
            
            playerBoard.loadBoard(reader);
            aiBoard.loadBoard(reader);
            reader.close();
            
            playGame(scanner);
        } catch (IOException e) {
            System.out.println("加载游戏时出错。");
        }
    }

    public void saveGame(int slot) {
        String fileName = "save" + slot + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(ai.getDifficulty() == 1 ? "easy" : "normal");
            writer.newLine();
            playerBoard.saveBoard(writer);
            aiBoard.saveBoard(writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("保存游戏时出错。");
        }
    }

    public void showInstructions() {
        System.out.println("战舰游戏说明：");
        // 显示详细说明
    }

    public void playGame(Scanner scanner) {
        isGameOver = false;
        while (!isGameOver) {
            playerTurn(scanner);
            if (isGameOver) break;
            aiTurn();
        }
    }

    public void playerTurn(Scanner scanner) {
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

    public void aiTurn() {
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

    class Board {
        public char[][] board;
        public static final int SIZE = 10;
        public Ship[] ships;

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

        //This
        public void placeShips(Scanner scanner) {
            boolean[] placedShips = new boolean[ships.length];

            for (int i = 0; i < ships.length; i++) {
                boolean placed = false;
                while (!placed) {
                    displayBoard();
                    System.out.println("选择舰船:");
                    for (int j = 0; j < ships.length; j++) {
                        if (!placedShips[j]) {
                            System.out.println((j + 1) + ". " + ships[j].getName() + " (长度: " + ships[j].getSize() + ")");
                        }
                    }
                    int choice = scanner.nextInt() - 1;
                    if (choice < 0 || choice >= ships.length || placedShips[choice]) {
                        System.out.println("无效选择，请重试。");
                        continue;
                    }
                    Ship ship = ships[choice];

                    System.out.print("输入起始坐标 (格式: x y): ");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.print("选择方向 (h: 水平, v: 垂直): ");
                    char direction = scanner.next().charAt(0);

                    placed = placeShip(x, y, ship.getSize(), direction);
                    if (placed) {
                        placedShips[choice] = true;
                    } else {
                        System.out.println("无效位置，请重试。");
                    }
                }
            }
        }


        //Problem unslove(sloved): as the variable got from method placeShips
        //the variable in the commander as for x is assgined to y and the y is assigned to x 

        //The effect: it got variable from method placeShips (both the ai and the user which different from the variable assgined to the two palceShips method)
        //and it acctually assgined the x, y, the size which is the size of ship (from an array by getting their length) and the direction which determine by the char
        public boolean placeShip(int x, int y, int size, char direction) {
            if (direction == 'h') {
                if (y + size > SIZE) return false;
                for (int i = 0; i < size; i++) {
                    if (board[x + i][y] != '-') return false;
                }
                for (int i = 0; i < size; i++) {
                    board[x + i][y] = 'S';
                }
            } else if (direction == 'v') {
                if (x + size > SIZE) return false;
                for (int i = 0; i < size; i++) {
                    if (board[x][y + i] != '-') return false;
                }
                for (int i = 0; i < size; i++) {
                    board[x][y + i] = 'S';
                }
            } else {
                return false;
            }
            return true;
        }

        public boolean shoot(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                return false;
            }
            if (board[x][y] == 'S') {
                board[x][y] = 'H';
                return true;
            } else {
                board[x][y] = 'M';
                return false;
            }
        }

        public boolean allShipsSunk() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == 'S') {
                        return false;
                    }
                }
            }
            return true;
        }

        public void saveBoard(BufferedWriter writer) throws IOException {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    writer.write(board[i][j]);
                }
                writer.newLine();
            }
        }

        public void loadBoard(BufferedReader reader) throws IOException {
            for (int i = 0; i < SIZE; i++) {
                String line = reader.readLine();
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
        }

        public char getCell(int x, int y) {
            return board[x][y];
        }
    }

    class Ship {
        public String name;
        public int size;

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

    class AI {
        public int difficulty;
        public boolean[][] shotBoard;
        public static final int SIZE = 10;
        public Random random;

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
                return strategicShoot(board);
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

        private int[] strategicShoot(Board board) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (shotBoard[i][j] && board.getCell(i, j) == 'H') {
                        int[] nextShot = findAdjacent(i, j);
                        if (nextShot != null) {
                            return nextShot;
                        }
                    }
                }
            }
            return randomShoot();
        }

        private int[] findAdjacent(int x, int y) {
            if (x > 0 && !shotBoard[x - 1][y]) return new int[]{x - 1, y};
            if (x < SIZE - 1 && !shotBoard[x + 1][y]) return new int[]{x + 1, y};
            if (y > 0 && !shotBoard[x][y - 1]) return new int[]{x, y - 1};
            if (y < SIZE - 1 && !shotBoard[x][y + 1]) return new int[]{x, y + 1};
            return null;
        }

        public int getDifficulty() {
            return difficulty;
        }
    }
}
