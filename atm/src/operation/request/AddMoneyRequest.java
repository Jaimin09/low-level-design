package operation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.OperationType;

@AllArgsConstructor
@Getter
public class AddMoneyRequest implements OperationRequest {
    int amount;

    @Override
    public OperationType getOperationType() {
        return OperationType.ADD_MONEY;
    }
}
