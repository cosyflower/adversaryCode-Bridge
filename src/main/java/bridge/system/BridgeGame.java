package bridge.system;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void checkBridgeAndChoice(PlayerChoice playerChoice) {
        if (bridge.hasSameValueAtIndex(playerChoice)) {
            move();
            return;
        }
        retry();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * bridge, PlayerChoice 비교했을 때 True를 반환하는 경우
     * bridge.hasSameValueAtIndex(PlayerChoice)
     */
    public void move() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
