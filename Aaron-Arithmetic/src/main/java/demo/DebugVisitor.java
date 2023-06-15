package demo;

import expressions.ArithmeticBaseVisitor;
import expressions.ArithmeticParser;
import java.util.List;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.ParseTree;

public class DebugVisitor extends ArithmeticBaseVisitor<Integer> {

    @Override
    public Integer visitRoot(ArithmeticParser.RootContext ctx) {
        System.out.println("I'm visiting a Root");
        return visit(ctx.expr());
    }

    @Override
    public Integer visitExpr(ArithmeticParser.ExprContext ctx) {
        System.out.println("I'm visiting an Expression" + ctx.INTEGER());
        if (ctx.INTEGER() != null) {     // If this expression is just a single integer value, has no operator
            return Integer.parseInt(ctx.INTEGER().getText());
        } else {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.OPERATOR().getText().equals("+")) {
                return left + right;
            } else {
                return left - right;
            }
        }
    }
}
