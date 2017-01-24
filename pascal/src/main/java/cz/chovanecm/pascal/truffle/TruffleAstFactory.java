package cz.chovanecm.pascal.truffle;

import cz.chovanecm.contrib.cz.rank.pj.pascal.parser.AstFactoryInterface;
import cz.chovanecm.pascal.truffle.nodes.*;
import cz.chovanecm.pascal.truffle.nodes.expression.*;
import cz.chovanecm.pascal.truffle.nodes.relational.EqualsOperatorNodeGen;
import cz.chovanecm.pascal.truffle.nodes.relational.LessThanOperatorNodeGen;
import cz.chovanecm.pascal.truffle.nodes.variables.*;

import java.util.List;

/**
 * Created by martin on 1/17/17.
 */
public class TruffleAstFactory implements AstFactoryInterface {

    @Override
    public ProcedureNode createWriteLnProcedure() {
        return new WritelnNode();
    }

    @Override
    public ProcedureNode createWriteProcedure() {
        return new WriteNode();
    }

    @Override
    public StatementNode createBlock(StatementNode[] statements) {
        return new BlockNode(statements);
    }

    @Override
    public StatementNode createBlock(List<StatementNode> statements) {
        return new BlockNode(statements);
    }

    @Override
    public StatementNode createGlobalAssignment(String variable, ExpressionNode expression) {
        return WriteVariableNodeGen.create(expression, variable);
    }

    @Override
    public StatementNode createWhile(ExpressionNode expression, StatementNode statement) {
        return null;
    }

    @Override
    public StatementNode createIf(ExpressionNode expression, StatementNode statementTrue, StatementNode statementFalse) {
        return null;
    }

    @Override
    public StatementNode createForDownTo(StatementNode assignmentStatement, ExpressionNode finalExpression, StatementNode executeStatement) {
        return null;
    }

    @Override
    public StatementNode createForTo(StatementNode assignmentStatement, ExpressionNode finalExpression, StatementNode executeStatement) {
        return null;
    }

    @Override
    public ExpressionNode createConstant(Long longValue) {
        return ConstantNodeGen.create(longValue);
    }

    @Override
    public ExpressionNode createConstant(Double doubleValue) {
        return ConstantNodeGen.create(doubleValue);
    }

    @Override
    public ExpressionNode createConstant(String stringValue) {
        return ConstantNodeGen.create(stringValue);
    }

    @Override
    public ExpressionNode createConstant(Boolean booleanValue) {
        return ConstantNodeGen.create(booleanValue);
    }

    @Override
    public ExpressionNode createUnaryMinus(ExpressionNode primaryExpression) {
        return UnaryMinusNodeGen.create(primaryExpression);
    }

    @Override
    public ExpressionNode createParenthesis(ExpressionNode expression) {
        return ParenthesisExpressionNodeGen.create(expression);
    }

    @Override
    public DeclareVariableNode createIntegerVariable(String id) {
        return new DeclareLongVariable(id);
    }

    @Override
    public DeclareVariableNode createStringVariable(String id) {
        return new DeclareStringVariable(id);
    }

    @Override
    public DeclareVariableNode createRealVariable(String id) {
        return new DeclareRealVariable(id);
    }

    @Override
    public ExpressionNode createPlusOperator(ExpressionNode left, ExpressionNode right) {
        return AddNodeGen.create(left, right);
    }

    @Override
    public ExpressionNode createMinusOperator(ExpressionNode left, ExpressionNode right) {
        return SubtractNodeGen.create(left, right);
    }

    @Override
    public ExpressionNode createMultiplicationOperator(ExpressionNode left, ExpressionNode right) {
        return MultiplyNodeGen.create(left, right);
    }

    @Override
    public ExpressionNode createDivisionOperator(ExpressionNode left, ExpressionNode right) {
        return DivisionNodeGen.create(left, right);
    }

    @Override
    public ExpressionNode createLessOperator(ExpressionNode left, ExpressionNode right) {
        return LessThanOperatorNodeGen.create(left, right);
    }

    @Override
    public ExpressionNode createGreaterOperator(ExpressionNode left, ExpressionNode right) {
        return null;
    }

    @Override
    public ExpressionNode createEqualOperator(ExpressionNode left, ExpressionNode right) {
        return EqualsOperatorNodeGen.create(left, right);
    }

    @Override
    public ExpressionNode createLessEqualOperator(ExpressionNode left, ExpressionNode right) {
        return null;
    }

    @Override
    public ExpressionNode createGreaterEqualOperator(ExpressionNode left, ExpressionNode right) {
        return null;
    }

    @Override
    public ExpressionNode createNotEqualOperator(ExpressionNode left, ExpressionNode right) {
        return null;
    }

    @Override
    public ExpressionNode createNotOperator(ExpressionNode expression) {
        return null;
    }

    @Override
    public ExpressionNode createAndOperator(ExpressionNode left, ExpressionNode right) {
        return null;
    }

    @Override
    public ExpressionNode createOrOperator(ExpressionNode left, ExpressionNode right) {
        return null;
    }

    @Override
    public ExpressionNode createReadVariable(String id) {
        return ReadVariableNodeGen.create(id);
    }
}
