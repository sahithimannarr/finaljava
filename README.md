# Flappy Bird Game

This is a Java implementation of the classic Flappy Bird game using the Swing framework. The game features a bird that the player controls, attempting to navigate through a series of pipes without colliding with them. The objective is to achieve the highest score possible by successfully passing through the gaps between the pipes.

## Features

- Simple and intuitive gameplay mechanics
- Randomly generated pipes for endless gameplay
- Score tracking to keep a record of the player's performance
- Game over detection and restart functionality
- Custom exceptions for collision and out-of-bounds scenarios
- Object-oriented design with separate packages for game objects, utility, exceptions, and core game logic

## Getting Started

To run the Flappy Bird game on your local machine, follow these steps:

1. Make sure you have Java Development Kit (JDK) installed on your computer.
2. Clone this repository to your local machine using the following command: git clone https://github.com/your-username/flappy-bird-game.git
3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
4. Build the project to ensure all dependencies are resolved.
5. Run the `Main` class located in the `main` package to start the game.

## How to Play

- Press the spacebar to make the bird flap its wings and ascend.
- Navigate the bird through the gaps between the pipes without colliding with them.
- Each successful pass through a pipe gap earns you one point.
- The game ends if the bird collides with a pipe or goes out of bounds.
- Press the restart button to start a new game after the game is over.

## Project Structure

The project follows a package structure to organize the code:

- `gameobjects`: Contains the classes for game objects such as `Bird` and `Pipe`.
- `gameutility`: Contains utility classes for game-related functionality, such as collision detection.
- `gameexceptions`: Contains custom exception classes for handling game-specific exceptions.
- `gamecore`: Contains the core game logic and the main `FlappyBird` class.
- `main`: Contains the entry point of the application, the `Main` class.

## Dependencies

The project uses the following dependencies:

- Java Development Kit (JDK) 8 or above
- Swing framework (included in the JDK)

## Contributing

Contributions to the Flappy Bird game project are welcome. If you find any bugs, have suggestions for improvements, or want to add new features, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

The Flappy Bird game is inspired by the original game created by Dong Nguyen. This project is developed for educational purposes and as a demonstration of Java programming concepts.
