package com.maroontress.intexpr.impl;

/**
    A function representing operation with a ternary operator.
*/
@FunctionalInterface
public interface IntTernaryOperation extends Operation {

    /**
        Returns the value operated with the specified operands.

        @param cond The condition.
        @param left The left operand.
        @param right The right operand.
        @return The operation result.
    */
    int apply(int cond, int left, int right);

    /** {@inheritDoc} */
    @Override
    default Executable toExecutable() {
        return (s, n, t) -> {
            if (n < 3) {
                var m = Messages.of(t, "operand is missing");
                throw new IllegalArgumentException(m);
            }
            var cond = s[n - 3];
            var left = s[n - 2];
            var right = s[n - 1];
            s[n - 3] = Operations.perform(t, () -> apply(cond, left, right));
            return n - 2;
        };
    }
}
