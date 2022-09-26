# Encoder

This is a program written in Java that continuously takes a string input, encodes it, and prints the encoded text.

- The program is started in the `Main` class.
- The encoding occurs using the `encode` method in the `Encoder` class.
- The reference table entries used during encoding are passed to `ReferenceTable` during instantiation in `Main`.
- The `Encoder` class also contains a `decode` method, although it is not used in the main program loop.


## Notes
- If no input is given (i.e. the user immediately presses `Enter`), a blank line is printed.
- If a character in the input string cannot be found in the reference table, it is mapped back to itself.
- The encoding is case-sensitive e.g. the character `A` is in the reference table and will be mapped to another character, but the character `a` is not in the table and will be mapped to itself.

## Usage
1. Download the source code from this repository.
2. Unzip the downloaded `.zip` file and open the folder.
3. If using Windows, you should be able to double-click the `.bat` file to run the program. If using Mac, open the terminal, navigate to the folder, and run the command `java Main`.
4. To exit the program, close the command prompt/terminal window.

## Software

```
java 17.0.4.1
javac 17.0.4.1
```
