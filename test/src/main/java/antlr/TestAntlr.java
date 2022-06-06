package antlr;

import antlr.ExprBaseVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TestAntlr {

    public static void main(String[] args) {

        ANTLRInputStream inputStream = new ANTLRInputStream("1 + 2");
        //词法解析器
        antlr.ExprLexer lexer = new antlr.ExprLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        antlr.ExprParser parser = new antlr.ExprParser(tokens);
        ParseTree tree = parser.stat();
        System.out.println(tree.toStringTree(parser));

    }

}
