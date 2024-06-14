import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battleship {

    //这里是一堆的不可改变的全局常数
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

    //仅仅作为初始化使用，因为不确定是否应该作为不可变数
    public Board playerBoard;
    public Board aiBoard;
    public AI ai;
    public boolean isGameOver;
    public boolean isPlayerTurn;

    //作为java程序中的入口点
    public static void main(String[] args) {
        //创建用于读取用户输入
        Scanner scanner = new Scanner(System.in);
        //创建了一个名为Battleship的对象主要用于调用并启动游戏
        Battleship game = new Battleship();

        //这行代码调用了 Battleship 对象的 run 方法，并传递了 scanner 作为参数
        //为什么这么做？我会说方便，只要将Battleship 类内封装游戏的所有逻辑。然后就可以访问和使用这个类定义的所有方法和变量。
        //并且如果我需要再一次调用里面的内容仅需调用game.run(scanner);,就很方便，这也是我在这里这么做的原因。
        //以及不同的逻辑也能够放到其中，所以main方法就很简洁，因为不需要调用各类不同的方法。

        //或者简单点：Battleship 对象是游戏的核心，负责启动和运行游戏。
        game.run(scanner);
    }


    //这段代码是一个海战游戏的主控制逻辑，它使用面向对象编程（以用户为输入为主导）的原则来组织游戏的结构和流程。
    public void run(Scanner scanner) {
        boolean running = true;

        //这是游戏的主循环，负责显示主菜单并根据用户的选择执行相应的操作。它使用 while 循环来持续运行，直到用户选择退出。
        while (running) {
            //通过输出菜单供玩家选择
            System.out.println("主菜单");
            System.out.println("1. 开始新游戏");
            System.out.println("2. 加载已保存的游戏");
            System.out.println("3. 查看游戏说明");
            System.out.println("4. 退出程序");
            System.out.print("请选择：");
    
            
            String input = scanner.next();
            int choice = Integer.parseInt(input);
    
            //通过上一条内容来调用每一个可能的选项，如果超过则返回
            switch (choice) {
                //startNewGame 方法：当用户选择开始新游戏时，这个方法会被调用。
                case 1 -> startNewGame(scanner);
                //loadGame 方法：当用户选择加载已保存的游戏时，这个方法会被调用。
                case 2 -> loadGame(scanner);
                //showInstructions 方法：当用户选择查看游戏说明时，这个方法会被调用，显示游戏的规则和操作指南。
                case 3 -> showInstructions();
                //选择退出程序也就是直接将while程序中的running条件由ture改为false
                case 4 -> running = false;
                //当用户输入超过以上选择时候则返回无效
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
    

    //作为用户在用户页面选择一后开始跳转的内容，也就是开始游戏。
    //因为其中没有返回值，所以则使用void,同时需要来自用户的输入所以为Scanner
    public void startNewGame(Scanner scanner) {

        //首先询问用户选择难度，然后创建 AI 和 Board 对象，并初始化它们。
        System.out.println("选择难度：1. 简单 2. 普通");
        int difficulty = scanner.nextInt();

        //这些对象代表游戏的状态，如AI的智能水平、玩家和AI的游戏板。

        //new AI(difficulty) 创建了一个 AI 类的实例，这个实例是游戏中的人工智能对手。
        ai = new AI(difficulty);

        //new Board()：创建一个新的游戏板对象，用于跟踪游戏中的船只和射击。
        //这里的 new Board() 被调用两次，分别创建了两个 Board 对象：playerBoard 和 aiBoard。
        //因为在游戏中，玩家和 AI（人工智能）通常需要各自的游戏板来跟踪他们的船只和射击。
        //每个 Board 对象都会有自己的 board 数组和 ships 数组，这样玩家和 AI 的游戏状态就可以独立管理，不会相互干扰。
        playerBoard = new Board();
        aiBoard = new Board();

        //initializeBoard()：初始化游戏板，设置空白状态或准备放置船只。
        //在 initializeBoard() 方法中，我们只关注 board 数组的初始化，因为这个方法的目的是将游戏板的所有格子设置为初始的空白状态，
        //这表示没有船只放置在游戏板上。ships 数组在这个阶段不需要改变，因为它已经在构造函数中被正确初始化了。
        playerBoard.initializeBoard();
        aiBoard.initializeBoard();

        //placeShips：在游戏板上放置船只，玩家和AI都需要执行这一步骤。

        //这行代码调用玩家的 Board 对象的 placeShips 方法，允许玩家通过 Scanner 对象输入坐标和方向来放置他们的船只。
        playerBoard.placeShips(scanner);

        //这行代码是 AI 对象的一个方法调用，它会通过调用ai.placeShips方法来自动且随机放置 AI 的船只到 aiBoard 上。
        ai.placeShips(aiBoard);

        //isPlayerTurn = true：设置轮到玩家行动的标志。
        isPlayerTurn = true;

        //开始游戏的主要部分，交替玩家和AI的回合直到游戏结束。
        playGame(scanner);
    }


    //它读取用户选择的存档文件，并恢复游戏的状态，包括游戏板和AI的状态。
    public void loadGame(Scanner scanner) {

        //显示可以选择的存档
        System.out.println("选择存档：1. 存档一 2. 存档二 3. 存档三");
        int slot = scanner.nextInt();
        //设置一个fileName用于下面
        String fileName = SAVE_FILE_PREFIX + slot + SAVE_FILE_SUFFIX;

        //如存档内无索引则无内容

        //new File(fileName).exists()：检查用户选择的存档文件是否存在。
        if (!new File(fileName).exists()) {
            System.out.println("该存档无内容");
            return;
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            playerBoard = new Board();
            aiBoard = new Board();
            ai = new AI(reader.readLine().equals("easy") ? EASY : NORMAL);

            //loadBoard(reader)：从文件中加载游戏板的状态。
            playerBoard.loadBoard(reader);
            aiBoard.loadBoard(reader);

            //isGameOver 和 isPlayerTurn：从文件中恢复游戏是否结束的状态和当前轮到谁行动
            isGameOver = Boolean.parseBoolean(reader.readLine());
            isPlayerTurn = reader.readLine().equals("player");
        
            playGame(scanner);
        } catch (IOException e) {
            System.out.println("加载游戏时出错。");
        }        
    }

    //在loadGame method中的前置条件

    //这里为存储对应游戏内容
    public void saveGame(int slot) {
        //用于创造一个fileName用于存储
        String fileName = SAVE_FILE_PREFIX + slot + SAVE_FILE_SUFFIX;

        //依照使用的fileName来对所需要的给了游戏中的内容进行存储
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //AI的难度条件
            writer.write(ai.getDifficulty() == EASY ? "easy" : "normal");
            writer.newLine();
            //游戏进行与否
            writer.write(Boolean.toString(isGameOver));
            writer.newLine();
            //是否为玩家或是ai回合
            writer.write(isPlayerTurn ? "player" : "ai");
            writer.newLine();
            //对双方的游戏板进行保存
            playerBoard.saveBoard(writer);
            aiBoard.saveBoard(writer);
            // 不需要显式调用writer.close()，它会在try块结束时自动关闭
        } catch (IOException e) {
            //一个象征性的报错，可在实际运行中并没有返回，而是直接弹出所有错误
            System.out.println("保存游戏时出错。");
        }
    }

    public void showInstructions() {
        System.out.println("战舰游戏说明：");
        // 显示详细说明
    }

    //playGame 方法，整个逻辑确保了玩家和 AI 能够交替进行回合，直到其中一个方法返回ture
    public void playGame(Scanner scanner) {
        isGameOver = false;
        while (!isGameOver) {
            if (isPlayerTurn) {
                //玩家回合
                playerTurn(scanner);
            } else {
                //AI回合
                aiTurn();
            }
             // 循环结束后，会根据游戏状态更新isGameOver变量
        }
    }

    //确保玩家可以互动地参与游戏，并且游戏的状态可以根据玩家的行动而改变。
    public void playerTurn(Scanner scanner) {
        System.out.println("玩家的回合");// 用于跟踪射击是否有效
        boolean validShot = false; //设置射击的初始状态
        while (!validShot) {
            //通过使用displayShotBoard()方法显示aiBoard (aiBoard 内有aiBoard = new Board()，则有Board()构造函数内的相关内容)
            aiBoard.displayShotBoard();

            System.out.println("玩家的战舰板：");
            playerBoard.displayBoard();

            //提示用户输入并读取用户输入
            System.out.print("输入射击坐标 (格式: x y) 或 'q' 退出 或 'save' 保存: ");
            String input = scanner.next();

            // 如果玩家输入 'q'，则退出游戏
            if (input.equalsIgnoreCase("q")) {
                System.out.println("退出游戏...");
                isGameOver = true;
                return;
            
            // 如果玩家输入 'save'，则保存游戏
            } else if (input.equalsIgnoreCase("save")) {
                System.out.println("选择存档：1. 存档一 2. 存档二 3. 存档三");
                int slot = scanner.nextInt();
                saveGame(slot);
                System.out.println("游戏已保存。");
                return;
            }

            try {
                // 解析输入的坐标，注意x和y的顺序与输入相反
                int y = Integer.parseInt(input) - 1; 
                int x = scanner.nextInt() - 1; 

                // 检查坐标是否在游戏板范围内
                if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
                    System.out.println("坐标超出范围，请重新输入。");
                    continue; // 继续下一次循环
                }

                // 检查该位置是否已经被射击过
                if (aiBoard.board[x][y] == HIT_SYMBOL || aiBoard.board[x][y] == MISS_SYMBOL) {
                    System.out.println("已经射击过这个区域，请重新输入。");
                    continue;
                }

                // 尝试在给定坐标上射击
                validShot = aiBoard.shoot(x, y);

                // 根据射击结果输出相应信息
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
                // 如果输入的不是数字，捕获异常并提示重新输入
                System.out.println("输入格式错误，请按照 'x y' 的格式输入坐标。");
            }
        }

        // 显示玩家的游戏板
        System.out.println("玩家的战舰板：");
        playerBoard.displayBoard();

        // 设置轮到AI行动
        isPlayerTurn = false;
    }

    public void aiTurn() {
        System.out.println("AI的回合");// 输出提示信息，表明现在是AI的回合
        int[] shot = ai.shoot(playerBoard);// AI计算射击位置
        int x = shot[0];
        int y = shot[1];

        // AI在玩家游戏板上执行射击，并根据结果输出相应信息
        if (playerBoard.shoot(x, y)) {
            System.out.println("AI命中！");
        } else {
            System.out.println("AI未命中。");
        }

        // 检查玩家的所有船只是否已沉没，如果是，则AI获胜
        if (playerBoard.allShipsSunk()) {
            System.out.println("AI获胜！");
            isGameOver = true;
        }

        // 显示玩家的游戏板，以便玩家看到AI射击的结果
        System.out.println("玩家的战舰板：");
        playerBoard.displayBoard();
        isPlayerTurn = true; // 设置轮到玩家行动
    }

    public class Board {
        public char[][] board;
        public Ship[] ships;

        //public Board() 是一个构造函数，它用于初始化 Board 类的新实例。
        //在 Java 中，构造函数的名称必须与类名相同，并且它们没有返回类型，甚至没有 void。
        //在这里是方便独立管理AI和玩家之间的游戏版跟船只
        public Board() {
            //行代码的作用是初始化 board 数组，为游戏板创建一个具体的大小。
            board = new char[BOARD_SIZE][BOARD_SIZE];
            ships = new Ship[]{
                new Ship("A", 5),
                new Ship("B", 4),
                new Ship("C", 3),
                new Ship("D", 3),
                new Ship("E", 2)
            };
        }

        //initializeBoard() 方法用于将游戏板的每个格子设置为一个预定义的空白符号，是为了游戏开始前的准备。
        //这个方法通过双重循环遍历游戏板的每一行和每一列，将每个位置的字符设置为 EMPTY_SYMBOL，这里为 '-'。
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
            // 遍历 ships 数组中的每艘船
            for (Ship ship : ships) {
                // 标记船只是否已放置
                boolean placed = false;
                while (!placed) {
                    // 显示当前游戏板
                    displayBoard();
                    // 提示玩家放置船只，并显示船只名称和大小
                    System.out.println("放置你的船只: " + ship.getName() + " (" + ship.getSize() + ")");
                    System.out.print("输入坐标和方向 (格式: x y h/v): ");

                    // 读取玩家输入的坐标和方向
                    int x = scanner.nextInt() - 1;
                    int y = scanner.nextInt() - 1;
                    char direction = scanner.next().charAt(0); // 读取方向（水平或垂直）

                    // 尝试放置船只，如果成功，placed将变为true
                    placed = placeShip(ship, y, x, direction);
                    if (!placed) {
                        //失败，返回重试
                        System.out.println("无效的位置，请重试。");
                    }
                }
            }
        }

        public boolean placeShip(Ship ship, int x, int y, char direction) {
            int size = ship.getSize();
            
            return switch (direction) {

                //在实际操作中或许会觉得x应当变化的为横轴，可我缺将实际应用设置为'v'
                //因为一维循环实际是一个方框后在方框下循环，实际表现为y(也就是竖轴行为)
                case 'v' -> {
                    if (x + size > BOARD_SIZE) { // 检查垂直放置是否超出边界
                        yield false;
                    }
                    for (int i = 0; i < size; i++) {
                        if (board[x + i][y] != EMPTY_SYMBOL) {
                            yield false;
                        }
                    }
                    for (int i = 0; i < size; i++) {
                        board[x + i][y] = SHIP_SYMBOL;
                        ship.addCoordinate(x + i, y);
                    }
                    yield true;
                }
                case 'h' -> {
                    if (y + size > BOARD_SIZE) { // 检查水平放置是否超出边界
                        yield false;
                    }
                    for (int i = 0; i < size; i++) {
                        if (board[x][y + i] != EMPTY_SYMBOL) {
                            yield false;
                        }
                    }
                    for (int i = 0; i < size; i++) {
                        board[x][y + i] = SHIP_SYMBOL;
                        ship.addCoordinate(x, y + i);
                    }
                    yield true;
                }
                default -> false;
            };

            //for java version which not 12
            /* 
            switch (direction) {
                case 'v':
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
                    break;
                case 'h':
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
                    break;
                default:
                    return false;
            }
            return true;
            */
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
        private final List<int[]> coordinates;

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


    //模块化：将AI的行为和数据分离到一个单独的类中，使得代码更加清晰和易于管理。
    public class AI {
        public final int difficulty;
        public final Random random;

        //构造函数 (public AI(int difficulty))：设置AI的难度和初始化随机数生成器。
        public AI(int difficulty) {
            //初始化对象的属性：在这里，this.difficulty = difficulty; 表示将传入的 difficulty 参数值赋给对象的 difficulty 属性。
            this.difficulty = difficulty;
            //初始化对象所需的资源：this.random = new Random(); 创建了一个 Random 类
            this.random = new Random();

            //this.difficulty 指的是当前对象的 difficulty 属性，而单独的 difficulty 指的是构造函数参数。
            //为什么使用这个（构造函数）？这是因为构造函数的目的不是返回一个值，而是初始化一个新的对象实例。
        }

        //getDifficulty 方法允许其他类获取 AI 对象的 difficulty 属性值，在这里并没有调用，而是在存储时调用
        public int getDifficulty() {
            return difficulty;
        }

        //placeShips 方法：在游戏板上随机放置船只。
        public void placeShips(Board board) {
            //for (Ship ship : board.ships) 这行代码使用了一个增强型 for 循环来遍历 board 对象中的 ships 数组，这个数组包含了所有需要放置的船只。
            for (Ship ship : board.ships) {
                boolean placed = false;
                while (!placed) {
                    //int x = random.nextInt(BOARD_SIZE); 和 int y = random.nextInt(BOARD_SIZE); 
                    //这两行代码生成两个随机数，用于确定船只放置的起始坐标（x 和 y）。
                    int x = random.nextInt(BOARD_SIZE);
                    int y = random.nextInt(BOARD_SIZE);

                    //这行代码随机选择船只的放置方向，'h' 表示水平方向，'v' 表示垂直方向。
                    //如果条件为真（true），则表达式的结果是 表达式1；如果条件为假（false），则结果是 表达式2。
                    char direction = random.nextBoolean() ? 'h' : 'v';

                    //尝试放置船只：这行代码调用 Board 类的 placeShip 方法尝试在指定位置和方向放置船只。
                    //如果放置成功，placeShip 方法会返回 true，并且 placed 变量会被设置为 true，这会结束 while 循环。
                    //如果放置失败（可能是因为船只超出了游戏板边界或与其他船只重叠），placeShip 方法会返回 false，while 循环会继续，AI会再次尝试新的随机位置和方向。
                    placed = board.placeShip(ship, x, y, direction);
                }
            }
        }

        //shoot 方法：根据AI的难度，决定射击的位置。在简单模式下，AI随机射击；在普通模式下，AI会根据上一次命中的位置来决定射击策略。
        public int[] shoot(Board board) {
            int row, col;

            //首先检查AI的难度级别是否为简单（EASY）。这决定了接下来AI射击策略的选择。
            if (difficulty == EASY) {
                //在简单模式下，AI通过 random.nextInt(BOARD_SIZE) 随机生成 x 和 y 坐标，直到找到一个之前没有射击过的位置（即不是 HIT_SYMBOL 或 MISS_SYMBOL）。
                do {
                    row = random.nextInt(BOARD_SIZE);
                    col = random.nextInt(BOARD_SIZE);
                } while (board.board[row][col] == HIT_SYMBOL || board.board[row][col] == MISS_SYMBOL);
            } else {
                // 在普通难度下的AI射击逻辑

                // 通过调用 findLastHit 方法来查找上一次射击命中的位置
                int[] lastHit = findLastHit();

                //如果 lastHit 不为 null（意味着之前有命中），并且周围有空位，则AI会尝试围绕该区域射击
                if (lastHit != null && hasAdjacentEmpty(board, lastHit[0], lastHit[1])) {
                    // 如果找到了上一次的命中，尝试围绕该区域射击
                    List<int[]> potentialTargets = getSurroundingCoordinates(lastHit[0], lastHit[1], board);

                    do {
                        int[] target = potentialTargets.remove(random.nextInt(potentialTargets.size()));
                        // 注意：这里我们使用 row 和 col 来表示行和列
                        row = target[0];
                        col = target[1];
                    } while (board.board[row][col] == HIT_SYMBOL || board.board[row][col] == MISS_SYMBOL);
                } else {
                    // 如果没有找到上一次的命中，AI会随机选择一个位置进行射击，但会避免已经射击过的位置。
                    do {
                        row = random.nextInt(BOARD_SIZE);
                        col = random.nextInt(BOARD_SIZE);
                    } while (board.board[row][col] == HIT_SYMBOL || board.board[row][col] == MISS_SYMBOL);
                }
            }
            return new int[]{row, col};
        }
        
        //List<int[]> 定义了一个列表，其中可以存储整数数组的元素。每个元素都是一个 int[] 类型，通常用于存储一组整数，比如坐标点 (x, y)。
        public final List<int[]> hits = new ArrayList<>();

        // 在AI射击并命中后调用此方法来记录命中的坐标
        public void recordHit(int row, int col) {
            // 将命中的坐标添加到列表中
            hits.add(new int[]{row, col});
        }
        
        // 改进的findLastHit方法，用于找到最后一次的hit
        private int[] findLastHit() {
            // 如果有命中记录，返回最后一次命中的坐标
            if (!hits.isEmpty()) {
                return hits.get(hits.size() - 1);
            }
            //使用 null 作为返回值的原因是，它提供了一种方式来区分“没有数据”（即 hits 列表为空）与“有数据但数据为零”（例如，如果列表中有一个坐标 [0, 0]）的情况。
            return null;
        }
        
        
        //hasAdjacentEmpty 方法的目的是检查在游戏板上给定位置 (row, col) 周围是否有未被射击过的区域。
        private boolean hasAdjacentEmpty(Board board, int row, int col) {
            //这行代码定义了一个二维数组 directions，包含四个方向：上、下、左、右。
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                //对于每个方向，计算新的坐标 (newRow, newCol)，这是通过将方向数组中的值加到当前坐标 (row, col) 上来实现的。
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                //这个条件判断确保新坐标在游戏板的范围内，即它们不会超出边界。
                if (newRow >= 0 && newRow < BOARD_SIZE && newCol >= 0 && newCol < BOARD_SIZE) {

                    //如果新坐标对应的位置是空的（即未被射击过），则方法返回 true。EMPTY_SYMBOL 是一个常量，代表游戏板上的空位。
                    if (board.board[newRow][newCol] == EMPTY_SYMBOL) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        //getSurroundingCoordinates 方法：获取给定位置周围的所有可能的射击坐标。
        private List<int[]> getSurroundingCoordinates(int row, int col, Board board) {
            //List<int[]> 定义了一个列表，其中可以存储整数数组的元素。每个元素都是一个 int[] 类型，通常用于存储一组整数，比如坐标点 (x, y)。
            List<int[]> coordinates = new ArrayList<>();

            //对于每个方向，计算新的坐标 (newRow, newCol)，这是通过将方向数组中的值加到当前坐标 (row, col) 上来实现的。
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < BOARD_SIZE && newCol >= 0 && newCol < BOARD_SIZE) {
                    if (board.board[newRow][newCol] == EMPTY_SYMBOL) {
                        coordinates.add(new int[]{newRow, newCol});
                    }
                }
            }

            return coordinates;
        }        
    }

}
