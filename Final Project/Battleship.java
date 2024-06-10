import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battleship {
    public static final int BOARD_SIZE = 10;
    public static final char SHIP_SYMBOL = 'S';
    public static final char HIT_SYMBOL = 'H';
    public static final char MISS_SYMBOL = 'M';
    public static final char EMPTY_SYMBOL = '-';
    public static final int EASY = 1;
    public static final int NORMAL = 2;
    public static final String SAVE_FILE_PREFIX = "save";
    public static final String SAVE_FILE_SUFFIX = ".txt";
    public static final int SAVE_SLOT_1 = 1;
    public static final int SAVE_SLOT_2 = 2;
    public static final int SAVE_SLOT_3 = 3;

    public Board playerBoard;
    public Board aiBoard;
    public AI ai;
    public boolean isGameOver;
    public boolean isPlayerTurn;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Battleship game = new Battleship();
        game.run(scanner);
    }

    public void run(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("主菜单");
            System.out.println("1. 开始新游戏");
            System.out.println("2. 加载已保存的游戏");
            System.out.println("3. 查看游戏说明");
            System.out.println("4. 退出程序");
            System.out.print("请选择：");
    
            String input = scanner.next();
            int choice = Integer.parseInt(input);
    
            switch (choice) {
                case 1 -> startNewGame(scanner);
                case 2 -> loadGame(scanner);
                case 3 -> showInstructions();
                case 4 -> running = false;
                default -> System.out.println("无效选择，请重试。");
            }

            //if your java version is not 12, change switch statement to:
            /*
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
             */

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

        isPlayerTurn = true;
        playGame(scanner);
    }

    public void loadGame(Scanner scanner) {
        System.out.println("选择存档：1. 存档一 2. 存档二 3. 存档三");
        int slot = scanner.nextInt();
        String fileName = SAVE_FILE_PREFIX + slot + SAVE_FILE_SUFFIX;

        if (!new File(fileName).exists()) {
            System.out.println("该存档无内容");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            playerBoard = new Board();
            aiBoard = new Board();
            ai = new AI(reader.readLine().equals("easy") ? EASY : NORMAL);
        
            playerBoard.loadBoard(reader);
            aiBoard.loadBoard(reader);
            isGameOver = Boolean.parseBoolean(reader.readLine());
            isPlayerTurn = reader.readLine().equals("player");
        
            playGame(scanner);
        } catch (IOException e) {
            System.out.println("加载游戏时出错。");
        }        
    }

    public void saveGame(int slot) {
        String fileName = SAVE_FILE_PREFIX + slot + SAVE_FILE_SUFFIX;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(ai.getDifficulty() == EASY ? "easy" : "normal");
            writer.newLine();
            writer.write(Boolean.toString(isGameOver));
            writer.newLine();
            writer.write(isPlayerTurn ? "player" : "ai");
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
            if (isPlayerTurn) {
                playerTurn(scanner);
            } else {
                aiTurn();
            }
        }
    }

    public void playerTurn(Scanner scanner) {
        System.out.println("玩家的回合");
        boolean validShot = false;
        while (!validShot) {
            aiBoard.displayShotBoard();
            System.out.print("输入射击坐标 (格式: x y) 或 'q' 退出 或 'save' 保存: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("退出游戏...");
                isGameOver = true;
                return;
            } else if (input.equalsIgnoreCase("save")) {
                System.out.println("选择存档：1. 存档一 2. 存档二 3. 存档三");
                int slot = scanner.nextInt();
                saveGame(slot);
                System.out.println("游戏已保存。");
                return;
            }

            try {
                int y = Integer.parseInt(input) - 1; // 先读取y坐标
                int x = scanner.nextInt() - 1; // 再读取x坐标

                if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
                    System.out.println("坐标超出范围，请重新输入。");
                    continue;
                }

                if (aiBoard.board[x][y] == HIT_SYMBOL || aiBoard.board[x][y] == MISS_SYMBOL) {
                    System.out.println("已经射击过这个区域，请重新输入。");
                    continue;
                }

                validShot = aiBoard.shoot(x, y);
                if (validShot) {
                    System.out.println("命中！");
                } else {
                    System.out.println("未命中。");
                }

                if (aiBoard.allShipsSunk()) {
                    System.out.println("玩家获胜！");
                    isGameOver = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("输入格式错误，请按照 'x y' 的格式输入坐标。");
            }
        }

        System.out.println("玩家的战舰板：");
        playerBoard.displayBoard();
        isPlayerTurn = false;
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

        System.out.println("玩家的战舰板：");
        playerBoard.displayBoard();
        isPlayerTurn = true;
    }

    public class Board {
        public char[][] board;
        public Ship[] ships;

        public Board() {
            board = new char[BOARD_SIZE][BOARD_SIZE];
            ships = new Ship[]{
                new Ship("A", 5),
                new Ship("B", 4),
                new Ship("C", 3),
                new Ship("D", 3),
                new Ship("E", 2)
            };
        }

        public void initializeBoard() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = EMPTY_SYMBOL;
                }
            }
        }

        public void displayBoard() {
            display(board, false);
        }

        public void displayShotBoard() {
            display(board, true);
        }

        private void display(char[][] board, boolean hideShips) {
            System.out.print("  ");
            for (int i = 1; i <= BOARD_SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (int i = 0; i < BOARD_SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (hideShips && board[i][j] == SHIP_SYMBOL) {
                        System.out.print(EMPTY_SYMBOL + " ");
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

        public void placeShips(Scanner scanner) {
            for (Ship ship : ships) {
                boolean placed = false;
                while (!placed) {
                    displayBoard();
                    System.out.println("放置你的船只: " + ship.getName() + " (" + ship.getSize() + ")");
                    System.out.print("输入坐标和方向 (格式: x y h/v): ");
                    int x = scanner.nextInt() - 1;
                    int y = scanner.nextInt() - 1;
                    char direction = scanner.next().charAt(0);

                    placed = placeShip(ship, x, y, direction);
                    if (!placed) {
                        System.out.println("无效的位置，请重试。");
                    }
                }
            }
        }

        public boolean placeShip(Ship ship, int x, int y, char direction) {
            int size = ship.getSize();
            if (direction == 'h') {
                if (x + size > BOARD_SIZE) { // 检查水平放置是否超出边界
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (board[x + i][y] != EMPTY_SYMBOL) {
                        return false;
                    }
                }
                for (int i = 0; i < size; i++) {
                    board[x + i][y] = SHIP_SYMBOL;
                    ship.addCoordinate(x + i, y);
                }
            } else if (direction == 'v') {
                if (y + size > BOARD_SIZE) { // 检查垂直放置是否超出边界
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (board[x][y + i] != EMPTY_SYMBOL) {
                        return false;
                    }
                }
                for (int i = 0; i < size; i++) {
                    board[x][y + i] = SHIP_SYMBOL;
                    ship.addCoordinate(x, y + i);
                }
            } else {
                return false;
            }
            return true;
        }   

        public boolean shoot(int x, int y) {
            if (board[x][y] == SHIP_SYMBOL) {
                board[x][y] = HIT_SYMBOL;
                for (Ship ship : ships) {
                    if (ship.isAtCoordinate(x, y)) {
                        ship.hit();
                        break;
                    }
                }
                return true;
            } else {
                board[x][y] = MISS_SYMBOL;
                return false;
            }
        }

        public boolean allShipsSunk() {
            for (Ship ship : ships) {
                if (!ship.isSunk()) {
                    return false;
                }
            }
            return true;
        }

        public void saveBoard(BufferedWriter writer) throws IOException {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    writer.write(board[i][j]);
                }
                writer.newLine();
            }
            for (Ship ship : ships) {
                writer.write(ship.getName() + " " + ship.getSize() + " " + ship.getHitCount());
                for (int[] coord : ship.getCoordinates()) {
                    writer.write(" " + coord[0] + " " + coord[1]);
                }
                writer.newLine();
            }
        }

        public void loadBoard(BufferedReader reader) throws IOException {
            for (int i = 0; i < BOARD_SIZE; i++) {
                String line = reader.readLine();
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            for (Ship ship : ships) {
                String[] parts = reader.readLine().split(" ");
                ship.setName(parts[0]);
                ship.setSize(Integer.parseInt(parts[1]));
                ship.setHitCount(Integer.parseInt(parts[2]));
                for (int i = 3; i < parts.length; i += 2) {
                    ship.addCoordinate(Integer.parseInt(parts[i]), Integer.parseInt(parts[i + 1]));
                }
            }
        }
    }

    public class Ship {
        private String name;
        private int size;
        private int hitCount;
        private List<int[]> coordinates;

        public Ship(String name, int size) {
            this.name = name;
            this.size = size;
            this.hitCount = 0;
            this.coordinates = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getHitCount() {
            return hitCount;
        }

        public void setHitCount(int hitCount) {
            this.hitCount = hitCount;
        }

        public List<int[]> getCoordinates() {
            return coordinates;
        }

        public void addCoordinate(int x, int y) {
            coordinates.add(new int[]{x, y});
        }

        public boolean isAtCoordinate(int x, int y) {
            for (int[] coord : coordinates) {
                if (coord[0] == x && coord[1] == y) {
                    return true;
                }
            }
            return false;
        }

        public void hit() {
            hitCount++;
        }

        public boolean isSunk() {
            return hitCount >= size;
        }
    }


    public class AI {
        private int difficulty;
        private Random random;

        public AI(int difficulty) {
            this.difficulty = difficulty;
            this.random = new Random();
        }

        public int getDifficulty() {
            return difficulty;
        }

        public void placeShips(Board board) {
            for (Ship ship : board.ships) {
                boolean placed = false;
                while (!placed) {
                    int x = random.nextInt(BOARD_SIZE);
                    int y = random.nextInt(BOARD_SIZE);
                    char direction = random.nextBoolean() ? 'h' : 'v';
                    placed = board.placeShip(ship, x, y, direction);
                }
            }
        }

        public int[] shoot(Board board) {
            int x, y;
            if (difficulty == EASY) {
                do {
                    x = random.nextInt(BOARD_SIZE);
                    y = random.nextInt(BOARD_SIZE);
                } while (board.board[x][y] == HIT_SYMBOL || board.board[x][y] == MISS_SYMBOL);
            } else {
                // 普通难度下的AI射击逻辑
                int[] lastHit = findLastHit(board);
                if (lastHit != null) {
                    // 如果找到了上一次的命中，尝试围绕该区域射击
                    List<int[]> potentialTargets = getSurroundingCoordinates(lastHit[0], lastHit[1], board);
                    do {
                        int[] target = potentialTargets.remove(random.nextInt(potentialTargets.size()));
                        x = target[0];
                        y = target[1];
                    } while (board.board[x][y] == HIT_SYMBOL || board.board[x][y] == MISS_SYMBOL);
                } else {
                    // 如果没有上一次的命中，随机选择一个位置射击
                    do {
                        x = random.nextInt(BOARD_SIZE);
                        y = random.nextInt(BOARD_SIZE);
                    } while (board.board[x][y] == HIT_SYMBOL || board.board[x][y] == MISS_SYMBOL);
                }
            }
            return new int[]{x, y};
        }
        
        private int[] findLastHit(Board board) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board.board[i][j] == HIT_SYMBOL) {
                        // 检查周围是否有未射击的区域
                        if (hasAdjacentEmpty(board, i, j)) {
                            return new int[]{i, j};
                        }
                    }
                }
            }
            return null;
        }
        
        private boolean hasAdjacentEmpty(Board board, int x, int y) {
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < BOARD_SIZE && newY >= 0 && newY < BOARD_SIZE) {
                    if (board.board[newX][newY] == EMPTY_SYMBOL) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        private List<int[]> getSurroundingCoordinates(int x, int y, Board board) {
            List<int[]> coordinates = new ArrayList<>();
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < BOARD_SIZE && newY >= 0 && newY < BOARD_SIZE) {
                    if (board.board[newX][newY] == EMPTY_SYMBOL) {
                        coordinates.add(new int[]{newX, newY});
                    }
                }
            }
            return coordinates;
        }        
    }
}
