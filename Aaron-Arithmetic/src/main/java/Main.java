import java.util.Scanner;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import demo.DebugVisitor;
import expressions.ArithmeticBaseVisitor;
import expressions.ArithmeticLexer;
import expressions.ArithmeticParser;

public class Main {
    
    public static void main(String[] args) {
        // reading
        Scanner myScanner = new Scanner(System.in);
        String expression = myScanner.nextLine();
        myScanner.close();
        // Parse
        ArithmeticLexer myLexer = new ArithmeticLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(myLexer);
        ArithmeticParser myParser = new ArithmeticParser(tokens);
        // Visiting the ParseTree
        ParseTree theTree = myParser.root();
        DebugVisitor debug = new DebugVisitor();
        String result = String.valueOf(theTree.accept(debug));
        
        // printing the final result
        System.out.println(result);
    }
}
