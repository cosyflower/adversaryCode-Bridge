package bridge.view.pathPrinter;

public class PathPrinter {
    private final StringBuilder stringBuilder;

    public PathPrinter() {
        this.stringBuilder = new StringBuilder();
        initPath();
    }

    public void initPath() {
        stringBuilder.append("[ ");
    }

    public void endPath() {
        stringBuilder.append(" ]");
    }

    public void appendFirstRightPath() {
        stringBuilder.append("O");
    }

    public void appendFirstWhiteSpace() {
        stringBuilder.append(" ");
    }

    public void appendFirstWrongPath() {
        stringBuilder.append("X");
    }

    public void appendRightPath() {
        printSeparator();
        stringBuilder.append("O");
    }

    public void appendWrongPath() {
        printSeparator();
        stringBuilder.append("X");
    }

    public void appendWhiteSpace() {
        printSeparator();
        stringBuilder.append(" ");
    }

    public String finalPath() { // 초기화 까지
        String finalPath = stringBuilder.toString();
        stringBuilder.setLength(0);
        return finalPath;
    }

    private void printSeparator() {
        stringBuilder.append(" | ");
    }

}
