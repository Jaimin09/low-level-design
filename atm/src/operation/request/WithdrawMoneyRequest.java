package operation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.OperationType;

@Getter
@AllArgsConstructor
public class WithdrawMoneyRequest implements OperationRequest{
    int amount;

    @Override
    public OperationType getOperationType() {
        return OperationType.WITHDRAW;
    }
}
