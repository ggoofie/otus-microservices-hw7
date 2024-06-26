package ru.otus.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.otus.order.dto.WithdrawalAccountDTO;
import ru.otus.order.exception.BillingException;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final RestClient restClient;

    @Override
    public void withdrawal(WithdrawalAccountDTO withdrawalAccountDTO) {
        restClient.patch()
                .uri("/api/account/withdrawal")
                .contentType(MediaType.APPLICATION_JSON)
                .body(withdrawalAccountDTO)
                .retrieve()
                .onStatus(status -> status.value() != 200, (request, response) -> {
                    throw new BillingException("Ошибка оплаты!");
                })
                .toBodilessEntity();
    }
}
