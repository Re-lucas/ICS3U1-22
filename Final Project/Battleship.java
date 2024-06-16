import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battleship {

    // Constants that define the game board size
   public static final int BOARD_SIZE = 10;
   public static final char SHIP_SYMBOL = 'S';
   public static final char HIT_SYMBOL = 'H';
   public static final char MISS_SYMBOL = 'M';
   public static final char EMPTY_SYMBOL = '-';
    
    // Difficulty levels
   public static final int EASY = 1;
   public static final int NORMAL = 2;
    
    // Save file related constants
   public static final String SAVE_FILE_PREFIX = "save";
   public static final String SAVE_FILE_SUFFIX = ".txt";
   public static final int SAVE_SLOT_1 = 1;
   public static final int SAVE_SLOT_2 = 2;
   public static final int SAVE_SLOT_3 = 3;

    // Initializations used for setup; unsure if should be immutable
   public Board playerBoard;
   public Board aiBoard;
   public AI ai;
   public boolean isGameOver;
   public boolean isPlayerTurn;

 // This is the entry point for the Java program
   public static void main(String[] args) {
    // Create a scanner object to read user input
      Scanner scanner = new Scanner(System.in);
    // Create an instance of Battleship game
      Battleship game = new Battleship();
   
    // This line of code invokes the run method of the Battleship object and passes scanner as a parameter
    // This is done to encapsulate all the game logic inside the Battleship class.
    // It allows easy access and use of all methods and variables defined in that class.
    // If we need to call its contents again, we simply call game.run(scanner);
    // It keeps the main method clean as we don't need to call various methods of different classes directly.
      game.run(scanner);
   
    // Alternatively, in simpler terms: The Battleship object is the core of the game, responsible for starting and running it.
   }


 // This method represents the main control logic of a Battleship game,
// organized using object-oriented principles with user input as the primary driver.
   public void run(Scanner scanner) {
      boolean running = true;
   
    // This is the main game loop responsible for displaying the main menu
    // and executing corresponding actions based on user input.
    // It uses a while loop to continue running until the user chooses to exit.
      while (running) {
        // Displaying the menu options for the player to choose from
         System.out.println("Main Menu (Enter Number)");
         System.out.println("1. Start a new game");
         System.out.println("2. Load a saved game");
         System.out.println("3. View game instructions");
         System.out.println("4. Quit the program");
         System.out.print("Please choose: ");
      
        // Read the user's input
         String input = scanner.next();
         int choice = Integer.parseInt(input);
      
        // Switch statement to handle each possible user choice
         switch (choice) {
            // startNewGame method: Invoked when the user chooses to start a new game.
            case 1 -> startNewGame(scanner);
            // loadGame method: Invoked when the user chooses to load a saved game.
            case 2 -> loadGame(scanner);
            // showInstructions method: Invoked when the user chooses to view game instructions,
            // displaying rules and gameplay guidelines.
            case 3 -> showInstructions();
            // Exit the program: Sets the running flag to false, ending the while loop.
            case 4 -> running = false;
            // Default case for handling invalid choices by the user.
            default ->  System.out.println("Invalid choice, please try again.");
         }
      }
   }

    
// This method represents the starting point of the game when the user chooses to begin a new game.
// It does not return any value (void) and requires user input via Scanner.
   public void startNewGame(Scanner scanner) {
   
    // Prompt the user to select the game difficulty: 1 for Easy, 2 for Normal.
      System.out.println("Choose difficulty: 1. Easy 2. Normal (Enter Number)");
      int difficulty = scanner.nextInt();
   
    // Initialize game state objects: AI, player's board, and AI's board.
   
    // Create an AI opponent instance based on the selected difficulty level.
      ai = new AI(difficulty);
   
    // Create new Board objects to track ships and shots for both the player and AI.
    // Here, new Board() is called twice, creating two Board objects: playerBoard and aiBoard.
    // In a game scenario, separate boards are necessary for the player and AI to manage their respective game states independently.
      playerBoard = new Board();
      aiBoard = new Board();
   
    // Initialize the player's game board, setting initial empty state or preparing for ship placement.
    // The initializeBoard() method initializes the board array to its initial state of blank cells,
    // indicating no ships are placed on the game board yet. The ships array does not need modification here
    // as it is already initialized correctly in the constructor.
      playerBoard.initializeBoard();
      aiBoard.initializeBoard();
   
    // Place ships on the game board for both the player and AI.
   
    // This line calls the placeShips method of the player's Board object,
    // allowing the player to input coordinates and directions via the Scanner object to place their ships.
      playerBoard.placeShips(scanner);
   
    // This line invokes a method of the AI object to automatically and randomly place AI's ships on aiBoard.
      ai.placeShips(aiBoard);
   
    // Set isPlayerTurn = true to indicate it's the player's turn to act.
      isPlayerTurn = true;
   
    // Start the main part of the game, alternating turns between the player and AI until the game ends.
      playGame(scanner);
   }


// This method saves the game state, including whose turn it is, player and AI boards, and AI state, to a specified slot.
   public void saveGame(int slot) {
      String filename = SAVE_FILE_PREFIX + slot + SAVE_FILE_SUFFIX;
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        // Save whether it's the player's turn
         writer.write(Boolean.toString(isPlayerTurn));
         writer.newLine();
        // Save player and AI game boards
         playerBoard.saveBoard(writer);
         aiBoard.saveBoard(writer);
        // Save AI state
         ai.saveAI(writer);
      } catch (IOException e) {
         System.out.println("Unable to save the game.");
      }
   }

// This method loads a saved game state from a specified slot, including player and AI boards and AI state.
   public void loadGame(Scanner scanner) {
      System.out.println("Select a slot to load:  1. Slot 1  2. Slot 2  3. Slot 3 (Enter Number)");
      int slot = scanner.nextInt();
      String filename = SAVE_FILE_PREFIX + slot + SAVE_FILE_SUFFIX;
      try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        // Load whether it's the player's turn
         isPlayerTurn = Boolean.parseBoolean(reader.readLine());
        // Create new Board objects for player and AI
         playerBoard = new Board();
         aiBoard = new Board();
        // Load player and AI boards
         playerBoard.loadBoard(reader);
         aiBoard.loadBoard(reader);
        // Initialize AI with difficulty 0; this will be overwritten by loadAI method
         ai = new AI(0);
        // Load AI state
         ai.loadAI(reader);
        // Resume the game
         playGame(scanner);
      } catch (IOException e) {
         System.out.println("Unable to load the game.");
      }
   }

// This method displays instructions for playing the Battleship game.
   public void showInstructions() {
    // Display detailed instructions
      System.out.println("### Battleship Game Instructions ###");
      System.out.println();
      
      System.out.println("Objective:");
      System.out.println("The objective of the game is to sink all of your opponent's ships before they sink all of yours. The game is played on a grid where players take turns guessing the locations of the opponent's ships.");
      System.out.println();
      
      System.out.println("Game Setup:");
      System.out.println("Board Configuration:");
      System.out.println("- Each player has their own board, which is typically a 10x10 grid. The rows are labeled 1 to 10 and the columns are labeled A to J.");
      System.out.println("- Players place their ships on their board. Ships can be placed either horizontally or vertically but not diagonally. Ships cannot overlap or be placed outside the grid.");
      System.out.println();
      
      System.out.println("Ships:");
      System.out.println("- Each player has a fleet of ships. The standard fleet consists of the following ships:");
      System.out.println("  - Carrier: 5 cells");
      System.out.println("  - Battleship: 4 cells");
      System.out.println("  - Cruiser: 3 cells");
      System.out.println("  - Submarine: 3 cells");
      System.out.println("  - Destroyer: 2 cells");
      System.out.println();
      
      System.out.println("Playing the Game:");
      System.out.println("Placing Ships:");
      System.out.println("- Players place their ships on their own grid. The ships' locations are kept secret from the opponent.");
      System.out.println("- In this game implementation, the AI will place its ships randomly on the board. Players can place their ships either manually or use a similar random placement strategy.");
      System.out.println();
      
      System.out.println("Taking Turns:");
      System.out.println("- Players take turns calling out a shot to a specific coordinate on the opponent's grid. For example, 'B7'.");
      System.out.println("- The opponent checks if the coordinate hits one of their ships:");
      System.out.println("  - Hit: If a shot hits a ship, the opponent announces 'Hit'. The cell is marked as hit on the attacker's grid.");
      System.out.println("  - Miss: If a shot misses, the opponent announces 'Miss'. The cell is marked as miss on the attacker's grid.");
      System.out.println("- The game continues with players taking alternate turns until one player sinks all the ships of the opponent.");
      System.out.println();
      
      System.out.println("Recording Hits and Misses:");
      System.out.println("- Each player's board tracks their own ships and the shots fired by the opponent.");
      System.out.println("- The attacker also maintains a separate grid to record the outcomes of their shots on the opponent's board.");
      System.out.println();
      
      System.out.println("Sinking Ships:");
      System.out.println("- When all the cells of a ship have been hit, the ship is considered sunk. The opponent announces which ship has been sunk.");
      System.out.println("- The game continues until all ships of one player are sunk.");
      System.out.println();
      
      System.out.println("Winning the Game:");
      System.out.println("- The first player to sink all of the opponent's ships wins the game.");
   }

// This method controls the main gameplay loop, ensuring turns alternate between player and AI until the game ends.
   public void playGame(Scanner scanner) {
      isGameOver = false;
      while (!isGameOver) {
         if (isPlayerTurn) {
            // Player's turn
            playerTurn(scanner);
         } else {
            // AI's turn
            aiTurn();
         }
        // The loop continues until the game is over, based on game logic updates to isGameOver variable.
      }
   }

// This method ensures the player can interactively participate in the game and updates the game state based on player actions.
   public void playerTurn(Scanner scanner) {
      System.out.println("Player's Turn");
      boolean validShot = false;
   
    // Display AI's board to the player
      System.out.println("AI's Ship Board:");
      aiBoard.displayBoard();
   
    // Prompt the player to input and read their action
      System.out.print("Enter shot coordinates (format: x y) or 'q' to quit or 'save' to save: ");
      String input = scanner.next();
   
    // If the player inputs 'q', quit the game
      if (input.equalsIgnoreCase("q")) {
         System.out.println("Quitting the game...");
         isGameOver = true;
         return;
      // If the player inputs 'save', save the game
      } else if (input.equalsIgnoreCase("save")) {
         System.out.println("Select a slot to save: 1. Slot 1 2. Slot 2 3. Slot 3");
         int slot = scanner.nextInt();
         saveGame(slot);
         System.out.println("Game saved.");
         return;
      }
   
      try {
        // Parse the shot coordinates from the input (note: x and y order is reversed from input)
         int y = Integer.parseInt(input) - 1; // Convert to zero-based index
         int x = scanner.nextInt() - 1; // Convert to zero-based index
      
        // Check if coordinates are within board bounds
         if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            System.out.println("Coordinates out of bounds. Please enter again.");
         } else if (aiBoard.board[x][y] == HIT_SYMBOL || aiBoard.board[x][y] == MISS_SYMBOL) {
            // Check if the position has already been shot at
            System.out.println("You have already shot at this position. Please enter again.");
         } else {
            // Shoot at the given coordinates
            validShot = aiBoard.shoot(x, y);
         
            // Output appropriate message based on shot result
            if (validShot) {
               System.out.println("Hit!");
            } else {
               System.out.println("Miss.");
            }
         
            // Check if all AI ships are sunk (player wins if true)
            if (aiBoard.allShipsSunk()) {
               System.out.println("Player wins!");
               isGameOver = true;
            } else {
                // Switch to AI's turn only after a valid shot
               isPlayerTurn = false;
            }
         }
      } catch (NumberFormatException e) {
        // Catch input format errors and prompt user to retry
         System.out.println("Invalid input format. Please enter coordinates in 'x y' format.");
      }
   
   }

    
// This method handles the AI's turn in the game.
   public void aiTurn() {
      System.out.println("AI's Turn"); // Output a message indicating it's the AI's turn
    
    // AI calculates the shot position on the player's board
      int[] shot = ai.shoot(playerBoard);
      int x = shot[0];
      int y = shot[1];
    
    // AI performs a shot on the player's board and outputs corresponding message based on the result
      if (playerBoard.shoot(x, y)) {
         System.out.println("AI hit!");
      } else {
         System.out.println("AI missed.");
      }
    
    // Check if all player's ships are sunk; if true, AI wins
      if (playerBoard.allShipsSunk()) {
         System.out.println("AI wins!");
         isGameOver = true;
      }
    
    // Display the player's board so the AI can see the result of its shot
      System.out.println("Player's Ship Board:");
      playerBoard.displayBoard();
    
      isPlayerTurn = true; // Set turn to player's turn
   }


// This class represents the game board.
   public class Board {
      public char[][] board; // Represents the game board as a 2D character array
      public Ship[] ships; // Array to hold the ships on the board
   
    // Constructor initializes a new instance of Board with a specific size and predefined ships.
      public Board() {
         board = new char[BOARD_SIZE][BOARD_SIZE]; // Initialize board with specified size
         ships = new Ship[]{ // Initialize ships array with predefined ships
            new Ship("Carrier", 5),
            new Ship("Battleship", 4),
            new Ship("Submarine", 3),
            new Ship("Cruiser", 3),
            new Ship("Destroyer", 2)
            };
      }
   
    // initializeBoard() method sets up the board with empty symbols at the start of the game.
      public void initializeBoard() {
         for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
               board[i][j] = EMPTY_SYMBOL; // Set each position on the board to empty symbol at the start
            }
         }
      }
   
    // displayBoard() method displays the current state of the board without showing ships' positions.
      public void displayBoard() {
         display(board, false); // Call display method with hideShips set to false
      }
   
    // displayShotBoard() method displays the board after shots, showing ships' positions if not hidden.
      public void displayShotBoard() {
         display(board, true); // Call display method with hideShips set to true
      }
   
    // display(char[][] board, boolean hideShips) method prints the board with options to hide ships' positions.
      public void display(char[][] board, boolean hideShips) {
         System.out.print("  ");
      
        // Print column numbers
         for (int i = 1; i <= BOARD_SIZE; i++) {
            System.out.print(i + " ");
         }
         System.out.println();
      
        // Iterate through each row of the board
         for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                // If hideShips is true and current position is a ship symbol, print empty symbol instead
               if (hideShips && board[i][j] == SHIP_SYMBOL) {
                  System.out.print(EMPTY_SYMBOL + " ");
               } else {
                    // Otherwise, print actual board content
                  System.out.print(board[i][j] + " ");
               }
            }
            System.out.println();
         }
      }
   
   // This method allows the player to place their ships on the board.
      public void placeShips(Scanner scanner) {
      // Iterate through each ship in the ships array
         for (Ship ship : ships) {
            boolean placed = false; // Flag to track if the ship has been successfully placed
            while (!placed) {
               displayBoard(); // Display the current state of the board
            // Prompt the player to place the ship, showing ship name and size
               System.out.println("Place your ship: " + ship.getName() + " (" + ship.getSize() + ")");
               System.out.print("Enter coordinates and direction (format: x y h/v): ");
            
            // Read player's input for coordinates and direction
               int x = scanner.nextInt() - 1; // Adjust to 0-based index
               int y = scanner.nextInt() - 1; // Adjust to 0-based index
               char direction = scanner.next().charAt(0); // Read direction (h for horizontal, v for vertical)
            
            // Attempt to place the ship; if successful, set placed to true
               placed = placeShip(ship, y, x, direction);
               if (!placed) {
                  System.out.println("Invalid position, please try again."); // Inform player of invalid placement
               }
            }
         }
      }
   
   // This method attempts to place a ship on the board at the specified coordinates and direction.
      public boolean placeShip(Ship ship, int x, int y, char direction) {
         int size = ship.getSize(); // Get the size of the ship
      
         return 
            switch (direction) {
               case 'v' -> {
                  if (x + size > BOARD_SIZE) { // Check if vertical placement exceeds board boundaries
                     yield false;
                  }
               // Check if there's any overlapping with existing ships in the chosen position
                  for (int i = 0; i < size; i++) {
                     if (board[x + i][y] != EMPTY_SYMBOL) { // Check if the position is already occupied
                        yield false;
                     }
                  }
               // Place the ship vertically on the board
                  for (int i = 0; i < size; i++) {
                     board[x + i][y] = SHIP_SYMBOL; // Mark the position with the ship symbol
                     ship.addCoordinate(x + i, y); // Add the ship's coordinates to its list of coordinates
                  }
                  yield true; // Return true indicating successful placement
               }
               case 'h' -> {
                  if (y + size > BOARD_SIZE) { // Check if horizontal placement exceeds board boundaries
                     yield false;
                  }
               // Check if there's any overlapping with existing ships in the chosen position
                  for (int i = 0; i < size; i++) {
                     if (board[x][y + i] != EMPTY_SYMBOL) { // Check if the position is already occupied
                        yield false;
                     }
                  }
               // Place the ship horizontally on the board
                  for (int i = 0; i < size; i++) {
                     board[x][y + i] = SHIP_SYMBOL; // Mark the position with the ship symbol
                     ship.addCoordinate(x, y + i); // Add the ship's coordinates to its list of coordinates
                  }
                  yield true; // Return true indicating successful placement
               }
               default -> false; // Return false for invalid direction
            };
      }
   
   // This method handles shooting actions by the player or AI on the game board.
      public boolean shoot(int x, int y) {
         if (board[x][y] == SHIP_SYMBOL) {
         // If there's a ship at the shooting coordinates (SHIP_SYMBOL), mark it as hit (HIT_SYMBOL)
            board[x][y] = HIT_SYMBOL;
            boolean hitMade = false;
         
         // Iterate through all ships to check if any ship is at the shooting coordinates.
         // If found, call the ship's hit method and use hitMade variable to ensure only one ship is hit per turn.
            for (Ship ship : ships) {
               if (!hitMade && ship.isAtCoordinate(x, y)) {
                  ship.hit();
                  hitMade = true; // Mark ship as hit to avoid hitting the same ship again
               }
            }
         // Return true indicating a hit.
            return true;
         } else {
         // If there's no ship at the shooting coordinates, mark it as a miss (MISS_SYMBOL).
            board[x][y] = MISS_SYMBOL;
         // Return false indicating a miss.
            return false;
         }
      }
   
   // This method checks if all ships on the board are sunk.
      public boolean allShipsSunk() {
         for (Ship ship : ships) {
         // Iterate through all ships and check if any ship is not sunk.
            if (!ship.isSunk()) {
            // If a ship is found that is not sunk, return false.
               return false;
            }
         }
      // If all ships are sunk, return true.
         return true;
      }
   
   
   // This method saves the current state of the game board and all ships to a file using a BufferedWriter.
      public void saveBoard(BufferedWriter writer) throws IOException {
      // Save the state of the game board
         for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
            // Write the character representing each cell on the board to the file
               writer.write(board[i][j]);
            }
         // Move to the next line in the file after writing each row of the board
            writer.newLine();
         }
      
      // Save the state of each ship
         for (Ship ship : ships) {
         // Write ship details in the format "name,size,hitCount,coordinates"
            writer.write(ship.getName() + "," + ship.getSize() + "," + ship.getHitCount());
         
         // Write each coordinate of the ship to the file
            for (int[] coord : ship.getCoordinates()) {
               writer.write("," + coord[0] + "," + coord[1]);
            }
         // Move to the next line in the file after writing each ship's details
            writer.newLine();
         }
      }
   
   // This method loads the game state from a file into the game board and ships using a BufferedReader.
      public void loadBoard(BufferedReader reader) throws IOException {
         for (int i = 0; i < BOARD_SIZE; i++) {
            String line = reader.readLine();
            for (int j = 0; j < BOARD_SIZE; j++) {
               board[i][j] = line.charAt(j);
            }
         }
         for (Ship ship : ships) {
            String[] parts = reader.readLine().split(",");
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
      public String name;           // Name of the ship
      public int size;              // Size of the ship (number of cells it occupies)
      public int hitCount;          // Number of times the ship has been hit
      public final List<int[]> coordinates;  // List to store the coordinates occupied by the ship
    
        // Constructor to initialize a Ship object with name and size
      public Ship(String name, int size) {
         this.name = name;
         this.size = size;
         this.hitCount = 0;        // Initially, no hits on the ship
         this.coordinates = new ArrayList<>();  // Initialize the list of coordinates
      }
    
        // Getter and setter methods for ship attributes
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
    
        // Method to retrieve the list of coordinates occupied by the ship
      public List<int[]> getCoordinates() {
         return coordinates;
      }
    
        // Method to add a coordinate (x, y) to the ship's list of coordinates
      public void addCoordinate(int x, int y) {
         coordinates.add(new int[]{x, y});
      }
    
        // Method to check if the ship is located at a specific coordinate (x, y)
      public boolean isAtCoordinate(int x, int y) {
         for (int[] coord : coordinates) {
            if (coord[0] == x && coord[1] == y) {
               return true;
            }
         }
         return false;
      }
    
        // Method to register a hit on the ship
      public void hit() {
         hitCount++;
      }
    
        // Method to check if the ship is sunk (all parts hit)
      public boolean isSunk() {
         return hitCount >= size;
      }
   }
    


    //Modularity: Separating AI behavior and data into a single class makes the code clearer and easier to manage.
   public class AI {
      public int difficulty;
      public final Random random;
   
        //List<int[]> defines a list in which the elements of an array of integers can be stored. Each element is of type int[] and is typically used to store a set of integers, such as coordinate points (x, y).        
      public final List<int[]> hits = new ArrayList<>();
   
      public void saveAI(BufferedWriter writer) throws IOException {
            // Write the AI's difficulty level to the file
         writer.write(Integer.toString(difficulty));
         writer.newLine(); // Move to the next line in the file
        
            // Write each hit coordinate stored in the hits list
         for (int[] hit : hits) {
            writer.write(hit[0] + "," + hit[1]); // Write x and y coordinates separated by comma
            writer.newLine(); // Move to the next line in the file for the next hit coordinate
         }
      }
        
      public void loadAI(BufferedReader reader) throws IOException {
            // Read and parse the AI's difficulty level
         difficulty = Integer.parseInt(reader.readLine());
        
         String line;
            // Read each line containing hit coordinates until the end of file or an empty line is encountered
         while ((line = reader.readLine()) != null && !line.isEmpty()) {
                // Split each line by commas to separate x and y coordinates
            String[] parts = line.split(",");
            int row = Integer.parseInt(parts[0]); // Parse x coordinate
            int col = Integer.parseInt(parts[1]); // Parse y coordinate
            hits.add(new int[]{row, col}); // Add the hit coordinate to the hits list
         }
      }
        
   /**
   * Constructor (public AI(int difficulty)): Sets the AI's difficulty and initializes the random number generator.
   *
   * The difficulty level to set for the AI.
   * Initializes the object's properties: Here, `this.difficulty = difficulty;` assigns the passed `difficulty` parameter value to the object's `difficulty` attribute.
   * Initializes the resources required by the object: `this.random = new Random();` creates a new instance of the `Random` class.
   *
   * `this.difficulty` refers to the current object's `difficulty` attribute, while `difficulty` alone refers to the constructor parameter.
   * Why use this (constructor)? This is because the purpose of a constructor is not to return a value, but to initialize a new object instance.
   */
      public AI(int difficulty) {
         this.difficulty = difficulty;
         this.random = new Random();
      }
   
   //getDifficulty method, which allows other classes to get the value of the difficulty property of an AI object, is not called here, but rather when it is stored.
      public int getDifficulty() {
         return difficulty;
      }
   
     /**
   * placeShips method: Randomly places ships on the game board.
   *
   * This method iterates over the `ships` array in the `board` object using an enhanced for loop (`for (Ship ship : board.ships)`).
   * The `ships` array contains all ships that need to be placed.
   *
   * Within the loop:
   * - `int x = random.nextInt(BOARD_SIZE);` and `int y = random.nextInt(BOARD_SIZE);` generate two random numbers to determine the starting coordinates (x and y) for placing the ship.
   * - `char direction = random.nextBoolean() ? 'h' : 'v';` randomly selects the direction ('h' for horizontal, 'v' for vertical) in which the ship will be placed.
   * 
   * The `board.placeShip(ship, x, y, direction)` method is called to attempt placing the ship at the specified position and direction.
   * - If placement is successful, `placeShip` returns true, and `placed` variable is set to true, ending the while loop.
   * - If placement fails (e.g., ship exceeds the game board boundaries or overlaps with another ship), `placeShip` returns false, and the while loop continues.
   * 
   * This process repeats for each ship in the `board.ships` array until all ships are successfully placed.
   */
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
   
   /**
   * shoot method: Determines the shooting position based on the AI's difficulty level.
   *
   * - In EASY mode, the AI randomly selects a shooting target until it finds a position that has not been shot before.
   * - In NORMAL mode, the AI's shooting strategy is more complex:
   *   - First, it checks for the last hit position using the findLastHit method.
   *   - If there was a previous hit and there are adjacent empty positions around the hit, it identifies potential targets.
   *   - If there are potential targets available:
   *     - It randomly selects one target from the surrounding coordinates until it finds an unshot position.
   *   - If no potential targets are found:
   *     - It resorts to randomly selecting a shooting target similar to EASY mode.
   *
   * Parameters:
   * - board: The game board object on which the AI is shooting.
   *
   * Returns:
   * - An array of integers representing the coordinates (row, col) of the selected shooting target.
   */
      public int[] shoot(Board board) {
         int row = -1, col = -1;
      
      // First, we check the AI's difficulty level
         if (difficulty == EASY) {
         // In EASY mode, the AI randomly selects a shooting target until it finds a position that has not been shot before
            do {
               row = random.nextInt(BOARD_SIZE);
               col = random.nextInt(BOARD_SIZE);
            } while (board.board[row][col] == HIT_SYMBOL || board.board[row][col] == MISS_SYMBOL);
         } else {
         // In NORMAL mode, the AI's shooting strategy is more complex
         
         // First, we find the last hit position
            int[] lastHit = findLastHit();
         
         // If there was a previous hit and there are adjacent empty positions around the hit
            if (lastHit != null && hasAdjacentEmpty(board, lastHit[0], lastHit[1])) {
            // We get all possible shooting targets around the hit position
               List<int[]> potentialTargets = getSurroundingCoordinates(lastHit[0], lastHit[1], board);
            
            // If there are potential targets
               if (!potentialTargets.isEmpty()) {
                // We randomly select a target to shoot until we find an unshot position
                  int[] target = potentialTargets.get(random.nextInt(potentialTargets.size()));
                  row = target[0];
                  col = target[1];
               } else {
                // If no potential targets are available, resort to random selection similar to EASY mode
                  do {
                     row = random.nextInt(BOARD_SIZE);
                     col = random.nextInt(BOARD_SIZE);
                  } while (board.board[row][col] == HIT_SYMBOL || board.board[row][col] == MISS_SYMBOL);
               }
            } else {
            // If there was no previous hit, or no adjacent empty positions around the hit, resort to random selection similar to EASY mode
               do {
                  row = random.nextInt(BOARD_SIZE);
                  col = random.nextInt(BOARD_SIZE);
               } while (board.board[row][col] == HIT_SYMBOL || board.board[row][col] == MISS_SYMBOL);
            }
         }
      // Finally, return the selected shooting target coordinates
         return new int[]{row, col};
      }
   
   /**
   * recordHit method: Called after the AI shoots and hits a target to record the hit coordinates.
   *
   * Parameters:
   * - row: The row index of the hit target.
   * - col: The column index of the hit target.
   */
      public void recordHit(int row, int col) {
      // Adds the hit coordinates to the hits list
         hits.add(new int[]{row, col});
      }
   
   /**
   * findLastHit method: Returns the coordinates of the last recorded hit by the AI.
   *
   * Returns:
   * - An array of integers representing the coordinates (row, col) of the last hit.
   * - Returns null if there are no recorded hits (hits list is empty).
   *
   * Notes:
   * - Uses null as a return value to distinguish between no data (empty hits list) and zero data (e.g., list contains [0, 0]).
   */
      public int[] findLastHit() {
      // If there are recorded hits, returns the coordinates of the last hit
         if (!hits.isEmpty()) {
            return hits.get(hits.size() - 1);
         }
      // Returns null if there are no recorded hits
         return null;
      }
   
        
   /**
   * hasAdjacentEmpty method: Checks if there are adjacent empty positions around the given coordinates (row, col) on the game board.
   *
   * Parameters:
   * - board: The game board object containing the board state.
   * - row: The row index of the position to check.
   * - col: The column index of the position to check.
   *
   * Returns:
   * - true if there is at least one adjacent position that is empty and hasn't been shot at.
   * - false otherwise.
   *
   * Notes:
   * - Uses a predefined 2D array directions to represent four directions: up, down, left, and right.
   * - Calculates new coordinates (newRow, newCol) for each direction by adding direction offsets to the current coordinates (row, col).
   * - Ensures the new coordinates are within the board boundaries (0 <= newRow, newCol < BOARD_SIZE).
   * - Checks if the position at the new coordinates on the board (board.board[newRow][newCol]) is EMPTY_SYMBOL, indicating it hasn't been shot at.
   */
      public boolean hasAdjacentEmpty(Board board, int row, int col) {
      // Defines directions array containing four directions: up, down, left, and right
         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      
      // Iterates over each direction
         for (int[] dir : directions) {
         // Calculates new coordinates (newRow, newCol) by adding direction offsets to (row, col)
            int newRow = row + dir[0];
            int newCol = col + dir[1];
         
         // Ensures new coordinates are within the board boundaries
            if (newRow >= 0 && newRow < BOARD_SIZE && newCol >= 0 && newCol < BOARD_SIZE) {
            // Checks if the position at the new coordinates is empty and hasn't been shot at
               if (board.board[newRow][newCol] == EMPTY_SYMBOL) {
                  return true; // Found an adjacent empty position
               }
            }
         }
         return false; // No adjacent empty position found
      }
   
     /**
   * getSurroundingCoordinates method: Retrieves all possible shooting coordinates surrounding a given position (row, col) on the game board.
   *
   * Parameters:
   * - row: The row index of the center position.
   * - col: The column index of the center position.
   * - board: The game board object containing the current board state.
   *
   * Returns:
   * - List<int[]>: A list containing integer arrays representing coordinates (row, col) of all surrounding empty positions that haven't been shot at.
   *
   * Notes:
   * - Uses a List<int[]> to store integer arrays where each array contains two integers representing coordinates (row, col).
   * - Calculates potential surrounding coordinates by adding predefined direction offsets to the center position (row, col).
   * - Checks if each calculated coordinate is within the board boundaries (0 <= newRow, newCol < BOARD_SIZE).
   * - Adds coordinates to the list only if the corresponding board position (board.board[newRow][newCol]) is EMPTY_SYMBOL, indicating it hasn't been shot at.
   */
      public List<int[]> getSurroundingCoordinates(int row, int col, Board board) {
      // Initialize an empty list to store coordinates
         List<int[]> coordinates = new ArrayList<>();
      
      // Define directions array containing four directions: up, down, left, right
         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      
      // Iterate over each direction to calculate surrounding coordinates
         for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
         
         // Check if the new coordinates are within the board boundaries
            if (newRow >= 0 && newRow < BOARD_SIZE && newCol >= 0 && newCol < BOARD_SIZE) {
            // Check if the board position at the new coordinates is empty and hasn't been shot at
               if (board.board[newRow][newCol] == EMPTY_SYMBOL) {
                // Add the new coordinates to the list of surrounding coordinates
                  coordinates.add(new int[]{newRow, newCol});
               }
            }
         }
      
      // Return the list of surrounding coordinates
         return coordinates;
      }
   }
}