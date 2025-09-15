package com.maroontress.intexpr.syntaxtree;

import com.maroontress.intexpr.impl.Opcode;

/**
    The syntax node representing a ternary operator.
*/
public final class TernaryOperatorNode implements SyntaxNode {

    private final Opcode opcode;
    private final SyntaxNode condOperand;
    private final SyntaxNode leftOperand;
    private final SyntaxNode rightOperand;

    /**
        Creates a new instance.

        @param opcode The opcode.
        @param condOperand The condition operand.
        @param leftOperand The left operand.
        @param rightOperand The right operand.
    */
    public TernaryOperatorNode(Opcode opcode, SyntaxNode condOperand,
            SyntaxNode leftOperand, SyntaxNode rightOperand) {
        this.opcode = opcode;
        this.condOperand = condOperand;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    // CSOFF: AvoidEscapedUnicodeCharacters
    /** {@inheritDoc} */
    @Override
    public String toString(String firstIndent, String indent) {
        var lf = System.lineSeparator();
        var verticalRight = indent + " \u251c ";
        var vertical = indent + " \u2502 ";
        var upRight = indent + " \u2514 ";
        var blank = indent + "   ";
        return firstIndent + opcode + lf
                + condOperand.toString(verticalRight, vertical) + lf
                + leftOperand.toString(verticalRight, vertical) + lf
                + rightOperand.toString(upRight, blank);
    }
    // CSON: AvoidEscapedUnicodeCharacters
}
