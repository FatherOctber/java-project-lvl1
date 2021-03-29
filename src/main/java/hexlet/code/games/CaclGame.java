package hexlet.code.games;

import hexlet.code.Cli;

public final class CaclGame extends Game {

    private enum Operator {
        PLUS("+"),
        MINUS("-"),
        DIV("*");

        private String opCode;

        Operator(final String operator) {
            opCode = operator;
        }

        @Override
        public String toString() {
            return opCode;
        }
    }

    @Override
    public String name() {
        return "Calc";
    }

    @Override
    protected Result round() {
        var a = getRandomNumber();
        var b = getRandomNumber();
        var op = getRandomOperator();
        System.out.println("What is the result of the expression?");
        System.out.println("Question: " + a + " " + op.opCode + " " + b);
        try {
            var in = Cli.input("Your answer: ");
            var expectedNum = Integer.parseInt(in);
            var result = calculateResult(a, b, op);
            if (expectedNum == result) {
                return Result.correct();
            } else {
                return Result.wrong(expectedNum, result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.noAnswer();
        }
    }

    private int calculateResult(final int a, final int b, final Operator op) {
        switch (op) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case DIV:
                return a * b;
            default:
                throw new IllegalStateException("Unknown operation: "
                        + op.opCode);
        }
    }

    private Operator getRandomOperator() {
        var operatorIndex = (int) ((Math.random() * 2) + 1);
        Operator operator;
        switch (operatorIndex) {
            case 0:
                operator = Operator.PLUS;
                break;
            case 1:
                operator = Operator.MINUS;
                break;
            case 2:
                operator = Operator.DIV;
                break;
            default:
                throw new IllegalStateException("Unknown operator index "
                        + operatorIndex);
        }
        return operator;
    }
}
