package bridge;

public class ResultMatch {
    private final PlayerChoice playerChoice;
    private final Boolean choiceResult;

    private ResultMatch(PlayerChoice playerChoice, Boolean choiceResult) {
        this.playerChoice = playerChoice;
        this.choiceResult = choiceResult;
    }

    public static ResultMatch of(PlayerChoice playerChoice, Boolean choiceResult) {
        return new ResultMatch(playerChoice, choiceResult);
    }

    public boolean hasSameValue(String playerChoiceValue) {
        return playerChoice.hasSameValue(playerChoiceValue);
    }

    public boolean isRight() {
        return choiceResult == true;
    }
}
