package bridge;

public class PlayerChoice {
    private final String playerChoiceValue;

    public PlayerChoice(String playerChoiceValue) {
        this.playerChoiceValue = playerChoiceValue;
    }

    public String getPlayerChoiceValue() {
        return playerChoiceValue;
    }

    public boolean hasSameValue(String otherPlayerChoiceValue) {
        return playerChoiceValue.equals(otherPlayerChoiceValue);
    }
}
