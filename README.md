# C/C++ Interpreter in C#

## 📌 Overview
This project is a **C/C++ interpreter** built in **C#**, designed to analyze and execute C/C++-like code. The interpreter follows a structured approach, using **lexical analysis, parsing, and scope management** to process and evaluate the source code. 

The project leverages **ANTLR** for grammar definition, tokenization, and syntax validation, enabling efficient construction of an **Abstract Syntax Tree (AST)**. The AST serves as the core structure for code execution, providing modularity and extensibility for future enhancements.

---

## 🚀 Features
- **Lexical Analysis (Lexer)**: Tokenizes source code into meaningful components.
- **Parsing & Abstract Syntax Tree (AST)**: Converts tokenized input into a hierarchical syntax tree.
- **Scope Management**: Maintains variable visibility across functions and blocks.
- **Function Handling**: Supports **declaration, recursion, and argument passing**.
- **Execution Flow Control**: Implements **conditionals (if, else), loops (for, while), and expressions**.
- **ANTLR-based Parsing**: Uses **ANTLR grammar rules** for efficient syntax validation.
- **Visitor & Listener Patterns**: Implements **custom visitor logic** to process AST nodes.
